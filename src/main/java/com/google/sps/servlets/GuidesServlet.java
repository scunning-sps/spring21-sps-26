package com.google.sps.servlets;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.sps.data.Error;
import com.google.sps.data.Guide;
import com.google.sps.storage.DatastoreGuides;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

@WebServlet("/guides")
public class GuidesServlet extends HttpServlet{
    static final long serialVersionUID = 0;
    private final DatastoreGuides helper = new DatastoreGuides();
    private final Gson gson = new Gson();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("application/json");
        String category = request.getParameter("category");

        if(category == null || category.equals("")){
            response.getWriter().print(gson.toJson(helper.queryAll()));
            return;
        }
        
        category = Jsoup.clean(category, Whitelist.none());
        response.getWriter().print(gson.toJson(helper.queryByCategory(category)));
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("application/json");

        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String content = request.getParameter("content");
        String category = request.getParameter("category");

        if(title == null || description == null || content == null || category == null){
            response.setStatus(400);
            response.getWriter().print(gson.toJson(new Error("Missing one of the required parameters.", 400)));
        }

        title = Jsoup.clean(title, Whitelist.none());
        description = Jsoup.clean(description, Whitelist.none());
        content = Jsoup.clean(content, Whitelist.none());
        category = Jsoup.clean(category, Whitelist.none());

        Guide guide = new Guide(title, description, content, category);

        try{
            Guide.validate(guide);
        }catch(Error err){
            response.setStatus(err.getCode());
            response.getWriter().print(gson.toJson(err));
            return;
        }
        
        guide = helper.put(guide);

        response.setStatus(201);
        response.getWriter().print(gson.toJson(guide));
    }
}
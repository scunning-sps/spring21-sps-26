package com.google.sps.servlets;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
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
        response.getWriter().print(gson.toJson(helper.queryAll()));
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String title = Jsoup.clean(request.getParameter("title"), Whitelist.none());
        String description = Jsoup.clean(request.getParameter("description"), Whitelist.none());
        String content = Jsoup.clean(request.getParameter("content"), Whitelist.none());

        Guide guide = new Guide(title, description, content);
        guide = helper.put(guide);

        response.setStatus(201);
        response.setContentType("application/json");
        response.getWriter().print(gson.toJson(guide));
    }
}
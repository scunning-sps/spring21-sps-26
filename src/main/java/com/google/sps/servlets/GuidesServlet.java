package com.google.sps.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.sps.data.Guide;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

@WebServlet("/guides")
public class GuidesServlet extends HttpServlet{
    static final long serialVersionUID = 0;
    private final ArrayList<Guide> guides = new ArrayList<>();
    private final Gson gson = new Gson();
    private int lastId = 0;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("application/json");
        response.getWriter().print(gson.toJson(guides));        
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        int id = ++lastId;
        String title = Jsoup.clean(request.getParameter("title"), Whitelist.none());
        String description = Jsoup.clean(request.getParameter("description"), Whitelist.none());
        String content = Jsoup.clean(request.getParameter("content"), Whitelist.none());

        Guide guide = new Guide(id, title, description, content);

        response.setContentType("application/json");
        response.getWriter().print(gson.toJson(guide));

        guides.add(guide);
    }
}
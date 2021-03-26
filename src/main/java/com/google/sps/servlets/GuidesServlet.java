package com.google.sps.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/guides")
public class GuidesServlet extends HttpServlet{
    static final long serialVersionUID = 0;
    private final ArrayList<String> guides = new ArrayList<>();
    private int lastId = 0;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        Gson gson = new Gson();

        response.setContentType("application/json");
        response.getWriter().print(gson.toJson(guides));        
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String content = request.getParameter("content");
        int id = ++lastId;
        long timestamp = System.currentTimeMillis();

        StringBuilder sb = new StringBuilder();

        sb.append("{ \"title\": \"");
        sb.append(title);
        sb.append("\", \"description\": \"");
        sb.append(description);
        sb.append("\", \"content\": \"");
        sb.append(content);
        sb.append("\", \"id\": \"");
        sb.append(id);
        sb.append("\", \"timestamp\": ");
        sb.append(timestamp);
        sb.append("}");

        response.setContentType("application/json");
        response.getWriter().print(sb.toString());

        guides.add(sb.toString());
    }

    
}
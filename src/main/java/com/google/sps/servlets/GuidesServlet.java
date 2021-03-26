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

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        ArrayList<Object> list = new ArrayList<>();

        Gson gson = new Gson();

        response.setContentType("application/json");
        response.getWriter().print(gson.toJson(list));        
        
    }

    
}
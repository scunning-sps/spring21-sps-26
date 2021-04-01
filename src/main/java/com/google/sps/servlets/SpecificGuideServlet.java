package com.google.sps.servlets;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.sps.data.Error;

@WebServlet("/guides/*")
public class SpecificGuideServlet extends HttpServlet{
    static final long serialVersionUID = 0;
    private final Gson gson = new Gson();

    private long getIdFromPath(String path){
        String[] parts = path.split("/");
        return Long.parseLong(parts[1]);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        long id;
        try{
            id = getIdFromPath(request.getPathInfo());
        }catch(NumberFormatException exception){
            response.setStatus(400);
            response.getWriter().print(gson.toJson(new Error("Guide id must be a number", 400)));
            return;
        }

        response.getWriter().println(id);

    }
}
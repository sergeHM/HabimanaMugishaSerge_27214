package com.example.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String q = req.getParameter("q");
        if (q == null) q = "";
        String encoded = URLEncoder.encode(q, StandardCharsets.UTF_8.toString());
        String target = "https://www.google.com/search?q=" + encoded;
        resp.sendRedirect(target);
    }
}

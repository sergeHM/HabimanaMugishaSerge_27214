package com.example.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (username == null) username = "";
        if (password == null) password = "";

        try (PrintWriter out = resp.getWriter()) {
            out.println("<!doctype html><html><head><meta charset='utf-8'><title>Login Result</title></head><body>");
            if (password.length() < 8) {
                out.println(escapeHtml("Hello " + username + ", your password is weak. Try a strong one."));
            } else {
                out.println(escapeHtml("Welcome " + username));
            }
            out.println("</body></html>");
        }
    }

    private String escapeHtml(String s) {
        if (s == null) return "";
        return s.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;");
    }
}

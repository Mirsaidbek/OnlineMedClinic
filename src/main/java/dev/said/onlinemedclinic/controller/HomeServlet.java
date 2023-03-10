package dev.said.onlinemedclinic.controller;

import dev.said.onlinemedclinic.domains.User;
import dev.said.onlinemedclinic.services.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "HomeServlet", value = "/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Integer id = Integer.parseInt(session.getAttribute("id").toString());
        User user = UserService.getInstance().get(id).getDomain();

        String page = UserService.getInstance().getPage(user);
        response.sendRedirect(page);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendError(405, "Method Not Supported");

    }
}

package dev.said.onlinemedclinic.controller.userController;

import dev.said.onlinemedclinic.domains.Doctor;
import dev.said.onlinemedclinic.services.DoctorService;
import dev.said.onlinemedclinic.services.Response;
import dev.said.onlinemedclinic.services.UserService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "mainPageController", value = "/user/main")
public class MainPageController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        HttpServletRequest getRequest = UserService.getInstance().get(request).getRequest();
        getRequest.setAttribute("id", session.getAttribute("id"));
        getRequest.setAttribute("firstname", session.getAttribute("firstname"));
        getRequest.getRequestDispatcher("/views/userPages/userPage.jsp").forward(getRequest, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Response<Doctor> response = DoctorService.getInstance().service(req);
        try {
            res.addCookie(response.getCookie());
            res.sendRedirect(response.getReturnPage());
        } catch (Exception e) {
            e.printStackTrace();
            RequestDispatcher dispatcher = req.getRequestDispatcher("/views/errors/error.jsp");
            dispatcher.forward(req, res);
        }
    }
}

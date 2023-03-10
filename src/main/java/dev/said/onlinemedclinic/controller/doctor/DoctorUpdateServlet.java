package dev.said.onlinemedclinic.controller.doctor;

import dev.said.onlinemedclinic.dao.DoctorDAO;
import dev.said.onlinemedclinic.domains.Doctor;
import dev.said.onlinemedclinic.services.DoctorService;
import dev.said.onlinemedclinic.services.Response;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DoctorUpdateServlet", value = "/dr/update")
public class DoctorUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DoctorDAO doctorDAO = DoctorDAO.getInstance();
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

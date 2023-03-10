package dev.said.onlinemedclinic.controller.doctor;

import dev.said.onlinemedclinic.domains.Doctor;
import dev.said.onlinemedclinic.services.DoctorService;
import dev.said.onlinemedclinic.services.OrderService;
import dev.said.onlinemedclinic.services.Response;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DoctorDailyServlet", value = "/dr/daily")
public class DoctorDailyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpServletRequest getRequest = OrderService.getInstance().getDailyOrders(request).getRequest();

        RequestDispatcher dispatcher = getRequest.getRequestDispatcher("/views/dr/daily.jsp");
        dispatcher.forward(getRequest, response);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Response<Doctor> response = DoctorService.getInstance().service(req);

        HttpServletRequest getRequest = OrderService.getInstance().getDailyOrders(req).getRequest();
        RequestDispatcher dispatcher = getRequest.getRequestDispatcher("/views/dr/daily.jsp");
        dispatcher.forward(getRequest, res);
    }
}

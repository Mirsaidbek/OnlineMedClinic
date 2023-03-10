package dev.said.onlinemedclinic.controller.admin.admin.specialization;

import dev.said.onlinemedclinic.services.SpecializationService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "DeleteSpecializationServlet", value = "/admin/specialization/delete/*")
public class DeleteSpecializationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getPathInfo().substring(1));
        request.setAttribute("specialization", SpecializationService.getInstance().get(id).getDomain());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/adminPages/specialization/SpecializationDelete.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SpecializationService.getInstance().delete(request).getRequest().getRequestDispatcher("/views/adminPages/Admin.jsp").forward(request, response);
    }
}

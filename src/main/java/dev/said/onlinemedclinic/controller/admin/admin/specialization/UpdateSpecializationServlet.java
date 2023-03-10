package dev.said.onlinemedclinic.controller.admin.admin.specialization;

import dev.said.onlinemedclinic.services.SpecializationService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "UpdateSpecializationServlet", value = "/admin/specialization/update/*")
public class UpdateSpecializationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getPathInfo().substring(1);
        request.setAttribute("specialization", SpecializationService.getInstance().get(Integer.parseInt(id)).getDomain());
        request.getRequestDispatcher("/views/adminPages/specialization/SpecializationUpdate.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SpecializationService.getInstance().update(request).getRequest().getRequestDispatcher("/views/adminPages/Admin.jsp").forward(request, response);
    }
}

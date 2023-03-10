package dev.said.onlinemedclinic.controller.admin.admin.disease;

import dev.said.onlinemedclinic.services.DiseaseService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "GetListDiseaseServlet", value = "/admin/disease/getList")
public class GetListDiseaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("diseases", DiseaseService.getInstance().getAll());
        request.getRequestDispatcher("/views/adminPages/issues/ListIssues.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}

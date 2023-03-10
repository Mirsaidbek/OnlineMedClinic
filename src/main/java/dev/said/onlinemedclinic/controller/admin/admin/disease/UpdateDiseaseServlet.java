package dev.said.onlinemedclinic.controller.admin.admin.disease;

import dev.said.onlinemedclinic.domains.Disease;
import dev.said.onlinemedclinic.domains.Specialization;
import dev.said.onlinemedclinic.services.DiseaseService;
import dev.said.onlinemedclinic.services.SpecializationService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "UpdateDiseaseServlet", value = "/admin/disease/update/*")
public class UpdateDiseaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Disease disease = DiseaseService.getInstance().get(Integer.parseInt(request.getPathInfo().substring(1))).getDomain();
        List<Specialization> specializations = SpecializationService.getInstance().getAll();
        request.setAttribute("specializations", specializations);
        request.setAttribute("disease", disease);
        request.getRequestDispatcher("/views/adminPages/issues/UpdateIssues.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DiseaseService.getInstance().update(request).getRequest().getRequestDispatcher("/views/adminPages/Admin.jsp").forward(request, response);
    }
}

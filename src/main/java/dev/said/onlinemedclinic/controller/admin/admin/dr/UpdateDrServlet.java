package dev.said.onlinemedclinic.controller.admin.admin.dr;

import dev.said.onlinemedclinic.domains.Doctor;
import dev.said.onlinemedclinic.domains.Specialization;
import dev.said.onlinemedclinic.domains.User;
import dev.said.onlinemedclinic.services.DoctorService;
import dev.said.onlinemedclinic.services.SpecializationService;
import dev.said.onlinemedclinic.services.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "UpdateDrServlet", value = "/admin/dr/update/*")
public class UpdateDrServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = UserService.getInstance().get(Integer.parseInt(request.getPathInfo().substring(1))).getDomain();
        Doctor doctor = DoctorService.getInstance().getDoctorsByUserID(Integer.parseInt(request.getPathInfo().substring(1))).getDomain();
        List<Specialization> specializations = SpecializationService.getInstance().getAll();


        request.setAttribute("user", user);
        request.setAttribute("doctor", doctor);
        request.setAttribute("specializations", specializations);

        request.getRequestDispatcher("/views/adminPages/dr/UpdateDr.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DoctorService.getInstance().changeSpecialization(request).getRequest().getRequestDispatcher("/views/adminPages/Admin.jsp").forward(request, response);
    }
}

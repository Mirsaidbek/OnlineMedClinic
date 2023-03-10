package dev.said.onlinemedclinic.controller.admin.admin.dr;

import dev.said.onlinemedclinic.domains.User;
import dev.said.onlinemedclinic.services.UserService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetListDrServlet", value = "/admin/dr/getList")
public class GetListDrServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> doctors = UserService.getInstance().getAllDoctors();
        request.setAttribute("doctors", doctors);
        request.getRequestDispatcher("/views/adminPages/dr/ListDr.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}

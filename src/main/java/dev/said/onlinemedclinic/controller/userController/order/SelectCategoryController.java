package dev.said.onlinemedclinic.controller.userController.order;

import dev.said.onlinemedclinic.domains.Specialization;
import dev.said.onlinemedclinic.services.OrderService;
import dev.said.onlinemedclinic.services.SpecializationService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "SelectCategoryController", urlPatterns = "/user/order")
public class SelectCategoryController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Specialization> all = SpecializationService.getInstance().getAll();
        req.setAttribute("categories", all);
        req.setAttribute("firstName", req.getSession().getAttribute("firstname"));
        req.getRequestDispatcher("/views/selectCategory.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderService.getInstance().selectCategory(req);
        req.setAttribute("firstName", req.getSession().getAttribute("firstname"));
        req.getRequestDispatcher("/views/selectDoctor.jsp").forward(req, resp);
    }
}

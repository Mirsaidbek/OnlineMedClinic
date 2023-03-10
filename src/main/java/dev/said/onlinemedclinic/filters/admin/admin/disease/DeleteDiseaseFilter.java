package dev.said.onlinemedclinic.filters.admin.admin.disease;

import dev.said.onlinemedclinic.validators.DiseaseValidator;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebFilter(filterName = "DeleteDiseaseFilter", urlPatterns = "/admin/disease/delete")
public class DeleteDiseaseFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        var req = (HttpServletRequest) request;
        var res = (HttpServletResponse) response;
        if (req.getMethod().equalsIgnoreCase("post")) {
            try {
                DiseaseValidator.getInstance().checkParamsDeletedisease(req);
                chain.doFilter(req, res);
            } catch (Exception e) {
                req.setAttribute("error", e.getMessage());
                req.getRequestDispatcher("/views/adminPages/admin/DeleteIssues.jsp").forward(req, res);
            }
        }else{
            chain.doFilter(req, res);
        }
    }
}

package dev.said.onlinemedclinic.filters.admin.admin.specialization;

import dev.said.onlinemedclinic.validators.SpecializationValidator;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(filterName = "CreateSpecializationFilter", urlPatterns = "/admin/specialization/create")
public class CreateSpecializationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        var req = (HttpServletRequest) request;
        var res = (HttpServletResponse) response;
        if (req.getMethod().equalsIgnoreCase("post")) {
            try {
                SpecializationValidator.getInstance().checkParamsCreateSer(req);
                chain.doFilter(req, res);
            } catch (Exception e) {
                req.setAttribute("error", e.getMessage());
                req.getRequestDispatcher("/views/adminPages/specialization/SpecializationCreate.jsp").forward(req, res);
            }
        }else{
            chain.doFilter(req, res);
        }
    }
}

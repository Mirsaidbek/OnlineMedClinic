package dev.said.onlinemedclinic.filters.auth;

import dev.said.onlinemedclinic.exceptions.AuthException;
import dev.said.onlinemedclinic.validators.AuthValidator;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(filterName = "SignUpValidationFilter", urlPatterns = "/signUp")
public class SignUpValidationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        var req = (HttpServletRequest) request;
        var res = (HttpServletResponse) response;

        if (req.getMethod().equalsIgnoreCase("post")) {
            try {
                AuthValidator.getInstance().checkParamsRegister(req);
                chain.doFilter(req, res);
            } catch (AuthException e) {
                RequestDispatcher dispatcher = req.getRequestDispatcher("/views/auth/signUp.jsp");
                dispatcher.forward(req, res);
            }
        } else
            chain.doFilter(req, res);
    }
}

package com.tpo5_bg_s23591;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "form", value = "/form")
public class form extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        request.setAttribute("cType",request.getParameter("Type"));
        request.setAttribute("cBrand",request.getParameter("Brand"));
        request.setAttribute("cModel",request.getParameter("Model"));
        request.setAttribute("cProd",request.getParameter("Prod"));
        request.setAttribute("cFuel",request.getParameter("Fuel"));
        request.setAttribute("cMileage",request.getParameter("Mileage"));

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Dblookup");
        requestDispatcher.forward(request,response);
    }

}

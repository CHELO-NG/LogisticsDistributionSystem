package controller;

import entity.Courier;
import service.CourierService;
import serviceimpl.CourierServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class QueryCourierServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        int courierID=Integer.parseInt(req.getParameter("courierID"));
        CourierService courierService=new CourierServiceImpl();
        Courier courier=null;
        try {
            courier=courierService.queryOneCourier(courierID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (courier!=null){
            req.setAttribute("courier",courier);
            req.getRequestDispatcher("updateCourier.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

package controller;

import service.CourierService;
import serviceimpl.CourierServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteCourierServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        int courierID=Integer.parseInt(req.getParameter("courierID"));

        CourierService courierService=new CourierServiceImpl();
        int n=courierService.deleteCourier(courierID);
        courierService.toString();
        if (n>0){
            resp.sendRedirect("courier");// 派送员页面
        }else {
            resp.getWriter().println("删除失败！");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

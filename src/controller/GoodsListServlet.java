package controller;

import dao.GoodsDao;
import daoimpl.GoodsDaoImpl;
import entity.Goods;
import entity.Page;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class GoodsListServlet extends HttpServlet {
    private GoodsDao goodsDao=new GoodsDaoImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int start=0;
        int count=10;
        String keywords=req.getParameter("keywords");
        try {
            start=Integer.parseInt(req.getParameter("page.start"));
            count=Integer.parseInt(req.getParameter("page.count"));
        }catch (Exception e){
            e.printStackTrace();
        }

        Page page=new Page(start,count);
        List<Goods> goods=null;

        try {
            if (keywords==null){
                goods=goodsDao.list(page.getStart(),page.getCount());
            }else {
               goods=goodsDao.listByKeywords(page.getStart(),page.getCount(),keywords);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        int total=0;
        try {
            total=goodsDao.getTotal();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        page.setTotal(total);
        req.setAttribute("goods",goods);
        req.setAttribute("page",page);
        req.getRequestDispatcher("/goods.jsp").forward(req,resp);// 货物页面
    }
}

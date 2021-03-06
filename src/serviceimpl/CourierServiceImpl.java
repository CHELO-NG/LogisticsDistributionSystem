package serviceimpl;

import dao.CourierDao;
import daoimpl.CourierDaoImpl;
import entity.Courier;
import service.CourierService;

import java.sql.SQLException;
import java.util.List;

public class CourierServiceImpl implements CourierService {
    private CourierDao courierDao=new CourierDaoImpl();
    @Override
    public int addCourier(Courier courier) {
        return courierDao.addCourier(courier);
    }

    @Override
    public int deleteCourier(int courierID) {
        return courierDao.deleteCourier(courierID);
    }

    @Override
    public int updateCourier(Courier courier) {
        return courierDao.updateCourier(courier);
    }

    @Override
    public Courier queryOneCourier(int courierID) throws SQLException {
        return courierDao.selectCourier(courierID);
    }

    @Override
    public List<Courier> queryAllCourier(int start, int count) throws SQLException {
        return courierDao.list(start,count);
    }

    @Override
    public List<Courier> queryCourierByKeywords(int start, int count, String keywords) throws SQLException {
        return courierDao.listByKeywords(start, count, keywords);
    }
}

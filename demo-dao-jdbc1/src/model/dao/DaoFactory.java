package model.dao;

import db.DB;
import model.dao.implementation.SellerDaoJBDBC;

public class DaoFactory {
	
	public static SellerDao createSellerDao() {
		return new SellerDaoJBDBC(DB.getConnection());
	}

}

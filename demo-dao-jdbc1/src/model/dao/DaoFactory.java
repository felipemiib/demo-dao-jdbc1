package model.dao;

import model.dao.implementation.SellerDaoJBDBC;

public class DaoFactory {
	
	public static SellerDao createSellerDao() {
		return new SellerDaoJBDBC();
	}

}

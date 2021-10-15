package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		// Department obj = new Department(1, "Books");
		
		// Seller seller = new Seller(21,"Bob","bob@gmail.com", new Date(), 3000.00, obj);
		
		SellerDao sellerdao = DaoFactory.createSellerDao();
		System.out.println("------------- Testes N1: seller findById -----------");
		Seller seller = sellerdao.findById(3);
		System.out.println(seller);
				
		//System.out.println(obj);
		
	}

}

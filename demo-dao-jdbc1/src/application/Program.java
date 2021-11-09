package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		// Department obj = new Department(1, "Books");
		
		// Seller seller = new Seller(21,"Bob","bob@gmail.com", new Date(), 3000.00, obj);
		
		
		System.out.println("------------- Testes N1: seller findById -----------");
		SellerDao sellerdao = DaoFactory.createSellerDao();
		Seller seller = sellerdao.findById(3);
		System.out.println(seller);
		
		System.out.println("------------- Testes N2: seller findByDepartment -----------");
		
		Department department = new Department(2, null); //instancia um novo objeto Departamento (model entities) e informa os parametros
		
		List<Seller> list = sellerdao.findByDepartment(department);
		
		for (Seller obj : list) {
			
			System.out.println(obj);
			
		}
		
		
		//System.out.println(obj);
		
	}

}

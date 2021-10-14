package model.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJBDBC implements SellerDao {
	//conexão com o banco de dados JDBC MYSQL
	private Connection conn;
	
	public SellerDaoJBDBC(Connection conn) {
		this.conn = conn;
	}
	
	
	@Override
	public void insert(Seller obj) {
		
	}
	
	@Override
	public void update(Seller obj) {
		
	}

	@Override
	public void deleteById(Integer id) {
	
		
	}

	@Override
	public Seller findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(
					"SELECT seller.*,department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "WHERE seller.Id = ?)");
			st.setInt(1, id);
			rs = st.executeQuery();
			if(rs.next()) {
				
				Department dep = new Department();
				dep.setId(rs.getInt("DepartmentId")); // tem que identico ao atributo criado no banco MYSQL
				dep.setName(rs.getString("DepName"));
				
				Seller obj = new Seller();  // criando um objeto Seller
				obj.setId(rs.getInt("Id")); // tem que identico ao atributo criado no banco MYSQL
				obj.setName(rs.getString("Name")); // tem que identico ao atributo criado no banco MYSQL
				obj.setEmail(rs.getString("Email")); // tem que identico ao atributo criado no banco MYSQL
				obj.setBithDate(rs.getDate("BithDay")); // tem que identico ao atributo criado no banco MYSQL
				obj.setBaseSalary(rs.getDouble("BaseSalary")); // tem que identico ao atributo criado no banco MYSQL
				obj.setDepartment(dep);	// não pode ser o Id do MYSQL, e sim a referencia de objeto na classe Seller.java
				//aqui nesse scrip, como foi criado um novo objeto, deve ser incluído a variável que contempla, nesse caso "dep"
				return obj;
			}
			
			return null;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		
		finally {
			DB.closeStatement(st);;
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}

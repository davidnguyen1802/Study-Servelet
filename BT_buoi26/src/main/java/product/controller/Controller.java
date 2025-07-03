package product.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import product.config.MySQL_config;
import product.entity.ProductApple;

@WebServlet("/searching")
public class Controller extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Connection connection = MySQL_config.getConnection();
		
		String query_select_all = "SELECT *\r\n"
				+ "FROM product p";
		List<ProductApple>listProductApples = new ArrayList<ProductApple>();
		try {
			PreparedStatement selectStmt = connection.prepareStatement(query_select_all);
			ResultSet resultSet = selectStmt.executeQuery();
			
			
			while(resultSet.next()) {
			listProductApples.add(new ProductApple(resultSet.getInt("id"),
												resultSet.getString("name_product"),
												resultSet.getInt("quantity"),
												resultSet.getDouble("price")));
			}
			
			if(listProductApples.size() > 0) {
				System.out.println("Successfully !");
			} else {
				System.out.println("Failed !");
			}
		} catch (SQLException e) {
			System.out.println("Error when try to connect DB: " + e.getMessage());
			e.printStackTrace();
		}
		req.setAttribute("listProducts", listProductApples);
		req.setAttribute("editId", req.getParameter("editId"));
		req.getRequestDispatcher("/product.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name_of_product = req.getParameter("name");
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		double price = Double.parseDouble(req.getParameter("price"));
		
		Connection connection = MySQL_config.getConnection();
		
		String query_insert = "INSERT INTO product(name_product, quantity, price) \r\n"
				+ "VALUES (?, ?, ?);";
		
		try {
			PreparedStatement insertStatement = connection.prepareStatement(query_insert);
			insertStatement.setString(1, name_of_product);
			insertStatement.setInt(2, quantity);
			insertStatement.setDouble(3, price);
			
			int check = insertStatement.executeUpdate();
			if (check > 0)
				System.out.println("Successfully added !");
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error insert: " + e.getMessage());
			e.printStackTrace();
		}
		
		resp.sendRedirect(req.getContextPath() + "/searching");
	}

}

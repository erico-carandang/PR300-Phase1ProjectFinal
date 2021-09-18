package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mvc.bean.RegisterBean;
import com.mvc.bean.UserDetails;
import com.mvc.util.DBConnection;

public class RegisterDao {
	public String registerUser(RegisterBean registerBean) {
		String firstName = registerBean.getFirstName();
		String lastName = registerBean.getLastName();
		String email = registerBean.getEmail();
		String userName = registerBean.getUserName();
		String password = registerBean.getPassword();

		Connection con = null;
		PreparedStatement preparedStatement = null;
		String query = null;
		try {
			con = DBConnection.createConnection();

			query = "SELECT count(*) from user_registration WHERE email = '" + email + "'";
			preparedStatement = con.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				if (resultSet.getInt(1) <= 0) {
					query = "SELECT count(*) from user_registration WHERE username = '" + userName + "'";
					preparedStatement = con.prepareStatement(query);
					resultSet = preparedStatement.executeQuery();
					
					if (resultSet.next()) {
						if (resultSet.getInt(1) <= 0) {
							query = "insert into user_registration(firstName,lastName,Email,userName,password) values (?,?,?,?,?)";
							preparedStatement = con.prepareStatement(query);
							preparedStatement.setString(1, firstName);
							preparedStatement.setString(2, lastName);
							preparedStatement.setString(3, email);
							preparedStatement.setString(4, userName);
							preparedStatement.setString(5, password);

							int i = preparedStatement.executeUpdate();

							if (i != 0) {
								return "Success";
							}
						}
						return "Username already exist!";
					}
				}
				return "Email already exist!";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Oops.. Something went wrong there..!"; // On failure, send a message from here.
	}
}
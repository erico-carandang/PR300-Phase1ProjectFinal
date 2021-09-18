package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mvc.bean.LoginBean;
import com.mvc.bean.RegisterBean;
import com.mvc.bean.UserDetails;
import com.mvc.util.DBConnection;

public class LoginDao {
	public UserDetails loginUser(LoginBean loginBean) {
		String userName = loginBean.getUserName();
		String password = loginBean.getPassword();

		Connection con = null;
		PreparedStatement preparedStatement = null;
		String query = null;
		try {
			con = DBConnection.createConnection();

			query = "SELECT TOP 1 * from user_registration WHERE userName = '" + userName + "' AND password = '" + password + "'";
			preparedStatement = con.prepareStatement(query);
			ResultSet userRegResultSet = preparedStatement.executeQuery();
			if (userRegResultSet.next()) {
				if (userRegResultSet.getInt(1) > 0) {
					
					UserDetails ud = new UserDetails();
					ud.UserId = userRegResultSet.getInt(1);
					ud.FirstName = userRegResultSet.getString(2);
					ud.LastName = userRegResultSet.getString(3);
					ud.Email = userRegResultSet.getString(4);
					ud.UserName = userRegResultSet.getString(5);
					
					query = "SELECT TOP 1 * from user_introduction WHERE userId = '" + userRegResultSet.getInt(1) + "'";
					preparedStatement = con.prepareStatement(query);
					ResultSet userIntroResultSet = preparedStatement.executeQuery();
					if (userIntroResultSet.next()) {
						if (userIntroResultSet.getInt(1) > 0) {
							ud.AboutMe = userIntroResultSet.getString(2);
							ud.Hobby = userIntroResultSet.getString(3);
							return ud;
						}
					}
					return ud;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null; // On failure, send a message from here.
	}
}
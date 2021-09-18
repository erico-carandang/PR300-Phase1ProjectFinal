package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mvc.bean.IntroductionBean;
import com.mvc.bean.LoginBean;
import com.mvc.bean.RegisterBean;
import com.mvc.bean.UserDetails;
import com.mvc.util.DBConnection;

public class IntroductionDao {
	public UserDetails AddIntroduction(IntroductionBean introductionBean) {
		String aboutMe = introductionBean.getAboutMe();
		String hobby = introductionBean.getHobby();
		String userId = introductionBean.getUserId();

		Connection con = null;
		PreparedStatement preparedStatement = null;
		String query = null;
		try {
			con = DBConnection.createConnection();
			
			if((aboutMe != null && !aboutMe.trim().isEmpty()) &&
					(hobby != null && !hobby.trim().isEmpty())) {
				query = "insert into user_introduction(userId, aboutMe, hobby) values (?,?,?)";
				preparedStatement = con.prepareStatement(query);
				preparedStatement.setString(1, userId);
				preparedStatement.setString(2, aboutMe);
				preparedStatement.setString(3, hobby);
				preparedStatement.executeUpdate();
			}

			query = "SELECT ur.userid, ur.firstname, ur.lastname, ur.email, ur.username, ur.password, ui.aboutme, ui.hobby "
					+ "FROM user_registration ur "
					+ "LEFT JOIN user_introduction ui ON ur.userid = ui.userid "
					+ "WHERE ur.userid = '" + userId + "'";
			preparedStatement = con.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				if (resultSet.getInt(1) > 0) {
					UserDetails ud = new UserDetails();
					ud.UserId = resultSet.getInt(1);
					ud.FirstName = resultSet.getString(2);
					ud.LastName = resultSet.getString(3);
					ud.Email = resultSet.getString(4);
					ud.UserName = resultSet.getString(5);
					ud.Password = resultSet.getString(6);
					ud.AboutMe = resultSet.getString(7);
					ud.Hobby = resultSet.getString(8);
					return ud;
				}
				return null;
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
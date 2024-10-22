package com.rgcorporation.main.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.rgcorporation.main.model.LoginDetails;

@Component
public final class LoginDetailsRowMapper implements RowMapper<LoginDetails> {

		@Override
		public LoginDetails mapRow(ResultSet resultSet, int arg1) throws SQLException {
			int loginId = resultSet.getInt("Login_Id");
			String password = resultSet.getString("Password");
			String role = resultSet.getString("Role");

			LoginDetails loginDetails = new LoginDetails();
			loginDetails.setLoginId(loginId);
			loginDetails.setPassword(password);
			loginDetails.setRole(role);
			return loginDetails;
		}

	}
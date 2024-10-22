package org.rgCorporation.main.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import org.rgCorporation.main.model.LoginDetails;

@Repository
public class LoginDetailsRepository implements LoginDetailsRepositoryInterface {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final String SELECT_ALL_LoginDetails = "SELECT * FROM LOGIN_DETAILS";
	private static final String SELECT_SINGLE_LoginDetails = "SELECT * FROM LOGIN_DETAILS WHERE LOGIN_ID = ?";
	private static final String login = "SELECT * FROM LOGIN_DETAILS WHERE LOGIN_ID = ? AND PASSWORD = ? ";

	// @Override
	public LoginDetails getLoginDetailsByLoginId(int loginId) {
		Object[] args = { loginId };
		LoginDetails details = jdbcTemplate.queryForObject(SELECT_SINGLE_LoginDetails, new LoginDetailRowMapper(),
				args);
		return details;
	}

	// @Override
	public List<LoginDetails> getAllLoginDetails() {

		List<LoginDetails> details = jdbcTemplate.query(SELECT_ALL_LoginDetails, new LoginDetailRowMapper());
		return details;

	}

	@Override
	public LoginDetails login(LoginDetails loginDetails) {
		try {
			Object[] args = { loginDetails.getLoginId(), loginDetails.getPassword() };
			LoginDetails loginDetails1 = jdbcTemplate.queryForObject(login, new LoginDetailRowMapper(), args);
			
			loginDetails1.setPassword("null");

			return loginDetails1;
		} catch (Exception e) {
			return new LoginDetails();
		}
	}

}

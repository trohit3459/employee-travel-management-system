package org.rgCorporation.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.rgCorporation.main.model.LoginDetails;
import org.rgCorporation.main.repository.LoginDetailsRepositoryInterface;

@Service
public class LoginDetailsService implements LoginDetailsServiceInterFace {
	@Autowired
	private LoginDetailsRepositoryInterface loginDetailsRepositoryInterface;

	@Override
	public LoginDetails getLoginDetailsByLoginId(int loginId) {
		return loginDetailsRepositoryInterface.getLoginDetailsByLoginId(loginId);
	}

	@Override
	public List<LoginDetails> getAllLoginDetails() {
		return loginDetailsRepositoryInterface.getAllLoginDetails();
	}

	@Override
	public LoginDetails login(LoginDetails loginDetails) {

		return loginDetailsRepositoryInterface.login(loginDetails);
	}

}

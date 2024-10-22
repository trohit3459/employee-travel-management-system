package org.rgCorporation.main.service;

import java.util.List;

import org.rgCorporation.main.model.LoginDetails;

public interface LoginDetailsServiceInterFace {
	public LoginDetails getLoginDetailsByLoginId(int loginId);

	public List<LoginDetails> getAllLoginDetails();

	public LoginDetails login(LoginDetails loginDetails);

}

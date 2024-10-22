package org.rgCorporation.main.repository;

import java.util.List;

import org.rgCorporation.main.model.LoginDetails;

public interface LoginDetailsRepositoryInterface {

	public LoginDetails getLoginDetailsByLoginId(int loginId);

	public List<LoginDetails> getAllLoginDetails();

	public LoginDetails login(LoginDetails loginDetails);

}

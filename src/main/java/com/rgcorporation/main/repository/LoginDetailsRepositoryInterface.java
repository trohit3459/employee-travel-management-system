package com.rgcorporation.main.repository;

import java.util.List;

import com.rgcorporation.main.model.LoginDetails;

public interface LoginDetailsRepositoryInterface
{
      public boolean addLoginDetails(LoginDetails loginDetails);
//      public boolean updateLoginDetails(LoginDetails loginDetails);
//      public boolean deleteLoginDetailsById(int loginId);
      public LoginDetails getLoginDetailsById(int loginId);
      public List<LoginDetails> getAllLoginDetails();
      public LoginDetails userLogin(LoginDetails loginDetails);
}

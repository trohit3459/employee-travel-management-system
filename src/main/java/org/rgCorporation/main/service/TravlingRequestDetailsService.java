package org.rgCorporation.main.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import org.rgCorporation.main.model.TravelDetails;
import org.rgCorporation.main.model.TravellingRequestDetails;
import org.rgCorporation.main.repository.TravelDetailsRepositoryInterface;
import org.rgCorporation.main.repository.TravelDocumentDetailsRepsitoryInterface;
import org.rgCorporation.main.repository.TravlingRequestDetailsRepositoryInterface;
@Service
public class TravlingRequestDetailsService implements TravlingRequestDetailsServiceInterface {
	@Autowired
	private TravlingRequestDetailsRepositoryInterface travlingRequestDetailsRepositoryInterface;
	@Autowired
	 private JavaMailSender javaMailSender;
	@Autowired
	private TravelDetailsRepositoryInterface travelDetailsRepositoryInterface;
	
	@Autowired
	private TravelDocumentDetailsRepsitoryInterface documentDetailsRepsitoryInterface;
	@Override
	public boolean addTravellingRequestDetails(TravellingRequestDetails travellingRequestDetails) {
		
		return   documentDetailsRepsitoryInterface.addTravelDocumentDetails(travellingRequestDetails.getTravelDocumentDetails())&&travlingRequestDetailsRepositoryInterface.addTravellingRequestDetails(travellingRequestDetails);
	}
	@Override
	public TravellingRequestDetails getTravellingRequestDetailsBytravelRequestId(int travelRequestId) {
		return travlingRequestDetailsRepositoryInterface.getTravellingRequestDetailsBytravelRequestId(travelRequestId);
	}

	@Override
	public List<TravellingRequestDetails> getAllTravellingRequestDetails() {
		return travlingRequestDetailsRepositoryInterface.getAllTravellingRequestDetails();
	}
	@Override
	public boolean updateTravellingRequestDetailsByTravelRequestId(TravellingRequestDetails travellingRequestDetails) {
		boolean flag=false;
		
		 try {
			 
	            SimpleMailMessage mailMessage = new SimpleMailMessage();
	            mailMessage.setFrom("santoshhonrao136@gmail.com");
	            mailMessage.setTo(travellingRequestDetails.getEmployeeDetails().getEmailId());
	            mailMessage.setText(travellingRequestDetails.getTarvelStatus()+" Your Traval Request by Traval Agent."+"\n"+"Please check your application status on company web application."+" \n"+"\n"+"Thank You, "+"\n"+"Yours Sincerely,"+"\n"+"Traval Agent.");
	            mailMessage.setSubject("Regarding Travel Request");
	            javaMailSender.send(mailMessage);
	            flag=true;
	        }
	 
	        catch (Exception e) {
	           flag=false;
	        }
		
		return travlingRequestDetailsRepositoryInterface.updateTravellingRequestDetailsBytravelRequestId(travellingRequestDetails)&& flag;
	}
	@Override
	public boolean updateManagerStatusByTravelRequestId(TravellingRequestDetails travellingRequestDetails) {
		boolean flag=false;
		
		
		 try {
			 
	            SimpleMailMessage mailMessage = new SimpleMailMessage();
	            
	            mailMessage.setFrom("santoshhonrao136@gmail.com");
	            mailMessage.setTo(travellingRequestDetails.getEmployeeDetails().getEmailId());
	            mailMessage.setText(travellingRequestDetails.getProjectManagerStatus()+" Your Traval Request by  Project Manager. "+"\n"+"\n"+"Please check your application status on company web application."+" \n"+"\n"+"Thank You," +"\n"+"\n"+"Yours Sincerely,"+"\n"+"Project Manager,"+"\n"+"Volterra Private Limited. ");
	            mailMessage.setSubject("Regarding Traval Request");
	            javaMailSender.send(mailMessage);
	            flag=true;
	        }
	 
	        catch (Exception e) {
	           flag=false;
	        }
		 
			return  travlingRequestDetailsRepositoryInterface.updateManagerStatusBytravelRequestId(travellingRequestDetails)&&flag;
					
	}
	@Override
	public boolean updateDirectorStatusByTravelRequestId(TravellingRequestDetails travellingRequestDetails) {
		boolean flag=false;
		
		 try {
			 
	            SimpleMailMessage mailMessage= new SimpleMailMessage();
	            mailMessage.setFrom("santoshhonrao136@gmail.com");
	            mailMessage.setTo(travellingRequestDetails.getEmployeeDetails().getEmailId());
	            mailMessage.setText(travellingRequestDetails.getDirectorStatus()+" Your Traval Request by Director."+"\n"+"\n"+"Please check your application status on company web application. "+"\n"+"\n"+"Thank You," +"\n"+"Yours Sincerely,"+"\n"+"Director,"+"\n"+"Volterra Private Limited.");
	            mailMessage.setSubject("Regarding Traval Request");
	 
	            javaMailSender.send(mailMessage);
	            flag=true;
	        }
	        catch (Exception e) {
	           flag=false;
	        }
		 if(travellingRequestDetails.getEmployeeDetails().getDesignation().equalsIgnoreCase("MANAGER"))
		 {
			 return travlingRequestDetailsRepositoryInterface.updateDirectorStatusBytravelRequestId(travellingRequestDetails)&&flag;
			 
		 }
		 else
		 {
		return travlingRequestDetailsRepositoryInterface.updateDirectorStatusBytravelRequestIdForEmployee(travellingRequestDetails)&&flag;
		 }
	}

	@Override
	public List<TravellingRequestDetails> getAllTravellingRequestDetailsByEmployeeId(int employeeId) {
		return travlingRequestDetailsRepositoryInterface.getAllTravellingRequestDetailsByEmployeeId(employeeId);
	}

	@Override
	public List<TravellingRequestDetails> getAllTravellingRequestDetailsForaAgent() {
		return getAllTravellingRequestDetailsForAgent();
	}

	@Override
	public List<TravellingRequestDetails> getAllTravellingRequestDetailsForAgent() {
		
		return travlingRequestDetailsRepositoryInterface.getAllTravellingRequestDetailsForAgent();
	}

	@Override
	public List<TravellingRequestDetails> getAllTravellingRequestByManagerId(int managerId) {
		return travlingRequestDetailsRepositoryInterface.getAllTravellingRequestByManagerId(managerId);
	}
	@Override
	public List<TravellingRequestDetails> getAllTravellingPendingRequestByManagerId(int managerId) {
		return travlingRequestDetailsRepositoryInterface.getAllTravellingPendingRequestByManagerId(managerId);
	}

	@Override
	public List<TravellingRequestDetails> getAllTravellingAcceptRequestByManagerId(int managerId) {
		return travlingRequestDetailsRepositoryInterface.getAllTravellingAcceptRequestByManagerId(managerId);
	}
	@Override
	public List<TravellingRequestDetails> getAllTravellingRejectedRequestByManagerId(int managerId) {
		return travlingRequestDetailsRepositoryInterface.getAllTravellingRejectedRequestByManagerId(managerId);
	}

	@Override
	public List<TravellingRequestDetails> getAllTravellingRequestDetailsForDirector() {
		return travlingRequestDetailsRepositoryInterface.getAllTravellingRequestDetailsForDirector();
	}
	@Override
	public List<TravellingRequestDetails> getAllAcceptedTravellingRequestDetailsForAgent() {
		return travlingRequestDetailsRepositoryInterface.getAllAcceptedTravellingRequestDetailsForAgent();
	}
	@Override
	public boolean insertTravalDetails(TravellingRequestDetails travellingRequestDetails) {
	TravelDetails travelDetails = travellingRequestDetails.getTravelDetails();
	TravellingRequestDetails loadedTravelingRequestDetails =  travlingRequestDetailsRepositoryInterface.getTravellingRequestDetailsBytravelRequestId(travellingRequestDetails.getTravelRequestId());
	loadedTravelingRequestDetails.setTravelDetails(travelDetails);
	return	(travelDetailsRepositoryInterface.addTravelDetails(loadedTravelingRequestDetails.getTravelDetails()) && travlingRequestDetailsRepositoryInterface.insertTravalDetails(loadedTravelingRequestDetails));
	}

	@Override
	public List<TravellingRequestDetails> getAllApprovedTravellingRequestForTravelAgent() {
		return travlingRequestDetailsRepositoryInterface.getAllApprovedTravellingRequestForTravelAgent();
	}
	@Override
	public List<TravellingRequestDetails> getPendingTravellingRequestForTravelAgent() {
		return travlingRequestDetailsRepositoryInterface.getPendingTravellingRequestForTravelAgent();
	}
	@Override
	public List<TravellingRequestDetails> getManagerTravellingRequestForDirector() {
		return travlingRequestDetailsRepositoryInterface.getManagerTravellingRequestForDirector();
	}
}

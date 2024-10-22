package org.rgCorporation.main.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import org.rgCorporation.main.model.TravelDocumentDetails;

@Repository
public class TravelDocumentDetailsRepository implements TravelDocumentDetailsRepsitoryInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private int resultCount;
	//private static final String INSERT_TRAVAL_DOCUMENT_DETAILS = " INSERT INTO travel_documents_details(DOCUMENT_ID,DOCUMENT_TYPE ,DOCUMENT_NAME,DOCUMENT_FILE) VALUES (sequ_travel_document_details.NEXTVAL,?,? ,?)";
	private static final String INSERT_TRAVAL_DOCUMENT_DETAILS = " INSERT INTO TRAVEL_DOCUMENTS_DETAILS(DOCUMENT_ID,DOCUMENT_TYPE ,DOCUMENT_NAME,DOCUMENT_FILE) VALUES (SEQU_TRAVEL_DOCUMENT_DETAILS.NEXTVAL,?,?,?)";
	private static final String SELECT_ALL_TRAVAL_DOCUMENT_DETAILS = "SELECT * FROM TRAVEL_DOCUMENTS_DETAILS";
	private static final String SELECT_SINGLE_TRAVAL_DOCUMENT_DETAILS = "SELECT * FROM TRAVEL_DOCUMENTS_DETAILS WHERE DOCUMENT_ID = ?";
  private static final  String SELECT_GET_SINGLE_DOCUMENT_DETAILS= "SELECT * FROM TRAVEL_DOCUMENTS_DETAILS  WHERE DOCUMENT_ID=(SELECT MAX(DOCUMENT_ID) FROM TRAVEL_DOCUMENTS_DETAILS)";
	@Override
	public boolean addTravelDocumentDetails(TravelDocumentDetails documentDetails) {
		Object[] args = { documentDetails.getDocumentType(), documentDetails.getDocumentName(),
				documentDetails.getDocumentFile() };
		resultCount = jdbcTemplate.update(INSERT_TRAVAL_DOCUMENT_DETAILS, args);
		
		if (resultCount > 0)
			return true;
		else
			return false;
	}
	

	public TravelDocumentDetails getTravelDocumentDetailForUpdate() {
		
		TravelDocumentDetails documentDetails = jdbcTemplate.queryForObject(SELECT_GET_SINGLE_DOCUMENT_DETAILS,
				new TravelDocumentDetailsRowMapper());
		return documentDetails;
	}

	@Override
	public TravelDocumentDetails getTravelDocumentDetailsByTravelDetailsId(int documentId) {
		Object[] args = { documentId };
		TravelDocumentDetails documentDetails = jdbcTemplate.queryForObject(SELECT_SINGLE_TRAVAL_DOCUMENT_DETAILS,
				new TravelDocumentDetailsRowMapper(), args);
		return documentDetails;
	}

	@Override
	public List<TravelDocumentDetails> getAllTravelDocumentDetails() {
		List<TravelDocumentDetails> documentDetails = jdbcTemplate.query(SELECT_ALL_TRAVAL_DOCUMENT_DETAILS,
				new TravelDocumentDetailsRowMapper());
		return documentDetails;
	}

}

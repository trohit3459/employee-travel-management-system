package org.rgCorporation.main.repository;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import org.rgCorporation.main.model.TravelDocumentDetails;



public class TravelDocumentDetailsRowMapper implements RowMapper<TravelDocumentDetails> {

	@Override
	public TravelDocumentDetails mapRow(ResultSet resultSet, int i) throws SQLException {
		 int documentId=resultSet.getInt("DOCUMENT_ID");
		 String documentType=resultSet.getString("DOCUMENT_TYPE");
         String documentName=resultSet.getString("DOCUMENT_NAME");
		 byte[] documentFile=resultSet.getBytes("DOCUMENT_FILE");
		 
		 TravelDocumentDetails documentDetails=new TravelDocumentDetails(documentId, documentType, documentName, documentFile);
		return documentDetails;
	}
	
	
	
	

}

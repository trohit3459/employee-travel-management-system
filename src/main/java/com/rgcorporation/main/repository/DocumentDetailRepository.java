package com.rgcorporation.main.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rgcorporation.main.model.DocumentDetails;
import com.rgcorporation.main.rowmapper.DocumentDetailsRowMapper;

@Repository
public class DocumentDetailRepository implements DocumentDetailRepositoryInterface {

	@Autowired
	private DocumentDetailsRowMapper documentDetailsRowMapper;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private int result;

	private static final String GET_DOCUMENT_DETAILS_BY_ID = "SELECT * FROM DOCUMENT_DETAILS WHERE DOCUMENT_ID=?";
	private static final String GET_ALL_DOCUMENT_DETAILS = "SELECT * FROM DOCUMENT_DETAILS";

	@Override
	public DocumentDetails getDocumentDetailsById(int documentId) {
		DocumentDetails documentDetails = jdbcTemplate.queryForObject(GET_DOCUMENT_DETAILS_BY_ID,
				documentDetailsRowMapper, new Object[] { documentId });
		if(documentDetails == null)
			return null;
		
		return documentDetails;
	}

	@Override
	public List<DocumentDetails> getAllDocumentDetails() {
		List<DocumentDetails> documentDetails = jdbcTemplate.query(GET_ALL_DOCUMENT_DETAILS, documentDetailsRowMapper);
		return documentDetails;
	}

//	public static final class DocumentDetailsRowMapper implements RowMapper<DocumentDetails>{
//
//		@Override
//		public DocumentDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
//			int documentId = rs.getInt("DOCUMENT_ID");
//			String documentType = rs.getString("DOCUMENT_TYPE");
//			String documentName = rs.getString("Document_name");
//			byte[] file = rs.getBytes("DOCUMENT_FILE");
//			
//			DocumentDetails documentDetails = new DocumentDetails();
//			
//			documentDetails.setDocumentId(documentId);
//			documentDetails.setDocumentName(documentName);
//			documentDetails.setDocumentType(documentType);
//			documentDetails.setFile(file);
//			
//			return documentDetails;
//		}
//		
//	}

}

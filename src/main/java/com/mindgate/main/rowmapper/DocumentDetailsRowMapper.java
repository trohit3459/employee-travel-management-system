package com.mindgate.main.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mindgate.main.pojo.DocumentDetails;

@Component
public final class DocumentDetailsRowMapper implements RowMapper<DocumentDetails> {

	@Override
	public DocumentDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		int documentId = rs.getInt("DOCUMENT_ID");
		String documentType = rs.getString("DOCUMENT_TYPE");
		String documentName = rs.getString("Document_name");
		byte[] file = rs.getBytes("DOCUMENT_FILE");

		DocumentDetails documentDetails = new DocumentDetails();

		documentDetails.setDocumentId(documentId);
		documentDetails.setDocumentName(documentName);
		documentDetails.setDocumentType(documentType);
		documentDetails.setFile(file);

		return documentDetails;
	}

}
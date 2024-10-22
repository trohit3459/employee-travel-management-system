package com.rgcorporation.main.repository;

import java.util.List;

import com.rgcorporation.main.model.DocumentDetails;

public interface DocumentDetailRepositoryInterface {
	public DocumentDetails getDocumentDetailsById(int documentId);

	public List<DocumentDetails> getAllDocumentDetails();
}

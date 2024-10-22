package com.rgcorporation.main.service;

import java.util.List;

import com.rgcorporation.main.model.DocumentDetails;

public interface DocumentDetailsServiceInterface {
	public DocumentDetails getDocumentDetailsById(int documentId);
	public List<DocumentDetails> getAllDocumentDetails();
}

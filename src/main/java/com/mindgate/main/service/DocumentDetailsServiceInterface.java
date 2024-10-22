package com.mindgate.main.service;

import java.util.List;

import com.mindgate.main.pojo.DocumentDetails;

public interface DocumentDetailsServiceInterface {
	public DocumentDetails getDocumentDetailsById(int documentId);
	public List<DocumentDetails> getAllDocumentDetails();
}

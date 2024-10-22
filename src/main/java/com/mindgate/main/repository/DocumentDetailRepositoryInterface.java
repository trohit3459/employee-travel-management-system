package com.mindgate.main.repository;

import java.util.List;

import com.mindgate.main.pojo.DocumentDetails;

public interface DocumentDetailRepositoryInterface {
	public DocumentDetails getDocumentDetailsById(int documentId);

	public List<DocumentDetails> getAllDocumentDetails();
}

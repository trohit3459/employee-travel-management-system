package com.rgcorporation.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgcorporation.main.model.DocumentDetails;
import com.rgcorporation.main.repository.DocumentDetailRepositoryInterface;

@Service
public class DocumntDetailsService implements DocumentDetailsServiceInterface {
	@Autowired
	private DocumentDetailRepositoryInterface documentDetailRepository;
	
	@Override
	public DocumentDetails getDocumentDetailsById(int documentId) {
		return documentDetailRepository.getDocumentDetailsById(documentId);
	}

	@Override
	public List<DocumentDetails> getAllDocumentDetails() {
		// TODO Auto-generated method stub
		return documentDetailRepository.getAllDocumentDetails();
	}
	
}

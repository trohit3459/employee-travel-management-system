package com.mindgate.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindgate.main.pojo.DocumentDetails;
import com.mindgate.main.service.DocumentDetailsServiceInterface;

@RestController
@RequestMapping("documentDetails")
public class DocumentDetailsController {
	@Autowired
	private DocumentDetailsServiceInterface serviceInterface;

	@RequestMapping(value = "document/{id}", method = RequestMethod.GET)
	public @ResponseBody DocumentDetails getDocumentDetailsById(@PathVariable("id") int documentId) {

		System.out.println("in document details Byid");
		return serviceInterface.getDocumentDetailsById(documentId);

	}

	@RequestMapping(value = "document", method = RequestMethod.GET)
	public @ResponseBody List<DocumentDetails> getProducts() {
		return serviceInterface.getAllDocumentDetails();
	}

}
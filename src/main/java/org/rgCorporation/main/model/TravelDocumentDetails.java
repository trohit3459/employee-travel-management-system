package org.rgCorporation.main.model;

import java.util.Arrays;

public class TravelDocumentDetails {
	private int documentId;
	private String documentType;
	private String documentName;
	private byte[] documentFile;
	
	public TravelDocumentDetails() {
	}
	public TravelDocumentDetails(int documentId, String documentType, String documentName, byte[] documentFile) {
		super();
		this.documentId = documentId;
		this.documentType = documentType;
		this.documentName = documentName;
		this.documentFile = documentFile;
	}
	public int getDocumentId() {
		return documentId;
	}
	public void setDocumentId(int documentId) {
		this.documentId = documentId;
	}
	public String getDocumentType() {
		return documentType;
	}
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	public String getDocumentName() {
		return documentName;
	}
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}
	public byte[] getDocumentFile() {
		return documentFile;
	}
	public void setDocumentFile(byte[] documentFile) {
		this.documentFile = documentFile;
	}
	@Override
	public String toString() {
		return "TravelDocumentDetails [documentId=" + documentId + ", documentType=" + documentType + ", documentName="
				+ documentName + ", documentFile=" + Arrays.toString(documentFile) + "]";
	}
	
	

}

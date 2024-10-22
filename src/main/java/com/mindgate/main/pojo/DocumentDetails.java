package com.mindgate.main.pojo;

import java.util.Arrays;

import org.springframework.stereotype.Component;
@Component
public class DocumentDetails
{
      private int documentId;
      private String documentType;
      private String documentName;
      private byte[] file;
      
      public DocumentDetails() {

      }

	public DocumentDetails(int documentId, String documentType, String documentName, byte[] file) {
		super();
		this.documentId = documentId;
		this.documentType = documentType;
		this.documentName = documentName;
		this.file = file;
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

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "DocumentDetails [documentId=" + documentId + ", documentType=" + documentType + ", documentName="
				+ documentName + ", file=" + Arrays.toString(file) + "]";
	}
      
      
}

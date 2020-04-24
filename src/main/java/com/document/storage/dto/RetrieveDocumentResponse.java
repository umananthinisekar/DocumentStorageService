/**
 * 
 */
package com.document.storage.dto;

import java.io.Serializable;
import java.util.Arrays;

public class RetrieveDocumentResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2258613788817917721L;
	
	private String docId;
	private byte[] document;
	private String docName;
	private long docSize;

	/**
	 * @return the docId
	 */
	public String getDocId() {
		return docId;
	}
	/**
	 * @param docId the docId to set
	 */
	public void setDocId(String docId) {
		this.docId = docId;
	}
	/**
	 * @return the document
	 */
	public byte[] getDocument() {
		return document;
	}
	/**
	 * @param document the document to set
	 */
	public void setDocument(byte[] document) {
		this.document = document;
	}
	/**
	 * @return the docName
	 */
	public String getDocName() {
		return docName;
	}
	/**
	 * @param docName the docName to set
	 */
	public void setDocName(String docName) {
		this.docName = docName;
	}
	
	/**
	 * @return the docSize
	 */
	public long getDocSize() {
		return docSize;
	}
	/**
	 * @param docSize the docSize to set
	 */
	public void setDocSize(long docSize) {
		this.docSize = docSize;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RetrieveDocumentResponse [docId=" + docId
				+ ", document=" + Arrays.toString(document) + ", docName=" + docName + "]";
	}
	
}

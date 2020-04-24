/**
 * 
 */
package com.document.storage.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RetrieveDocumentRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8178907531951598172L;
	
	@JsonProperty(value="docId", required = true)
	private String docId;
	
	
	/**
	 * @return the docId
	 */
	@JsonProperty(value="docId", required = true)
	public String getDocId() {
		return docId;
	}
	/**
	 * @param docId the docId to set
	 */
	public void setDocId(String docId) {
		this.docId = docId;
	}
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RetrieveDocumentRequest [docId=" + docId + "]";
	}
	
	
}

/**
 * 
 */
package com.document.storage.dto;

import java.io.Serializable;

/**
 * The POJO class to hold the document information in Document Service.
 *
 */
public class DocumentInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2698507926331119004L;
	private String docId;
	private long size;
	private String documentName;
	private String contentType;
	private byte[] document;

	/**
	 * @return the docId
	 */
	public String getDocId() {
		return docId;
	}

	/**
	 * @param docId
	 *            the docId to set
	 */
	public void setDocId(String docId) {
		this.docId = docId;
	}

	/**
	 * @return the size
	 */
	public long getSize() {
		return size;
	}

	/**
	 * @param size
	 *            the size to set
	 */
	public void setSize(long size) {
		this.size = size;
	}

	/**
	 * @return the documentName
	 */
	public String getDocumentName() {
		return documentName;
	}

	/**
	 * @param documentName
	 *            the documentName to set
	 */
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	/**
	 * @return the contentType
	 */
	public String getContentType() {
		return contentType;
	}

	/**
	 * @param contentType
	 *            the contentType to set
	 */
	public void setContentType(String contentType) {
		this.contentType = contentType;
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

	public DocumentInfo() {

	}

	public DocumentInfo(String docId, long size, String documentName, String contentType, byte[] document) {
		this.docId = docId;
		this.size = size;
		this.documentName = documentName;
		this.contentType = contentType;
		this.document = document;
	}

}

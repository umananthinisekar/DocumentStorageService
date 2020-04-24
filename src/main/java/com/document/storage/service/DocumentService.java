/**
 * 
 */
package com.document.storage.service;

import org.springframework.web.multipart.MultipartFile;

import com.document.storage.dto.DocumentInfo;
import com.document.storage.dto.RetrieveDocumentResponse;

public interface DocumentService {

	/**
	 * @param file
	 * @return
	 */
	DocumentInfo storeDocument(MultipartFile file) throws Exception;

	/**
	 * @param docId
	 * @param file
	 * @return
	 */
	void updateDocument(String docId, MultipartFile file) throws Exception;

	/**
	 * @param retrieveDocumentRequest
	 * @return
	 */
	RetrieveDocumentResponse retrieveDocument(String docId);
	
	
	/**
	 * @param docId
	 */
	void deleteDocument(String docId);

}

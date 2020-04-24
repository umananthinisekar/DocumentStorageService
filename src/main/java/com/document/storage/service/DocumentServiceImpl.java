/**
 * 
 */
package com.document.storage.service;

import java.sql.Timestamp;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.document.storage.dto.DocumentInfo;
import com.document.storage.dto.RetrieveDocumentResponse;
import com.document.storage.exception.DocumentException;
import com.document.storage.model.DocumentEntity;
import com.document.storage.repository.DocumentRepository;
import com.document.storage.util.Constant;
import com.document.storage.util.DocumentUtil;

/**
 * The implementation of DocumentService
 *
 */
@Service
public class DocumentServiceImpl implements DocumentService {

	private static final Logger LOG = LoggerFactory.getLogger(DocumentServiceImpl.class);

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	private DocumentRepository documentRepository;

	/**
	 * Saves uploaded document to DB
	 * @throws Exception 
	 */
	@Override
	public DocumentInfo storeDocument(MultipartFile file) throws Exception{
		LOG.debug("Entering DocumentServiceImpl.storeDocument ");
		try {
			String name = file.getOriginalFilename();
			int slashPos = name.lastIndexOf('\\');
			if (slashPos == -1)
				slashPos = name.lastIndexOf('/');
			name = name.substring(slashPos > 0 ? slashPos + 1 : 0);

			DocumentEntity entity = new DocumentEntity();
			entity.setDocId(UUID.randomUUID().toString());
			entity.setDocumentName(name);
			entity.setContentType(file.getContentType());
			entity.setDocument(file.getBytes());
			entity.setDocumentSize(file.getSize());
			entity.setCreateDtm(new Timestamp(System.currentTimeMillis()));
			DocumentEntity savedEntity = documentRepository.save(entity);

			LOG.debug("Exiting DocumentServiceImpl.storeDocument");

			return DocumentUtil.convertToDocumentInfo(savedEntity);

		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			throw e;
		}
	}

	/**
	 * Update existing document in DB
	 * @throws Exception 
	 */
	@Override
	public void updateDocument(String docId, MultipartFile file) throws Exception {
		try {
			LOG.debug("Entering DocumentServiceImpl.updateDocument for docId --> " + docId);

			DocumentEntity docEntityFromDB = documentRepository.findById(docId)
					.orElseThrow(() -> new DocumentException(Constant.DOCREUPLDERR03, Constant.DOCREUPLDERR03_DESC,
							String.format(Constant.DOESNOT_EXISTS, Constant.DOCUMENT, docId), HttpStatus.NOT_FOUND));

			// Update record with updated document from request in DOCUMENT_INFO
			String name = file.getOriginalFilename();
			int slashPos = name.lastIndexOf('\\');
			if (slashPos == -1)
				slashPos = name.lastIndexOf('/');
			name = name.substring(slashPos > 0 ? slashPos + 1 : 0);

			docEntityFromDB.setContentType(file.getContentType());
			docEntityFromDB.setCreateDtm(new Timestamp(System.currentTimeMillis()));
			docEntityFromDB.setDocument(file.getBytes());
			docEntityFromDB.setDocumentName(name);
			docEntityFromDB.setDocumentSize(file.getSize());

			 documentRepository.save(docEntityFromDB);

			LOG.debug("Exiting DocumentServiceImpl.updateDocument for docId --> " + docId);

		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			throw e;
		}
	}

	/**
	 * Retrieve document from DB
	 */
	@Override
	public RetrieveDocumentResponse retrieveDocument(String docId) {
		LOG.debug("Entering DocumentServiceImpl.retrieveDocument for docId --> " + docId);
		RetrieveDocumentResponse retrieveDocumentResponse = new RetrieveDocumentResponse();

		// Logic to check if the doc_id is present in DOCUMENT_INFO table
		try {
			DocumentEntity docEntity = documentRepository.findById(docId)
					.orElseThrow(() -> new DocumentException(Constant.RETDOCERR02, Constant.RETDOCERR02_SVC_ERROR,
							String.format(Constant.DOESNOT_EXISTS, Constant.DOCUMENT, docId), HttpStatus.NOT_FOUND));
			// Generate response
			retrieveDocumentResponse.setDocId(docEntity.getDocId());
			retrieveDocumentResponse.setDocument(docEntity.getDocument());
			retrieveDocumentResponse.setDocName(docEntity.getDocumentName());
			retrieveDocumentResponse.setDocSize(docEntity.getDocumentSize());
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			throw e;
		}
		LOG.debug("Exiting DocumentServiceImpl.retrieveDocument for docId --> " + docId);
		return retrieveDocumentResponse;

	}

	/**
	 * Delete existing document 
	 */
	@Override
	public void deleteDocument(String docId) {
		LOG.debug("Entering DocumentServiceImpl.deleteDocument for docId --> " + docId);
		try {
			DocumentEntity entity = documentRepository.findById(docId)
					.orElseThrow(() -> new DocumentException(Constant.DELDOCERR02, Constant.DELDOCERR02_SVC_ERROR,
							String.format(Constant.DOESNOT_EXISTS, Constant.DOCUMENT, docId), HttpStatus.NOT_FOUND));
			documentRepository.delete(entity);
			LOG.debug("Exiting DocumentServiceImpl.deleteDocument for docId --> " + docId);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			throw e;
		}
	}

}

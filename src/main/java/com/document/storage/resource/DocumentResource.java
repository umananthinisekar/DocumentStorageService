/**
 * 
 */
package com.document.storage.resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.document.storage.dto.DocumentInfo;
import com.document.storage.dto.RetrieveDocumentResponse;
import com.document.storage.exception.DocumentException;
import com.document.storage.service.DocumentService;
import com.document.storage.util.Constant;

/**
 * The class that handles the requests related to document in Document Service.
 *
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = "/storage")
public class DocumentResource {

	private static final Logger LOG = LoggerFactory.getLogger(DocumentResource.class);

	@Autowired
	private DocumentService documentService;

	@PostMapping(path = "/documents/", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<DocumentInfo> storeDocument(@RequestParam("file") MultipartFile file) {
		LOG.debug("Entering  DocumentResource.storeDocument ");
		DocumentInfo documentInfo;

		if (file == null || file.isEmpty() || file.getSize() <= 0) {
			throw new DocumentException(Constant.DOCUPLDERR01, Constant.DOCUPLDERR01_DESC,
					Constant.DOCUPLDERR01_DESC, HttpStatus.BAD_REQUEST);
		}

		try {
			documentInfo = documentService.storeDocument(file);
		} catch (DocumentException dx) {
			LOG.error("DocumentException in DocumentResource.storeDocument -->" + dx.getMsg());
			LOG.info("DocumentException in DocumentResource.storeDocument  -->" + dx);
			throw dx;
		} catch (Exception ex) {
			LOG.error("RuntimeException in DocumentResource.storeDocument -->" + ex.getMessage());
			LOG.info("RuntimeException in DocumentResource.storeDocument  -->" + ex);
			throw new DocumentException(Constant.DOCUPLDSYSERR, Constant.DOCUPLDSYSERR_SVC_ERROR,
					Constant.DOCUPLDSYSERR_DESCRIPTION, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(documentInfo);
	}

	@PutMapping(path = "/documents/{docId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<String> updateDocument(
			@PathVariable(name = Constant.DOCID, required = true) String docId,
			@RequestParam("file") MultipartFile file) {

		LOG.debug("Entering  DocumentResource.updateDocument --> ");
		if (file == null || file.isEmpty() || file.getSize() <= 0) {
			throw new DocumentException(Constant.DOCREUPLDERR01, Constant.DOCREUPLDERR01_DESC,
					Constant.DOCREUPLDERR01_DESC, HttpStatus.BAD_REQUEST);
		}
		if (StringUtils.isBlank(docId)) {
			throw new DocumentException(Constant.DOCREUPLDERR02, Constant.DOCREUPLDERR02_DESC,
					Constant.DOCREUPLDERR02_DESC, HttpStatus.BAD_REQUEST);
		}

		try {
				documentService.updateDocument(docId, file);
		} catch (DocumentException dx) {
			LOG.error("DocumentException in DocumentResource.updateDocument -->" + dx.getMsg());
			LOG.info("DocumentException in DocumentResource.updateDocument  -->" + dx);
			throw dx;
		} catch (Exception ex) {
			LOG.error("RuntimeException in DocumentResource.updateDocument -->" + ex.getMessage());
			LOG.info("RuntimeException in DocumentResource.updateDocument  -->" + ex);
			throw new DocumentException(Constant.DOCREUPLDSYSERR,Constant.DOCREUPLDSYSERR_SVC_ERROR,
					Constant.DOCREUPLDSYSERR_DESCRIPTION,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(Constant.SUCCESS);
	}

	@GetMapping("/documents/{docId}")
	public ResponseEntity<RetrieveDocumentResponse> retrieveDocument(
			@PathVariable(name = Constant.DOCID, required = true) String docId) {
		if (StringUtils.isBlank(docId)) {
			throw new DocumentException(Constant.RETDOCERR01, Constant.RETDOCERR01_SVC_ERROR,
					Constant.RETDOCERR01_DESCRIPTION, HttpStatus.BAD_REQUEST);
		}

		RetrieveDocumentResponse retrieveDocumentResponse = documentService.retrieveDocument(docId);
		return ResponseEntity.ok().body(retrieveDocumentResponse);
	}

	@DeleteMapping("/documents/{docId}")
	public ResponseEntity<String> deleteDocument(@PathVariable(name = Constant.DOCID, required = true) String docId) {
		if (StringUtils.isBlank(docId)) {
			throw new DocumentException(Constant.RETDOCERR01, Constant.RETDOCERR01_SVC_ERROR,
					Constant.RETDOCERR01_DESCRIPTION, HttpStatus.BAD_REQUEST);
		}
		documentService.deleteDocument(docId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(Constant.SUCCESS);
	}

}
/**
 *
 */
package com.document.storage.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.document.storage.dto.DocumentInfo;
import com.document.storage.model.DocumentEntity;
import com.document.storage.resource.DocumentResource;

@Component
public class DocumentUtil {
	private static final Logger LOG = LoggerFactory.getLogger(DocumentResource.class);

	public static DocumentInfo convertToDocumentInfo(DocumentEntity entity) {
		LOG.debug("Entering DocumentUtil.convertToDocumentInfo");
		return new DocumentInfo(entity.getDocId(), entity.getDocumentSize(), entity.getDocumentName(),
				entity.getContentType(), entity.getDocument());
	}

}
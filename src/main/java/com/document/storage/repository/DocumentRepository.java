/**
 *
 */
package com.document.storage.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.document.storage.model.DocumentEntity;

/**
 * The Repository that handles the CRUD operations for the {@link DocumentEntity} in Document Service.
 *
 * @See JpaRepository
 */
public interface DocumentRepository extends JpaRepository<DocumentEntity, String> {


    /**
     * Delete document by doc id.
     *
     * @param docId the doc id
     */
    @Transactional
    @Modifying
    @Query("delete from DocumentEntity docInfo where docInfo.docId = ?1")
    void deleteDocumentByDocId(String docId);

}

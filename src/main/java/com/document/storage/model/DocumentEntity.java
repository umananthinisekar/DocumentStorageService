/**
 *
 */
package com.document.storage.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * The POJO class that represents the Document Entity in Document Service.
 */
@Entity
@Table(name = "document_info")
public class DocumentEntity implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -8291745352466925704L;

    @Id
    @Column(name = "doc_id")
    private String docId;

    @Column(name = "document_name")
    private String documentName;

    @Column(name = "content_type")
    private String contentType;

    @Lob
    @Column(name = "document")
    private byte[] document;

    @Column(name = "document_size")
    private Long documentSize;

    @Column(name = "create_dtm")
    private Timestamp createDtm;

    /**
     * Gets doc id.
     *
     * @return the doc id
     */
    public String getDocId() {
        return docId;
    }

    /**
     * Sets doc id.
     *
     * @param docId the doc id
     */
    public void setDocId(String docId) {
        this.docId = docId;
    }


    /**
     * Gets document name.
     *
     * @return the document name
     */
    public String getDocumentName() {
        return documentName;
    }

    /**
     * Sets document name.
     *
     * @param documentName the document name
     */
    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    /**
     * Gets content type.
     *
     * @return the content type
     */
    public String getContentType() {
        return contentType;
    }

    /**
     * Sets content type.
     *
     * @param contentType the content type
     */
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    /**
     * Get document byte [ ].
     *
     * @return the byte [ ]
     */
    public byte[] getDocument() {
        return document;
    }

    /**
     * Sets document.
     *
     * @param document the document
     */
    public void setDocument(byte[] document) {
        this.document = document;
    }

    /**
     * Gets document size.
     *
     * @return the document size
     */
    public Long getDocumentSize() {
        return documentSize;
    }

    /**
     * Sets document size.
     *
     * @param documentSize the document size
     */
    public void setDocumentSize(Long documentSize) {
        this.documentSize = documentSize;
    }


    /**
     * Gets create dtm.
     *
     * @return the create dtm
     */
    public Timestamp getCreateDtm() {
        return createDtm;
    }

    /**
     * Sets create dtm.
     *
     * @param createDtm the create dtm
     */
    public void setCreateDtm(Timestamp createDtm) {
        this.createDtm = createDtm;
    }

}

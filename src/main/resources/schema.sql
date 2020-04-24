DROP TABLE IF EXISTS DOCUMENT_INFO;
  
CREATE TABLE DOCUMENT_INFO (
  DOC_ID	VARCHAR2(36 BYTE)  NOT NULL  PRIMARY KEY,
  DOCUMENT_NAME      		VARCHAR2(128 BYTE)         NOT NULL,
  CONTENT_TYPE       		VARCHAR2(100 BYTE)         NOT NULL,
  DOCUMENT           		BLOB                       NOT NULL,
  DOCUMENT_SIZE      		NUMBER                     NOT NULL,
  CREATE_DTM				TIMESTAMP(6)        	DEFAULT SYSDATE
);
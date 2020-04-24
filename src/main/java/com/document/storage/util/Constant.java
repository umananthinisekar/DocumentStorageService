/**
 *
 */
package com.document.storage.util;

/**
 * The class to maintain all the constants of the application Document Service.
 */
public final class Constant {

    private Constant() {
    }

    /**
     * The constant SUCCESS.
     */
    public static final String SUCCESS = "Success";
    /**
     * The constant CAN_NOT_NULL.
     */
    public static final String CAN_NOT_NULL = "%s cannot be null or empty";
    /**
     * The constant DOCID.
     */
    public static final String DOCID = "docId";
    /**
     * The constant FILE.
     */
    public static final String FILE = "file";
    /**
     * The constant DOCUMENT.
     */
    public static final String DOCUMENT = "Document";
    /**
     * The constant DOESNOT_EXISTS.
     */
    public static final String DOESNOT_EXISTS = "%s does not exists for docId '%s'";
    /**
     * The constant EMPTY_STRING.
     */
    public static final String EMPTY_STRING = "";
    /**
     * The constant SPACE_STRING.
     */
    public static final String SPACE_STRING = " ";

 // Document Storage service errors
    /**
     * The constant DOCUPLDERR01.
     */
    public static final String DOCUPLDERR01 = "DOCUPLDERR01";
    /**
     * The constant DOCUPLDERR01_DESC.
     */
    public static final String DOCUPLDERR01_DESC = String.format(Constant.CAN_NOT_NULL, Constant.FILE);
    /**
     * The constant DOCUPLDSYSERR.
     */
    public static final String DOCUPLDSYSERR = "DOCUPLDSYSERR";
    /**
     * The constant DOCUPLDSYSERR_SVC_ERROR.
     */
    public static final String DOCUPLDSYSERR_SVC_ERROR = "Exception occurred in service.Check logs";
    /**
     * The constant DOCUPLDSYSERR_DESCRIPTION.
     */
    public static final String DOCUPLDSYSERR_DESCRIPTION = "We are momentarily having service issues. Please try again later.";

    /**
     * The constant DOCREUPLDERR01.
     */
    public static final String DOCREUPLDERR01 = "DOCREUPLDERR01";
    /**
     * The constant DOCREUPLDERR01_DESC.
     */
    public static final String DOCREUPLDERR01_DESC = String.format(Constant.CAN_NOT_NULL, Constant.FILE);
    
    /**
     * The constant DOCREUPLDERR02.
     */
    public static final String DOCREUPLDERR02 = "DOCREUPLDERR02";
    /**
     * The constant DOCREUPLDERR02_DESC.
     */
    public static final String DOCREUPLDERR02_DESC = String.format(Constant.CAN_NOT_NULL, Constant.DOCID);
    
    /**
     * The constant DOCREUPLDERR03.
     */
    public static final String DOCREUPLDERR03 = "DOCREUPLDERR03";
    /**
     * The constant DOCREUPLDERR03_DESC.
     */
    public static final String DOCREUPLDERR03_DESC = "document does not exist";
    /**
     * The constant DOCREUPLDSYSERR.
     */
    public static final String DOCREUPLDSYSERR = "DOCREUPLDSYSERR";
    /**
     * The constant DOCREUPLDSYSERR_SVC_ERROR.
     */
    public static final String DOCREUPLDSYSERR_SVC_ERROR = "Exception occurred in service.Check logs";
    /**
     * The constant DOCREUPLDSYSERR_DESCRIPTION.
     */
    public static final String DOCREUPLDSYSERR_DESCRIPTION = "We are momentarily having service issues. Please try again later.";
    
    //Retrieve document service errors

    /**
     * The constant RETDOCERR01.
     */
    public static final String RETDOCERR01 = "RETDOCERR01";
    /**
     * The constant RETDOCERR01_SVC_ERROR.
     */
    public static final String RETDOCERR01_SVC_ERROR = "docId cannot be null or empty";
    /**
     * The constant RETDOCERR01_DESCRIPTION.
     */
    public static final String RETDOCERR01_DESCRIPTION = "docId cannot be null or empty";
    /**
     * The constant RETDOCERR02.
     */
    public static final String RETDOCERR02 = "RETDOCERR02";
    /**
     * The constant RETDOCERR02_SVC_ERROR.
     */
    public static final String RETDOCERR02_SVC_ERROR = "document does not exist";
    /**
     * The constant RETDOCERR02_DESCRIPTION.
     */
    public static final String RETDOCERR02_DESCRIPTION = "document does not exist";
    /**
     * The constant RETDOCSYSERR.
     */
    public static final String RETDOCSYSERR = "RETDOCSYSERR";
    /**
     * The constant RETDOCSYSERR_SVC_ERROR.
     */
    public static final String RETDOCSYSERR_SVC_ERROR = "Exception occurred in service.Check logs";
    /**
     * The constant RETDOCSVCERR_DESCRIPTION.
     */
    public static final String RETDOCSYSERR_DESCRIPTION = "We are momentarily having service issues. Please try again later.";
    
    
    //Delete document service errors

    /**
     * The constant DELDOCERR01.
     */
    public static final String DELDOCERR01 = "DELDOCERR01";
    /**
     * The constant DELDOCERR01_SVC_ERROR.
     */
    public static final String DELDOCERR01_SVC_ERROR = "docId cannot be null or empty";
    /**
     * The constant DELDOCERR01_DESCRIPTION.
     */
    public static final String DELDOCERR01_DESCRIPTION = "docId cannot be null or empty";
    /**
     * The constant DELDOCERR02.
     */
    public static final String DELDOCERR02 = "DELDOCERR02";
    /**
     * The constant DELDOCERR02_SVC_ERROR.
     */
    public static final String DELDOCERR02_SVC_ERROR = "document does not exist";
    /**
     * The constant DELDOCERR02_DESCRIPTION.
     */
    public static final String DELDOCERR02_DESCRIPTION = "document does not exist";
    /**
     * The constant DELDOCSYSERR.
     */
    public static final String DELDOCSYSERR = "DELDOCSYSERR";
    /**
     * The constant DELDOCSYSERR_SVC_ERROR.
     */
    public static final String DELDOCSYSERR_SVC_ERROR = "Exception occurred in service.Check logs";
    /**
     * The constant DELDOCSYSERR_DESCRIPTION.
     */
    public static final String DELDOCSYSERR_DESCRIPTION = "We are momentarily having service issues. Please try again later.";
    
}

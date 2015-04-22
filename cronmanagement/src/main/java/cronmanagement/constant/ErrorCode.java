package cronmanagement.constant;

public enum ErrorCode {

    /*The enum contains the error codes that are given in response.
    These are mapped in a property file to a message */ 
    SAMPLE_PUBLISHER_ID("PP01_001");          
    
    private String code;
    
    ErrorCode(String code) {
        this.code = code;
    }
    
    public String getCode() {
        return this.code;
    }
}

package code.exception;

import java.io.Serializable;

/**
 * @author knightjxnu
 * @version 1.0
 * @date 2018年1月4日
 * @function : 
 */
public class BaseException extends Exception implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = -4956747057084113815L;
    
    /**
     * 错误代码
     */
    protected String code;
    
    /**
     * 错误信息
     */
    protected String message;
    
    
    public BaseException(String code, String message){
        this.code = code;
        this.message = message;
    }


    public String getCode(){
        return code;
    }

    
    public void setCode(String code){
        this.code = code;
    }

    
    public String getMessage(){
        return message;
    }

    
    public void setMessage(String message){
        this.message = message;
    }
    
    
}

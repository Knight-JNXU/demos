/**
 
* Copyright (c) 2014 knightjxnu All Rights Reserved.
 
*
 
* This software is the confidential and proprietary information of Baozun.
 
* You shall not disclose such Confidential Information and shall use it only in
 
* accordance with the terms of the license agreement you entered into
 
* with Baozun.
 
*
 
* BAOZUN MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF THE
 
* SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 
* IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 
* PURPOSE, OR NON-INFRINGEMENT. BAOZUN SHALL NOT BE LIABLE FOR ANY DAMAGES
 
* SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR DISTRIBUTING
 
* THIS SOFTWARE OR ITS DERIVATIVES.
 
*
 
*/
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

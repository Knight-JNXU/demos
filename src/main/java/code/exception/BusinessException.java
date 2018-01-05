package code.exception;

/**
 * @author knightjxnu
 * @version 1.0
 * @date 2018年1月4日
 * @function : 
 */
public class BusinessException extends BaseException{

    /**
     * 
     */
    private static final long serialVersionUID = 2601266880432979623L;
    
    public BusinessException(String code, String message){
        super(code, message);
    }
    
}

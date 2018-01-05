package code.persister;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.feilong.accessor.cookie.CookieAccessor;

/**
 * @author knightjxnu
 * @version 1.0
 * @date 2018年1月5日
 * @function : 
 */
public class UserCookiePersister implements BasePersister<String>{
    
    /** cookie寄存器. */
    private CookieAccessor cookieAccessor;
    
    public CookieAccessor getCookieAccessor(){
        return cookieAccessor;
    }
    
    public void setCookieAccessor(CookieAccessor cookieAccessor){
        this.cookieAccessor = cookieAccessor;
    }

    @Override
    public String getValue(HttpServletRequest request,HttpServletResponse response){
        return cookieAccessor.getCookieEntity().getValue();
    }
    
    @Override
    public void setValue(String value,HttpServletRequest request,HttpServletResponse response){
        cookieAccessor.save(value, response);
    }
    
    @Override
    public void clear(HttpServletRequest request,HttpServletResponse response){
        cookieAccessor.remove(response);
    }
    
    

}

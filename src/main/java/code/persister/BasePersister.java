package code.persister;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author knightjxnu
 * @version 1.0
 * @date 2018年1月5日
 * @function : 
 */
public interface BasePersister<T>{
    
    /**
     * 获取值
     * @author liuwen
     * @param request
     * @return
     */
    T getValue(HttpServletRequest request,HttpServletResponse response);
    
    /**
     * 保存值
     * @author liuwen
     * @param value
     * @param request
     * @param response
     */
    void setValue(T value,HttpServletRequest request,HttpServletResponse response);
    
    /**
     * 清除
     * @author liuwen
     * @param request
     * @param response
     */
    void clear(HttpServletRequest request,HttpServletResponse response);
}

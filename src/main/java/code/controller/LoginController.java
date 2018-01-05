package code.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.feilong.core.Validator;
import com.feilong.servlet.http.CookieUtil;

import code.persister.UserCookiePersister;

/**
 * @author knightjxnu
 * @version 1.0
 * @date 2018年1月4日
 * @function : 登录
 */
@Controller
public class LoginController extends BaseController{
    
    
    /** The Constant log. */
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
    
    /** 用户名 **/
    private static final String USERNAME = "username";
    
    @Autowired
    private UserCookiePersister userCookiePersister;
    
    /**
     * 进入登录页
     * @author liuwen
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value="/go/login", method=RequestMethod.GET)
    public String goLogin(HttpServletRequest request, HttpServletResponse response, Model model) {
        return "login/login";
    }
    
    /**
     * 登录
     * @author liuwen
     * @param request
     * @param response
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String login(@RequestParam(value="loginname") String loginname, @RequestParam(value="password") String password, HttpServletRequest request, HttpServletResponse response, Model model) throws Exception{
        String result = "";
        
        LOGGER.info("loginname{},password{}", loginname, password);
        
        String loginedName = userCookiePersister.getValue(request, response);
        if(Validator.isNotNullOrEmpty(loginedName) && loginedName.equals(loginname)) {
            result = (loginname+" has logined!");
        }else {
            userCookiePersister.setValue(loginname, request, response);
            result = (loginname+" login success!");
        }
        
        return result;
    }
    
}

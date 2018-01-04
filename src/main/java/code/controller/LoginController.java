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
package code.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.feilong.core.Validator;
import com.feilong.servlet.http.CookieUtil;

import code.exception.BusinessException;

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
    
    /**
     * 进入登录页
     * @author liuwen
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value="/goLogin", method=RequestMethod.GET)
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
        
        Cookie userCookie = CookieUtil.getCookie(request, USERNAME);
        if(Validator.isNotNullOrEmpty(userCookie) && userCookie.getValue().equals(loginname)) {
            result = (loginname+" has logined!");
        }else {
            CookieUtil.addCookie(USERNAME, loginname, response);
            result = (loginname+" login success!");
        }
        
        
        
        return result;
    }
    
}

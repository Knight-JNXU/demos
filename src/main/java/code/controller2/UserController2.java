package code.controller2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author liuwen
 * @version 1.0
 * @date 2018年2月26日
 */
@RequestMapping("/user2")
@Controller
public class UserController2 {
    
    /** The Constant log. */
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController2.class);
    
    @RequestMapping("/login2")
    @ResponseBody
    public String login2(HttpServletRequest request, HttpServletResponse response, Model model) {
	LOGGER.info("login2");
	return "登录成功";
    }
    
}

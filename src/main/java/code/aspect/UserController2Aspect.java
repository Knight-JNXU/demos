package code.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author liuwen
 * @version 1.0
 * @date 2018年2月26日
 */
@Aspect
@Component
public class UserController2Aspect {
    
    /** The Constant log. */
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController2Aspect.class);
    
    
    @Pointcut("execution(java.lang.String code.controller2.UserController2.login2(..))")
    public void login2Point() {
    }
    
    
    @Before("execution(java.lang.String code.controller2.UserController2.login2(..))")
    public void beforeLogin() {
	LOGGER.info("beforeLogin");
    }
    
    @After("login2Point()")
    public void afterLogin() {
	LOGGER.info("afterLogin");
    }
    
}

package code.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
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
public class UserControllerAspect {
    
    /** The Constant log. */
    private static final Logger LOGGER = LoggerFactory.getLogger(UserControllerAspect.class);
    
    
    @Before("execution(java.lang.String code.controller.UserController.login(..))")
    public void beforeLogin() {
	LOGGER.info("beforeLogin");
    }
    
}

package code.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
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
public class StringAspect {
    
    
    /** The Constant log. */
    private static final Logger LOGGER = LoggerFactory.getLogger(StringAspect.class);
    
    @After("execution(* com.feilong.core.lang.StringUtil.split(..))")
    public void afterStringUtilSplit() {
	LOGGER.info("afterStringUtilSplit");
    }
    
    
}

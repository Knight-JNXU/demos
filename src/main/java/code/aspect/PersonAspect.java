package code.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
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
public class PersonAspect {
    
    
    /** The Constant log. */
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonAspect.class);
    
    @Pointcut("execution(void code.behavior.PersonBehavior.eatLunch(..))")
    public void eatLunchPoint() {
    }
    
    @After("eatLunchPoint()")
    public void afterEatLunchPoint() {
	LOGGER.info("afterEatLunchPoint");
    }
    
    @After("execution(void code.behavior.PersonBehavior.eatLunch(..))")
    public void afterEatLunchPoint2() {
	LOGGER.info("afterEatLunchPoint2");
    }
    
}

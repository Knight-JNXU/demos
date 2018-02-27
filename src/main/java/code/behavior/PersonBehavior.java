package code.behavior;
/**
 * @author liuwen
 * @version 1.0
 * @date 2018年2月26日
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class PersonBehavior {
    
    /** The Constant log. */
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonBehavior.class);
    
    public void eatLunch() {
	LOGGER.info("eat lunch");
    }
    
}

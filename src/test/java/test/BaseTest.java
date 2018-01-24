package test;
/**
 * @author knightjxnu
 * @version 1.0
 * @date 2018年1月24日
 * @function : 
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseTest {
    
    
    /** The Constant log. */
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseTest.class);

    /**
     * 
     * @author liuwen
     */
    @Test
    public void stringReplaceTest() {
	String filePath = "\\images\\activity-pc\\Speedo-CN-1920_01.jpg";
	
//	Pattern pattern = Pattern.compile("(\\)");
//	Matcher matcher = pattern.matcher(filePath);
//	while (matcher.find()) {
//	    LOGGER.info("matcher.group():{}", matcher.group());
//	}
	
	LOGGER.info("before change:{}", filePath);
	String resultStr = filePath.replace("\\", "/");
	if (LOGGER.isInfoEnabled()) {
	    LOGGER.info("after change:{}", resultStr);
	}
    }
    
}

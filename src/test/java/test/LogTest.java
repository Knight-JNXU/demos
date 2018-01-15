package test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author knightjxnu
 * @version 1.0
 * @date 2018年1月15日
 * @function : 
 */
public class LogTest{
    
    
    /** The Constant log. */
    private static final Logger LOGGER = LoggerFactory.getLogger(LogTest.class);
    
    
    /**
    * TestLogTest.
    */
    @Test
    public void testLog(){
        String infoStr = "testLog";
        if (LOGGER.isInfoEnabled()){
            LOGGER.info(infoStr);
        }
    }
    
}

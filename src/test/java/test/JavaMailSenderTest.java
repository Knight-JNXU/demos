package test;
/**
 * @author knightjxnu
 * @version 1.0
 * @date 2018年1月31日
 * @function : 
 */

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

public class JavaMailSenderTest extends AbstractJUnit4SpringContextTests {
    
    /** The Constant log. */
    private static final Logger LOGGER = LoggerFactory.getLogger(JavaMailSenderTest.class);
    
//    @Qualifier(value="javaMailSender")
//    @Autowired
//    private JavaMailSenderImpl javaMailSender;

    @Test
    public void baseTest() {
	LOGGER.info("hello world!");
    }
    
//    @Test
//    public void testJavaMailSenderTest() {
//	LOGGER.info("javaMailSender:{}", javaMailSender);
//    }
    
}

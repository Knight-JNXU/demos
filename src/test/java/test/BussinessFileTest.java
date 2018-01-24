package test;

import java.io.File;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import core.BussinessFile;

/**
 * @author knightjxnu
 * @version 1.0
 * @date 2018年1月24日
 * @function : 
 */
public class BussinessFileTest{
    
    
    /** The Constant log. */
    private static final Logger LOGGER = LoggerFactory.getLogger(BussinessFileTest.class);
    

    /**
    * TestBussinessFileTest.
    */
    @Test
    public void testBussinessFileTest(){
        if (LOGGER.isInfoEnabled()){
            LOGGER.info(new BussinessFile("", new File("D:\\all\\code\\work1\\mainland-official-store\\speedo-store-frontend\\src\\main\\webapp\\images\\H20\\last-5.png")).toString());
        }
    }
    
}

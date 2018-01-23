package test;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author knightjxnu
 * @version 1.0
 * @date 2018年1月23日
 * @function : 
 */
public class FileTest{
    
    
    /** The Constant log. */
    private static final Logger LOGGER = LoggerFactory.getLogger(FileTest.class);
    

    /**
    * TestFileTest.
    */
    @Test
    public void testFileTest() throws Exception{
        File file = new File("D:\\all\\code\\work1\\mainland-official-store\\speedo-store-frontend\\src\\main\\webapp\\images\\H20\\last-5.png");
        if (LOGGER.isInfoEnabled()){
            LOGGER.info("file.getCanonicalPath():{}", file.getCanonicalPath());
            LOGGER.info("file.getAbsoluteFile():{}", file.getAbsoluteFile());
        }
    }
    
}

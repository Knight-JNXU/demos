package test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import core.EncodingDetect;

/**
 * @author knightjxnu
 * @version 1.0
 * @date 2018年1月30日
 * @function : 
 */
public class EncodingDetectTest{
    
    /** The Constant log. */
    private static final Logger LOGGER = LoggerFactory.getLogger(EncodingDetectTest.class);
    
    
    /**
    * TestEncodingDetectTest.
    */
    @Test
    public void testEncodingDetectTest(){
        String file1Path = "E:\\software\\game\\test\\out\\0636-0001.png.info.txt";
        String file2Path = "E:\\software\\game\\test\\out\\0636-0002.png.info.txt";
        String file3Path = "E:\\software\\game\\test\\out\\0636-0003.png.info.txt";
        LOGGER.info("file1Path encode:{}", EncodingDetect.getJavaEncodeByFilePath(file1Path));
        LOGGER.info("file2Path encode:{}", EncodingDetect.getJavaEncodeByFilePath(file2Path));
        LOGGER.info("file3Path encode:{}", EncodingDetect.getJavaEncodeByFilePath(file3Path));
    }
    
}

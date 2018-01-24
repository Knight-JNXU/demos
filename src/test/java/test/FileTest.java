package test;

import static org.junit.Assert.*;

import java.io.File;
import java.text.DecimalFormat;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.feilong.io.FileUtil;

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
        File file2 = new File("D:\\all\\code\\work1\\mainland-official-store\\speedo-store-frontend\\src\\main\\webapp\\images\\activity-pc\\Speedo VClass Video_ CN.mp4");
        DecimalFormat df = new DecimalFormat("0.000");
        if (LOGGER.isInfoEnabled()){
            LOGGER.info("file.getCanonicalPath():{}", file.getCanonicalPath());
            LOGGER.info("file.getAbsoluteFile():{}", file.getAbsoluteFile());
            LOGGER.info("FileUtil.getFileFormatSize(file):{}", FileUtil.getFileFormatSize(file));
            LOGGER.info("FileUtil.getFileFormatSize(file2):{}", FileUtil.getFileFormatSize(file2));
            LOGGER.info("FileUtil.getFileSize(file):{}", FileUtil.getFileSize(file));
            LOGGER.info("FileUtil.getFileSize(file2):{}", FileUtil.getFileSize(file2));
            LOGGER.info("FileUtil.getFileSize(file)/1048576:{}M", df.format(new Double(FileUtil.getFileSize(file))/1048576));
            LOGGER.info("FileUtil.getFileSize(file2)/1048576:{}M", df.format(new Double(FileUtil.getFileSize(file2))/1048576));
        }
    }
    
}

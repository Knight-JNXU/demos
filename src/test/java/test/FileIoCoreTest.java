package test;

import static org.junit.Assert.*;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Set;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.feilong.json.jsonlib.JsonUtil;

import core.EncodingDetect;
import core.FileIoCore;

/**
 * @author knightjxnu
 * @version 1.0
 * @date 2018年1月24日
 * @function : 
 */
public class FileIoCoreTest{
    
    
    /** The Constant log. */
    private static final Logger LOGGER = LoggerFactory.getLogger(FileIoCoreTest.class);
    
    private String filePath = "D:\\all\\code\\demos\\BaseSpring\\src\\main\\java\\code\\dto\\BaseResult.java";

    /**
    * TestFileIoCoreTest.
    */
    @Test
    public void encodingDetectTest() throws Exception{
        String fileEncode=EncodingDetect.getJavaEncodeByFilePath("D:\\all\\code\\demos\\PictureReferenceProgram\\src\\main\\java\\core\\EncodingDetect.java");  
        LOGGER.info(fileEncode);
        String readFileToString = FileIoCore.getFileContentByAbsolutePath("D:\\all\\code\\demos\\PictureReferenceProgram\\src\\main\\java\\core\\EncodingDetect.java");
        LOGGER.info(readFileToString);
    }
    
    
    /**
     * 在 directory 下获取文件名符合 fileNamePartten 的文件，把 文件中符合 contentPartten 的字符串提取出来
     * @author knightjxnu
     * @throws Exception
     */
    @Test
    public void getContentInDirectoryTest() throws Exception{
	Set<String> contentInDirectory = FileIoCore.getContentInDirectory("D:\\all\\code\\work1\\mainland-official-store\\speedo-store-frontend", ".+(\\.jsp|\\.css|\\.js)$", "(/images/)([^.]+)(\\.jpg|\\.JPG|\\.jpeg|\\.JPEG|\\.png|\\.PNG|\\.gig|\\.GIF)");
        if (LOGGER.isInfoEnabled()){
            LOGGER.info("contentInDirectory:{}", JsonUtil.format(contentInDirectory));
        }
    }
    
}

package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import core.FileCore;
import core.FileFormatConversionCore;

/**
 * @author knightjxnu
 * @version 1.0
 * @date 2018年1月30日
 * @function : 
 */
public class BatchFormatConversionTest{
    
    /** The Constant log. */
    private static final Logger LOGGER = LoggerFactory.getLogger(BatchFormatConversionTest.class);

    /**
     * 将UTF-8的txt文件转换成GB2312文件
     * @author knightjxnu
     * @throws Exception 
     */
    @Test
    public void batchUTF8Txt2GB2312() throws Exception{
        String directory = "E:\\software\\game\\test\\out";
        String patternStr = ".+(\\.txt)$";
        List<File> filesInDirectoryByPattern = FileCore.getFilesInDirectoryByPattern(directory, patternStr);
        for (File file : filesInDirectoryByPattern){
            FileUtils.writeLines(new File(file.getAbsolutePath()), "GB2312", FileUtils.readLines(new File(file.getAbsolutePath()), "UTF-8"));
            if (LOGGER.isInfoEnabled()){
                LOGGER.info(file.getAbsolutePath());
            }
        }
    }
    
    
    

    
    @Test
    public void batchFileFormatConversionTest() throws Exception{
        String directory = "E:\\software\\game\\test\\out";
        String patternStr = ".+(\\.txt)$";
        String formFileFormat = "UTF-8";
        String toFileFormat = "GB2312";
        FileFormatConversionCore.batchFileFormatConversion(directory, patternStr, formFileFormat, toFileFormat);
    }
}

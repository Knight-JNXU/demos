package core;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;

/**
 * @author knightjxnu
 * @version 1.0
 * @date 2018年1月30日
 * @function : 文件格式转换
 */
public class FileFormatConversionCore{
    
    /**
     * 把 directory 目录下，文件名称符合 patternStr 正则的文件格式从 formFileFormat 转换到 toFileFormat
     * @author knightjxnu
     * @param directory
     * @param patternStr
     * @param formFileFormat
     * @param toFileFormat
     * @throws Exception
     */
    public static void batchFileFormatConversion(String directory, String patternStr, String formFileFormat, String toFileFormat) throws Exception{
        List<File> filesInDirectoryByPattern = FileCore.getFilesInDirectoryByPattern(directory, patternStr);
        for (File file : filesInDirectoryByPattern){
            FileUtils.writeLines(new File(file.getAbsolutePath()), toFileFormat, FileUtils.readLines(new File(file.getAbsolutePath()), formFileFormat));
        }
    }
    
}

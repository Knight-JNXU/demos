package core;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.feilong.io.FilenameUtil;

/**
 * @author knightjxnu
 * @version 1.0
 * @date 2018年1月15日
 * @function : 
 */
public class FileCore{
    
    /** The Constant log. */
    private static final Logger LOGGER = LoggerFactory.getLogger(FileCore.class);
    
    /**
     * 递归遍历文件
     * @author liuwen
     * @param directory
     * @param fileFolderList
     */
    public static void fileTraversalRecursive(String directory, List<File> fileFolderList) {
        File file = new File(directory);  
        if (file.exists()) {  
            File[] files = file.listFiles();  
            if (files.length == 0) {  
                LOGGER.info("folder ({}) is empty!", directory);  
                return;  
            } else {  
                for (File file2 : files) {  
                    if (file2.isDirectory()) {  
//                        LOGGER.info("folder:" + file2.getAbsolutePath());  
                        fileFolderList.add(file2);
                        fileTraversalRecursive(file2.getAbsolutePath(), fileFolderList); 
                    } else {  
                        fileFolderList.add(file2);
//                        LOGGER.info("file:" + file2.getAbsolutePath());  
                    }  
                }  
            }  
        } else {  
            LOGGER.info("folder ({}) does not exist!", directory);  
        }
    }
    
    /**
     * 获取文件和文件夹
     * @author liuwen
     * @param directory
     * @return
     */
    public static List<File> getAllFilesFoldersInDirectory(String directory){
        List<File> fileFolderList = new ArrayList<>();
        fileTraversalRecursive(directory, fileFolderList);
        return fileFolderList;
    }
    
    
    /**
     * 获取文件
     * @author liuwen
     * @param directory
     * @return
     */
    public static List<File> getAllFilesInDirectory(String directory){
        List<File> fileList = new ArrayList<>();
        List<File> tempfileList = getAllFilesFoldersInDirectory(directory);
        for(File file : tempfileList) {
            if(!file.isDirectory()) {
                fileList.add(file);
            }
        }
        return fileList;
    }
    
    /**
     * 提取文件名拓展名
     * @author liuwen
     * @param directory
     * @return
     */
    public static Set<String> getFileExtensionInDirectory(String directory){
        Set<String> fileSuffixSet = new HashSet<>();
        List<File> fileList = getAllFilesInDirectory(directory);
        for (File file : fileList){
            String extensionName = FilenameUtil.getExtension(file.getAbsolutePath());
            fileSuffixSet.add(extensionName);
        }
        return fileSuffixSet;
    }
    
    /**
     * 根据正则表达式在某个目录下获取文件
     * @author liuwen
     * @param directory
     * @param pattern
     * @return
     */
    public static List<File> getFilesInDirectoryByPattern(String directory, String pattern){
        List<File> fileList = new ArrayList<>();
        List<File> tempfileList = getAllFilesInDirectory(directory);
        for (File file : tempfileList){
            if(Pattern.matches(pattern, file.getAbsolutePath())) {
                fileList.add(file);
            }
        }
        return fileList;
    }
    
    
    /**
     * 输出文件绝对路径
     * @author liuwen
     * @param fileList
     */
    public static void printFileAbsolutePath(List<File> fileList) {
        for (File file : fileList){
            LOGGER.info(file.getAbsolutePath());
        }
    }
}

package core;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
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
     * @author knightjxnu
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
     * @author knightjxnu
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
     * @author knightjxnu
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
     * @author knightjxnu
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
     * 在目录 directory 下获取文件绝对路径符合正则表达式 patternStr 的文件
     * @author knightjxnu
     * @param directory
     * @param patternStr
     * @return
     */
    public static List<File> getFilesInDirectoryByPattern(String directory, String patternStr){
        List<File> fileList = new ArrayList<>();
        List<File> tempfileList = getAllFilesInDirectory(directory);
        for (File file : tempfileList){
            if(Pattern.matches(patternStr, file.getAbsolutePath())) {
                fileList.add(file);
            }
        }
        return fileList;
    }
    
    /**
     * 提取路径 directory 下所有 满足 picExtensionPatternStr 正则的文件、子文件绝对路径中符合 patternStr 正则的部分路径
     * @author knightjxnu
     * @param directory
     * @param picExtensionPatternStr 图片后缀
     * @param patternStr 需要提取的路径正则
     * @return
     */
    public static List<BussinessFile> getFilePartialPathByDirectoryPattern(String directory, String picExtensionPatternStr, String patternStr){
        List<BussinessFile> bussinessFileList = new ArrayList<>();
        List<File> fileList = getFilesInDirectoryByPattern(directory, picExtensionPatternStr);
        Pattern pattern = Pattern.compile(patternStr);
        for (File file : fileList){
            Matcher matcher = pattern.matcher(file.getAbsolutePath());
            while (matcher.find()){
                BussinessFile bussinessFile = new BussinessFile(matcher.group(), file);
                bussinessFileList.add(bussinessFile);
            }
        }
        return bussinessFileList;
    }
    
    
    /**
     * 输出文件绝对路径
     * @author knightjxnu
     * @param fileList
     */
    public static void printFileListAbsolutePath(List<File> fileList) {
        for (File file : fileList){
            LOGGER.info(file.getAbsolutePath());
        }
    }
    
    /**
     * 输出bussinessFileList
     * @author knightjxnu
     * @param bussinessFileList
     */
    public static void printBussinessFileListAbsolutePath(List<BussinessFile> bussinessFileList) {
        for (BussinessFile bussinessFile : bussinessFileList){
            LOGGER.info(bussinessFile.toString());
        }
    }
    
    
}

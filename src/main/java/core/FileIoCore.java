package core;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author knightjxnu
 * @version 1.0
 * @date 2018年1月24日
 * @function : 
 */
public class FileIoCore{
    
    
    /** The Constant log. */
    private static final Logger LOGGER = LoggerFactory.getLogger(FileIoCore.class);
    
    /**
     * 获取文件内容
     * @author knightjxnu
     * @param fileAbsolutePath
     * @return
     * @throws Exception
     */
    public static String getFileContentByAbsolutePath(String fileAbsolutePath) throws Exception{
        String fileContent = getFileContentByFile(new File(fileAbsolutePath));
        return fileContent;
    }
    
    /**
     * 获取文件内容
     * @author knightjxnu
     * @param file
     * @return
     * @throws Exception
     */
    public static String getFileContentByFile(File file) throws Exception{
        String fileContent = FileUtils.readFileToString(file);
        fileContent = fileContent.replaceAll("\\s", "");
        return fileContent;
    }
    
    /**
     * 在 directory 下获取文件名符合 fileNamePartten 的文件，把 文件中符合 contentPartten 的字符串提取出来
     * @author knightjxnu
     * @param directory
     * @param fileNameParttenStr
     * @param contentParttenStr
     * @return
     */
    public static Set<String> getContentInDirectory(String directory, String fileNameParttenStr, String contentParttenStr) throws Exception{
        Set<String> conformContentSet = new HashSet<>();
        List<File> filesInDirectoryByPattern = FileCore.getFilesInDirectoryByPattern(directory, fileNameParttenStr);
        for (File file : filesInDirectoryByPattern){
            String fileContent = getFileContentByFile(file);
            Pattern contentPartten = Pattern.compile(contentParttenStr);
            Matcher contentMatcher = contentPartten.matcher(fileContent);
            LOGGER.info("fileContent:{}", fileContent);
            while(contentMatcher.find()) {
                conformContentSet.add(contentMatcher.group());
//                LOGGER.info("contentMatcher.groupCount():{}", contentMatcher.groupCount());
//                for(int i=1; i<contentMatcher.groupCount(); i++) {
//                    LOGGER.info("contentMatcher.group(i):{}", contentMatcher.group(i));
//                    conformContentSet.add(contentMatcher.group(i));
//                }
            }
        }
        return conformContentSet;
    }
    
}

package test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.feilong.core.util.SortUtil;

import core.FileCore;

/**
 * @author knightjxnu
 * @version 1.0
 * @date 2018年1月23日
 * @function : 
 */
public class FileCoreTest{
    
    /** The Constant log. */
    private static final Logger LOGGER = LoggerFactory.getLogger(FileCoreTest.class);
    
    private String directory = "D:\\all\\code\\work1\\mainland-official-store\\speedo-store-frontend\\src\\main\\webapp\\images";
    
    /**
    * TestCoreTest.
    */
    @Test
    public void fileTraversalRecursiveTest(){
        List<File> fileFolderList = new ArrayList<>();
        FileCore.fileTraversalRecursive(directory, fileFolderList);
    }
    
    /**
     * 验证是否有重复的文件
     * @author liuwen
     */
    @Test
    public void getAllFilesFoldersInDirectoryTest(){
        List<File> fileFolderList = FileCore.getAllFilesFoldersInDirectory(directory);
        List<String> fileFolderNameList = new ArrayList<>();
        Set<String> fileFolderNameSet = new HashSet<>();
        for (File file : fileFolderList){
            fileFolderNameList.add(file.getAbsolutePath());
            fileFolderNameSet.add(file.getAbsolutePath());
        }
        LOGGER.info("fileFolderNameList.size():{}, fileFolderNameSet.size():{}", fileFolderNameList.size(), fileFolderNameSet.size());
        fileFolderList = SortUtil.sortList(fileFolderList);
        for (String name : fileFolderNameList){
            LOGGER.info(name);
        }
    }
    
    
    

    /**
    * TestFileCoreTest.
    */
    @Test
    public void getAllFilesInDirectoryTest(){
        List<File> allFilesInDirectory = FileCore.getAllFilesInDirectory(directory);
        for (File file : allFilesInDirectory){
            LOGGER.info(file.getAbsolutePath());
        }
    }
    
    
    

    /**
    * TestFileCoreTest.
    */
    @Test
    public void getFileSuffixInDirectoryTest(){
        Set<String> fileSuffixInDirectory = FileCore.getFileExtensionInDirectory(directory);
        if (LOGGER.isInfoEnabled()){
            LOGGER.info("fileSuffixInDirectory:{}",fileSuffixInDirectory.toString());
        }
    }
    

    /**
    * TestFileCoreTest.
    */
    @Test
    public void getFilesInDirectoryByPatternTest(){
        String pattern = ".+(.jpg|.mp4|.JPG|.ico|.mov|.gif|.png|.webm)$";
        List<File> filesInDirectoryByPattern = FileCore.getFilesInDirectoryByPattern(directory, pattern);
        FileCore.printFileAbsolutePath(filesInDirectoryByPattern);
    }
    
}

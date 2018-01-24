package test;

import static org.junit.Assert.*;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.feilong.core.util.CollectionsUtil;

import core.BussinessFile;
import core.FileCore;
import core.FileIoCore;
import core.PrintUtil;

/**
 * @author knightjxnu
 * @version 1.0
 * @date 2018年1月24日
 * @function : 
 */
public class CompleteTest{
    
    
    /** The Constant log. */
    private static final Logger LOGGER = LoggerFactory.getLogger(CompleteTest.class);
    
    /**
    * TestCompleteTest.
    */
    @Test
    public void tempTest() throws Exception{
	String directory = "D:\\test\\speedo-store-frontend\\src\\main\\webapp";
	 Set<String> contentInDirectory = FileIoCore.getContentInDirectory(directory, ".+(\\.jsp|\\.css|\\.js)$", "(/images/)([^.]+)(\\.jpg|\\.JPG|\\.jpeg|\\.JPEG|\\.png|\\.PNG|\\.gig|\\.GIF)");
	 List<BussinessFile> filePartialPathByDirectoryPattern = FileCore.getFilePartialPathByDirectoryPattern(directory, ".+(\\.jpg|\\.JPG|\\.jpeg|\\.JPEG|\\.png|\\.PNG|\\.gig|\\.GIF)$", ".+(\\\\images\\\\.+(\\.jpg|\\.JPG|\\.jpeg|\\.JPEG|\\.png|\\.PNG|\\.gig|\\.GIF))$");
	 
	 LOGGER.info("==========================================");
         LOGGER.info("original");
         PrintUtil.printContentSet(contentInDirectory);
         PrintUtil.printBussinessFileSetAbsolutePath(filePartialPathByDirectoryPattern);
    	 
    	 //没有被使用的图片
    	 for (String picName : contentInDirectory) {
    	     BussinessFile usedPic = CollectionsUtil.find(filePartialPathByDirectoryPattern, "filePath", picName);
    	     filePartialPathByDirectoryPattern.remove(usedPic);
    	 }
    	 
    	 LOGGER.error("==========================================");
    	 LOGGER.error("analysis");
    	 PrintUtil.printBussinessFileSetAbsolutePath(filePartialPathByDirectoryPattern);
    	 PrintUtil.printBussinessFileSetTotalSize(filePartialPathByDirectoryPattern, 1024*1024l, "M", new DecimalFormat("0.000"));
    }
    
    /**
     * 检测fronted是否有没有被 jsp css 引用的图片
     */
     @Test
     public void frontedUnusedPicTest() throws Exception{
//	 String directory = "D:\\test\\speedo-store-frontend";
	 String directory = "D:\\all\\code\\work1\\mainland-official-store\\speedo-store-frontend\\src\\main\\webapp";
         Set<String> contentInDirectory = FileIoCore.getContentInDirectory(directory, ".+(\\.jsp|\\.css|\\.js)$", "(/images/)([^.]+)(\\.jpg|\\.JPG|\\.jpeg|\\.JPEG|\\.png|\\.PNG|\\.gig|\\.GIF)");
         List<BussinessFile> filePartialPathByDirectoryPattern = FileCore.getFilePartialPathByDirectoryPattern(directory, ".+(\\.jpg|\\.JPG|\\.jpeg|\\.JPEG|\\.png|\\.PNG|\\.gig|\\.GIF)$", ".+(\\\\images\\\\.+(\\.jpg|\\.JPG|\\.jpeg|\\.JPEG|\\.png|\\.PNG|\\.gig|\\.GIF))$");
         
//         LOGGER.info("==========================================");
//         LOGGER.info("original");
//         PrintUtil.printContentSet(contentInDirectory);
//         PrintUtil.printBussinessFileSetAbsolutePath(filePartialPathByDirectoryPattern);
         
         //没有被使用的图片
         for (String picName : contentInDirectory) {
             BussinessFile usedPic = CollectionsUtil.find(filePartialPathByDirectoryPattern, "filePath", picName);
             filePartialPathByDirectoryPattern.remove(usedPic);
         }
         
         LOGGER.info("==========================================");
         LOGGER.info("analysis");
         PrintUtil.printBussinessFileSetAbsolutePath(filePartialPathByDirectoryPattern);
         LOGGER.info("pc");
         PrintUtil.printBussinessFileSetTotalSize(filePartialPathByDirectoryPattern, 1024*1024l, "M", new DecimalFormat("0.000"));
     }
     
     /**
      * 检测mobile是否有没有被 jsp css 引用的图片
      */
     @Test
     public void mobileUnusedPicTest() throws Exception{
	 String directory = "D:\\all\\code\\work1\\mainland-official-store\\speedo-store-mobile\\src\\main\\webapp";
	 Set<String> contentInDirectory = FileIoCore.getContentInDirectory(directory, ".+(\\.jsp|\\.css|\\.js)$", "(/images/)([^.]+)(\\.jpg|\\.JPG|\\.jpeg|\\.JPEG|\\.png|\\.PNG|\\.gig|\\.GIF)");
	 List<BussinessFile> filePartialPathByDirectoryPattern = FileCore.getFilePartialPathByDirectoryPattern(directory, ".+(\\.jpg|\\.JPG|\\.jpeg|\\.JPEG|\\.png|\\.PNG|\\.gig|\\.GIF)$", ".+(\\\\images\\\\.+(\\.jpg|\\.JPG|\\.jpeg|\\.JPEG|\\.png|\\.PNG|\\.gig|\\.GIF))$");
	 
	 //没有被使用的图片
	 for (String picName : contentInDirectory) {
	     BussinessFile usedPic = CollectionsUtil.find(filePartialPathByDirectoryPattern, "filePath", picName);
	     filePartialPathByDirectoryPattern.remove(usedPic);
	 }
	 
	 LOGGER.error("==========================================");
	 LOGGER.error("analysis");
	 PrintUtil.printBussinessFileSetAbsolutePath(filePartialPathByDirectoryPattern);
	 LOGGER.info("mobile");
	 PrintUtil.printBussinessFileSetTotalSize(filePartialPathByDirectoryPattern, 1024*1024l, "M", new DecimalFormat("0.000"));
     }
     
}

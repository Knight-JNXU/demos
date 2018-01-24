package core;

import java.io.File;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.feilong.io.FileUtil;

/**
 * @author knightjxnu
 * @version 1.0
 * @date 2018年1月24日
 * @function : 
 */
public class PrintUtil {
    
    
    /** The Constant log. */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrintUtil.class);
    
    
    /**
     * 输出文件绝对路径
     * 
     * @author knightjxnu
     * @param fileList
     */
    public static void printFileSetAbsolutePath(List<File> fileList) {
	for (File file : fileList) {
	    LOGGER.info(file.getAbsolutePath());
	}
    }

    /**
     * 输出bussinessFileList
     * 
     * @author knightjxnu
     * @param bussinessFileList
     */
    public static void printBussinessFileSetAbsolutePath(List<BussinessFile> bussinessFileList) {
	LOGGER.info("BussinessFile list (size {} ): ", bussinessFileList.size());
	for (BussinessFile bussinessFile : bussinessFileList) {
	    LOGGER.info(bussinessFile.toString());
	}
    }

    /**
     * 计算文件总大小
     * 
     * @author liuwen
     * @param bussinessFileList
     */
    public static void printBussinessFileSetTotalSize(List<BussinessFile> bussinessFileList,
	    long sizeConversionCoefficient, String unitStr, DecimalFormat fileSizeFormat) {
	double totalSize = 0d;
	for (BussinessFile bussinessFile : bussinessFileList) {
	    totalSize += FileUtil.getFileSize(bussinessFile.getFile());
	}
	totalSize /= sizeConversionCoefficient;
	String totalSizeStr = fileSizeFormat.format(totalSize);
	LOGGER.info("total file size : {} {}",totalSizeStr, unitStr);
    }
    
    /**
     * 输出提取物 contentSet
     * @author liuwen
     * @param contentSet
     */
    public static void printContentSet(Set<String> contentSet) {
	for (String string : contentSet) {
	    LOGGER.info(string);
	}
    }
    
}

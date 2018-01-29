package core;

import java.util.List;
import java.util.Set;

import com.feilong.core.util.CollectionsUtil;

/**
 * @author knightjxnu
 * @version 1.0
 * @date 2018年1月29日
 * @function : 
 */
public class AnalysisCore {
    
    /**
     * 获取没有被引用的图片
     * @author knightjxnu
     * @param analysisDirectory 需要分析的文件夹
     * @param picReferenceFileExtensionPattern	引用图片的文件（如 jsp、css、js等）拓展名正则
     * @param picReferencePathPattern	提取引用路径的正则（如 提取单位引用路径是 /images/speedo-1kwet-active/cap-big1.jpg）
     * @param picExtensionPattern	图片拓展名（如 jpg、JPG、png等）正则
     * @param picPathPattern	图片路径提取（如 /images/temp/templates/news3.jpg）正则
     * @return
     * @throws Exception
     */
    public static List<BussinessFile> getUselessPicList(String analysisDirectory, String picReferenceFileExtensionPattern, String picReferencePathPattern, String picExtensionPattern, String picPathPattern) throws Exception{
	Set<String> contentInDirectory = FileIoCore.getContentInDirectory(analysisDirectory, picReferenceFileExtensionPattern, picReferencePathPattern);
	 List<BussinessFile> filePartialPathByDirectoryPattern = FileCore.getFilePartialPathByDirectoryPattern(analysisDirectory, picExtensionPattern, picPathPattern);
	 
	 //没有被使用的图片
	 for (String picName : contentInDirectory) {
	     BussinessFile usedPic = CollectionsUtil.find(filePartialPathByDirectoryPattern, "filePath", picName);
	     filePartialPathByDirectoryPattern.remove(usedPic);
	 }
	 
	 return filePartialPathByDirectoryPattern;
    }
    
}

package core;

import java.io.File;
import java.text.DecimalFormat;

import com.feilong.io.FileUtil;

/**
 * @author knightjxnu
 * @version 1.0
 * @date 2018年1月24日
 * @function :
 */
public class BussinessFile{

    /**
     * 文件路径，可根据需求修改
     */
    private String filePath;

    private File file;

    // 文件大小显示格式
    private DecimalFormat fileSizeFormat;

    // 文件大小转换系数
    private long sizeConversionCoefficient;

    // 文件大小默认显示格式
    private final DecimalFormat DEFAULT_FILE_SIZE_FORMAT = new DecimalFormat("0.000");

    private final long SIZE_CONVERSION_COEFFICIENT_MEGABYTE = 1048576l;

    // 初始化块
    {
        fileSizeFormat = DEFAULT_FILE_SIZE_FORMAT;
        sizeConversionCoefficient = SIZE_CONVERSION_COEFFICIENT_MEGABYTE;
    }

    public BussinessFile(){
        super();
    }

    public BussinessFile(String filePath, File file){
        this.filePath = filePath;
        this.file = file;
    }

    public String getFilePath(){
        return filePath;
    }

    public void setFilePath(String filePath){
        this.filePath = filePath;
    }

    public File getFile(){
        return file;
    }

    public void setFile(File file){
        this.file = file;
    }

    public DecimalFormat getFileSizeFormat(){
        return fileSizeFormat;
    }

    public void setFileSizeFormat(DecimalFormat fileSizeFormat){
        this.fileSizeFormat = fileSizeFormat;
    }

    public long getSizeConversionCoefficient(){
        return sizeConversionCoefficient;
    }

    public void setSizeConversionCoefficient(long sizeConversionCoefficient){
        this.sizeConversionCoefficient = sizeConversionCoefficient;
    }

    @Override
    public String toString(){
        return "BussinessFile [filePath = " + filePath + ", file.size= " + fileSizeFormat.format(new Double(FileUtil.getFileSize(file))/sizeConversionCoefficient) + " M]";
    }

}

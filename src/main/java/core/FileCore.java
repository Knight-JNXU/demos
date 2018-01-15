package core;

import java.io.File;

/**
 * @author knightjxnu
 * @version 1.0
 * @date 2018年1月15日
 * @function : 
 */
public class FileCore{
    
    public static void fileTraversal(String directory) {
        File file = new File(directory);  
        if (file.exists()) {  
            File[] files = file.listFiles();  
            if (files.length == 0) {  
                System.out.println("文件夹是空的!");  
                return;  
            } else {  
                for (File file2 : files) {  
                    if (file2.isDirectory()) {  
                        System.out.println("文件夹:" + file2.getAbsolutePath());  
                        fileTraversal(file2.getAbsolutePath());  
                    } else {  
                        System.out.println("文件:" + file2.getAbsolutePath());  
                    }  
                }  
            }  
        } else {  
            System.out.println("文件不存在!");  
        }
    }
    
}

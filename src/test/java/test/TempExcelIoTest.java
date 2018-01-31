package test;
/**
 * @author knightjxnu
 * @version 1.0
 * @date 2018年1月25日
 * @function : 
 */


import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashSet;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import core.ExcelFileIoCore;

public class TempExcelIoTest {
    
    /** The Constant log. */
    private static final Logger LOGGER = LoggerFactory.getLogger(TempExcelIoTest.class);

    /**
     * 
     * @author knightjxnu
     */
    @Test
    public void poiTest() {
	if (LOGGER.isInfoEnabled()) {
	    LOGGER.info(new Double("1.25").toString());
	}
    }
    
    
    

    /**
     * 
     * @author knightjxnu
     */
    @Test
    public void getCellStrValueTest() throws Exception{
	XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new File("D:\\test.xlsx"));
        Sheet sheetAt = xssfWorkbook.getSheetAt(0);
        String cellStrValue = ExcelFileIoCore.getCellStrValue(ExcelFileIoCore.getCellBySheetRanks(sheetAt, 0, 0));
        if (LOGGER.isInfoEnabled()) {
	    LOGGER.info(cellStrValue);
	}
        String cellStrValue2 = ExcelFileIoCore.getCellStrValue(ExcelFileIoCore.getCellBySheetRanks(sheetAt, 3, 3));
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info(cellStrValue2);
        }
        String cellStrValue3 = ExcelFileIoCore.getCellStrValue(ExcelFileIoCore.getCellBySheetRanks(sheetAt, 2, 2));
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info(cellStrValue3);
            if("关键词名称".equals(cellStrValue3)) {
        	LOGGER.info("equal");
            }
        }
    }
    
    /**
    * 获取列数.
    */
    @Test
    public void getColumnCountTest() throws Exception{
	XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new File("D:\\test2.xlsx"));
        XSSFSheet sheetAt = xssfWorkbook.getSheetAt(0);
        XSSFRow row = sheetAt.getRow(2);
        int physicalNumberOfCells = row.getPhysicalNumberOfCells();
        if (LOGGER.isInfoEnabled()) {
	    LOGGER.info(""+physicalNumberOfCells);
	}
        XSSFRow row2 = sheetAt.getRow(0);
        int physicalNumberOfCells2 = row2.getPhysicalNumberOfCells();
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info(""+physicalNumberOfCells2);
        }
    }
    /**
     * 获取行数.
     */
    @Test
    public void getRowCountTest() throws Exception{
	XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new File("D:\\test2.xlsx"));
	XSSFSheet sheetAt = xssfWorkbook.getSheetAt(0);
	XSSFRow row = sheetAt.getRow(2);
	int physicalNumberOfCells = row.getPhysicalNumberOfCells();
	XSSFRow row2 = sheetAt.getRow(0);
	float columnWidthInPixels = sheetAt.getColumnWidthInPixels(0);
	LOGGER.info("columnOutlineLevel:{}", columnWidthInPixels);
    }
    
    /**
     * 
     * @author knightjxnu
     */
    @Test
    public void testTempExcelIoTest() throws Exception{
	Set<String> sensitiveWordsSet = new HashSet<>();
	XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new File("D:\\test.xlsx"));
        XSSFSheet sheetAt = xssfWorkbook.getSheetAt(0);
        XSSFRow row = sheetAt.getRow(2);
        int physicalNumberOfCells = row.getPhysicalNumberOfCells();
        for(int columnNum=0; columnNum<physicalNumberOfCells; columnNum++) {
            int maxRowNum = row.getRowNum();
            for(int rowNum=3; rowNum<maxRowNum; rowNum++) {
        	String word = ExcelFileIoCore.getCellStrValue(ExcelFileIoCore.getCellBySheetRanks(sheetAt, rowNum, columnNum));
        	sensitiveWordsSet.add(word);
            }
        }
        for (String word : sensitiveWordsSet) {
	    LOGGER.info("word");
	}
    }
    
}

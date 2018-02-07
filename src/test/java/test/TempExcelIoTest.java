package test;
/**
 * @author knightjxnu
 * @version 1.0
 * @date 2018年1月25日
 * @function : 
 */

import static com.feilong.core.util.CollectionsUtil.newLinkedHashSet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.feilong.core.Validator;

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
    public void getCellStrValueTest() throws Exception {
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
	    if ("关键词名称".equals(cellStrValue3)) {
		LOGGER.info("equal");
	    }
	}
    }

    /**
     * 获取列数.
     */
    @Test
    public void getColumnCountTest() throws Exception {
	XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new File("D:\\test2.xlsx"));
	XSSFSheet sheetAt = xssfWorkbook.getSheetAt(0);
	XSSFRow row = sheetAt.getRow(2);
	int physicalNumberOfCells = row.getPhysicalNumberOfCells();
	if (LOGGER.isInfoEnabled()) {
	    LOGGER.info("" + physicalNumberOfCells);
	}
	XSSFRow row2 = sheetAt.getRow(0);
	int physicalNumberOfCells2 = row2.getPhysicalNumberOfCells();
	if (LOGGER.isInfoEnabled()) {
	    LOGGER.info("" + physicalNumberOfCells2);
	}
    }

    /**
     * 获取行数.
     */
    @Test
    public void getRowCountTest() throws Exception {
	XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new File("D:\\test2.xlsx"));
	XSSFSheet sheetAt = xssfWorkbook.getSheetAt(0);
	XSSFRow row = sheetAt.getRow(2);
	int physicalNumberOfCells = row.getPhysicalNumberOfCells();
	XSSFRow row2 = sheetAt.getRow(0);
	short lastCellNum = row2.getLastCellNum();
	LOGGER.info("lastCellNum:{}", lastCellNum);
	int numHyperlinks = sheetAt.getNumHyperlinks();
	short firstCellNum = row.getFirstCellNum();
	short lastCellNum2 = row.getLastCellNum();
	LOGGER.info("firstCellNum:{}", firstCellNum);
	LOGGER.info("lastCellNum2:{}", lastCellNum2);
	int physicalNumberOfCells2 = sheetAt.getRow(2).getPhysicalNumberOfCells();
	if (LOGGER.isInfoEnabled()) {
	    LOGGER.info("physicalNumberOfCells2:{}", physicalNumberOfCells2);
	}
	int physicalNumberOfRows = sheetAt.getPhysicalNumberOfRows();
	if (LOGGER.isInfoEnabled()) {
	    LOGGER.info("physicalNumberOfRows:{}", physicalNumberOfRows);
	}
    }

    /**
     * 
     * @throws Exception
     */
    @Test
    public void testTempExcelIoTest() throws Exception {
	Set<String> sensitiveWordSet = new HashSet<>();
	XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new File("D:\\test.xlsx"));
	XSSFSheet sheetAt = xssfWorkbook.getSheetAt(0);
	int lastRowNum = sheetAt.getLastRowNum();
	int maxColumnNum = 10000;
	for (int columnNum = 0; columnNum < maxColumnNum; columnNum += 2) {
	    for (int rowNum = 3; rowNum <= lastRowNum; rowNum++) {
		XSSFRow row = sheetAt.getRow(rowNum);
		XSSFCell cell = row.getCell(columnNum);
		if (Validator.isNotNullOrEmpty(cell)) {
		    String word = ExcelFileIoCore.getCellStrValue(cell);
		    if(Validator.isNotNullOrEmpty(word)) {
			sensitiveWordSet.add(word);
		    }
//		    System.out.println("columnNum:"+columnNum+",rowNum:"+rowNum+","+word);
		}
	    }
	}
	LOGGER.info("set size:{}", sensitiveWordSet.size());
	for (String word : sensitiveWordSet) {
//	    LOGGER.info(word);
	    System.out.println(word);
	}
    }

    @Test
    public void tempTest() {
	try {
	    FileInputStream readFile = new FileInputStream("D:\\test.xlsx");
	    // 创建一个WorkBook，从指定的文件流中创建，即上面指定了的文件流
	    XSSFWorkbook wb = new XSSFWorkbook(readFile);
	    // 获取名称为"测试页"的sheet
	    // 注意，如果不能确定具体的名称，可以用getSheetAt(int)方法取得Sheet
	    // HSSFSheet st = wb.getSheet("测试页");
	    // --遍历整个excel
	    int sheetCount = wb.getNumberOfSheets();
	    for (int i = 0; i < sheetCount; i++) {
		XSSFSheet sheet = wb.getSheetAt(i);
		int rowNum = sheet.getPhysicalNumberOfRows();
		int cellNum = sheet.getRow(0).getPhysicalNumberOfCells();
		for (int j = 0; j < rowNum; j++) {
		    XSSFRow row = sheet.getRow(j);
		    for (short k = 0; k < cellNum; k++) {
			XSSFCell cell = row.getCell(k);
			String word = ExcelFileIoCore.getCellStrValue(cell);
			LOGGER.info("word:{}", word);
		    }
		}
	    }
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
    }

    @Test
    public void tempTest2() throws FileNotFoundException, IOException {
	List<String> wordList = new ArrayList<>();
	File excelFile = new File("D:\\test.xlsx");
	XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(excelFile));
	XSSFSheet sheet = wb.getSheetAt(0);
	for (Row row : sheet) {
	    for (Cell cell : row) {
		String word = ExcelFileIoCore.getCellStrValue(cell);
		wordList.add(word);
		LOGGER.info("word:{}", word);
	    }
	}
	LOGGER.info("wordList.size():{}", wordList.size());
    }

    @Test
    public void tempTest3() throws FileNotFoundException, IOException {
	// List<Double> values = new ArrayList<Double>();
	// for(Row r : sheet) {
	// Cell c = r.getCell(columnNumber);
	// if(c != null) {
	// if(c.getCellType() == Cell.CELL_TYPE_NUMERIC) {
	// valuesadd(c.getNumericCellValue());
	// } else if(c.getCellType() == Cell.CELL_TYPE_FORMULA &&
	// c.getCachedFormulaResultType() == Cell.CELL_TYPE_NUMERIC) {
	// valuesadd(c.getNumericCellValue());
	// }
	// }
	// }
    }

}

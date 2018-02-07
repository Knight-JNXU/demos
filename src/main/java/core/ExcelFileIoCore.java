package core;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.feilong.core.Validator;
import com.feilong.json.jsonlib.JsonUtil;

/**
 * @author knightjxnu
 * @version 1.0
 * @date 2018年1月25日
 * @function :
 */
public class ExcelFileIoCore {
    
    /** The Constant log. */
    private static final Logger LOGGER = LoggerFactory.getLogger(ExcelFileIoCore.class);

    private final static String BLANK_STR = "";

    /**
     * 获取单元格的字符串值
     * 
     * @author knightjxnu
     * @param cell
     * @return
     */
    public static String getCellStrValue(Cell cell) {
	String valueStr = "error";
	if (Validator.isNotNullOrEmpty(cell)) {
	    CellType cellType = cell.getCellTypeEnum();
	    switch (cellType) {
	    case STRING:
		valueStr = cell.getStringCellValue();
		break;
	    case NUMERIC:
		cell.setCellType(CellType.STRING);
		valueStr = (BLANK_STR + cell.getStringCellValue());
		break;
	    case FORMULA:
		valueStr = cell.getCellFormula();
		break;
	    case BOOLEAN:
		valueStr = (BLANK_STR + cell.getBooleanCellValue());
		break;
	    case _NONE:
	    case BLANK:
		valueStr = BLANK_STR;
		break;
	    default:
		LOGGER.error("cell {} type illegal!", JsonUtil.format(cell));
		break;
	    }
	}else {
	    LOGGER.error("cell is null!");
	}
	return valueStr;
    }

    /**
     * 根据 sheet、行、列 获取单元格
     * 
     * @author knightjxnu
     * @param sheet
     * @param rowNum
     * @param columnNum
     * @return
     */
    public static Cell getCellBySheetRanks(Sheet sheet, int rowNum, int columnNum) {
	Cell cell = sheet.getRow(rowNum).getCell(columnNum);
	return cell;
    }

    /**
     * 获取 sheet 中 columnNum 列所有单元格
     * 
     * @author knightjxnu
     * @param sheet
     * @param columnNum
     * @return
     */
    // public static List<Cell> getCellBySheetColumnNum(Sheet sheet, int columnNum){
    // sheet.getColumnOutlineLevel(columnIndex)
    // }

}

package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.feilong.json.jsonlib.JsonUtil;

/**
 * @author knightjxnu
 * @version 1.0
 * @date 2018年1月23日
 * @function : 
 */
public class PatternTest{
    
    
    /** The Constant log. */
    private static final Logger LOGGER = LoggerFactory.getLogger(PatternTest.class);
    
    private String fileName = "D:\\all\\code\\work1\\mainland-official-store\\speedo-store-frontend\\src\\main\\webapp\\images\\biofuse\\img-6.jpg";
    

    /**
    * java 正则表达式提取字符串
    */
    @Test
    public void getStringByPatternTest(){
        LOGGER.info(fileName);
        Pattern pattern = Pattern.compile(".+(\\images\\).+(.jpg)$");
        LOGGER.info(JsonUtil.format(pattern));
        Matcher matcher = pattern.matcher(fileName);
        if(matcher.find()) {
            LOGGER.info(matcher.group(1));
        }
            
    }
    
}

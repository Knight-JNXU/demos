package test;

import static org.junit.Assert.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.feilong.core.lang.StringUtil;
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
    private String chinesFileName = "D:\\all\\code\\work1\\mainland-official-store\\speedo-store-frontend\\src\\main\\webapp\\images\\biofuse\\img中文-6.jpg";
    private String chinesFileName2 = "D:\\all\\code\\work1\\mainland-official-store\\speedo-store-frontend\\src\\main\\webapp\\images\\biofuse\\img、-6.jpg";
    private String chinesFileName3 = "D:\\all\\code\\work1\\mainland-official-store\\speedo-store-frontend\\src\\main\\webapp\\images\\biofuse\\img，-6.jpg";
    
    private String fileContent = "<%@pagelanguage=\"java\"contentType=\"text/html;charset=UTF-8\"pageEncoding=\"UTF-8\"%><linkrel=\"stylesheet\"type=\"text/css\"href=\"${staticbase}/css/biofuse.css\"><scriptsrc=\"${staticbase}/js/biofuse.js\"></script><!--内容部分--><sectionclass=\"container\"><!--kv--><article><divclass=\"box-1\"><imgsrc=\"${staticbase}/images/bzofuse/img-1.jpg\"alt=\"\"></div></article><!----><article><divclass=\"boxbox-2\"><imgsrc=\"${staticbase}/images/biofuse/img-2.jpg\"alt=\"\"><divclass=\"box-text\"><p>当一件游泳装备舒适到能让你忘却它的存在</p><p>游泳，就成了一种美妙的享受</p><p>想象一下，畅游在无垠水域</p><p>不必思考水流何时会袭击双眼，更不用担心水雾会遮住方向</p><p>所见之处，都清晰透彻，每个眼神，都自然生动</p><p>这，是真正自由无束的泳动</p><p>而佩戴宛若无物的新款FUTURABIOFUSEFLEXISEAL柔韧贴合系列泳镜3代，</p><p>正是你乐享泳动的佳作之选</p></div></div></article><article><divclass=\"box-3\"><imgsrc=\"${staticbase}/images/biofuse/img-3.jpg\"alt=\"\"></div></article><article><divclass=\"boxbox-4\"><imgsrc=\"${staticbase}/images/biofuse/img-4.jpg\"alt=\"\"class=\"video-img\"><divclass=\"play-btnevent-play-video\"><imgsrc=\"${staticbase}/images/biofuse/play.png\"alt=\"\"></div><divclass=\"biofuse-video\"><scriptsrc=\"https://p.bokecc.com/player?vid=4EA10AF0179C695C9C33DC5901307461&siteid=72A2F2B0A81D0411&autoStart=true&playerid=B10AC757094341AE&playertype=1\"type=\"text/javascript\"></script></div></div></article><article><divclass=\"box-5\"><imgsrc=\"${staticbase}/images/biofuse/img-5.jpg\"alt=\"\"></div></article><article><divclass=\"boxbox-6\"><imgsrc=\"${staticbase}/images/biofuse/img-6.jpg\"alt=\"\"><ahref=\"https://www.speedo.com.cn/women-biofuse\"class=\"linklink-1\"></a><ahref=\"https://www.speedo.com.cn/neutral-biofuse\"class=\"linklink-2\"></a></div></article></section>/images/biofuse/img-7.jpgapng";
    
    
    
    /**
    * java 正则表达式提取字符串
    */
    @Test
    public void getStringByPatternTest(){
	String tempFileName = "D:\\all\\code\\work1\\mainland-official-store\\speedo-store-frontend\\src\\main\\webapp\\images\\biofuse\\img-1.JPG";
        LOGGER.info(tempFileName);
//        "(/images/)([^.]+)(\\.jpg|\\.JPG|\\.jpeg|\\.JPEG|\\.png|\\.PNG|\\.gig|\\.GIF)"
        Pattern pattern = Pattern.compile(".+(\\\\images\\\\.+(\\.jpg|\\.JPG|\\.jpeg|\\.JPEG|\\.png|\\.PNG|\\.gig|\\.GIF))$");
        Matcher matcher = pattern.matcher(tempFileName);
        if(matcher.find()) {
            LOGGER.info(matcher.group(1));
        }
    }
    
    /**
     * 找出含有中文的字符串
     * @author knightjxnu
     */
    @Test
    public void chinesePatternTest(){
        String chinesePattern = "^.+[\u4e00-\u9fa5]+.+$";
        Pattern pattern = Pattern.compile(chinesePattern);
        Matcher matcher = pattern.matcher(fileName);
        LOGGER.info(""+matcher.find());
        Matcher matcher2 = pattern.matcher(chinesFileName);
        LOGGER.info(""+matcher2.find());
        Matcher matcher3 = pattern.matcher(chinesFileName2);
        LOGGER.info(""+matcher3.find());
        Matcher matcher4 = pattern.matcher(chinesFileName3);
        LOGGER.info(""+matcher4.find());
    }
    
    
    

    /**
     * 
     * @author knightjxnu
     */
    @Test
    public void fileContentGetTest(){
//        String parttenStr = "/images/[^(jpg)(png)]+[(jpg)|(png)]{1}";
//        String parttenStr = "/images/[^(jpg png)]+[(jpg png)]+?";
//        String parttenStr = "(/images/([^(jpg)(png)]+)[(jpg)|(png)]{1})";
        
//        String parttenStr = "(\\.jpg|\\.png)";
//        String parttenStr = "(/images/)([^.]+)(\\.jpg|\\.png)";
        String parttenStr = "(/images/)([^.]+)(\\.jpg|\\.JPG|\\.jpeg|\\.JPEG|\\.png|\\.PNG|\\.gig|\\.GIF)";
        
        
        Pattern partten = Pattern.compile(parttenStr);
        Matcher matcher = partten.matcher(fileContent);
        LOGGER.info(fileContent);
        LOGGER.info("matcher.groupCount():{}", matcher.groupCount());
        while (matcher.find()) {
//            for(int i=1; i<10; i++) {
//                LOGGER.info("contentMatcher.group(i):{}", matcher.group(i));
//            }
            LOGGER.info("contentMatcher.group(0):{}", matcher.group());
//            LOGGER.info("contentMatcher.group(1):{}", matcher.group(1));
        }
        
    }
    
    /**
     * 
     * @author knightjxnu
     */
    @Test
    public void fileContentGetTest2(){
        String s = "Hello my name is Neo and my company brand name is Company Country1. But we have also other companies like Company Country2 (in Europe), and also Company Country3 (in Asia)";

        Pattern pattern = Pattern.compile("Company Country\\d");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            String group = matcher.group();
            System.out.println(group);
        }
    }
    
    
    

    /**
    * TestPatternTest.
    */
    @Test
    public void fileContentGetTest3(){
     // 按指定模式在字符串查找
        String line = "This order was placed for QT30 00! OK?";
//        String pattern = "(\\D*)(\\d+)(.*)";
        String pattern = "(\\D*)(\\S+)(.*)(\\S+)";
   
        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);
   
        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        if (m.find( )) {
           System.out.println("Found value: " + m.group(0) );
           System.out.println("Found value: " + m.group(1) );
           System.out.println("Found value: " + m.group(2) );
           System.out.println("Found value: " + m.group(3) ); 
           System.out.println("Found value: " + m.group(4) ); 
        } else {
           System.out.println("NO MATCH");
        }
    }
    
    
}

package code.model;

import java.util.Map;

import com.feilong.core.URIComponents;
import com.feilong.core.net.ParamUtil;

/**
 * @author knightjxnu
 * @version 1.0
 * @date 2018年1月11日
 * @function : 接口请求参数
 */
public class RequestParams extends BaseModel{
    
    /**
     * 
     */
    private static final long serialVersionUID = 6612298449173011279L;

    /**
     * url
     */
    private String url;
    
    /**
     * 请求参数，key：参数名称，value：参数值
     * 如：http://japi.juhe.cn/joke/content/list.from?sort=desc
     *    key = sort
     *    value = desc
     */
    private Map<String, String> paramsMap;

    
    public String getUrl(){
        return url;
    }

    
    public void setUrl(String url){
        this.url = url;
    }

    
    public Map<String, String> getParamsMap(){
        return paramsMap;
    }

    
    public void setParamsMap(Map<String, String> paramsMap){
        this.paramsMap = paramsMap;
    }
    
    /**
     * 构建完整的url
     * @author liuwen
     * @param page 页码
     * @param time 10位时间戳
     * 示例请求：http://japi.juhe.cn/joke/content/list.from?key=450ccabad500fda6964d6517a9c72647&page=2&pagesize=10&sort=asc&time=1418745237
     * @return
     */
    public String buildeCompleteUrl(String page, String time) {
        String result = "";
        result += (url+URIComponents.QUESTIONMARK+ParamUtil.toQueryStringUseSingleValueMap(paramsMap)+"page="+page+URIComponents.AMPERSAND+"time="+time);
        return result;
    }
}

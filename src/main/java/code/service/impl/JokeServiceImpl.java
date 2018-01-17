package code.service.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import code.service.JokeService;

/**
 * @author knightjxnu
 * @version 1.0
 * @date 2018年1月11日
 * @function : 
 */
@Service
public class JokeServiceImpl extends BaseServiceImpl implements JokeService{
    
    
    /** The Constant log. */
    private static final Logger LOGGER = LoggerFactory.getLogger(JokeServiceImpl.class);
    
//    @Qualifier(value="jokeRequestParams")
//    private RequestParams httpRequest;
    
    /**
     * 根据页码获取笑话
     * @author knightjxnu
     * @param page
     * @return
     */
    public String getJokesByPage(String page) {
        /*String requestUrl = httpRequest.buildeCompleteUrl(page, ""+(new Date().getTime()/1000));
        String responseStr = HttpClientUtil.get(requestUrl);
        LOGGER.info("聚合数据：笑话大全：request{}：response{}", requestUrl, responseStr);
        return responseStr;*/
        
        
        
        return "";
    }
    
}

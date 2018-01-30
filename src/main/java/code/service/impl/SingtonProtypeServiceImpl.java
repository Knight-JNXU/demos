package code.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import code.service.SingtonProtypeService;

/**
 * @author knightjxnu
 * @version 1.0
 * @date 2018年1月29日
 * @function : 单例 service 实现类，用于 spring sington/protype 探究
 */
public class SingtonProtypeServiceImpl extends BaseServiceImpl implements SingtonProtypeService{
    
    /** The Constant log. */
    private static final Logger LOGGER = LoggerFactory.getLogger(SingtonProtypeServiceImpl.class);
    
    private String name = "lw";
    
    public SingtonProtypeServiceImpl() {
	super();
	LOGGER.info("SingtonProtypeServiceImpl structuring");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
}

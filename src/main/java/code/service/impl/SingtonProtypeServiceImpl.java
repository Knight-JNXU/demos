package code.service.impl;

import code.service.SingtonProtypeService;

/**
 * @author knightjxnu
 * @version 1.0
 * @date 2018年1月29日
 * @function : 单例 service 实现类，用于 spring sington/protype 探究
 */
public class SingtonProtypeServiceImpl extends BaseServiceImpl implements SingtonProtypeService{
    
    private String name = "lw";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
}

package test;
/**
 * @author knightjxnu
 * @version 1.0
 * @date 2018年1月29日
 * @function : 
 */

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import code.service.SingtonProtypeService;
import code.service.impl.SingtonProtypeServiceImpl;

public class SingtonProtypeServiceTest extends BaseJUnit4SpringContextTests{
    
    
    /** The Constant log. */
    private static final Logger LOGGER = LoggerFactory.getLogger(SingtonProtypeServiceTest.class);
    
    public SingtonProtypeServiceTest() {
	super();
	LOGGER.info("SingtonProtypeServiceTest structuring");
    }

    @Qualifier(value = "SingtonService")
    @Autowired
    private SingtonProtypeServiceImpl singtonService1;
    @Qualifier(value = "SingtonService")
    @Autowired
    private SingtonProtypeServiceImpl singtonService2;
    
    @Qualifier(value = "ProtypeService")
    @Autowired
    private SingtonProtypeServiceImpl protypeService1;
    @Qualifier(value = "ProtypeService")
    @Autowired
    private SingtonProtypeServiceImpl protypeService2;
    

    @Test
    public void testSingtonProtypeServiceTest() {
	LOGGER.info("begin");
	SingtonProtypeServiceImpl singtonService3 = singtonService1;
	LOGGER.info("singtonService1.getName():{}", singtonService1.getName());
	singtonService1.setName("feilong");
	LOGGER.info("singtonService1.getName():{}", singtonService1.getName());
	LOGGER.info("singtonService2.getName():{}", singtonService2.getName());
	LOGGER.info("singtonService3.getName():{}", singtonService3.getName());
	singtonService3.setName("sw");
	LOGGER.info("singtonService1.getName():{}", singtonService1.getName());
	LOGGER.info("=============================");
	SingtonProtypeServiceImpl protypeService3 = protypeService1;
	LOGGER.info("protypeService1.getName():{}", protypeService1.getName());
	protypeService1.setName("feilong");
	LOGGER.info("protypeService1.getName():{}", protypeService1.getName());
	LOGGER.info("protypeService2.getName():{}", protypeService2.getName());
	LOGGER.info("protypeService3.getName():{}", protypeService3.getName());
	protypeService3.setName("sw");
	LOGGER.info("protypeService3.getName():{}", protypeService3.getName());
	LOGGER.info("end");
    }
    
}

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import base.BaseJUnit4SpringContextTests;
import code.controller.UserController;

/**
 * @author liuwen
 * @version 1.0
 * @date 2018年2月26日
 */
@ContextConfiguration(locations = { "classpath*:spring/spring-aop-mvc-conf.xml"})
public class UserControllerAspectTest extends BaseJUnit4SpringContextTests{
    
    @Autowired
    private UserController userController;

    /**
    * TestUserControllerAspectTest.
    */
    @Test
    public void testUserControllerAspectTest() {
	userController.login(null, null, null);
    }
    
}

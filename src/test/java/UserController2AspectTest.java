import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import base.BaseJUnit4SpringContextTests;
import code.controller2.UserController2;

/**
 * @author liuwen
 * @version 1.0
 * @date 2018年2月26日
 */
@ContextConfiguration(locations = { "classpath*:spring/spring-aop-mvc2-conf.xml"})
public class UserController2AspectTest extends BaseJUnit4SpringContextTests{
    
    @Autowired
    private UserController2 userController2;
    
    @Test
    public void testUserController2AspectTest() {
	userController2.login2(null, null, null);
    }
    
}

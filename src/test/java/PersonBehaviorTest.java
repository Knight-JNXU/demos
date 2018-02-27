

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import base.BaseJUnit4SpringContextTests;
import code.behavior.PersonBehavior;

@ContextConfiguration(locations = { "classpath*:spring/spring-aop-conf.xml"})
public class PersonBehaviorTest extends BaseJUnit4SpringContextTests{
    
    @Autowired
    private PersonBehavior personBehavior;
    
    @Test
    public void testPersonBehaviorTest() {
	personBehavior.eatLunch();
    }
    
}

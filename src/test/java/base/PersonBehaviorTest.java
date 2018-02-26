package base;
/**
 * @author liuwen
 * @version 1.0
 * @date 2018年2月26日
 */

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import code.behavior.PersonBehavior;

public class PersonBehaviorTest extends BaseJUnit4SpringContextTests{
    
    @Autowired
    private PersonBehavior personBehavior;
    
    @Test
    public void testPersonBehaviorTest() {
	personBehavior.eatLunch();
    }
    
}

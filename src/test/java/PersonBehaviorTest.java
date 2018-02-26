

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import base.BaseJUnit4SpringContextTests;
import code.behavior.PersonBehavior;

public class PersonBehaviorTest extends BaseJUnit4SpringContextTests{
    
    @Autowired
    private PersonBehavior personBehavior;
    
    @Test
    public void testPersonBehaviorTest() {
	personBehavior.eatLunch();
    }
    
}

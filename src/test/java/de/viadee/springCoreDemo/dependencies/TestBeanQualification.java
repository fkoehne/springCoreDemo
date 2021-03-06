/**
 * 
 */
package de.viadee.springCoreDemo.dependencies;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.viadee.springCoreDemo.MyConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(MyConfiguration.class)
public class TestBeanQualification {

    @Autowired(required = false)
    private Movie LotR;

    @Autowired(required = false)
    @Qualifier("elijahWood")
    private Actor a;

    @Autowired(required = false)
    @Qualifier("ianMcKellen")
    private Actor b;

    @Test
    public void TestBasicSetupWithQualifiers() {
        assertNotNull("Desired movie is not initialized.", LotR);
        assertNotNull("Frodo is missing.", a);
        assertNotNull("Gandalf is missing.", b);
        assertTrue("Frodo must be part of the movie.", LotR.getActors().contains(a));
        assertTrue("Gandalf must be part of the movie.", LotR.getActors().contains(b));
    }
}

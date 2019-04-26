package edu.isu.cs.cs3308;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author fate
 */
public class PostFixTest {

    public PostFixTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of evalPostFix method, of class PostFix.
     */
    @Test
    public void testEvalPostFix() {
        assertEquals("Incorrect evaluation of expression: 5 2 + 8 3 - * 4 / : check that your operands are not reversed", 8, PostFix.evalPostFix("5 2 + 8 3 - * 4 /"));
        assertEquals("Incorrect evaluation of expression: 40 5 + 90 3 / - 14 * : check that your operands are not reversed", 210, PostFix.evalPostFix("40 5 + 90 3 / - 14 *"));
    }

    @Test
    public void testEvalPostFix_2() {
        assertEquals("Zero not returned on empty expression", 0, PostFix.evalPostFix(""));
    }

    @Test
    public void testEvalPostFix_3() {
        assertEquals("Zero not returned on whitespace only expression", 0, PostFix.evalPostFix(" "));
    }

    @Test
    public void testEvalPostFix_4() {
        assertEquals("Zero not returned on null expression", 0, PostFix.evalPostFix(null));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEvalPostFix_5() {
        PostFix.evalPostFix("5 2 + 8 - * 4 /");
    }

}

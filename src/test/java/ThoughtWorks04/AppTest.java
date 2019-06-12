package ThoughtWorks04;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import ThoughtWorks04.util.Utils;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    static int[][] mat = {
            {1, 0, 1},
            {1, 0, 1},
            {1, 0, 1}
    };
    static int[][] lifeNum = {
            {1, 4, 1},
            {2, 6, 2},
            {1, 4, 1}
    };

    static int[][] ns = {
            {0, 0, 0},
            {1, 0, 1},
            {0, 0, 0}
    };


    @Test
    public void shouldAnswerWithTrue()
    {;
        assertTrue( true );
    }
//    @Test
    public void testCountLifedNum(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertThat(lifeNum[i][j], is(App.countLifedNum(i, j)));
            }
        }
    }
    @Test
    public void testNextStatus(){
//        Utils.printMat(App.ns);
        assertThat(ns, is(App.transform(mat)));
    }
}

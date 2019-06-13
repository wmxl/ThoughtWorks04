package ThoughtWorks04;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import ThoughtWorks04.model.CellMat;
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

    @Test
    public void testJudge(){
        CellMat cm = new CellMat(3,3, mat);
        int height = 10, width = 10;
        assertThat(true, is(cm.judge(3, 5, height, width)));
        assertThat(true, is(cm.judge(0, 0, height, width)));
        assertThat(false, is(cm.judge(11, 11, height, width)));
        assertThat(false, is(cm.judge(11, -1, height, width)));
        assertThat(false, is(cm.judge(23, 11, height, width)));


    }
    @Test
    public void testCountLifedNum(){
        CellMat cm = new CellMat(3,3, mat);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertThat(lifeNum[i][j], is(cm.countLifedNum(i, j)));
            }
        }
    }
    @Test
    public void testTransform(){

        CellMat cm = new CellMat(3,3, mat);
        cm.transform();
        assertThat(ns, is(cm.getMat()));
    }
}

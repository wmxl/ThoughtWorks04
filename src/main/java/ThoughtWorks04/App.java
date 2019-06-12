package ThoughtWorks04;

import ThoughtWorks04.model.CellMat;
import ThoughtWorks04.util.Utils;
import javafx.scene.control.Cell;

/**
 * Hello world!
 *
 */
public class App 
{
    /**
     * 判断坐标是否合法
     * @param i
     * @param j
     * @param height
     * @param width
     * @return
     */
    public static boolean judge(int i, int j, int height, int width){
        if(i >= 0 && i < height && j >= 0 && j < width)
            return true;
        return false;
    }

    /**
     * 统计每个细胞周围活着的个数
     * @param j 横坐标
     * @param i 纵坐标
     * @return
     */
    public static int countLifedNum(CellMat cm, int i, int j){
        int num=0;
        int mat[][] = cm.getMat();
        int height = cm.getHeight();
        int width = cm.getWidth();

        if(judge(i-1, j-1, height, width))
            num += mat[i-1][j-1];
        if(judge(i-1, j, height, width))
            num += mat[i-1][j];
        if(judge(i-1, j+1, height, width))
            num += mat[i-1][j+1];

        if(judge(i, j-1, height, width))
            num += mat[i][j-1];
        if(judge(i, j+1, height, width))
            num += mat[i][j+1];

        if(judge(i+1, j-1, height, width))
            num += mat[i+1][j-1];
        if(judge(i+1, j, height, width))
            num += mat[i+1][j];
        if(judge(i+1, j+1, height, width))
            num += mat[i+1][j+1];

        return num;
    }
    public static void draw(CellMat cm){
        int[][] mat = cm.getMat();
        int cow = mat.length;
        int col = mat[0].length;
        for (int i = 0; i < cow; i++) {
            for (int j = 0; j < col; j++) {
                if(mat[i][j] == 1)
                    System.out.print("■");
                else
                    System.out.print("□");
            }
            System.out.println();
        }
    }

    /**
     * 判断什么时候该停止
     * @param cm
     */
    public static boolean judgeStop(CellMat cm){
        int[][] mat = cm.getMat();
        int cow = mat.length;
        int col = mat[0].length;
        for (int i = 0; i < cow; i++) {
            for (int j = 0; j < col; j++) {
                if(mat[i][j] != 0)
                    return false;
            }
        }
        return true;
    }

    public static CellMat transform(CellMat cm){
        int[][] mat = cm.getMat();
        int height = cm.getHeight();
        int width = cm.getWidth();

        int[][] ns = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int temp = countLifedNum(cm, i, j);
//                System.out.println("-----" + temp);
                if(mat[i][j] == 0){
                    if(temp == 3)
                        ns[i][j] = 1;
                }else{
                    if(temp < 2 || temp >3)
                        ns[i][j] = 0;
                    else
                        ns[i][j] = 1;
                }
            }
        }
        CellMat newMat = new CellMat(height, width, ns);

        return newMat;
    }

    public static void main( String[] args )
    {
        int height = 4, width = 4;
        int[][] mat1 = {
                {0, 0, 0, 0},
                {0, 1, 1, 1},
                {1, 1, 1, 0},
                {0, 0, 0, 0}
        };
        int[][] mat = {
                {0, 1, 1, 0},
                {1, 0, 0, 1},
                {0, 1, 1, 0}
        };

        CellMat cmJZ = new CellMat(3, 4, mat);
        CellMat cmZD = new CellMat(4, 4, mat1);


        while(true){
            draw(cmJZ);
            cmJZ = transform(cmJZ);
            System.out.println("====================");

            //判断是否停止
            if(judgeStop(cmJZ))
            {
                System.out.println("cells are all dead");
                break;
            }
        }

    }
}

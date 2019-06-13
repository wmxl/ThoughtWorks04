package ThoughtWorks04;

import ThoughtWorks04.model.CellMat;
import ThoughtWorks04.util.Utils;
import javafx.scene.control.Cell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    /**
     * 控制台绘图
     * @param cm
     */
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

    public static void main( String[] args )
    {
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
            draw(cmZD);
            cmZD.transform();
            System.out.println("====================");

            //判断是否停止
            if(judgeStop(cmZD))
            {
                System.out.println("cells are all dead");
                break;
            }
        }
    }
}

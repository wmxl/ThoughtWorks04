package ThoughtWorks04;

import ThoughtWorks04.util.Utils;

/**
 * Hello world!
 *
 */
public class App 
{


    static int[][] ns = new int[3][3];

    public static boolean judge(int x, int y){
        if(x >= 0 && x <= 2 && y >= 0 && y <= 2)
            return true;
        return false;
    }

    /**
     * 统计每个细胞周围活着的个数
     * @param j 横坐标
     * @param i 纵坐标
     * @return
     */
    public static int countLifedNum(int[][] mat, int i, int j){
        int num=0;
        if(judge(i-1, j-1))
            num += mat[i-1][j-1];
        if(judge(i-1, j))
            num += mat[i-1][j];
        if(judge(i-1, j+1))
            num += mat[i-1][j+1];

        if(judge(i, j-1))
            num += mat[i][j-1];
        if(judge(i, j+1))
            num += mat[i][j+1];

        if(judge(i+1, j-1))
            num += mat[i+1][j-1];
        if(judge(i+1, j))
            num += mat[i+1][j];
        if(judge(i+1, j+1))
            num += mat[i+1][j+1];
        return num;
    }
    public static void draw(int[][] mat){
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
     * @param mat
     */
    public static boolean judgeStop(int[][] mat){
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

    public static int[][] transform(int[][] m){
        int[][] ns = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int temp = countLifedNum(m, i, j);
//                System.out.println("-----" + temp);
                if(m[i][j] == 0){
                    if(temp == 3)
                        ns[i][j] = 1;
                }else{
                    if(temp < 2 || temp >3)
                        ns[i][j] = 0;
                }
            }
        }
        return ns;
    }

    public static void main( String[] args )
    {
        int[][] mat = {
                {1, 0, 1},
                {1, 0, 0},
                {0, 0, 1}
        };


        while(true){
            draw(mat);
            mat = transform(mat);
//            Utils.printMat(mat);
//            Utils.printMat(mat);
            System.out.println("====================");
            //判断
            if(judgeStop(mat))
                break;
        }
        int a = countLifedNum(mat, 1,1);
        System.out.println(a);


    }
}

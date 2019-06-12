package ThoughtWorks04;

/**
 * Hello world!
 *
 */
public class App 
{

    static int[][] mat = {
            {1, 0, 1},
            {1, 0, 1},
            {1, 0, 1}
    };

    public static boolean judge(int x, int y){
        if(x >= 0 && x <= 2 && y >= 0 && y <= 2)
            return true;
        return false;
    }

    /**
     * 统计每个细胞周围活着的个数
     * @param x 横坐标
     * @param y 纵坐标
     * @return
     */
    public static int countLifedNum(int x, int y){
        int num=0;

        if(judge(x-1, y-1))
            num += mat[x-1][y-1];
        if(judge(x, y-1))
            num += mat[x][y-1];
        if(judge(x+1, y-1))
            num += mat[x+1][y-1];
        if(judge(x-1, y))
            num += mat[x-1][y];
        if(judge(x+1, y))
            num += mat[x+1][y];
        if(judge(x-1, y+1))
            num += mat[x-1][y+1];
        if(judge(x, y+1))
            num += mat[x][y+1];
        if(judge(x+1, y+1))
            num += mat[x+1][y+1];

        return num;
    }

    public static int[][] transform(int[][] m){
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                System.out.print(countLifedNum(i, j)+ " ");
//            }
//            System.out.println();
//        }
        return m;
    }


    public static void main( String[] args )
    {

//        transform();

    }
}

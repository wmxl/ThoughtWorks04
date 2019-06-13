package ThoughtWorks04.model;

import ThoughtWorks04.util.Utils;

public class CellMat {
    int height;
    int width;
    int[][] mat;

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setMat(int[][] mat) {
        this.mat = mat;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int[][] getMat() {
        return mat;
    }

    public CellMat(int height, int width) {
        this.height = height;
        this.width = width;
        this.mat = new int[height][width];
    }

    public CellMat(int height, int width, int[][] mat){
        this.height = height;
        this.width = width;
        this.mat = mat;
    }

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
    public int countLifedNum(int i, int j){
        int num=0;
        int mat[][] = this.getMat();
        int height = this.getHeight();
        int width = this.getWidth();

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

    public void transform(){
        int[][] mat = this.getMat();
        int height = this.getHeight();
        int width = this.getWidth();

        int[][] ns = new int[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int temp = countLifedNum(i, j);
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
        this.mat = ns;
    }

    /**
     * 打印矩阵
     */
    public void printMat(){
        Utils.printMat(this.mat);
    }
}

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

    public void printMat(){
        Utils.printMat(this.mat);
    }
}

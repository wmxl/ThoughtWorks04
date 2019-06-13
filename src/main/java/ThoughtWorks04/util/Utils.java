package ThoughtWorks04.util;

import ThoughtWorks04.model.CellMat;

import java.io.*;

public class Utils {

    public static void printMat(int[][] mat){
        int row = mat.length;
        int col = mat[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static CellMat readFileMatrix(String path) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
            String line = reader.readLine();
            String[] array = line.split(" ");
            int width = Integer.parseInt(array[0]);
            int height = Integer.parseInt(array[1]);
            int[][] matrix = new int[height][width];
            for (int i = 0; i < height; i++) {
                line = reader.readLine();
                array = line.split(" ");
                for (int j = 0; j < array.length; j++) {
                    matrix[i][j] = Integer.parseInt(array[j]);
                }
            }
            CellMat cellMatrix = new CellMat(height, width, matrix);
            return cellMatrix;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
    public static CellMat saveMatric(String path) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
            String line = reader.readLine();
            String[] array = line.split(" ");
            int width = Integer.parseInt(array[0]);
            int height = Integer.parseInt(array[1]);
            int[][] matrix = new int[height][width];
            for (int i = 0; i < height; i++) {
                line = reader.readLine();
                array = line.split(" ");
                for (int j = 0; j < array.length; j++) {
                    matrix[i][j] = Integer.parseInt(array[j]);
                }
            }
            CellMat cellMatrix = new CellMat(height, width, matrix);
            return cellMatrix;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}

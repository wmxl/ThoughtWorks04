package ThoughtWorks04.ui;

import ThoughtWorks04.model.CellMat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.TimeUnit;


public class LifeGameFrame extends JFrame {

    private JButton generateBtn = new JButton("Generate");
    private JButton startGameBtn = new JButton("Start Game");
    private JButton durationPromtLabel = new JButton("Speed(1~1000,   1 mean fastest)");
    private JTextField durationTextField = new JTextField("300");

    private JButton setWidthBtn = new JButton("Input Width");
    private JTextField setWidthField = new JTextField();
    private JButton setHeightBtn = new JButton("Input Height");
    private JTextField setHeightField = new JTextField();

    private JPanel gridPanel;

    private boolean isStart = false;
    private boolean stop = false;

    private CellMat cellMat;
    private JPanel buttonPanel = new JPanel(new GridLayout(4, 2, 10, 5));
//    private JPanel gridPanel = new JPanel();

    private JButton[][] btnMat;


    /**
     * 速度，（实际上是间隔，越大越慢）
     */
    private static final int DEFAULT_DURATION = 200;

    //动画间隔
    private int duration = DEFAULT_DURATION;

    private int width = 4;
    private int height = 4;

    public LifeGameFrame() {
        setTitle("LifeGame");
        generateBtn.addActionListener(new RestartActioner());
        startGameBtn.addActionListener(new StartGameActioner());


        buttonPanel.add(generateBtn, 0);
        buttonPanel.add(startGameBtn, 1);
        buttonPanel.add(durationPromtLabel, 2);
        buttonPanel.add(durationTextField, 3);

        buttonPanel.add(setWidthBtn);
        buttonPanel.add(setWidthField);
        buttonPanel.add(setHeightBtn);
        buttonPanel.add(setHeightField);

        buttonPanel.setBackground(Color.WHITE);

        getContentPane().add("North", buttonPanel);

        this.setSize(800, 800);
        this.setLocation(500, 100);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    private class RestartActioner implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Restart");
//            new LifeGameFrame();
//            removeAll();
            //获取时间, 宽，高
            try {
                duration = Integer.parseInt(durationTextField.getText().trim());
                width = Integer.parseInt(setWidthField.getText().trim());
                height = Integer.parseInt(setHeightField.getText().trim());
                System.out.println("width = " + width);
                System.out.println("height = " + height);
            } catch (NumberFormatException e1) {
                duration = DEFAULT_DURATION;

                System.out.println("异常");
                JOptionPane.showConfirmDialog(null, "请输入高和宽", "未输入高或宽", JOptionPane.CLOSED_OPTION);
                return;
            }

            isStart = false;
            stop = true;
            startGameBtn.setText("Start");

            int matrix0[][] = new int[height][width];

            cellMat = new CellMat(height, width, matrix0);

            int rows = cellMat.getHeight();
            int cols = cellMat.getWidth();
            gridPanel = new JPanel();
            gridPanel.setLayout(new GridLayout(rows, cols));
            btnMat = new JButton[rows][cols];
            for (int y = 0; y < rows; y++) {
                for (int x = 0; x < cols; x++) {
                    btnMat[y][x] = new JButton();
                    gridPanel.add(btnMat[y][x]);
                }
            }

            add("Center", gridPanel);
            draw();

            for (int y = 0; y < btnMat.length; y++) {
                for (int x = 0; x < btnMat[0].length; x++) {
                    btnMat[y][x].addMouseListener(new MouseListener() {

                        public void mouseReleased(MouseEvent e) {
                            draw();
                            gridPanel.updateUI();
                        }

                        public void mousePressed(MouseEvent e) {
                            System.out.println("点击了方块");
                            JButton temp = (JButton) e.getSource();

                            if (temp.getBackground() != Color.BLACK) {
                                System.out.println("涂黑");
                                temp.setBackground(Color.BLACK);
                            } else
                                temp.setBackground(Color.WHITE);

                            //更新数字矩阵
                            for (int i = 0; i < btnMat.length; i++) {
                                for (int j = 0; j < btnMat[0].length; j++) {
                                    if (temp.getX() == btnMat[i][j].getX() && temp.getY() == btnMat[i][j].getY()) {
                                        System.out.println("更新");
                                        if (cellMat.getMat()[i][j] == 0)
                                            cellMat.getMat()[i][j] = 1;
                                        else
                                            cellMat.getMat()[i][j] = 0;
                                    }
                                }
                            }

                            draw();
                            gridPanel.updateUI();

                            System.out.println("当前数字矩阵：");
                            cellMat.printMat();
                        }

                        public void mouseExited(MouseEvent e) {
                            draw();
                            gridPanel.updateUI();
                        }

                        public void mouseEntered(MouseEvent e) {
                            draw();
                            gridPanel.updateUI();
                        }

                        public void mouseClicked(MouseEvent e) {
                            draw();
                            gridPanel.updateUI();
                        }
                    });
                }
            }
            gridPanel.updateUI();
        }
    }

    private void draw() {

        int[][] matrix = cellMat.getMat();

        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[0].length; x++) {
                if (matrix[y][x] == 1) {
                    btnMat[y][x].setBackground(Color.BLACK);
                } else {
                    btnMat[y][x].setBackground(Color.WHITE);
                }
            }
        }
    }

    private class StartGameActioner implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("点击了开始");
            System.out.println("isStart = " + isStart);
            ;

            if (!isStart) {

                //获取时间, 宽，高
                try {
                    duration = Integer.parseInt(durationTextField.getText().trim());
                } catch (NumberFormatException e1) {
                    duration = DEFAULT_DURATION;
                    System.out.println("异常");
                }

                new Thread(new GameControlTask()).start();

                isStart = true;
                stop = false;
                startGameBtn.setText("Pause");
            } else {
                stop = true;
                isStart = false;
                startGameBtn.setText("Start");
            }
        }
    }

    private class GameControlTask implements Runnable {
        @Override
        public void run() {
            System.out.println("线程启动。。。");

            while (!stop) {
                cellMat.transform();
                System.out.println("draw。。。");
                cellMat.printMat();
                draw();
                gridPanel.updateUI();

                try {
                    TimeUnit.MILLISECONDS.sleep(duration);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    /**
     * Ui测试main方法
     *
     * @param args
     */
    public static void main(String[] args) {
        new LifeGameFrame();
    }
}

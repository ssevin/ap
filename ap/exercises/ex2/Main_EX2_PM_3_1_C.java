package ap.exercises.ex2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

class PacmanGUI extends JFrame implements KeyListener {

    Point pacmanPoint = new Point();
    final int width = 300, height = 300, boxSize = 5;
    static int direction = 1;
    final int LEFT = 1, RIGHT = 2, TOP = 3, BOTTOM = 4;
    Point dotPoint = new Point();
    int score = 0;
    int addedPoints = 3;
    boolean running = true;
    char[][] square = new char[width / boxSize][height / boxSize];
    long startTime = System.currentTimeMillis();

    public PacmanGUI() {
        addKeyListener(this);
        pacmanPoint.setLocation((width / boxSize) / 2, (height / boxSize) / 2);


        for (int i = 0; i < width / boxSize; i++) {
            for (int j = 0; j < height / boxSize; j++) {
                square[i][j] = ' ';
            }
        }

        for (int i = 0; i < width / boxSize; i++) {
            for (int j = 0; j < height / boxSize; j++) {
                square[0][i] = '*';
                square[i][0] = '*';
                square[i][(height / boxSize) - 1] = '*';
                square[(width / boxSize) - 1][i] = '*';
            }
        }


        Random random = new Random();
        int pointsAdded = 0;
        while (pointsAdded < addedPoints) {
            int randY = 1 + random.nextInt((height / boxSize) - 2);
            int randX = 1 + random.nextInt((width / boxSize) - 2);

            if (square[randX][randY] == ' ') {
                square[randX][randY] = '.';
                pointsAdded++;
            }
        }

        setSize(width, height);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g.clearRect(0, 0, width, height);
        if (running) {
            logic();
        }
        drawWalls(g2D);
        drawPacman(g2D);
        drawDots(g2D);
        drawScore(g2D);
        setVisible(true);
    }

    private void drawWalls(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        for (int i = 0; i < width / boxSize; i++) {
            for (int j = 0; j < height / boxSize; j++) {
                if (square[i][j] == '*') {
                    g2d.fillRect(i * boxSize, j * boxSize, boxSize, boxSize);
                }
            }
        }
    }

    private void drawPacman(Graphics2D g2d) {
        g2d.setColor(Color.BLUE);
        g2d.fillRect(pacmanPoint.x * boxSize, pacmanPoint.y * boxSize, boxSize, boxSize);
    }

    private void drawDots(Graphics2D g2d) {
        g2d.setColor(Color.RED);
        for (int i = 0; i < width / boxSize; i++) {
            for (int j = 0; j < height / boxSize; j++) {
                if (square[i][j] == '.') {
                    g2d.fillRect(i * boxSize, j * boxSize, boxSize, boxSize);
                }
            }
        }
    }

    private void drawScore(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        String s = "Score: " + score + " - Points remaining: " + addedPoints;
        g2d.drawString(s, 25, 50);

        if (!running) {
            long endTime = System.currentTimeMillis();
            long duration = (endTime - startTime) / 1000;
            g2d.drawString("Game Over! Final Score: " + score + " - Time: " + duration + " seconds", 25, 80);
        }
    }

    private void logic() {
        movePacman();
        checkDotCollision();
    }

    private void movePacman() {
        int newX = pacmanPoint.x;
        int newY = pacmanPoint.y;

        switch (direction) {
            case LEFT:
                newX--;
                break;
            case RIGHT:
                newX++;
                break;
            case TOP:
                newY--;
                break;
            case BOTTOM:
                newY++;
                break;
        }


        if (newX >= 0 && newX < width / boxSize && newY >= 0 && newY < height / boxSize) {
            if (square[newX][newY] != '*') {
                pacmanPoint.setLocation(newX, newY);
            }
        }
    }

    private void checkDotCollision() {
        if (square[pacmanPoint.x][pacmanPoint.y] == '.') {
            square[pacmanPoint.x][pacmanPoint.y] = ' ';
            score++;
            addedPoints--;

            if (addedPoints == 0) {
                running = false;
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP)
            direction = 3;
        else if (e.getKeyCode() == KeyEvent.VK_DOWN)
            direction = 4;
        else if (e.getKeyCode() == KeyEvent.VK_LEFT)
            direction = 1;
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            direction = 2;
        else if (e.getKeyCode() == KeyEvent.VK_Q) {
            running = false;
            repaint();
            System.exit(0);
        }

        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}

public class Main_EX2_PM_3_1_C {
    public static void main(String[] args) {

        PacmanGUI frame = new PacmanGUI();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


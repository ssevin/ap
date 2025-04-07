package ap.exercises.ex2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

class PacmanGUI extends JFrame implements KeyListener {

    Point pacmanPoint = new Point();
    final int width = 300, height = 300, boxSize = 5;
    static int direction = 1;
    final int LEFT = 1, RIGHT = 2, TOP = 3, BOTTOM = 4;
    ArrayList<Point> dotPoints = new ArrayList<>();
    int score = 0;
    long startTime;
    int numberOfDots = 10;
    boolean gameRunning = true;

    public PacmanGUI() {
        addKeyListener(this);
        pacmanPoint.setLocation((width / boxSize) / 2, (height / boxSize) / 2);
        generateDotPoints();
        startTime = System.currentTimeMillis();
        setSize(width, height);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g.clearRect(0, 0, width, height);
        if (gameRunning) {
            logic();
        }
        drawWalls(g2D);
        drawPacman(g2D);
        drawDotPoints(g2D);
        drawScore(g2D);
        setVisible(true);
    }

    private void drawWalls(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);

        for (int i = 0; i < width / boxSize; i++) {
            g2d.fillRect(i * boxSize, 0, boxSize, boxSize);
            g2d.fillRect(i * boxSize, height - boxSize, boxSize, boxSize);
        }

        for (int i = 0; i < height / boxSize; i++) {
            g2d.fillRect(0, i * boxSize, boxSize, boxSize);
            g2d.fillRect(width - boxSize, i * boxSize, boxSize, boxSize);
        }
    }

    private void drawPacman(Graphics2D g2d) {
        g2d.setColor(Color.BLUE);
        g2d.fillRect(pacmanPoint.x * boxSize, pacmanPoint.y * boxSize, boxSize, boxSize);
    }

    private void drawDotPoints(Graphics2D g2d) {
        g2d.setColor(Color.RED);
        for (Point dot : dotPoints) {
            g2d.fillRect(dot.x * boxSize, dot.y * boxSize, boxSize, boxSize);
        }
    }

    private void drawScore(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        String s = "Score: " + score;
        g2d.drawString(s, 25, 50);

        if (!gameRunning) {
            long endTime = System.currentTimeMillis();
            long duration = (endTime - startTime) / 1000;
            g2d.drawString("Game Over! Time: " + duration + " seconds", 25, 80);
        }
    }

    private void logic() {
        checkDotCollision();
        movePacman();
    }

    private void checkDotCollision() {
        for (int i = 0; i < dotPoints.size(); i++) {
            Point dot = dotPoints.get(i);
            if (dot.x == pacmanPoint.x && dot.y == pacmanPoint.y) {
                dotPoints.remove(i);
                score++;
                i--;

                if (dotPoints.isEmpty()) {
                    gameRunning = false;
                }
            }
        }
    }

    private void movePacman() {
        int xMovement = 0;
        int yMovement = 0;

        switch (direction) {
            case LEFT:
                xMovement = -1;
                break;
            case RIGHT:
                xMovement = 1;
                break;
            case TOP:
                yMovement = -1;
                break;
            case BOTTOM:
                yMovement = 1;
                break;
        }

        pacmanPoint.setLocation(pacmanPoint.x + xMovement, pacmanPoint.y + yMovement);
        handleCrossBorder();
    }

    private void generateDotPoints() {
        Random rand = new Random();
        int maxX = (width / boxSize) - 2;
        int maxY = (height / boxSize) - 2;

        for (int i = 0; i < numberOfDots; i++) {
            int x = rand.nextInt(maxX - 1) + 1;
            int y = rand.nextInt(maxY - 1) + 1;
            dotPoints.add(new Point(x, y));
        }
    }

    private void handleCrossBorder() {

        int maxX = (width / boxSize) - 2;
        int maxY = (height / boxSize) - 2;

        if (pacmanPoint.x < 1) {
            pacmanPoint.x = 1;
        } else if (pacmanPoint.x > maxX) {
            pacmanPoint.x = maxX;
        }

        if (pacmanPoint.y < 1) {
            pacmanPoint.y = 1;
        } else if (pacmanPoint.y > maxY) {
            pacmanPoint.y = maxY;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (gameRunning) {
            if (e.getKeyCode() == KeyEvent.VK_UP)
                direction = TOP;
            else if (e.getKeyCode() == KeyEvent.VK_DOWN)
                direction = BOTTOM;
            else if (e.getKeyCode() == KeyEvent.VK_LEFT)
                direction = LEFT;
            else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
                direction = RIGHT;

            repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}

public class Main_EX2_PM_3_1_B {
    public static void main(String[] args) {

        PacmanGUI frame = new PacmanGUI();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

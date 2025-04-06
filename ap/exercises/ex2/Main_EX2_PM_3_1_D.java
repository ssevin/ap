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
    private int score = 0;
    private int pointsRemaining = 0;
    private long startTime;
    private boolean running = true;
    private final int gridWidth = width / boxSize;
    private final int gridHeight = height / boxSize;

    public PacmanGUI() {
        addKeyListener(this);
        pacmanPoint.setLocation((gridWidth) / 2, (gridHeight) / 2);
        startTime = System.currentTimeMillis();
        generatePoints(5);
        setSize(width, height);
        setTitle("Pacman Game");
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
        drawDotPoint(g2D);
        drawScore(g2D);
        setVisible(true);
    }

    private void drawWalls(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);

        for (int i = 0; i < gridWidth; i++) {
            g2d.fillRect(i * boxSize, 0, boxSize, boxSize);
            g2d.fillRect(i * boxSize, (gridHeight - 1) * boxSize, boxSize, boxSize);
        }
        for (int i = 0; i < gridHeight; i++) {
            g2d.fillRect(0, i * boxSize, boxSize, boxSize);
            g2d.fillRect((gridWidth - 1) * boxSize, i * boxSize, boxSize, boxSize);
        }
    }

    private void drawPacman(Graphics2D g2d) {
        g2d.setColor(Color.BLUE);
        g2d.fillRect(pacmanPoint.x * boxSize, pacmanPoint.y * boxSize, boxSize, boxSize);
    }

    private void drawDotPoint(Graphics2D g2d) {
        g2d.setColor(Color.RED);
        g2d.fillRect(dotPoint.x * boxSize, dotPoint.y * boxSize, boxSize, boxSize);
    }

    private void drawScore(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        String scoreText = "Score: " + score;
        String pointsText = "Points: " + pointsRemaining;

        long currentTime = System.currentTimeMillis();
        long duration = (currentTime - startTime) / 1000;
        String timeText = "Time: " + duration + "s";

        g2d.drawString(scoreText, 25, 25);
        g2d.drawString(pointsText, 25, 45);
        g2d.drawString(timeText, 25, 65);

        if (!running) {
            g2d.drawString("Game Over! Press Q to exit", width / 2 - 80, height / 2);
        }
    }

    private void logic() {
        if (dotPoint.x == pacmanPoint.x && dotPoint.y == pacmanPoint.y) {
            score++;
            pointsRemaining--;
            if (pointsRemaining > 0) {
                getNewDotPointLocation();
            } else {
                running = false;
            }
        }
        movePacman();
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

        int newX = pacmanPoint.x + xMovement;
        int newY = pacmanPoint.y + yMovement;

        if (newX > 0 && newX < gridWidth - 1 && newY > 0 && newY < gridHeight - 1) {
            pacmanPoint.setLocation(newX, newY);
        }
    }

    private void getNewDotPointLocation() {
        Random rand = new Random();
        do {
            dotPoint.setLocation(
                    rand.nextInt(gridWidth - 2) + 1,
                    rand.nextInt(gridHeight - 2) + 1
            );
        } while (dotPoint.equals(pacmanPoint));
    }

    private void generatePoints(int count) {
        Random rand = new Random();
        pointsRemaining = count;
        getNewDotPointLocation();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (!running && e.getKeyCode() == KeyEvent.VK_Q) {
            System.exit(0);
        }

        if (!running) {
            return;
        }

        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                direction = TOP;
                break;
            case KeyEvent.VK_DOWN:
                direction = BOTTOM;
                break;
            case KeyEvent.VK_LEFT:
                direction = LEFT;
                break;
            case KeyEvent.VK_RIGHT:
                direction = RIGHT;
                break;
            case KeyEvent.VK_Q:
                running = false;
                break;
        }

        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}

public class Main_EX2_PM_3_1_D {
    public static void main(String[] args) {

        PacmanGUI frame = new PacmanGUI();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}


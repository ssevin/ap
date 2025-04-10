package ap.exercises.ex2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class Main_EX2_PM_2_1 extends JFrame implements KeyListener {
    private static final int SIZE = 10;
    private char[][] square = new char[SIZE][SIZE];
    private int y = 1;
    private int x = 1;
    private final int BOX_SIZE = 30;

    public Main_EX2_PM_2_1() {
        setTitle("X game move");
        setSize(SIZE * BOX_SIZE, SIZE * BOX_SIZE + 50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addKeyListener(this);
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                square[i][j] = ' ';
            }
        }

        for (int i = 0; i < SIZE; i++) {
            square[0][i] = '*';
            square[i][0] = '*';
            square[i][SIZE - 1] = '*';
            square[SIZE - 1][i] = '*';
        }

        square[y][x] = 'X';
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (square[i][j] == '*') {
                    g2d.setColor(Color.BLACK);
                    g2d.fillRect(j * BOX_SIZE, i * BOX_SIZE, BOX_SIZE, BOX_SIZE);
                } else if (square[i][j] == 'X') {
                    g2d.setColor(Color.RED);
                    g2d.fillOval(j * BOX_SIZE, i * BOX_SIZE, BOX_SIZE, BOX_SIZE);
                }
            }
        }
        g2d.setColor(Color.BLACK);
        g2d.drawString("Direction of movement: Keyboard arrow keys", 10, SIZE * BOX_SIZE + 20);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        square[y][x] = ' ';

        switch (keyCode) {
            case KeyEvent.VK_UP:
                if (y > 1) y--;
                else JOptionPane.showMessageDialog(this, "You hit the wall");
                break;
            case KeyEvent.VK_RIGHT:
                if (x < SIZE - 2) x++;
                else JOptionPane.showMessageDialog(this, "You hit the wall");
                break;
            case KeyEvent.VK_DOWN:
                if (y < SIZE - 2) y++;
                else JOptionPane.showMessageDialog(this, "You hit the wall");
                break;
            case KeyEvent.VK_LEFT:
                if (x > 1) x--;
                else JOptionPane.showMessageDialog(this, "You hit the wall");
                break;
            default:
                break;
        }
        square[y][x] = 'X';
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main_EX2_PM_2_1 game = new Main_EX2_PM_2_1();
            game.setVisible(true);
        });
    }
}


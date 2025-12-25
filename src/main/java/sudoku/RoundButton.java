package sudoku;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

public class RoundButton extends JButton {
    private int radius;
    private Color normalColor;
    private Color hoverColor;
    private Color pressColor;
    private boolean isHover;
    private boolean isPress;

    public RoundButton(String text, int radius) {
        super(text);
        this.radius = radius;
        this.normalColor = new Color(130, 188, 191);
        this.hoverColor = new Color(167, 210, 213);
        this.pressColor = new Color(111, 133, 135);

        setFont(new Font("微软雅黑", Font.BOLD, 16));
        setForeground(Color.WHITE);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setOpaque(false);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                isHover = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                isHover = false;
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                isPress = true;
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                isPress = false;
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Color bgColor = normalColor;
        if (isPress) {
            bgColor = pressColor;
        } else if (isHover) {
            bgColor = hoverColor;
        }

        g2.setColor(bgColor);
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), radius, radius));

        super.paintComponent(g2);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
    }

    @Override
    public boolean contains(int x, int y) {
        return new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), radius, radius).contains(x, y);
    }

    public void setNormalColor(Color normalColor) {
        this.normalColor = normalColor;
        repaint();
    }
}
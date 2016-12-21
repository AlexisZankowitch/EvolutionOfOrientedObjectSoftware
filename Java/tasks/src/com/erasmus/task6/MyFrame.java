package com.erasmus.task6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

public class MyFrame extends JFrame {

    private boolean click = false;
    private ArrayList<Point> points;

    private MyFrame() {
        super("Drawer");
        setSize(800,400);
        setBackground(Color.BLUE);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.points = new ArrayList<>();
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                if (click)
                    points.add(e.getPoint());
                else
                    points.add(null);
                repaint();
            }
        });
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                click = !click;
                if (click)
                    points.add(e.getPoint());
                else
                    points.add(null);
                repaint();
            }
        });
    }

    public void paint(Graphics g) {
        for (int i=0; i< points.size()-1; i++)
        {
            if (points.get(i) != null){
                if (points.get(i+1) != null){
                    g.drawLine(
                            (int) points.get(i).getX(),
                            (int) points.get(i).getY(),
                            (int) points.get(i+1).getX(),
                            (int) points.get(i+1).getY()
                    );
                }
            }
        }
    }

    public static void main(String[] args) {
        new MyFrame();
    }
}

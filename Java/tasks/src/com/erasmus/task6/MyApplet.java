package com.erasmus.task6;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class MyApplet extends  Applet{

    private ArrayList<Point> points;

    public void init(){
        this.points = new ArrayList<>();
        setBackground(Color.GREEN);
        MyMouseListener mouseListener = new MyMouseListener();
        this.addMouseListener(mouseListener);
        this.addMouseMotionListener(mouseListener);
    }

    public void paint (Graphics g) {
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

    class MyMouseListener implements MouseMotionListener, MouseListener {

        private boolean click = false;

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            this.click = !this.click;
            points.add(e.getPoint());
            repaint();
            if (!this.click)
                points.add(null);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void mouseDragged(MouseEvent e) {

        }

        @Override
        public void mouseMoved(MouseEvent e) {
            if(this.click){
                points.add(e.getPoint());
                repaint();
            }else
                points.add(null);
        }
    }
}

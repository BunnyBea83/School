package src;

import src.DrawingPanel;

import java.awt.*;
public class Project {
    public static void main(String[] args) {
        drawParabola();


    }
    public static void drawParabola() {
        int height = 400;
        int width = 400;
        int increment = 1;
        DrawingPanel panel = new DrawingPanel(400, 400);
        Image parabola = panel.loadImage("parabola.jpg");
        Graphics g = panel.getGraphics();
        for (int i = 0; i < increment; i++) {
            g.drawImage(parabola, 0, 0, panel);
        }

    }
}

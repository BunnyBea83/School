package src;
import java.awt.*;
/**
 * @author Bea Sauve
 * @version 01/24/2025
 */

public class GraphicsProject {
    /**
     *
     * @param  args not present
     * @return A parabola curve made of lines and a little image
     */
    public static void main(String[] args) {
        //set a drawing panel for part 2 image
        src.DrawingPanel ImagePanel = new src.DrawingPanel(600, 600);
        Graphics g2 = ImagePanel.getGraphics();

        //call part1 method: DrawParabola and part2: Frog and DupSquare
        DrawParabola();
        DupSquare(g2,1,1);
        Frog(g2);

    }

    //Method for creating a line parabola
    public static void DrawParabola(){
        //set the variables
        int width = 400;
        int height = 400;
        int halfHeight = height / 2;
        int lines = 10;
        //create the panel and define the colors
        src.DrawingPanel panel = new src.DrawingPanel(width, height);
        Graphics g = panel.getGraphics();
        panel.setBackground(Color.BLACK);

        //Draw lines for the parabola within the for loop
        for (int j = 0; j <= 20; j++){
            int twentyInc = j * lines;
            int halfInc= j/2;
            //set color shifter
            g.setColor(new Color(220-(8*j), 2*j, 200- (2*j)));
            //quadrant 1
            g.drawLine(halfHeight, twentyInc, halfHeight+twentyInc, halfHeight);
            //quadrant 2
            g.drawLine(twentyInc, halfHeight, halfHeight, halfHeight-twentyInc);
            //quadrant 3
            g.drawLine(twentyInc, halfHeight, halfHeight, halfHeight+twentyInc);
            //quadrant 4
            g.drawLine(height-twentyInc, halfHeight, halfHeight, halfHeight+twentyInc);

            //Calculate the length of the line at 45 degrees
            //Use radians(45=pi/2) and radius (200 points)
            double radians = (double) (Math.PI/4);
            int sector = (int) (halfHeight * radians);
            //use sector /max j in (20) to calculate the increments needed for x2 and y2
            int quarterInc = sector/20;
            //calc quarter angle inc to define coords for the quarter angle
            int quarterAngleInc = j * quarterInc;

            //set color shifter
            g.setColor(new Color(225, 6*j, 200- twentyInc ));

            //quadrant 1.1
            g.drawLine(height-twentyInc, halfHeight,(int) (halfHeight + quarterAngleInc),  (int) (halfHeight - quarterAngleInc));
            //quadrant 1.2
            g.drawLine(halfHeight, twentyInc, (int) (halfHeight + quarterAngleInc), (int) (halfHeight - quarterAngleInc));
            //quadrant 2.1
            g.drawLine(halfHeight, twentyInc, (int) (halfHeight - quarterAngleInc),  (int) (halfHeight - quarterAngleInc));
            //quadrant 2.2
            g.drawLine(twentyInc, halfHeight, (int) (halfHeight - quarterAngleInc),  (int) (halfHeight - quarterAngleInc));
            //Quadrant 3.1
            g.drawLine(twentyInc, halfHeight,(int) (halfHeight - quarterAngleInc), halfHeight+quarterAngleInc);
            //quadrant 3.2
            g.drawLine(halfHeight, height-twentyInc,halfHeight-quarterAngleInc, halfHeight+quarterAngleInc);
            //quadrant 4.1
            g.drawLine(halfHeight, height-twentyInc,(int) (halfHeight + quarterAngleInc), halfHeight+quarterAngleInc);
            //quadrant 4.2
            g.drawLine(height-twentyInc, halfHeight,(int) (halfHeight + quarterAngleInc), halfHeight+quarterAngleInc);
        }
        }
    /**
     * @param g2, x, y
     * @return Image background of an alternating square and circle pattern
     */
        public static void DupSquare(Graphics g2, int x, int y){

            for (int i = 0; i < 12; i++) {
                for (int j=0; j<3; j++){
                    AltSquare(g2, x + j * 200, y*50*i);
                }
            }
        }
    /**
     * @param g2, x, y
     * @return Four duplicated squares with alternating circles in each square
     */
        public static void AltSquare(Graphics g2, int x, int y){
            for (int i = 0; i < 4; i++){
                Square(g2,x+50*i,y);
            g2.setColor(new Color(72,53,25));//brown
            g2.fillOval(x+25,y+0,25,25);
            g2.fillOval(x+50,y+25,25,25);
            g2.fillOval(x+100,y+0,25,25);
            g2.fillOval(x+175,y+25,25,25);

            }
        }
        /**
         * @param g2, x, y
         * @return A square drawing
         */
        public static void Square(Graphics g2, int x, int y){
            g2.setColor(new Color(72,53,25));//brown
            g2.fillRect(x, y,50,50);
            g2.setColor(new Color(245,245,220)); //beige
            g2.fillOval(x,y,50,50);

        }
        /**
         * @param g2
         * @return A frog drawing
         */
        public static void Frog (Graphics g2){
            g2.setColor(new Color(111,124,18)); //grass green
            int x = 120;
            int y = 200;
            g2.fillOval(x,y,375,375);
            g2.fillOval(x-10,y-20,200,200);
            g2.fillOval(x+180,y-20,200,200);

            //make the eyes
            g2.setColor(new Color(240,240,240));//off-white
            g2.fillOval(x+10,y,150,150);
            g2.fillOval(x+210,y,150,150);
            g2.setColor(Color.BLACK);
            g2.fillOval(x+10,y,125,125);
            g2.fillOval(x+210,y,125,125);

            //make a smile
            g2.fillOval(x+65,y+200,250,125);
            g2.setColor(new Color(111,124,18)); //grass green
            g2.fillOval(x+10,y+120,150,100);
            g2.fillOval(x+210,y+120,150,100);
            g2.fillOval(x+65,y+170,250,125);

            //Make a lil Phrase
            g2.fillRect(90,5,420,100);
            g2.setFont(new Font("Monospaced",Font.BOLD + Font.ITALIC, 30));
            g2.setColor(Color.BLACK);
            g2.drawString("Ribbit, Ribbit,", 162, 41);
            g2.drawString("Compile and Commit it!", 102, 81);
            g2.setColor(new Color(218,168,1));//mustard yellow
            g2.drawString("Ribbit, Ribbit,", 160, 40);
            g2.drawString("Compile and Commit it!", 100, 80);
        }
    }

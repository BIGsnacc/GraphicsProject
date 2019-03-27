
/**
 * 1. Get info
 *          1.1.1 Get first picture from a specific file on computer
 *          1.1.2 Get second picture from a specific file on computer
 *          1.1.3 Get third picture from a specific file on computer
 *      1.2. Get parameters for circle
 *      1.3. Get parameters for line
 *      1.4. Get parameters for polygon
 *      1.5. Get parameters for hexagon
 *      1.6. Get parameters for arc
 *          1.7.1. Get parameters for invisible rectangle
 *          1.7.2. Get parameters for invisible rectangle 2
 *          1.7.3. Get parameters for invisible rectangle 3
 *               1.8.1. Get the variations of the circle after click of picture one
 *               1.8.2. Get the variations of the hexagon after click of picture two
 *               1.8.3. Get the variations of the polygon after click of picture three
 * 2. Do calculations
 *      2.1. Calculate the parameters for the hexagon's offset to the circle
 *      2.2. Calculate the parameters for the hexagon's points/parameters
 *      2.3. Calculate the parameters for the polygon's points/parameters
 * 3. Print Results
 *      3.1. Draw the line
 *      3.2. Draw the arc
 *      3.3. Draw the circle
 *      3.4. Draw the polygon
 *      3.5. Draw teh hexagon
 *          3.6.1. Print the first picture
 *          3.6.2. Print the second picture
 *          3.6.3. Print the third picture
 *              3.7.1. Print the variation of circle after click of picture one
 *              3.7.2. Print the variation of hexagon after click of picture two
 *              3.7.3. Print the variation of polygon after click of picture three
 *
 */


import java.awt.*;
import java.applet.*;



public class GraphicsThings extends Applet {

            //all the declarations
    Image picture;
    Image picture2;
    Image picture3;
    Rectangle rectangle1;
    Rectangle rectangle2;
    Rectangle rectangle3;
    int numClicks;
    int imageNumber = 0;
    int centerX;
    int centerY;
    int radius;


        //pictures used
    public void init() {
        picture = getImage(getDocumentBase(),"Big Bird.jpg");
        picture2 = getImage(getDocumentBase(),"Big Bird Resting.jpg");
        picture3 = getImage(getDocumentBase(),"Tired Big Bird.jpg");


        String url = String.valueOf(getDocumentBase());
        System.out.println(url);

    }

    {
        numClicks = 0;
    }



            //changing the size of the pictures and the drawings
    public void paint(Graphics g) {

        int width = picture.getWidth(this)/3;
        int height = picture.getHeight(this)/3;

        g.drawImage(picture,585,200,width,height, this);

        rectangle1 = new Rectangle(585,200,width,height);



        width = picture2.getWidth(this)/3;
        height = picture2.getHeight(this)/3;

        g.drawImage(picture2,600,500,width,height, this);

        rectangle2 = new Rectangle(600,500,width,height);

        width = picture3.getWidth(this);
        height = picture3.getHeight(this);

        g.drawImage(picture3,600,800,width,height, this);

        rectangle3 = new Rectangle(600,800,width,height);


        for (int x=100, y=100; x <= 300; x+=5, y+=5)
            g.fillRect(x,y,2,2);


        g.fillArc(50, 150, 100, 75, 90, 90);
        //         X   Y     W   H   SA   deg



        Color myPurple = new Color(111, 123, 196); // Color white
        g.setColor(myPurple);
        g.setFont(new Font("Arial",Font.BOLD,40));
        g.drawString("Hello there.",100,100 );

        //the circle with its parameters
        radius = 100;
        centerX = 200;
        centerY = 400;
        drawCircle(g,radius,centerX,centerY);

        //The hexigon with its parameters
        drawHexigon(g,radius,(centerX + (radius * 2) + 50),(centerY + (radius * 2) + 50),myPurple);



        //The polygon with its parameters
        int xCoord[] = {400,550,500,300,250};
        int yCoord[] = {70,200,350,350,200};
        drawPolygon(g, xCoord, yCoord, 5, Color.blue);

        switch (imageNumber) {         //Decides what changes are made when each image is clicked
            case 1:
                drawCircle(g,200,200,400);
                break;

            case 2:
                drawHexigon(g,350,(centerX + (radius * 2) + 50),(centerY + (radius * 2) + 50),myPurple);
                break;
            case 3:
                drawPolygon(g, xCoord, yCoord, 5, Color.orange);
                break;

        }



/*
        {
            g.drawString("Mouse is clicked " + numClicks + " times.",20,20);
        }
*/

    }

    public void drawCircle (Graphics g, int radius, int centerX, int centerY) {    //circle function
        int x,y;

        g.setColor(Color.blue);
        for (double radian = 0; radian <= 2 * Math.PI; radian += 0.01)
        {
            x = (int) Math.round(Math.cos(radian) * radius) + centerX;
            y = (int) Math.round(Math.sin(radian) * radius) + centerY;
            g.drawLine(x,y,x,y);
        }
    }

    public void drawHexigon (Graphics g, int radius, int centerX, int centerY, Color color) {   //hexigon function
        double twoPI = 2 * Math.PI;
        g.setColor(Color.blue);
        int x1 = (int) Math.round(Math.cos(twoPI * 1/6) * radius) + centerX;
        int y1 = (int) Math.round(Math.sin(twoPI * 1/6) * radius) + centerY;
        int x2 = (int) Math.round(Math.cos(twoPI * 2/6) * radius) + centerX;
        int y2 = (int) Math.round(Math.sin(twoPI * 2/6) * radius) + centerY;
        int x3 = (int) Math.round(Math.cos(twoPI * 3/6) * radius) + centerX;
        int y3 = (int) Math.round(Math.sin(twoPI * 3/6) * radius) + centerY;
        int x4 = (int) Math.round(Math.cos(twoPI * 4/6) * radius) + centerX;
        int y4 = (int) Math.round(Math.sin(twoPI * 4/6) * radius) + centerY;
        int x5 = (int) Math.round(Math.cos(twoPI * 5/6) * radius) + centerX;
        int y5 = (int) Math.round(Math.sin(twoPI * 5/6) * radius) + centerY;
        int x6 = (int) Math.round(Math.cos(twoPI) * radius) + centerX;
        int y6 = (int) Math.round(Math.sin(twoPI) * radius) + centerY;

        Polygon hex = new Polygon();
        hex.addPoint(x1,y1);
        hex.addPoint(x2,y2);
        hex.addPoint(x3,y3);
        hex.addPoint(x4,y4);
        hex.addPoint(x5,y5);
        hex.addPoint(x6,y6);
        g.setColor(color);
        g.fillPolygon(hex);
    }

    public void drawPolygon (Graphics g, int[] xCoord, int[] yCoord, int points, Color color) {     //polygon function
        g.setColor(color);
        g.fillPolygon(xCoord,yCoord, points);
    }

    public boolean mouseDown(Event e, int x, int y)    //Actual mouse click tracker
    {

        if (rectangle1.contains(x, y)) {
            imageNumber = 1;

        } else if (rectangle2.contains(x, y)) {
            imageNumber = 2;
        } else if (rectangle3.contains(x, y)) {
            imageNumber = 3;
        }

        numClicks++;
        repaint();
        return true;
    }




}



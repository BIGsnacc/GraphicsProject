
/**
 * @(#)GraphicsThings.java
 *
 * GraphicsThings Applet application
 *
 * @author
 * @version 1.00 2019/3/18
 */


import java.awt.*;
import java.applet.*;



public class GraphicsThings extends Applet {

    Image picture;
    Image picture2;
    Image picture3;
    Rectangle rectangle1;
    Rectangle rectangle2;
    Rectangle rectangle3;
    int numClicks;
    int imageNumber = 0;



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


        int x,y;
        int radius = 100;
        int centerX = 200;
        int centerY = 400;
        g.setColor(Color.blue);
        for (double radian = 0; radian <= 2 * Math.PI; radian += 0.01)
        {
            x = (int) Math.round(Math.cos(radian) * radius) + centerX;
            y = (int) Math.round(Math.sin(radian) * radius) + centerY;
            g.drawLine(x,y,x,y);
        }

         radius = 100;
         centerX = (centerX + (radius * 2) + 50);
         centerY = (centerY + (radius * 2) + 50);
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
        g.fillPolygon(hex);
        g.setColor(myPurple);




        int xCoord[] = {400,550,500,300,250};
        int yCoord[] = {70,200,350,350,200};
        g.fillPolygon(xCoord,yCoord,5);


        switch (imageNumber) {
            case 1:
                if(g.getColor() == Color.blue) {
                    g.setColor(myPurple);
                    g.fillPolygon(hex);
                    System.out.println("purple");

                } else if (g.getColor() == myPurple) {
                    g.setColor(Color.blue);
                    g.fillPolygon(hex);
                    System.out.println("blue");
                }
                break;

            case 2:

                break;
            case 3:

                break;
        }



/*
        {
            g.drawString("Mouse is clicked " + numClicks + " times.",20,20);
        }
*/

    }




    public boolean mouseDown(Event e, int x, int y)
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



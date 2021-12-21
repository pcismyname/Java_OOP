import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
public class GUI extends JPanel {
    Ball balls [];

    public GUI()
    {
        balls = new Ball[10];
        
        for(int i = 0;i<balls.length;i++)
        {
            balls[i] = new Ball();
            balls[i].pos = new Vector();
            balls[i].vel = new Vector();
            balls[i].acc = new Vector();
            
            balls[i].pos.x = (int)(Math.random()*500);
            balls[i].pos.y = (int)(Math.random()*500);
        
            balls[i].vel.x = (int)(Math.random()*10-5);
            balls[i].vel.y = (int)(Math.random()*10-5);

            balls[i].acc.x = 0;
            balls[i].acc.y = 0.1;

            balls[i].R = (int)(Math.random()*255);
            balls[i].G = (int)(Math.random()*255);
            balls[i].B = (int)(Math.random()*255);
            balls[i].Size = (int)(Math.random()*255);
        }
        Thread t = new Thread(new Runnable() {
            public void run(){
                while(true)
                {
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    for(int i=0;i<balls.length;i++)
                    {
                        balls[i].move();
                    }
                    repaint();
                }
            }
        });
        t.start();
        JFrame f = new JFrame();
        f.add(this);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(500, 500);
        f.setVisible(true);
    }
    public void paint(Graphics g){
        super.paint(g);
        for(int i=0;i<balls.length;i++){
            balls[i].draw(g);
        }
    }
    public static void main(String[] args) {
        new GUI();
    }
}

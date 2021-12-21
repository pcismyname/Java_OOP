import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
public class GUI extends JPanel {
    
    Ball balls [];
    
    public GUI()
    {
        balls = new Ball[30];
        for(int i = 0;i<10;i++)
        {
            balls[i] = new Ball();

        }

        for(int i = 10;i<20;i++)
        {
            balls[i] = new Rect();

        }
        
        for(int i = 20;i<balls.length;i++)
        {
            balls[i] = new Star();

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

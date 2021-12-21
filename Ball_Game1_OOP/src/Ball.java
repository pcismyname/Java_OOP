import java.awt.Color;
import java.awt.Graphics;

public class Ball {
    public Vector pos,vel,acc;
    public int R,G,B,Size;

    public void move()
    {
        
        vel = vel.add(acc);
        pos = pos.add(vel);
        if(pos.x  < 0)
        {
            pos.x = 0;
            vel.x *= -1;
        }
        if(pos.y   < 0)
        {
            pos.y = 0;
            vel.y *= -1;
        }
        if(pos.x + Size > 500)
        {
            pos.x = 500 - Size;
            vel.x *= -1;
        }
        if(pos.y + Size > 500)
        {
            pos.y = 500 - Size;
            vel.y *= -1;
        }  
    }

    public void draw(Graphics g)
        {
            g.setColor(new Color(R,G,B,190));
            g.fillOval((int)pos.x, (int)pos.y, Size, Size);
        }
}

import java.awt.Color;
import java.awt.Graphics;

public class Rect extends Ball {
   
    

    public void draw(Graphics g)
        {
            g.setColor(new Color(R,G,B,190));
            g.fillRect((int)pos.x, (int)pos.y, Size, Size);
        } 
}

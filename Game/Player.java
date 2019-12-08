import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Player extends Spaceship{
	
	public int lives = 3;
	private int speed = 1;
	
	Player() {
		//super();
        var playerImg = "file:///Users/jquilty/Desktop/playership.png"; //////THIS IS LOCAL AND NEEDS TO BE IN PROJECT
        var ii = new ImageIcon(playerImg);

        width = ii.getImage().getWidth(null);
        setImage(ii.getImage());

        int START_X = 270;
        setX(START_X);

        int START_Y = 280;
        setY(START_Y);
	}
	
	Player(int x, int y)
	{
		super(x, y);
	}
	
	public void move()
	{
		if(this.getX() != 0 && this.getX() != 500)
			this.setX(this.getX() + speed);
	}
	
	public void keyPressed(KeyEvent k)
	{
		int keyCode = k.getKeyCode();
		switch(keyCode) {
			case(KeyEvent.VK_LEFT):
			{
				speed = -1;
				break;
			}
			case(KeyEvent.VK_RIGHT):
			{
				speed = 1;
				break;
			}
			case(KeyEvent.VK_SPACE):
			{
				shoot();
				break;
			}
		}
	}
	public void keyReleased(KeyEvent k)
	{
		int keyCode = k.getKeyCode();
		switch(keyCode) {
			case(KeyEvent.VK_LEFT):
			{
				speed = 0;
				break;
			}
			case(KeyEvent.VK_RIGHT):
			{
				speed = 0;
				break;
			}
		}
	}
	
}
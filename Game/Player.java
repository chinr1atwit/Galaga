import java.awt.event.KeyEvent;

public class Player extends Spaceship{
	
	public int lives = 3;
	private int speed = 1;
	
	Player() {
		super();
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
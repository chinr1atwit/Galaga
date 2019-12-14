public class Player extends Spaceship
{
	public int lives = 3;
	public int speed = 0;
	Player() {
		super();
		loadImage("Game/playerShip.png");
		getImageDimensions();
	}
	Player(int x, int y)
	{
		super(x, y);
		loadImage("Game/playerShip.png");
		getImageDimensions();
	}
	public void update()
	{
		this.setX(this.getX() + speed);
	}
	public void move()
	{
		if(this.getX()+width/2+20 == 500 && speed > 0)
			speed = 0;
		if(this.getX() == 0 && speed < 0)
			speed = 0;
		this.setX(this.getX() + speed);
	}
}
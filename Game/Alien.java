public class Alien extends Spaceship{
	public Alien()
	{
		super();
	}
	public Alien(int x, int y)
	{
		super(x, y);
		loadImage("C:\\Users\\chinr1\\git\\Galaga\\Game\\vsmallenemy.png");
		getImageDimensions();
	}
	public void move()
	{
		this.setX(this.getX());
		this.setY(this.getY());
	}
}
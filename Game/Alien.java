
public class Alien extends Spaceship{
	public Alien()
	{
		super();
	}
	public Alien(int x, int y)
	{
		super(x, y);
	}
	public void move()
	{
		this.setX(this.getX());
		this.setY(this.getY());
	}
}

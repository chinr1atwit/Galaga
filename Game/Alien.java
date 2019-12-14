public class Alien extends Spaceship{
	
	int timer = 0;
	int moved = 0;
	public Alien()
	{
		super();
	}
	public Alien(int x, int y)
	{
		super(x, y);
		loadImage("Game/enemy2.png");
		getImageDimensions();
	}
	public void move()
	{
		timer++;
		if(timer%225 == 0)
		{
			this.setX(this.getX()+1);
			moved++;
			if(this.getY() > 650)
			{
				GameScene.markedAliens.add(GameScene.aliens.indexOf(this));
			}
			else if(moved == 110-this.width)
			{
				this.setY(this.getY()+this.height);
				this.setX(this.getX()-110+this.width);
				moved = 0;
			}
		}
	}
}
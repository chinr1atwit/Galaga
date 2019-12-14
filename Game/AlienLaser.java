public class AlienLaser extends GameObject
{
	Player player = GameScene.player;
	public int timer = 0;
    public AlienLaser()
    {
        super(0, 0);
        move();
    }
    public AlienLaser(int x, int y)
    {
    	super(x, y);
        loadImage("Game/laser3.png");
        getImageDimensions();
    }
    public void move()
    {
    	timer++;
	    if(timer % 3 == 0) 
	    {
	        this.setY(this.getY() + 1);
	        
	        if(this.getY() > 650)
	        {
	            GameScene.markedAlienLasers.add(GameScene.alienLasers.indexOf(this)); //mark for death
	        }
	        else if(isCollision())
	        {
	        	player.takeDamage();
	        	if(player.health <= 0)
	        		; //mark for death
	        	GameScene.markedAlienLasers.add(GameScene.alienLasers.indexOf(this)); //mark for death
	        }
	        else
	            move();
    	}
    }
    private boolean isCollision() //checks for collision
    {
    	int y = this.getY(), x = this.getX();
		for(int i = 0; i <= this.height; i++)
		{
			if(y + i > player.getY() && y + i < player.getY()+player.height)
			{
				for(int j = 0; j <= this.width; j++)
				{
					if(x + j > player.getX() && x + j < player.getX()+player.width)
					{
						return true;
					}
				}
			}
		}
    	return false;
    }
}
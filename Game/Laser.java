public class Laser extends GameObject
{    
    public Laser()
    {
        super(0, 0);
        move();
    }
    public Laser(int x, int y)
    {
    	super(x, y);
        move();
    }
    private void move()
    {
        this.setY(this.getY() - 5);
        if(this.getY() + height < 0)
            GameScene.destroyLaser(this);
        else if(isCollision())
        {
        	GameScene.destroyAlien(collisionWith());
        	GameScene.destroyLaser(this);
        }
        else
            move();
    }
    private boolean isCollision()
    {
    	int y = this.getY(), x = this.getX();
    	for(Alien a : GameScene.getAliens())
    	{
    		for(int i = 0; i <= this.height; i++)
    		{
    			if(y + i > a.getY() && y + i < a.getY()+a.height)
    			{
    				for(int j = 0; j <= this.width; j++)
    				{
    					if(x + j > a.getX() && x + j < a.getX()+a.width)
    					{
    						return true;
    					}
    				}
    			}
    		}
    	}
    	return false;
    }
    private Alien collisionWith()
    {
    	int y = this.getY(), x = this.getX();
    	for(Alien a : GameScene.getAliens())
    	{
    		for(int i = 0; i <= this.height; i++)
    		{
    			if(y + i > a.getY() && y + i < a.getY()+a.height)
    			{
    				for(int j = 0; j <= this.width; j++)
    				{
    					if(x + j > a.getX() && x + j < a.getX()+a.width)
    					{
    						return a;
    					}
    				}
    			}
    		}
    	}
    	return null;
    }
}

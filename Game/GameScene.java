import java.util.ArrayList;

public class GameScene
{
    Player player = new Player();
    static ArrayList<Laser> lasers = new ArrayList<>();
    private static ArrayList<Alien> aliens = new ArrayList<>();
    
    public static void main(String[] args)
    {
    	
    } 
    public static void destroyLaser(Laser l)
    {
    	lasers.remove(l);
    }
    public static void destroyAlien(Alien a)
    {
    	aliens.remove(a);
    }
    public static void createLaser(int x, int y)
    {
    	lasers.add(new Laser(x, y));
    }
    public static void createAlien(int x, int y)
    {
    	aliens.add(new Alien(x, y));
    }
    public void moveShips()
    {
    	player.move();
    	for(Alien a : aliens)
    	{
    		a.move();
    	}
    }
    public static ArrayList<Alien> getAliens()
    {
    	return aliens;
    }
}

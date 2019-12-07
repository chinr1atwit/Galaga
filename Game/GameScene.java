import java.util.ArrayList;

public class GameScene
{
    Spaceship ship = new Spaceship();
    static ArrayList<Laser> lasers = new ArrayList<>();
    static ArrayList<Spaceship> aliens = new ArrayList<>();
    
    public static void main(String[] args)
    {

    } 
    public static void destroyLaser(Laser l)
    {
    	lasers.remove(l);
    }
    public static void destroyAlien(Spaceship s)
    {
    	aliens.remove(s);
    }
    public static void createLaser(int x, int y)
    {
    	lasers.add(new Laser(x, y));
    }
    public static void createAlien(int x, int y)
    {
    	aliens.add(new Alien(x, y));
    }
}

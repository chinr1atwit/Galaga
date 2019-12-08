import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class GameScene
{
    Player player = new Player(275, 550);
    static ArrayList<Laser> lasers = new ArrayList<>();
    private static ArrayList<Alien> aliens = new ArrayList<>();
    private static Frame mainFrame;
	private static Label headerLabel;
	private static Label statusLabel;
	private static Panel controlPanel;

	public GameScene(){
		prepareGUI();
	}
    private static void prepareGUI(){
    	   mainFrame = new Frame("Galaga");
    	   mainFrame.setSize(550,650);
    	   mainFrame.setLayout(new GridLayout(3, 1));
    	   mainFrame.addWindowListener(new WindowAdapter() {
    		   public void windowClosing(WindowEvent windowEvent){
    			   System.exit(0);
    		   }     
    	   });   
    	   headerLabel = new Label();
    	   headerLabel.setAlignment(Label.CENTER);
    	   statusLabel = new Label();     
    	   statusLabel.setAlignment(Label.CENTER);
    	   statusLabel.setSize(350,100);
    	   controlPanel = new Panel();
    	   controlPanel.setLayout(new FlowLayout());
    	   mainFrame.add(headerLabel);
    	   mainFrame.add(controlPanel);
    	   mainFrame.add(statusLabel);
    	   mainFrame.setVisible(true);  
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

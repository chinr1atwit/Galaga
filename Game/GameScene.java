import java.awt.Canvas;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
public class GameScene extends Canvas implements Runnable
{
	static GameScene gs;
    public static Player player;
    public static ArrayList<Laser> lasers = new ArrayList<Laser>();
    public static ArrayList<Alien> aliens = new ArrayList<Alien>();
    public static ArrayList<AlienLaser> alienLasers = new ArrayList<AlienLaser>();
    public static ArrayList<Integer> markedLasers = new ArrayList<Integer>();
    public static ArrayList<Integer> markedAliens = new ArrayList<Integer>();
    public static ArrayList<Integer> markedAlienLasers = new ArrayList<Integer>();
    private int[][] positions = {{40, 100},
    		 					 {40, 150},
    		 					 {40, 200},
    							 {140,100}, 
    							 {140,150},
    		 					 {140,200},
    		 					 {240,100},
    		 					 {240,150},
    		 					 {240,200},
    		 					 {340,100},
    		 					 {340,150},
    		 					 {340,200},
    		 					 {440,100},
    		 					 {440,150},
    		 					 {440,200}};
	
    int foo = 0, bar = 0, baz = 0, timer = 3000;
    private boolean onCooldown = false;
	private boolean inGame = false;
	private Thread thread;
	private BufferedImage background = new BufferedImage(550, 650, BufferedImage.TYPE_INT_RGB);	
	public void init()
	{
		requestFocus();
		for(int i = 0; i < positions.length; i++)
		{
			createAlien(positions[i][0], positions[i][1]);
		}
		player = new Player(225, 450);
		addKeyListener(new KeyInput(this));
	}
	public void run()
	{
		init();

		while(inGame)
		{
			update();
			render();
		}
		stop();
	}
	private void render()
	{
		BufferStrategy buffStrat = this.getBufferStrategy();
		if(buffStrat == null)
		{
			createBufferStrategy(3);
			return;
		}
		Graphics g = buffStrat.getDrawGraphics();
		g.drawImage(background, 0, 0, 550, 650, this);
		g.drawImage(player.getImage(), player.getX(), player.getY(), player.width, player.height, this);
		for(Alien a : aliens)
		{
			g.drawImage(a.getImage(), a.getX(), a.getY(), a.width, a.height, this);
		}
		for(Laser l : lasers)
		{
				g.drawImage(l.getImage(), l.getX(), l.getY(), l.width, l.height, this);
		}
		update();
		g.dispose();
		buffStrat.show();
	}
    public void update()
    {
    	player.move();
    	System.out.println(timer);
    	if(onCooldown)
    		timer--;
    	if(timer == 0)
    	{
    		timer = 3000;
    		onCooldown = false;
    	}
    	for(Alien a : aliens)
    	{
    		a.move();
    	}
    	for(Laser l : lasers)
    	{
    		l.move();
	    }
    	for(Integer i : markedLasers)
    	{
    		lasers.remove((int)i - foo);
    		foo++;
    	}
    	for(Integer i : markedAliens)
    	{
    		aliens.remove((int)i - bar);
    		bar++;
    	}
    	for(Integer i : markedAlienLasers)
    	{
    		alienLasers.remove((int)i - baz);
    		baz++;
    	}
    	foo = 0;
    	bar = 0;
    	baz = 0;
    	markedLasers.removeAll(markedLasers);
    	markedAliens.removeAll(markedAliens);
    	markedAlienLasers.removeAll(markedAlienLasers);
    }
	private synchronized void start()
	{
		if(inGame)
			return;
		inGame = true;
		thread = new Thread(this);
		thread.start();
	}
	private synchronized void stop()
	{
		if(!inGame)
			inGame = false;
		try
		{
			thread.join();
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		System.exit(1);
	}
    public static void main(String[] args)
    {
    	gs = new GameScene();
    	gs.setPreferredSize(new Dimension(550, 650));
    	JFrame frame = new JFrame("Galaga");
    	frame.add(gs);
    	frame.pack();
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setResizable(false);
    	frame.setLocationRelativeTo(null);
    	frame.setVisible(true);
    	gs.start();
    }
    public static void destroyLaser(Laser l)
    {
    	lasers.remove(l);
    }
    public static void destroyAlien(Alien a)
    {
    	aliens.remove(a);
    }
    public static void destroyPlayer()
    {
    	gs.stop();
    }
    public static void createLaser(int x, int y)
    {
    	lasers.add(new Laser(x, y));
    }
    public static void createAlien(int x, int y)
    {
    	aliens.add(new Alien(x, y));
    }

    public void keyPressed(KeyEvent k)
	{
		int keyCode = k.getKeyCode();
		switch(keyCode) {
			case(KeyEvent.VK_LEFT):
			{
				player.speed = -1;
				break;
			}
			case(KeyEvent.VK_RIGHT):
			{
				player.speed = 1;
				break;
			}
			case(KeyEvent.VK_SPACE):
			{
				if(timer == 0 || !onCooldown) 
				{
					player.shoot();
					onCooldown = true;
				}
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
				player.speed = 0;
				break;
			}
			case(KeyEvent.VK_RIGHT):
			{
				player.speed = 0;
				break;
			}
		}
	}
}
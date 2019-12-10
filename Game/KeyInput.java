import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class KeyInput extends KeyAdapter{
	GameScene gs;
	public KeyInput(GameScene gs)
	{
		this.gs = gs;
	}
	public void keyPressed(KeyEvent ke)
	{
		gs.keyPressed(ke);
	}
	public void keyReleased(KeyEvent ke)
	{
		gs.keyReleased(ke);
	}
}
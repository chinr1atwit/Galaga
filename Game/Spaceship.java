
public class Spaceship {

	private int xcoord;
	private int ycoord;

	Spaceship() {
		xcoord = 0;
		ycoord = 0;
	}

	//Getter and setter methods
	public double getX() {
		return xcoord;
	}

	public double getY() {
		return ycoord;
	}

	public void setX(int arg) {
		xcoord = arg;
	}

	public void setY(int arg) {
		ycoord = arg;
	}

	public void fire() {
		//create new laserbolt object at tip of triangle
	}
	public void keyPressed(keyEvent e)
	{
		int keyCode = e.getKeyCode();
		if(keyCode == KeyEvent.VK_A)
			xcoord += 5;
		else if(keyCode == KeyEvent.VK_D)
			xcoord -= 5;
	}
}

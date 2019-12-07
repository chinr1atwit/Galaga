

public class Spaceship extends GameObject{
	
	public int health;
	
	Spaceship(){
		super();
	}
	
	Spaceship(int x, int y){
		super(x, y);
	}
	
	//Fire a blaster bolt
	public void shoot(){
		GameScene.createLaser(this.getX() + width/2, this.getY());
	}
	//Decreases the health
	public void takeDamage(Spaceship c) {
		this.health = this.health - 1000;
	}
}

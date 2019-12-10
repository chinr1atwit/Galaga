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
		GameScene.createLaser(this.getX() + width/2 + 20, this.getY() + this.height);
	}
	//Decreases the health
	public void takeDamage() {
		this.health = this.health - 1000;
	}
}
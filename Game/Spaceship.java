public class Spaceship extends GameObject{
	
	public int health;
	
	Spaceship(){
	
	}
	
	//Fire a blaster bolt
	public void shoot(Spaceship c) {
		
	}
	//Decreases the health
	public void takeDamage(Spaceship c) {
		this.health = this.health - 1000;
	}
	
	
}

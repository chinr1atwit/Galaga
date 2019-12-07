class GameObject {
	
	private int xcoord;
	private int ycoord;
	
	GameObject(){
		xcoord = 100;
		ycoord = 100;
	}

	GameObject(int x, int y){
		xcoord = x;
		ycoord = y;
	}
	
	//Getters and setters of coordinates
	public int getX() {
		return this.xcoord;
	}
	
	public void setX(int n) {
		this.xcoord = n;
	}
	
	public int getY() {
		return this.ycoord;
	}
	
	public void setY(int n) {
		this.ycoord = n;
	}
}

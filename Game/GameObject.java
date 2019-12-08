import java.awt.Image;

class GameObject {
	
	private int xcoord;
	private int ycoord;
	protected int height;
	protected int width;
	private boolean isVisible;
	private Image image;
	//private Image image;
	
	GameObject(){
		xcoord = 100;
		ycoord = 100;
		isVisible = true;
	}

	GameObject(int x, int y){
		xcoord = x;
		ycoord = y;
		isVisible = true;
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
	
	
	
	//
	public void setImage(Image image) {

        this.image = image;
    }

    public Image getImage() {

        return image;
    }
    
	public void setVisibilty(boolean vis) {
		isVisible = vis;
	}
}

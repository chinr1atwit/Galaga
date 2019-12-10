import java.awt.Image;
import javax.swing.ImageIcon;
public abstract class GameObject {
	private int xcoord;
	private int ycoord;
	protected int height;
	protected int width;
	private Image image;
	GameObject(){
		xcoord = 100;
		ycoord = 100;
	}
	GameObject(int x, int y){
		xcoord = x;
		ycoord = y;
	}
	public void getImageDimensions()
	{
		width = image.getWidth(null);
		height = image.getHeight(null);
	}
	protected void loadImage(String imageName)
	{
		ImageIcon ii = new ImageIcon(imageName);
		image = ii.getImage();
	}
	//Getters and setters
	public Image getImage()
	{
		return image;
	}
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
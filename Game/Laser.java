public class Laser
{
    private int xcoord, ycoord;
    
    public Laser()
    {
        xcoord = 0;
        ycoord = 0;
        move();
    }
    public Laser(int x, int y)
    {
        xcoord = x;
        ycoord = y;
        move();
    }
    private void move()
    {
        ycoord -= 5;
        if(this.ycoord < 0)
            GameScene.destroyLaser(this);
        else
            move();
    }
}

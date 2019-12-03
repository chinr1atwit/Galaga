public class Laser
{
    private int xcoord, ycoord;
    
    public Laser()
    {
        xcoord = 0;
        ycoord = 0;
    }
    public Laser(int x, int y)
    {
        xcoord = x;
        ycoord = y;
    }
    private void move()
    {
        ycoord -= 5;
        if(this.ycoord < 0)
            lasers.remove(this);
        else
            move();
    }
}

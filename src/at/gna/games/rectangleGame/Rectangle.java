package at.gna.games.rectangleGame;

import org.newdawn.slick.Graphics;

public class Rectangle
{
    private float x;
    private float y;
    private float sizeX;
    private float sizeY;
    private float speed;

    public Rectangle(float x, float y, float sizeX, float sizeY, float speed)
    {
        this.x = x;
        this.y = y;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.speed = speed;
    }

    public void update(int delta)
    {
        this.x += (float)delta/(this.speed/10);
        if(this.x > 800)
        {
            this.x = -50;
        }
    }

    public void render(Graphics graphics)
    {
        graphics.drawRect(this.x, this.y, this.sizeX, this.sizeY);
    }

    public float getX()
    {
        return x;
    }
}

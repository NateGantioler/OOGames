package at.gna.games.FlappyBird;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Pipe implements HitBoxActor
{
    //Hitboxes
    private Shape upperHitbox, lowerHitbox;
    //For sliding Pipes
    private float PosX, speed;
    //Pipe Sizes
    private float upperPipe_Height, lowerPipe_Height, pipe_Width, pipe_spaceBetween;

    public Pipe()
    {
        this.PosX = 1000;
        this.pipe_Width = 40;
        this.pipe_spaceBetween = 200;
        this.upperPipe_Height = 100;
        this.lowerPipe_Height = this.upperPipe_Height + this.pipe_spaceBetween;
        this.upperHitbox = new Rectangle(this.PosX, 0, this.pipe_Width, this.upperPipe_Height);
        this.lowerHitbox = new Rectangle(this.PosX, this.lowerPipe_Height , this.pipe_Width, 800);
        this.speed = 2f;
    }

    public void update(GameContainer gameContainer, int delta)
    {
        PosX -= delta/speed;
        lowerPipe_Height = this.upperPipe_Height + this.pipe_spaceBetween;
        this.upperHitbox = new Rectangle(this.PosX, 0, this.pipe_Width, this.upperPipe_Height);
        this.lowerHitbox = new Rectangle(this.PosX, this.lowerPipe_Height , this.pipe_Width, 800);
    }
    public void render(Graphics graphics)
    {
        //upperPipe
        graphics.fillRect(this.PosX, 0, this.pipe_Width, this.upperPipe_Height);
        //lower Pipe
        graphics.fillRect(this.PosX, this.lowerPipe_Height, this.pipe_Width, 800);
        graphics.draw(this.upperHitbox);
        graphics.draw(this.lowerHitbox);

        //TODO delete in the End
        //graphics.draw(this.pointsTrigger);
    }

    public Shape getUpperCollisionShape()
    {
        return upperHitbox;
    }
    public Shape getLowerCollisionShape()
    {
        return lowerHitbox;
    }

    @Override
    public Shape getCollisionShape()
    {
        return null;
    }

    // Getter & Setter


    public float getPosX()
    {
        return PosX;
    }

    public void setPosX(float posX)
    {
        this.PosX = posX;
    }

    public void setUpperPipe_Height(float upperPipe_Height)
    {
        this.upperPipe_Height = upperPipe_Height;
    }
}

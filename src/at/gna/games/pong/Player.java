package at.gna.games.pong;

import at.gna.games.FlappyBird.HitBoxActor;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Player implements HitBoxActor {

    private float y_Pos;
    private float x_Pos;
    private float speed;
    private Shape hitbox;
    private boolean isPlayer2;


    public Player(float x_Pos, boolean isPlayer2)
    {
        this.y_Pos = 400;
        this.x_Pos = x_Pos;
        this.speed = 1.0f;
        this.hitbox = new Rectangle(this.x_Pos,this.y_Pos,15,150);
        this.isPlayer2 = isPlayer2;
    }

    @Override
    public void update(GameContainer gameContainer, int delta)
    {
        //Controls
        if(isPlayer2)
        {
            if (gameContainer.getInput().isKeyDown(Input.KEY_UP) && this.y_Pos > 10)
            {
                this.y_Pos -= (float) delta / speed;
            }

            if(gameContainer.getInput().isKeyDown(Input.KEY_DOWN) && this.y_Pos < 640)
            {
                this.y_Pos += (float) delta / speed;
            }
        }
        else
        {
            if (gameContainer.getInput().isKeyDown(Input.KEY_W) && this.y_Pos > 10)
            {
                this.y_Pos -= (float) delta / speed;
            }

            if(gameContainer.getInput().isKeyDown(Input.KEY_S) && this.y_Pos < 640)
            {
                this.y_Pos += (float) delta / speed;
            }
        }

        this.hitbox = new Rectangle(this.x_Pos,this.y_Pos,15,150);
    }

    @Override
    public void render(Graphics graphics)
    {
        //graphics.draw(hitbox);
        graphics.fillRect(this.x_Pos,this.y_Pos,15,150);
    }

    @Override
    public Shape getCollisionShape()
    {
        return hitbox;
    }

}

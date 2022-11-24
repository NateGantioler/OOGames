package at.gna.games.pong;

import at.gna.games.FlappyBird.HitBoxActor;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;
import java.util.concurrent.ThreadLocalRandom;
import java.lang.Math;

public class Ball implements HitBoxActor {

    private float x_Pos;
    private float y_Pos;
    private float speed;
    private Shape ballHitbox;
    private double x_Degree;
    private double y_Degree;
    private int Score1;
    private int Score2;

    public Ball()
    {
        this.x_Pos = 500.0f;
        this.y_Pos = 400.0f;
        this.speed = 3f;
        this.ballHitbox = new Circle(this.x_Pos, this.y_Pos, 15,30);
        this.x_Degree = Math.sin(ThreadLocalRandom.current().nextInt(0, 180));
        this.y_Degree = Math.cos(ThreadLocalRandom.current().nextInt(0, 180));
        this.Score1 = 0;
        this.Score2 = 0;
    }

    @Override
    public void update(GameContainer gameContainer, int delta)
    {
        this.x_Pos += (float) delta * x_Degree * (1/speed);
        this.y_Pos += (float) delta * y_Degree * (1/speed);
        this.ballHitbox = new Circle(this.x_Pos, this.y_Pos, 15,30);
        if(this.y_Pos <= 15 || this.y_Pos >= 785)
        {
            changeYDirection();
        }
    }

    @Override
    public void render(Graphics graphics)
    {
        graphics.draw(ballHitbox);
        graphics.fill(ballHitbox);
    }

    @Override
    public Shape getCollisionShape()
    {
        return ballHitbox;
    }
    public void changeXDirection()
    {
        this.x_Degree = this.x_Degree * (-1);
        this.speed -= 0.1f;
    }

    public void changeYDirection()
    {
        this.y_Degree = this.y_Degree * (-1);
        this.speed -= 0.1f;
    }

    public float getX_Pos()
    {
        return x_Pos;
    }

    public void newBall(int whoWon)
    {
        this.x_Pos = 500.0f;
        this.y_Pos = 400.0f;
        this.x_Degree = Math.sin(ThreadLocalRandom.current().nextInt(0, 180));
        this.y_Degree = Math.cos(ThreadLocalRandom.current().nextInt(0, 180));
        this.speed = 3f;
        if(whoWon == 1)
        {
            Score1++;
        }
        if(whoWon == 2)
        {
            Score2++;
        }
    }

    public int getScore1()
    {
        return Score1;
    }

    public int getScore2()
    {
        return Score2;
    }
}
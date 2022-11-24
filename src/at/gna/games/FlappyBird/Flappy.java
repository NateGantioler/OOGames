package at.gna.games.FlappyBird;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;
import org.w3c.dom.ranges.Range;

import java.util.concurrent.ThreadLocalRandom;

public class Flappy extends BasicGame {
    private float Pos_y, speed;
    private boolean isJumping;
    private int deltaRunTime;
    private float gravity;
    private int JumpTime;
    private float JumpHeight;
    private int Score;
    private String ScoreText;
    private Shape birdHitbox;

    private Pipe pipe1;

    public Flappy(String title)
    {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException
    {
        this.Pos_y = 200;
        this.speed = 2;
        this.isJumping = false;
        this.deltaRunTime = 0;
        this.gravity = 0;
        this.JumpHeight = 1f;
        this.JumpTime = 100;
        this.pipe1 = new Pipe();
        this.Score = 0;
        this.birdHitbox = new Circle(265, this.Pos_y, 12);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException
    {
        this.deltaRunTime += delta;

        //Gravity
        if(this.Pos_y < 570)
        {
            this.gravity += (float)delta / speed;
            this.Pos_y += gravity/700;
        }

        //Jump
        if (gameContainer.getInput().isKeyPressed(Input.KEY_SPACE) && !isJumping)
        {
            this.gravity = 4;
            this.deltaRunTime = 0;
            this.isJumping = true;
        }

        //Increase Bird height;
        if (this.isJumping)
        {
            this.Pos_y -= JumpHeight;
        }

        //Stop Jumping after an amount of Time
        if(this.isJumping && deltaRunTime > JumpTime)
        {
            this.isJumping = false;
        }

        //Update Pipe
        this.pipe1.update(gameContainer, delta);

        //Score
        if(this.pipe1.getPosX() == 250)
        {
            this.Score++;
        }

        //Pipe Position
        if(this.pipe1.getPosX() < 0)
        {
            this.pipe1.setPosX(850);
            this.pipe1.setUpperPipe_Height(ThreadLocalRandom.current().nextInt(-125, 250) + 100);
        }

        birdHitbox.setY(Pos_y);

        if(birdHitbox.intersects(pipe1.getLowerCollisionShape()) || birdHitbox.intersects(pipe1.getUpperCollisionShape()))
        {
            System.exit(0);
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException
    {
        graphics.drawOval(250, this.Pos_y, 30, 30);
        pipe1.render(graphics);
        graphics.drawString("Score: " + String.valueOf(Score), 8, 30);
        //graphics.draw(birdHitbox);
    }

    public static void main(String argv[]) {
        try {
            AppGameContainer container = new AppGameContainer(new Flappy("FlappyBird"));
            container.setDisplayMode(800,600,false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}

package at.gna.games.firstgame;

import org.newdawn.slick.*;

public class testGame extends BasicGame {
    private float x;
    private float y;
    private float speed = 0.5f;

    public testGame(String title)
    {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException
    {
        this.x = 50;
        this.y = 50;
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException
    {
        this.x += (float)delta * speed;
        if(x > 800)
        {
            x = -50;
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException
    {
        graphics.drawOval(x, y, 50, 50);
    }



    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new testGame("Rectangles"));
            container.setDisplayMode(800,600,false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}

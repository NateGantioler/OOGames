package at.gna.games.rectangleGame;

import at.gna.games.firstgame.testGame;
import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main extends BasicGame{

    public Main(String title)
    {
        super(title);
    }

    private List<Rectangle> rectangleList;

    @Override
    public void init(GameContainer gameContainer) throws SlickException
    {
        this.rectangleList = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i < 100; i++)
        {
            Rectangle rectangle = new Rectangle(random.nextInt(800), random.nextInt(600), random.nextInt(150), random.nextInt(150), random.nextInt(20));
            rectangleList.add(rectangle);
        }
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException
    {
        for(Rectangle rectangle:this.rectangleList)
        {
            rectangle.update(delta);
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException
    {
        for(Rectangle rectangle:this.rectangleList)
        {
            rectangle.render(graphics);
        }
    }

    public static void main(String[] args)
    {
        try {
            AppGameContainer container = new AppGameContainer(new Main("RectangleGame"));
            container.setDisplayMode(800,600,false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}

package at.gna.games.pong;

import org.newdawn.slick.*;

public class PongMain extends BasicGame {

    private Ball ball;
    private Player player1;
    private Player player2;

    public PongMain(String title) {
        super(title);
    }


    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.ball = new Ball();
        this.player1 = new Player(50, false);
        this.player2 = new Player(950, true);
    }

    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {
        ball.update(gameContainer, i);
        player1.update(gameContainer, i);
        player2.update(gameContainer, i);

        if(ball.getCollisionShape().intersects(player1.getCollisionShape()) || ball.getCollisionShape().intersects(player2.getCollisionShape()))
        {
            System.out.println("odaufk");
            ball.changeXDirection();
        }

        if(gameContainer.getInput().isKeyPressed(Input.KEY_R))
        {
            ball.newBall(0);
        }

        if(ball.getX_Pos() <= 15)
        {
            ball.newBall(2);
        }
        else if(ball.getX_Pos() >= 985)
        {
            ball.newBall(1);
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        ball.render(graphics);
        player1.render(graphics);
        player2.render(graphics);
        graphics.drawString(String.valueOf(ball.getScore1()) + " | " +String.valueOf(ball.getScore2()), 8, 30);
    }

    public static void main(String argv[]) {
        try {
            AppGameContainer container = new AppGameContainer(new PongMain("Pong"));
            container.setDisplayMode(1000, 800, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
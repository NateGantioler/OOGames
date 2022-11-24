package at.gna.games.FlappyBird;

import org.newdawn.slick.geom.Shape;

public interface HitBoxActor extends Actor {
    public Shape getCollisionShape();
}
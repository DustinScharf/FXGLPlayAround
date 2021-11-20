package com.dustinscharf.fxglplayaround;

import com.almasb.fxgl.core.math.FXGLMath;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.dsl.components.ProjectileComponent;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.texture.Texture;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

/**
 * Creates all entity objects
 */
public class Factory implements EntityFactory {
    /**
     * Creates a new enemy
     *
     * @param data data for the entity to spawn
     * @return the entity to spawn
     */
    @Spawns("enemy")
    public Entity newEnemy(SpawnData data) {
        Texture texture = FXGL.texture("arrow.png").toColor(Color.RED);

        // ProjectileComponent means a moving component
        return FXGL.entityBuilder(data)
                .view(texture)
                .with(new ProjectileComponent(new Point2D(1, FXGLMath.random(-1, 1)), FXGLMath.random(100, 500)))
                .build();
    }

    /**
     * Creates a new ally
     *
     * @param data data for the entity to spawn
     * @return the entity to spawn
     */
    @Spawns("ally")
    public Entity newAlly(SpawnData data) {
        Texture texture = FXGL.texture("arrow.png").toColor(Color.GREEN);

        return FXGL.entityBuilder(data)
                .view(texture)
                .with(new ProjectileComponent(new Point2D(-1, FXGLMath.random(-1, 1)), FXGLMath.random(100, 500)))
                .build();
    }

    /**
     * Creates a new dude
     *
     * @param data data for the entity to spawn
     * @return the entity to spawn
     */
    @Spawns("dude")
    public Entity newDude(SpawnData data) {
        Texture texture = FXGL.texture("arrow.png").toColor(Color.VIOLET);

        return FXGL.entityBuilder(data)
                .view(texture)
                .opacity(0.5)
                .rotate(-90)
                .build();
    }

    // TODO make a full player controlled entity
    @Spawns("player")
    public Entity newPlayer(SpawnData data) {
        Texture texture = FXGL.texture("arrow.png").toColor(Color.VIOLET);

        // TODO make controllable

        return FXGL.entityBuilder(data)
                .view(texture)
                .opacity(0.5)
                .rotate(-90)
                .build();
    }
}

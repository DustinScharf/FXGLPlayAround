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
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class Factory implements EntityFactory {
    @Spawns("enemy")
    public Entity newEnemy(SpawnData data) {
        Texture texture = FXGL.texture("arrow.png").toColor(Color.RED);

        return FXGL.entityBuilder(data)
                .view(texture)
                .with(new ProjectileComponent(new Point2D(1, FXGLMath.random(-1, 1)), FXGLMath.random(100, 500)))
                .build();
    }

    @Spawns("ally")
    public Entity newAlly(SpawnData data) {
        Texture texture = FXGL.texture("arrow.png").toColor(Color.GREEN);

        return FXGL.entityBuilder(data)
                .view(texture)
                .with(new ProjectileComponent(new Point2D(-1, FXGLMath.random(-1, 1)), FXGLMath.random(100, 500)))
                .build();
    }

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
}

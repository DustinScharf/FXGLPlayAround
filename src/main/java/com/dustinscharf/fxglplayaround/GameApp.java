package com.dustinscharf.fxglplayaround;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.core.math.FXGLMath;
import com.almasb.fxgl.dsl.FXGL;
import javafx.geometry.Rectangle2D;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;

import static com.almasb.fxgl.dsl.FXGL.*;

public class GameApp extends GameApplication {
    @Override
    protected void initSettings(GameSettings gameSettings) {
        // empty
    }

    @Override
    protected void initInput() {
        onKeyDown(KeyCode.F, () -> {
            System.out.println("hi world");
        });
    }

    @Override
    protected void initGame() {
        getGameWorld().addEntityFactory(new Factory());

        run(() -> {
            if (FXGLMath.random(0, 5) == 0) {
                // todo disappear after few seconds
                spawn("dude",
                        FXGLMath.randomPoint(new Rectangle2D(0, 0, getAppWidth(), getAppHeight()))
                );
            }

            spawn("enemy",
                    FXGLMath.randomPoint(new Rectangle2D(0, 0, getAppWidth(), getAppHeight()))
            );

            spawn("ally",
                    FXGLMath.randomPoint(new Rectangle2D(0, 0, getAppWidth(), getAppHeight()))
            );
        }, Duration.seconds(0.1));
    }

    public static void main(String[] args) {
        launch(args);
    }
}

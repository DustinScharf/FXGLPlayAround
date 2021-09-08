package com.dustinscharf.fxglplayaround;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.core.math.FXGLMath;
import com.almasb.fxgl.dsl.FXGL;
import javafx.geometry.Rectangle2D;
import javafx.util.Duration;

import static com.almasb.fxgl.dsl.FXGL.*;

public class GameApp extends GameApplication {
    @Override
    protected void initSettings(GameSettings gameSettings) {
        // empty
    }

    @Override
    protected void initGame() {
        getGameWorld().addEntityFactory(new Factory());

        spawn("dude",
                FXGLMath.randomPoint(new Rectangle2D(0, 0, getAppWidth(), getAppHeight()))
        );

        run(() -> {
            spawn("enemy",
                    FXGLMath.randomPoint(new Rectangle2D(0, 0, getAppWidth(), getAppHeight()))
            );

            spawn("ally",
                    FXGLMath.randomPoint(new Rectangle2D(0, 0, getAppWidth(), getAppHeight()))
            );
        }, Duration.seconds(1));
    }

    public static void main(String[] args) {
        launch(args);
    }
}

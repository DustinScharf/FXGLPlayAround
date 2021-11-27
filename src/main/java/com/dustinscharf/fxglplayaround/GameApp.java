package com.dustinscharf.fxglplayaround;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.core.math.FXGLMath;
import javafx.geometry.Rectangle2D;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;

import static com.almasb.fxgl.dsl.FXGL.getAppHeight;
import static com.almasb.fxgl.dsl.FXGL.getAppWidth;
import static com.almasb.fxgl.dsl.FXGL.getGameWorld;
import static com.almasb.fxgl.dsl.FXGL.getNotificationService;
import static com.almasb.fxgl.dsl.FXGL.onKeyDown;
import static com.almasb.fxgl.dsl.FXGL.run;
import static com.almasb.fxgl.dsl.FXGL.spawn;

public class GameApp extends GameApplication {

    /**
     * Initializes the game settings
     *
     * @param gameSettings the game settings
     */
    @Override
    protected void initSettings(GameSettings gameSettings) {
        // empty
    }

    /**
     * Initializes the input keys
     */
    @Override
    protected void initInput() {
        onKeyDown(KeyCode.F, () -> getNotificationService().pushNotification("Hello world!"));
    }

    @Override
    protected void initGame() {
        // sets the entity factory for the one and only game world
        getGameWorld().addEntityFactory(new Factory());

        // run starts a thread in the bbackground to not let the gui hang between frames
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
        }, Duration.seconds(0.05)); // the run thread loops itself
    }

    /**
     * Entry point
     *
     * @param args launch arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}

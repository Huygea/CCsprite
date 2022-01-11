package com.ccsprite.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sun.org.apache.bcel.internal.generic.LoadClass;

/**
 * Created by fractal on 16.03.2017.
 */

public class ClickClack extends Game {

    public SpriteBatch batch;
    public BitmapFont font;
    public static boolean loaderCheck = true;


    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();





        this.setScreen(new MainMenuScreen(this));
    }

    public void render(){


        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClearColor(0,0, 0, 1);
        super.render();
    }
}

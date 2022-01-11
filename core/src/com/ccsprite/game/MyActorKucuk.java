package com.ccsprite.game;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;


/**
 * Created by fractal on 01.03.2017.
 */

public class MyActorKucuk  extends Actor {

   public static Image nextGear;
   Image k1,o1,b1;
    final ClickClack game;
    TextureRegion kucuk1, orta1, buyuk1;
    TextureAtlas texAtlas;


    public MyActorKucuk(final ClickClack game) {
            this.game=game;
        texAtlas = new TextureAtlas("texPacked/texPacked.atlas");

        kucuk1 = texAtlas.findRegion("kucuksteampunk");
        orta1 = texAtlas.findRegion("ortasteampunk");
        buyuk1 = texAtlas.findRegion("buyuksteampunk");
            k1 = new Image(kucuk1);
            o1 = new Image(orta1);
            b1 = new Image(buyuk1);






        if (VariableCalls.prevRand == 1) {
            nextGear = new Image(kucuk1);

            nextGear.setSize(5.5f, 5.5f);

        }
        if (VariableCalls.prevRand == 2) {
            nextGear = new Image(orta1);
            nextGear.setSize(10.8f, 10.8f);

        }
        if (VariableCalls.prevRand == 3) {
            nextGear = new Image(buyuk1);
            nextGear.setSize(16f, 16f);

        }


        nextGear.setPosition(15 - nextGear.getWidth()/2, VariableCalls.WORLD_HEIGHT-15 - nextGear.getHeight()/2);






    }



    @Override
    public void draw(Batch batch, float parentAlpha) {



        nextGear.draw(game.batch,1);









    }


}

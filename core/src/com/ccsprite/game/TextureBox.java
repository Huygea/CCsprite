package com.ccsprite.game;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

/**
 * Created by fractal on 20.03.2017.
 */

public class TextureBox {
}
    /*
private static TextureAtlas texAtlas;



  public  static TextureRegion dark,star,button,timer,whiteBox,one,crossHair,crate,openChest, explosion,youLose,kucuk,orta,buyuk,bomb,kucuk1,orta1,buyuk1,backGroundt,hingeTex,youwinT,blowtorcht,creatureTexture
            ;
   public static TextureRegion uiSkin;

    public static Skin skin;
    public static Skin smallSkin;
    static Texture  explosions;

   public static Texture bulletHitTex;
    public static TextureRegion[] bulletFrames;
    public static Animation<TextureRegion> bulletHit;

    public static TextureRegion[] animationFrames;
   public static Animation<TextureRegion> animation;

    public static void TextureBoxa() {







            texAtlas = new TextureAtlas("texPacked/texPacked.atlas");
            kucuk = texAtlas.findRegion("kucuktamam");
            orta = texAtlas.findRegion("ortatamam");
            buyuk = texAtlas.findRegion("BuyukDisliTamamdir");
            bomb = texAtlas.findRegion("bomb");
            kucuk1 = texAtlas.findRegion("kucuksteampunk");
            orta1 = texAtlas.findRegion("ortasteampunk");
            buyuk1 = texAtlas.findRegion("buyuksteampunk");
            backGroundt = texAtlas.findRegion("background");
            hingeTex = texAtlas.findRegion("hinge");
            youwinT = texAtlas.findRegion("youwin");
            blowtorcht = texAtlas.findRegion("blowtorch");
            creatureTexture = texAtlas.findRegion("cyclops");
            youLose = texAtlas.findRegion("youLose");
            explosion = texAtlas.findRegion("explosion");
            one = texAtlas.findRegion("one");
            whiteBox = texAtlas.findRegion("timerWhiteBox");
            timer = texAtlas.findRegion("timer");
            button = texAtlas.findRegion("button");
            dark = texAtlas.findRegion("dark");


            star = texAtlas.findRegion("star");

            openChest = texAtlas.findRegion("openCrate");




            uiSkin = texAtlas.findRegion("uiskin");






            crate = texAtlas.findRegion("crate");



            crossHair = texAtlas.findRegion("crosshair");




            skin = new Skin(Gdx.files.internal("uiskin.json"), new TextureAtlas("uiskin.atlas"));



        skin.getFont("default-font").getData().setScale(0.2f);



        smallSkin = new Skin(Gdx.files.internal("uiskin.json"), new TextureAtlas("uiskin.atlas"));



        smallSkin.getFont("default-font").getData().setScale(0.1f);
            explosions  =new Texture("explosion.png");

            bulletHitTex = new Texture("fireBullet.png");


        bulletFrames = new TextureRegion[4];
        TextureRegion [][] tempBulletFrames = TextureRegion.split(bulletHitTex,25,25);

        int indexb = 0;

         for(int j = 0; j<4; j++){

             bulletFrames[indexb++] = tempBulletFrames[0][j];
         }


bulletHit = new Animation<TextureRegion>(1f/4f, bulletFrames);

            animationFrames = new TextureRegion[10];
            TextureRegion [][] tempFrames = TextureRegion.split(explosions,10,10);


            int index = 0;

            for(int i = 0; i<10;i++){


                animationFrames[index++] = tempFrames[0][i];
            }

            animation = new Animation<TextureRegion>(1f/10f, animationFrames);





    }





    public static void dispose(){






    }
}
*/
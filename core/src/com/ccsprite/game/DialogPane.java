

package com.ccsprite.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;

import levels.Level1;

import static com.ccsprite.game.VariableCalls.WORLD_HEIGHT;
import static com.ccsprite.game.VariableCalls.WORLD_WIDTH;

public class DialogPane extends Actor {

    Label.LabelStyle style;
    Label label1;
   
   TextButton.TextButtonStyle textButtonStyle;
    TextButton abtnYes;
    TextButton abtnNo;
    Skin skinDialog;
    TextureRegion myTex;
    String baslik;
    Drawable drawable;
    Table t;
    final ClickClack game;

    Skin skin;
    Skin smallSkin;



    Texture backGroundt;
    TextureRegion uiSkin;

    private TextureAtlas texAtlas;

    public DialogPane(final ClickClack game) {


        this.game = game;


        texAtlas = new TextureAtlas("texPacked/texPacked.atlas");

        backGroundt = new Texture("dialogbg.png");




        uiSkin = texAtlas.findRegion("uiskin");










//SKIN AND ANIMATIONS

        skin = new Skin(Gdx.files.internal("uiskin.json"), new TextureAtlas("uiskin.atlas"));



        skin.getFont("default-font").getData().setScale(0.1f);



        smallSkin = new Skin(Gdx.files.internal("uiskin.json"), new TextureAtlas("uiskin.atlas"));


        smallSkin.getFont("default-font").getData().setScale(0.05f);




        BitmapFont font;
        font = smallSkin.getFont("default-font");


        baslik ="";
        style = new Label.LabelStyle(font, Color.WHITE);

        textButtonStyle = new TextButton.TextButtonStyle();

        //style.font.setScale(1, -1);
        style.fontColor = Color.WHITE;


        textButtonStyle.font = smallSkin.getFont("default-font");
        textButtonStyle.downFontColor = new Color(0.2f,0.4f,0,1);
        textButtonStyle.fontColor = Color.WHITE;


       




        abtnYes = new TextButton("Exit", skin);
        abtnNo = new TextButton("Cancel", skin);

        abtnNo.setStyle(textButtonStyle);
        abtnYes.setStyle(textButtonStyle);

    }



    public Actor quitGameConfirm(final int a) {




        if(a == 0)
        label1 = new Label("We will miss you...", style);

        if(a == 1)
            label1 = new Label("Exit to Level Selection?",style);
        if(a == 2)
            label1 = new Label("Restart Level?",style);
        label1.setAlignment(Align.center);

        final Dialog dialog = new Dialog(baslik, skin ){
            @Override
            public float getPrefWidth() {
                // force dialog width
                // return Gdx.graphics.getWidth() / 2;
                return WORLD_WIDTH/2;
            }

            @Override
            public float getPrefHeight() {
                // force dialog height
                // return Gdx.graphics.getWidth() / 2;
                return WORLD_HEIGHT/2;
            }
        };
        dialog.setModal(true);
        dialog.setMovable(false);
        dialog.setResizable(false);

        dialog.setSize(WORLD_WIDTH/2,WORLD_HEIGHT/3);
        abtnYes.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y,
                                     int pointer, int button) {

                // Do whatever here for exit button


                dialog.hide();
                dialog.cancel();
                dialog.remove();

                if(a ==0) {
                    ClickClack.loaderCheck = true;
                    dispose();
                    Gdx.app.exit();

                }

                if(a == 1){
                    game.getScreen().dispose();
                    VariableCalls.timeLeft = 100f;

                    game.setScreen(new LevelSelection(game));



                    dispose();


                }

                if(a == 2){


                    VariableCalls.timeLeft = 100f;
                    VariableCalls.initBool = true;
                    EnumClass.state = EnumClass.State.RUN;





                }
              //  _parent.changeState("StateMenu");


                return true;
            }

        });

        abtnNo.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y,
                                     int pointer, int button) {

                //Do whatever here for cancel

                dialog.cancel();
                dialog.hide();
                dialog.remove();

                VariableCalls.buttonCheck = true;

                dispose();
                return true;
            }

        });



        drawable = new TextureRegionDrawable(backGroundt);
        dialog.setBackground(drawable);

        float btnSize = 10f;
        t = new Table();
        // t.debug();

        dialog.getContentTable().add(label1).padTop(10f);

        t.add(abtnYes).width(btnSize).height(btnSize).size(20f);
        t.add().pad(10f);
        t.add(abtnNo).width(btnSize).height(btnSize).size(20f);

        dialog.getButtonTable().add(t).center().padBottom(1f);
        dialog.setPosition(
                (WORLD_WIDTH / 2) - WORLD_WIDTH/4,
                (WORLD_HEIGHT/2) - WORLD_HEIGHT/4);

        t.setName("quitDialogs");
        dialog.setName("quitDialog");

        return dialog;
    }
public void dispose(){

    skin.dispose();
    smallSkin.dispose();
    texAtlas.dispose();




}

}

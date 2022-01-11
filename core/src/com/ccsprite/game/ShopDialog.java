

package com.ccsprite.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
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

import static com.ccsprite.game.ShopClass.bombLabel;
import static com.ccsprite.game.ShopClass.goldLabel;
import static com.ccsprite.game.ShopClass.oilLabel;
import static com.ccsprite.game.ShopClass.sniperLabel;
import static com.ccsprite.game.VariableCalls.WORLD_HEIGHT;
import static com.ccsprite.game.VariableCalls.WORLD_WIDTH;

public class ShopDialog extends Actor {

    Label.LabelStyle style;
    Label label1;
    TextButton.TextButtonStyle textButtonStyle;
    TextButton abtnYes;
    TextButton abtnNo;
    TextureRegion myTex;
    String baslik;
    Drawable drawable;
    Table t;
    public static String dialogHeader ="";
    Preferences prefs;


    TextureRegion backGroundt
            ;
    TextureRegion uiSkin;




    private TextureAtlas texAtlas;


    Skin skin;
    Skin smallSkin;

    final ClickClack game;
    public ShopDialog(final ClickClack game) {

        prefs = Gdx.app.getPreferences("My Preferences");
        this.game = game;

        texAtlas = new TextureAtlas("texPacked/texPacked.atlas");

        backGroundt = texAtlas.findRegion("background");




//SKIN AND ANIMATIONS

        skin = new Skin(Gdx.files.internal("uiskin.json"), new TextureAtlas("uiskin.atlas"));



        skin.getFont("default-font").getData().setScale(0.2f);



        smallSkin = new Skin(Gdx.files.internal("uiskin.json"), new TextureAtlas("uiskin.atlas"));



        smallSkin.getFont("default-font").getData().setScale(0.1f);


        BitmapFont font;
        font = smallSkin.getFont("default-font");



        baslik ="";
        style = new Label.LabelStyle(font, Color.WHITE);
        label1 = new Label(dialogHeader, style);
        textButtonStyle = new TextButton.TextButtonStyle();
        label1.setAlignment(Align.center);
        //style.font.setScale(1, -1);
        style.fontColor = Color.WHITE;


        textButtonStyle.font = smallSkin.getFont("default-font");
        textButtonStyle.downFontColor = new Color(0.2f,0.4f,0,1);
        textButtonStyle.fontColor = Color.WHITE;







        abtnYes = new TextButton("Buy", skin);
        abtnNo = new TextButton("Cancel", skin);

        abtnNo.setStyle(textButtonStyle);
        abtnYes.setStyle(textButtonStyle);

    }



    public Actor quitGameConfirm(final int check) {








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
        label1.setText(dialogHeader);

        dialog.setSize(WORLD_WIDTH/2,WORLD_HEIGHT/3);
        abtnYes.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y,
                                     int pointer, int button) {

                // Do whatever here for exit button




                switch (check){

                    case 1:{

                        if(prefs.getInteger("gold", 100) >=100){
                            prefs.putInteger("gold", prefs.getInteger("gold",100)-100);
                            prefs.putInteger("bomb",prefs.getInteger("bomb",5)+10);
                            prefs.flush();
                            bombLabel.setText(String.valueOf(prefs.getInteger("bomb")));
                            goldLabel.setText(String.valueOf(prefs.getInteger("gold")));
                        }


                        break;
                    }
                    case 2:{


                        if(prefs.getInteger("gold", 100) >=100){
                            prefs.putInteger("gold", prefs.getInteger("gold",100)-100);
                            prefs.putInteger("bullet",prefs.getInteger("bullet",5)+10);
                            prefs.flush();
                            sniperLabel.setText(String.valueOf(prefs.getInteger("bullet")));
                            goldLabel.setText(String.valueOf(prefs.getInteger("gold")));
                        }

                        break;
                    }

                    case 3:{
                        if(prefs.getInteger("gold", 100) >=100){
                            prefs.putInteger("gold", prefs.getInteger("gold",100)-100);
                            prefs.putInteger("oil",prefs.getInteger("oil",5)+10);
                            prefs.flush();
                            oilLabel.setText(String.valueOf(prefs.getInteger("oil")));
                            goldLabel.setText(String.valueOf(prefs.getInteger("gold")));
                        }


                        break;
                    }


                }
                dialog.hide();
                dialog.cancel();
                dialog.remove();
                //  _parent.changeState("StateMenu");

dispose();
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

                dispose();

                return true;
            }

        });

        myTex = backGroundt;
        myTex.flip(false, true);
        drawable = new TextureRegionDrawable(myTex);
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

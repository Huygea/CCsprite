package com.ccsprite.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Tree;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.ArrayList;

import levels.Level1;
import levels.Level2;
import levels.Level3;
import levels.Level4;
import levels.Level5;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeIn;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeOut;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.run;

/**
 * Created by fractal on 16.03.2017.
 */




/**
 * Created by fractal on 16.03.2017.
 */

public class LevelSelection implements Screen {

    final ClickClack game;

    OrthographicCamera camera;
    Preferences prefs;
    private Viewport viewport;
    Stage stage;
    int waitTimer;
    Table tableX;
    //TextButton level1,level2,level3,level4,level5;
    TextButton.TextButtonStyle textButtonStyle;
    private Vector2 touch, newTouch;
    Actor touchDownActor;
    ArrayList<TextButton> butList;
    ArrayList<Image> palList;
    ArrayList<Image> wheelList;
    ArrayList<Image> assembleList;
    Image butright, butleft;
    public boolean goleft = false;
    public boolean goright = false;
    Image backgroundmain;
    Float boxW, boxAW;
   // Image colorImage, grayscaleImage;

    Skin skin,smallSkin;
    Label award;

   DialogPane dPane;

    public LevelSelection(final ClickClack game){
        VariableCalls.buttonCheck = true;

        this.game=game;
        float aspectRatio = (float) (Gdx.graphics.getHeight() / Gdx.graphics.getWidth());
        prefs = Gdx.app.getPreferences("My Preferences");
        skin = new Skin(Gdx.files.internal("uiskin.json"), new TextureAtlas("uiskin.atlas"));



        skin.getFont("default-font").getData().setScale(0.2f);




        smallSkin = new Skin(Gdx.files.internal("uiskin.json"), new TextureAtlas("uiskin.atlas"));



        smallSkin.getFont("default-font").getData().setScale(0.1f);

        textButtonStyle = new TextButton.TextButtonStyle();

        butList = new ArrayList<TextButton>();
        touchDownActor = new Actor();
        touch = new Vector2(0,0);
        newTouch = new Vector2(0,0);
        textButtonStyle.font = skin.getFont("default-font");
        textButtonStyle.downFontColor = new Color(0.2f,0.4f,0,1);
        textButtonStyle.fontColor = Color.WHITE;




        camera = new OrthographicCamera(aspectRatio * VariableCalls.WORLD_WIDTH, VariableCalls.WORLD_HEIGHT);
        camera.setToOrtho(false);
        viewport = new FitViewport(VariableCalls.WORLD_WIDTH , VariableCalls.WORLD_HEIGHT,camera );
        stage = new Stage(viewport, game.batch);
        waitTimer = 1;
        prefs.getInteger("passedlevel",1);

        prefs.flush();
        tableX = new Table();
      //  tableX.debug();
        //tableX.setFillParent(true);





        butList.add(new TextButton("",textButtonStyle));

        award = new Label("", smallSkin);



        award.setText("Select Level");
        GlyphLayout layout = new GlyphLayout(award.getStyle().font, "Select Level");
        float textWidth = layout.width;
        award.setPosition(120-textWidth/2,30);

        palList = new ArrayList<>();
        wheelList = new ArrayList<>();
        assembleList = new ArrayList<>();
        butleft = new Image(new Texture("butleft.png"));
        butright = new Image(new Texture("butright.png"));
        backgroundmain = new Image(new Texture("entrybg.png"));
        backgroundmain.setSize(VariableCalls.WORLD_WIDTH, VariableCalls.WORLD_WIDTH/1.136f);
        backgroundmain.setColor(1,1,1,0.10f);
        backgroundmain.setPosition(0,0);
        butleft.setSize(40,40*351/500f);
        butright.setSize(40,40*351/500f);

        butleft.setPosition(5,5);
        butright.setPosition(240-butright.getWidth(), 5);

        palList.add(new Image(new Texture("pal1.png")));
        palList.add(new Image(new Texture("pal2.png")));
        palList.add(new Image(new Texture("pal3.png")));
        palList.add(new Image(new Texture("pal4.png")));
        palList.add(new Image(new Texture("pal5.png")));
        palList.add(new Image(new Texture("pal6.png")));
        palList.add(new Image(new Texture("pal7.png")));
        palList.add(new Image(new Texture("pal8.png")));
        palList.add(new Image(new Texture("pal1.png")));
        palList.add(new Image(new Texture("pal2.png")));
        palList.add(new Image(new Texture("pal3.png")));
        palList.add(new Image(new Texture("pal4.png")));
        palList.add(new Image(new Texture("pal5.png")));
        palList.add(new Image(new Texture("pal6.png")));
        palList.add(new Image(new Texture("pal7.png")));
        palList.add(new Image(new Texture("pal8.png")));
        palList.add(new Image(new Texture("pal1.png")));
        palList.add(new Image(new Texture("pal2.png")));
        palList.add(new Image(new Texture("pal3.png")));
        palList.add(new Image(new Texture("pal4.png")));
        palList.add(new Image(new Texture("pal5.png")));
        palList.add(new Image(new Texture("pal6.png")));
        palList.add(new Image(new Texture("pal7.png")));
        palList.add(new Image(new Texture("pal8.png")));


        wheelList.add(new Image(new Texture("wheel1.png")));
        wheelList.add(new Image(new Texture("wheel2.png")));
        wheelList.add(new Image(new Texture("wheel3.png")));
        wheelList.add(new Image(new Texture("wheel4.png")));
        wheelList.add(new Image(new Texture("wheel5.png")));
        wheelList.add(new Image(new Texture("wheel6.png")));

        assembleList.add(new Image(new Texture("boxassembled.png")));

        System.out.println(prefs.getInteger("passedlevel"));


        for(int x = 1 ; x<101;x++){

            butList.add(new TextButton(String.valueOf(x),textButtonStyle));




            if(prefs.getInteger("passedlevel",1)>x){

                butList.get(x).setColor(0,1,0.5f,1);
                Image boxAssembled = new Image(new Texture("boxassembled.png"));
                boxAssembled.setScale(0.06F);
                assembleList.add(boxAssembled);

                boxW = boxAssembled.getWidth()/2;








            }
            else{

                if(prefs.getInteger("passedlevel",1)==x)
                    butList.get(x).setColor(0,1,0.5f,1);

                else
                butList.get(x).setColor(1,1,1,0.5f);

                Image boxNeedAssembly = new Image(new Texture("assemblyneeded.png"));

                boxNeedAssembly.setScale(0.06f);

                assembleList.add(boxNeedAssembly);


                boxAW = boxNeedAssembly.getWidth()/2;


            }


          //  tableX.add(butList.get(x)).pad(10);


        }











        Gdx.input.setInputProcessor(stage);

















        stage.getRoot().getColor().a = 0;
        stage.getRoot().addAction(fadeIn(0.5f));


        stage.addActor(backgroundmain);
      //  stage.addActor(tableX);
        for(int i = 1; i<butList.size();i++){

            stage.addActor(assembleList.get(i));
            stage.addActor(butList.get(i));

            butList.get(i).setPosition(120+(i*50)-50* prefs.getInteger("passedlevel",1),80);

        }
        stage.addActor(butleft);
        stage.addActor(butright);
        for(int i = 0 ; i<wheelList.size();i++){
            wheelList.get(i).setSize(20,20);
            wheelList.get(i).setPosition(15+(39*i),53);
            stage.addActor(wheelList.get(i));
            wheelList.get(i).setOrigin(Align.center);

            // System.out.println(palList.get(i).getX() + " -"+i+"- " + palList.get(i).getY());
        }
        for(int i = 0; i<palList.size();i++){
            palList.get(i).setSize(40,40/7.5f);
            palList.get(i).setPosition(-240+(34*i),70);
            stage.addActor(palList.get(i));

            System.out.println(palList.get(i).getX() + " -"+i+"- " + palList.get(i).getY());


        }



        dPane = new DialogPane(game);









     //LEVEL LISTENERS
        butList.get(1).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);

                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<10 ||Math.abs(newTouch.y - touch.y)<10) && butList.get(1).getColor().a == 1 )
                    switchScreen(game, new Level1(game));            }        });
        butList.get(2).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level2(game));            }        });
        butList.get(3).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level3(game));            }        });
        butList.get(4).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level4(game));            }        });
        butList.get(5).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level5(game));            }        });/*
        butList.get(6).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level6(game));            }        });
        butList.get(7).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level7(game));            }        });
        butList.get(8).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level8(game));            }        });
        butList.get(9).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level9(game));            }        });
        butList.get(10).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level10(game));            }        });
        butList.get(11).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level11(game));            }        });
        butList.get(12).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level12(game));            }        });
        butList.get(13).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level13(game));            }        });
        butList.get(14).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level14(game));            }        });
        butList.get(15).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level15(game));            }        });
        butList.get(16).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level16(game));            }        });
        butList.get(17).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level17(game));            }        });
        butList.get(18).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level18(game));            }        });
        butList.get(19).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level19(game));            }        });
        butList.get(20).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level20(game));            }        });
        butList.get(21).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level21(game));            }        });
        butList.get(22).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level22(game));            }        });
        butList.get(23).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level23(game));            }        });
        butList.get(24).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level24(game));            }        });
        butList.get(25).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level25(game));            }        });
        butList.get(26).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level26(game));            }        });
        butList.get(27).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level27(game));            }        });
        butList.get(28).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level28(game));            }        });
        butList.get(29).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level29(game));            }        });
        butList.get(30).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level30(game));            }        });
        butList.get(31).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level31(game));            }        });
        butList.get(32).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level32(game));            }        });
        butList.get(33).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level33(game));            }        });
        butList.get(34).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level34(game));            }        });
        butList.get(35).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level35(game));            }        });
        butList.get(36).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level36(game));            }        });
        butList.get(37).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level37(game));            }        });
        butList.get(38).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level38(game));            }        });
        butList.get(39).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level39(game));            }        });
        butList.get(40).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level40(game));            }        });
        butList.get(41).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level41(game));            }        });
        butList.get(42).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level42(game));            }        });
        butList.get(43).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level43(game));            }        });
        butList.get(44).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level44(game));            }        });
        butList.get(45).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level45(game));            }        });
        butList.get(46).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level46(game));            }        });
        butList.get(47).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level47(game));            }        });
        butList.get(48).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level48(game));            }        });
        butList.get(49).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level49(game));            }        });
        butList.get(50).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level50(game));            }        });
        butList.get(51).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level51(game));            }        });
        butList.get(52).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level52(game));            }        });
        butList.get(53).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level53(game));            }        });
        butList.get(54).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level54(game));            }        });
        butList.get(55).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level55(game));            }        });
        butList.get(56).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level56(game));            }        });
        butList.get(57).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level57(game));            }        });
        butList.get(58).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level58(game));            }        });
        butList.get(59).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level59(game));            }        });
        butList.get(60).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level60(game));            }        });
        butList.get(61).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level61(game));            }        });
        butList.get(62).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level62(game));            }        });
        butList.get(63).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level63(game));            }        });
        butList.get(64).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level64(game));            }        });
        butList.get(65).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level65(game));            }        });
        butList.get(66).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level66(game));            }        });
        butList.get(67).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level67(game));            }        });
        butList.get(68).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level68(game));            }        });
        butList.get(69).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level69(game));            }        });
        butList.get(70).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level70(game));            }        });
        butList.get(71).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level71(game));            }        });
        butList.get(72).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level72(game));            }        });
        butList.get(73).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level73(game));            }        });
        butList.get(74).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level74(game));            }        });
        butList.get(75).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level75(game));            }        });
        butList.get(76).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level76(game));            }        });
        butList.get(77).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level77(game));            }        });
        butList.get(78).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level78(game));            }        });
        butList.get(79).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level79(game));            }        });
        butList.get(80).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level80(game));            }        });
        butList.get(81).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level81(game));            }        });
        butList.get(82).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level82(game));            }        });
        butList.get(83).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level83(game));            }        });
        butList.get(84).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level84(game));            }        });
        butList.get(85).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level85(game));            }        });
        butList.get(86).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level86(game));            }        });
        butList.get(87).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level87(game));            }        });
        butList.get(88).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level88(game));            }        });
        butList.get(89).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level89(game));            }        });
        butList.get(90).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level90(game));            }        });
        butList.get(91).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level91(game));            }        });
        butList.get(92).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level92(game));            }        });
        butList.get(93).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level93(game));            }        });
        butList.get(94).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level94(game));            }        });
        butList.get(95).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level95(game));            }        });
        butList.get(96).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level96(game));            }        });
        butList.get(97).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level97(game));            }        });
        butList.get(98).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level98(game));            }        });
        butList.get(99).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level99(game));            }        });
        butList.get(100).addListener(new InputListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                newTouch = new Vector2(x,y);            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                touch.set(x,y);
                return true;            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )
                    switchScreen(game, new Level100(game));            }        });

*/

        //


        butright.addListener(new InputListener(){

            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {

               // newTouch = new Vector2(x,y);

            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                goleft = true;

                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {

            goleft = false;

            }
        });

        butleft.addListener(new InputListener(){

            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {

                // newTouch = new Vector2(x,y);

            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                goright = true;

                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {

                goright = false;

            }
        });


        stage.addActor(award);
        tableX.setOrigin(Align.bottomLeft);
        tableX.setSize(2775*2,0);
        tableX.setPosition(0,0);

      //  tableX.getCell(butList.get(prefs.getInteger("passedlevel",1)));
        tableX.debug();

        for(int i = 1; i<butList.size();i++){
            if(i<10)
            assembleList.get(i).setPosition(butList.get(i).getX()-10,butList.get(i).getY());
            else
                assembleList.get(i).setPosition(butList.get(i).getX(),butList.get(i).getY());



        }
    }


    public static Vector2 getStageLocation(Actor actor) {
        return actor.localToStageCoordinates(new Vector2(0, 0));
    }
    @Override
    public void render(float delta){

        Gdx.gl.glClearColor(0, 0, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if(Gdx.input.isKeyJustPressed(Input.Keys.BACK)){


            if(VariableCalls.buttonCheck) {
                switchScreen(game, new MainMenuScreen(game));

                VariableCalls.buttonCheck =false;
            }


        }
        game.batch.begin();




        game.batch.end();
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        stage.draw();





        stage.act(delta);



        if(goleft&&butList.get(1).getX()<=120) {


            for(int i = 1; i<butList.size();i++){
                butList.get(i).setPosition(butList.get(i).getX()+6,butList.get(i).getY());
                if(i<10)
                    assembleList.get(i).setPosition(butList.get(i).getX()-10,butList.get(i).getY());
                else
                    assembleList.get(i).setPosition(butList.get(i).getX(),butList.get(i).getY());
            }


            for(int i  = 0; i<wheelList.size();i++){
                wheelList.get(i).setRotation(wheelList.get(i).getRotation()-10 );
            }

            for(int i = 0; i<palList.size();i++){

               palList.get(i).setPosition(palList.get(i).getX()+6f,70);

               if(palList.get(i).getX()>542){
                   palList.get(i).setPosition(-240,70);
               }


            }
        }


        if(goright&&butList.get(100).getX()>=120) {






            for(int i = 1; i<butList.size();i++){
                butList.get(i).setPosition(butList.get(i).getX()-6,butList.get(i).getY());

                if(i<10)
                    assembleList.get(i).setPosition(butList.get(i).getX()-10,butList.get(i).getY());
                else
                    assembleList.get(i).setPosition(butList.get(i).getX(),butList.get(i).getY());

            }

            for(int i  = 0; i<wheelList.size();i++){
                wheelList.get(i).setRotation(wheelList.get(i).getRotation()+10);
            }

            for(int i = 0; i<palList.size();i++){

               palList.get(i).setPosition(palList.get(i).getX()-6f,70);

                if(palList.get(i).getX()<-240){
                    palList.get(i).setPosition(542,70);
                }

            }
        }
/*
        if(VariableCalls.confirmBoolean){

stage.addActor(dPane.quitGameConfirm());

            game.setScreen(new Level1(game));
            dispose();
        }


*/






    }


    public void switchScreen(final ClickClack game, final Screen newScreen){
       if(VariableCalls.buttonCheck) {
           VariableCalls.buttonCheck = false;
           stage.getRoot().getColor().a = 1;
           SequenceAction sequenceAction = new SequenceAction();
           sequenceAction.addAction(fadeOut(0.5f));
           sequenceAction.addAction(run(new Runnable() {
               @Override
               public void run() {
                   game.setScreen(newScreen);
                   VariableCalls.buttonCheck = true;
                   dispose();

               }
           }));
           stage.getRoot().addAction(sequenceAction);
       }
    }
    @Override
    public void show() {

    }



    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    stage.dispose();


        skin.dispose();
        smallSkin.dispose();



    }
}




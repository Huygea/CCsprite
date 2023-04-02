package com.ccsprite.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.ArrayList;
import java.util.Random;

import levels.Level1;
import levels.Level3;

import static com.badlogic.gdx.Gdx.input;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeIn;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeOut;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.run;
import static com.ccsprite.game.VariableCalls.WORLD_WIDTH;

/**
 * Created by fractal on 16.03.2017.
 */

public class MainMenuScreen implements Screen {


    Preferences prefs;
    Stage stage;
    Viewport viewport;
    private Image options, logo, tutorial,  exit, play,shop,backgroundmain, large,mid,small;


    private TextureAtlas tAtlas;
    private Vector2 newTouch,touch;
    Sound click;
    Sprite loaderGear;






    final ClickClack game;

    OrthographicCamera camera;

    DialogPane dPane;



    public MainMenuScreen(final ClickClack game){
        input.setCatchBackKey(true);
        this.game=game;







        newTouch = new Vector2();
        touch = new Vector2();


        tAtlas = new TextureAtlas("texPacked/packMan.atlas");

        options = new Image(new Texture("options.png"));
        exit = new Image(new Texture("exit.png"));
        play = new Image(new Texture("play.png"));
        shop = new Image(new Texture("shop.png"));
        tutorial = new Image(new Texture("tutorial.png"));
        logo = new Image(new Texture("logo.png"));
        backgroundmain = new Image(new Texture("entrybg.png"));

        large = new Image(new Texture("largepin.png"));
        mid = new Image(new Texture("mediumpin.png"));
        small = new Image(new Texture("smallpin.png"));


        large.setSize(16f*3,16f*3);
        mid.setSize(10.8f,10.8f);
        small.setSize(5.5f*3,5.5f*3);







        float aspectRatio = (float) (Gdx.graphics.getHeight() / Gdx.graphics.getWidth());
        prefs = Gdx.app.getPreferences("My Preferences");
        prefs.getInteger("chest",0);
        prefs.getInteger("bomb", 5);
        prefs.getInteger("oil",5);
        prefs.getInteger("bullet",5);
        prefs.getInteger("gold",100);


        prefs.flush();


        camera = new OrthographicCamera(aspectRatio * WORLD_WIDTH, VariableCalls.WORLD_HEIGHT);
        camera.setToOrtho(false);


        dPane = new DialogPane(game);

        viewport = new FitViewport(VariableCalls.WORLD_WIDTH , VariableCalls.WORLD_HEIGHT,camera );
        stage = new Stage(viewport, game.batch);
        input.setInputProcessor(stage);


        backgroundmain.setSize(VariableCalls.WORLD_WIDTH, VariableCalls.WORLD_WIDTH/1.136f);
        backgroundmain.setColor(1,1,1,0.60f);
        options.setSize(66.38f,15);
        exit.setSize(34.64f,15);
        play.setSize(38.26f,15);
        shop.setSize(37.97f,15);
        tutorial.setSize(73.89f,15);
        logo.setSize(100,49.5f);



        System.out.println(options.getWidth() + "   " + options.getHeight() + "  ex" + exit.getWidth()+"  "+ exit.getHeight()+"   pl" + play.getWidth()+"   "+play.getHeight() + "  sh" + shop.getWidth()+  "  "+shop.getHeight());


        click = Gdx.audio.newSound(Gdx.files.internal("click.mp3"));





        play.setPosition(160.87f,110);
        play.setOrigin(play.getWidth()/2,play.getHeight()/2);

        shop.setPosition(161.02f,87);
        shop.setOrigin(shop.getWidth()/2,shop.getHeight()/2);

        options.setPosition(146.81f,64);
        options.setOrigin(options.getWidth()/2, options.getHeight()/2);

        exit.setPosition(162.68f,18);
        exit.setOrigin(exit.getWidth()/2,exit.getHeight()/2);

        logo.setPosition(10,65.5f);

        large.setPosition(40,15);
        small.setPosition(78,12);

        large.setOrigin(Align.center);
        small.setOrigin(Align.center);


        large.setColor(205f/255f,0,120f/255f,1);
        small.setColor(255/255f,158/255f,84f/255f,1);

        tutorial.setPosition(143.06f,41);
        tutorial.setOrigin(tutorial.getWidth()/2,tutorial.getHeight()/2);






//To Start a Task:

        backgroundmain.setPosition(0,0);
        newTouch = new Vector2();

        exit.addListener(new InputListener(){

            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {



            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                touch.set(x,y);


               exit.setScale(0.98f);
                click.play(1.0f);


                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                click.play(1.0f);

                newTouch.set(x,y);
                exit.setScale(1f/0.98f);

                newTouch = new Vector2(x,y);

                if((Math.abs(newTouch.x - touch.x)<20 && Math.abs(newTouch.y - touch.y)<20) )

                {


                    stage.addActor(dPane.quitGameConfirm(0));


                }

            }
        });
        shop.addListener(new InputListener(){

            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {



            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                touch.set(x,y);


               shop.setScale(0.98f);
                click.play(1.0f);


                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                click.play(1.0f);
                newTouch.set(x,y);
                shop.setScale(1/0.98f);

                if((Math.abs(newTouch.x - touch.x)<20 &&Math.abs(newTouch.y - touch.y)<20) )

                {


                    switchScreen(game, new ShopClass(game));


                }

            }
        });
        play.addListener(new InputListener(){

            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {



            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                touch.set(x,y);


                play.setScale(0.98f);
                click.play(1.0f);


                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                click.play(1.0f);
                newTouch.set(x,y);
                play.setScale(1f/0.98f);

                if((Math.abs(newTouch.x - touch.x)<20 &&Math.abs(newTouch.y - touch.y)<20) )

                {


                   // switchScreen(game,new LevelSelection(game));
                    switchScreen(game,new Level1(game));


                }

            }
        });

        options.addListener(new InputListener(){

            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {



            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                touch.set(x,y);


                options.setScale(0.98f);
                click.play(1.0f);


                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                click.play(1.0f);

                options.setScale(1f/0.98f);
                newTouch.set(x,y);
                if((Math.abs(newTouch.x - touch.x)<20 &&Math.abs(newTouch.y - touch.y)<20) )

                {



                    switchScreen(game, new OptionsMenu(game));

                }

            }
        });

        tutorial.addListener(new InputListener(){

            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {



            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                touch.set(x,y);


                tutorial.setScale(0.98f);
                click.play(1.0f);


                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                click.play(1.0f);

                tutorial.setScale(1f/0.98f);
                newTouch.set(x,y);
                if((Math.abs(newTouch.x - touch.x)<20 &&Math.abs(newTouch.y - touch.y)<20) )

                {



                 //   switchScreen(game, new OptionsMenu(game));

                }

            }
        });



        stage.getRoot().getColor().a = 0;
        stage.getRoot().addAction(fadeIn(0.5f));

        stage.addActor(backgroundmain);




        stage.addActor(play);
        stage.addActor(options);

        stage.addActor(exit);
        stage.addActor(shop);
        stage.addActor(tutorial);
        stage.addActor(logo);
        stage.addActor(large);
        stage.addActor(small);


    }

    @Override
    public void render(float delta){



            Gdx.gl.glClearColor(0, 0,0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

      camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        stage.draw();

        game.batch.begin();






        game.batch.end();




        small.setRotation(small.getRotation()-1);
        large.setRotation(large.getRotation()+0.5f);
        stage.act();





        if(Gdx.input.isKeyJustPressed(Input.Keys.BACK) && VariableCalls.buttonCheck){


            stage.addActor(dPane.quitGameConfirm(0));



        }



    }
    public void switchScreen(final ClickClack game, final Screen newScreen){




        stage.getRoot().getColor().a = 1;
        SequenceAction sequenceAction = new SequenceAction();
        sequenceAction.addAction(fadeOut(0.5f));

/*
        if(stage.getRoot().getColor().a  <=  0.30f) {
            bigGear.setAlpha(stage.getRoot().getColor().a);
            smallGear.setAlpha(stage.getRoot().getColor().a);

        }*/
        sequenceAction.addAction(run(new Runnable() {
            @Override
            public void run() {
                game.setScreen(newScreen);
                dispose();

            }
        }));
        stage.getRoot().addAction(sequenceAction);

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

        tAtlas.dispose();
        click.dispose();

        stage.dispose();
        //tileSkin.dispose();
        //skinDialog.dispose();



    }


}

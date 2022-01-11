package com.ccsprite.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
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
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Tree;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
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
    TextButton level1,level2,level3,level4,level5;
    TextButton.TextButtonStyle textButtonStyle;
    private Vector2 touch, newTouch;
    Actor touchDownActor;
    ArrayList<TextButton> butList;

    Skin skin,smallSkin;

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

        waitTimer = 1;
        prefs.getInteger("passedlevel",1);
        prefs.flush();
        tableX = new Table();
        tableX.setFillParent(true);

      //  tableX.setPosition(VariableCalls.WORLD_WIDTH/2 - tableX.getWidth()/2, VariableCalls.WORLD_HEIGHT/2 - tableX.getHeight()/2);


        butList.add(new TextButton("",textButtonStyle));



        System.out.println(prefs.getInteger("passedlevel"));
        for(int x = 1 ; x<6;x++){

            butList.add(new TextButton(String.valueOf(x),textButtonStyle));




            if(prefs.getInteger("passedlevel",1)>=x){

                butList.get(x).setColor(0,1,0.5f,1);



            }
            else{  butList.get(x).setColor(1,1,1,0.5f);  }


            tableX.add(butList.get(x)).pad(5);

        }




        viewport = new FitViewport(VariableCalls.WORLD_WIDTH , VariableCalls.WORLD_HEIGHT,camera );
        stage = new Stage(viewport, game.batch);





        Gdx.input.setInputProcessor(stage);

















        stage.getRoot().getColor().a = 0;
        stage.getRoot().addAction(fadeIn(0.5f));



        stage.addActor(tableX);
        dPane = new DialogPane(game);

        butList.get(1).addListener(new InputListener(){

            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {

                newTouch = new Vector2(x,y);

            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                touch.set(x,y);

                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {

                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(1).getColor().a == 1 )
                switchScreen(game, new Level1(game));

            }
        });

        butList.get(2).addListener(new InputListener(){

            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {

                newTouch = new Vector2(x,y);

            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                touch.set(x,y);

                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {

                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(2).getColor().a == 1 )

                    switchScreen(game, new Level2(game));

            }
        });
        butList.get(3).addListener(new InputListener(){

            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {

                newTouch = new Vector2(x,y);

            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                touch.set(x,y);

                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {

                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(3).getColor().a == 1 )

                    switchScreen(game, new Level3(game));

            }
        });

        butList.get(4).addListener(new InputListener(){

            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {

                newTouch = new Vector2(x,y);

            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                touch.set(x,y);

                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {

                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(4).getColor().a == 1 )

                    switchScreen(game, new Level4(game));

            }
        });

        butList.get(5).addListener(new InputListener(){

            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {

                newTouch = new Vector2(x,y);

            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                touch.set(x,y);

                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {

                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5) && butList.get(5).getColor().a == 1 )

                    switchScreen(game, new Level5(game));

            }
        });
    }



    @Override
    public void render(float delta){

        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
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




package com.ccsprite.game;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ai.fsm.State;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.ArrayList;

/**
 * Created by fractal on 17.03.2017.
 */

public class VariableCalls {

   public static int prevRand;
   public static final float WORLD_HEIGHT = 135;
   public static final float WORLD_WIDTH = 240;
   public static boolean buttonCheck = true;

    public static int world_dotx_count;
    public static int world_doty_count;
    public static float timeLeft = 100.0f;
    public static float timeDivider = 100.0f;
    public static boolean confirmBoolean = false;
    public static boolean gameEnd = false;
    public static boolean gameStart = false;
    public static Screen screen;
    public static boolean initBool = false;
    public static float fadeOut = 0;
    public static int levelNum;



    Vector2 worldReturn;

public Vector2 callSetter(int worldLevel){

    worldReturn = new Vector2();

    if(worldLevel == 1){

        world_dotx_count = 16;
        world_doty_count = 14;

    }
    if(worldLevel == 2){

        world_dotx_count = 25;
        world_doty_count =6;

    }

    if(worldLevel == 3){

        world_dotx_count = 6;
        world_doty_count =25;


    }
    if(worldLevel == 4){

        world_dotx_count = 20;
        world_doty_count =6;

    }
    if(worldLevel == 5){

        world_dotx_count = 10;
        world_doty_count =16;


    }
   return worldReturn.set(world_dotx_count,world_doty_count);
}

  public VariableCalls(){




  }






}

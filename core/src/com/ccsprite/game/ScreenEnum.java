package com.ccsprite.game;

import com.badlogic.gdx.Screen;

import levels.Level1;
import levels.Level2;
import levels.Level3;
import levels.Level4;
import levels.Level5;

/**
 * Created by fractal on 25.04.2017.
 */

public class ScreenEnum {

final ClickClack game;

public ScreenEnum(final ClickClack game){

    this.game = game;

}

    public Screen levelSwitcher(int lnum , final ClickClack game)
    {


        if(lnum == 1)
        return new Level1(game);
        if(lnum == 2)
            return new Level2(game);
        if(lnum == 3)
            return new Level3(game);
        if(lnum == 4)
            return new Level4(game);
        if(lnum == 5)
            return new Level5(game);


        else
            return game.getScreen();





    }


}

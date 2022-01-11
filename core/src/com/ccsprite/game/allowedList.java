package com.ccsprite.game;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by fractal on 15.03.2017.
 */

public class allowedList {

    public Vector3[][][] allowedList = new Vector3[VariableCalls.world_dotx_count+2][VariableCalls.world_doty_count+2][4];

    public void allowedList(int x , int y , int z, float xAxis, float yAxis, int GearType){



        allowedList[x][y][z] = new Vector3(xAxis,yAxis,GearType);


    }

    public void allowedListDelete (int x, int y,int z){

        allowedList[x][y][z].z = 0;

    }


}

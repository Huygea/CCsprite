package com.ccsprite.game;

import com.badlogic.gdx.math.Vector3;



public class forbiddenList {


    public Vector3[][][] forbiddenList = new Vector3[100][100][4];

    public void forbidList(int x , int y , int z, float xAxis, float yAxis, int GearType){



        forbiddenList[x][y][z] = new Vector3(xAxis,yAxis,GearType);


    }

    public void forbidListDelete (int x, int y,int z){

        forbiddenList[x][y][z].z = 0;

    }



}









package com.ccsprite.game;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by fractal on 14.03.2017.
 */

public class Randomizer {

    float selfOran_1 = 33.33f;
    float selfOran_2 = 33.33f;
    float selfOran_3 = 33.33f;

    float selfReduction;

    ArrayList <Integer> populatedArray;
    Random randomInt;
    int returnValue;
    int arrayPicker;
public Randomizer(){

    randomInt = new Random();
    populatedArray = new ArrayList<Integer>();


}

public void setSelfReduction(int x){

    switch(x){

        case 1:{

           selfReduction  = 15.0f;
            break;

        }

        case 2:{

            selfReduction = 12.0f;
            break;
        }

        case 3: {

             selfReduction = 8.0f;
            break;
        }

        case 4: {
             selfReduction = 4.0f;
            break;

        }





    }



}
public int randomize(){
    int i=1;
    while(i < selfOran_1){
        populatedArray.add(1);
        i++;

    }
    i=1;
    while(i < selfOran_2){
        populatedArray.add(2);
        i++;

    }
    i=1;
    while(i < selfOran_3){
        populatedArray.add(3);
        i++;}



    arrayPicker = randomInt.nextInt(98);
        returnValue = populatedArray.get(arrayPicker);



    if (returnValue ==1){

        selfOran_1 -= selfReduction;
        selfOran_2 += selfReduction/2;
        selfOran_3 += selfReduction/2;

    }
    if(returnValue == 2){

        selfOran_1 += selfReduction/2;
        selfOran_2 -= selfReduction;
        selfOran_3 += selfReduction/2;
    }
    if(returnValue ==3){

        selfOran_1 += selfReduction/2;
        selfOran_2 += selfReduction/2;
        selfOran_3 -= selfReduction;
    }

    populatedArray.clear();
return returnValue;

}


}
package com.example.goldrule;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.stream.IntStream;

import static java.lang.System.exit;

public class MainActivity extends AppCompatActivity {


    ImageView pointer, roulette;
    //new game button, spin wheel button
    Button spinner, newGame;
    //input fields
    EditText betOne, betTwo, betOdd, betEven, betLow, betMid, betHigh, betRed, betBlack;
    //Current balance Text
    TextView money;
    //Total cash int
    int cash = 1000;
    //selected winning number
    int lotto = -1;

    //cash bet int
    int b1, b2, bO, bE, bL, bM, bH, bR, bB;
    //subtracted losing amount
    int deduct = 0;
    //int winnings = 0;
    int cashWon = 0;

    int spinDegree=0;

    String betOneString = "0";
    String betTwoString = "0";
    String betOddString = "0";
    String betEvenString = "0";
    String betRedString = "0";
    String betBlackString = "0";
    String betLowString = "0";
    String betHighString = "0";
    String betMidString = "0";

    int lottoArr [] = {0,1,13,36,24,3,15,34,22,5,17,32,20,7,11,30,26,9,28,0,2,14,35,23,4,16,33,21,6,18,31,19,8,12,29,35,10,27,00};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //link variables to app elements
        spinner = findViewById(R.id.betButton);
        newGame = findViewById(R.id.startButton);

        money = findViewById(R.id.money);

        betBlack = findViewById(R.id.betBlack);
        betRed = findViewById(R.id.betRed);
        betOne = findViewById(R.id.betOne);
        betTwo = findViewById(R.id.betTwo);
        betOdd = findViewById(R.id.betOdd);
        betEven = findViewById(R.id.betEven);
        betLow = findViewById(R.id.betLow);
        betMid = findViewById(R.id.betMid);
        betHigh = findViewById(R.id.betHigh);

        pointer = findViewById(R.id.imageView2);
        roulette = findViewById(R.id.imageView);

        //red number in array
        final int redArr [] = {
        1, 27, 35, 12, 19, 18, 21, 16 ,23, 14, 9 ,30, 7, 32, 5, 34, 3, 36};

        //black numbers in array
        final int blackArr [] = {
        10, 29,8,31,6,33,4,35,2,28,26,11,20,17,22,15,24,13};


        //new game resets all variables
        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //**********************************************
            betBlack.setText("");
            betRed.setText("");
            betOne.setText("");
            betTwo.setText("");
            betOdd.setText("");
            betEven.setText("");
            betLow.setText("");
            betMid.setText("");
            betHigh.setText("");
            int cash = 1000;
            money.setText("$"+cash);
            lotto = -1;
            deduct = 0;
            //winnings = 0;
            b1=0; b2=0;  bO=0;  bE=0;  bL=0;  bM=0;  bH=0;  bR=0;  bB=0;

             betOddString = "0";
             betEvenString = "0";
             betRedString = "0";
             betBlackString = "0";
             betLowString = "0";
             betHighString = "0";
             betMidString = "0";
             betOneString = "0";
             betTwoString = "0";

             cashWon=0;

             spinDegree = 0;
            }
        });


        //spinner button collects all betting values, converts to ints, and adds/subtracts winnings based on selected winning value
        spinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //************************************
                lotto=-1;
                spinDegree = 0;
                deduct = 0;
                b1=0; b2=0;  bO=0;  bE=0;  bL=0;  bM=0;  bH=0;  bR=0;  bB=0;
                betOddString = "0";
                betEvenString = "0";
                betRedString = "0";
                betBlackString = "0";
                betLowString = "0";
                betHighString = "0";
                betMidString = "0";
                betOneString = "0";
                betTwoString = "0";
                cashWon=0;

                Random rando = new Random();
                //from 0 to 3600 degrees
                spinDegree=rando.nextInt(3600);

                RotateAnimation rotateDial = new RotateAnimation(0, spinDegree, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                rotateDial.setDuration(2000);//2000
                rotateDial.setFillAfter(true);

                rotateDial.setInterpolator(new AccelerateDecelerateInterpolator());
                //pointer.startAnimation(rotateDial);
                roulette.startAnimation(rotateDial);

                //*****************************************************************************
                //spinDegree += 1;
                //if(spinDegree%360 >= 1 && spinDegree <%360 10)
                for(int i = 0; i <= 38; i++) {
                    if (spinDegree % 360 >= 9.31 * i && spinDegree % 360 < 9.31 * (i + 1)) {
                        lotto = lottoArr[i];
                        Log.d("mytag", "spinDegree:" + spinDegree % 360 + " , Lotto: " + lotto);
                        Toast.makeText(MainActivity.this, "SpinDegree:" + spinDegree % 360 + " , Lotto: " + lotto, Toast.LENGTH_SHORT).show();
                        //break;
                    }
                }//38
                //00--

                //***************************************************************************

                //if all input fields are empty, then dont run rest of code
                //if((betOne.getText().toString()).indexOf('.') >= 0 | (betTwo.getText().toString()).indexOf('.') >= 0 | (betRed.getText().toString()).indexOf('.') >= 0 | (betBlack.getText().toString()).indexOf('.') >= 0 | (betMid.getText().toString()).indexOf('.') >= 0 | (betLow.getText().toString()).indexOf('.') >= 0 | (betHigh.getText().toString()).indexOf('.') >= 0 | (betOdd.getText().toString()).indexOf('.') >= 0 | (betEven.getText().toString()).indexOf('.') >= 0)
                if (((betOne.getText().toString()).length() <= 0 && (betTwo.getText().toString()).length() <= 0) && (betRed.getText().toString()).length() <= 0 && (betBlack.getText().toString()).length() <= 0 && (betMid.getText().toString()).length() <= 0 && (betLow.getText().toString()).length() <= 0 && (betHigh.getText().toString()).length() <= 0 && (betOdd.getText().toString()).length() <= 0 && (betEven.getText().toString()).length() <= 0) {
                    Toast.makeText(MainActivity.this, "You must make a wager", Toast.LENGTH_SHORT).show();
                    //exit(0);
                }
                //if not all input values are empty, run code
                else {
                    //lotto = 5;

                    //if both field one and two are filled, convert to int, if both are not, dont collect values
                    if ((betOne.getText().toString()).length() >= 1 && (betTwo.getText().toString()).length() >= 1) {
                         betOneString = betOne.getText().toString().replaceAll("[a-zA-Z$, \n\t]", "");
                        //Toast.makeText(MainActivity.this, "Single Bet: "+betOneString, Toast.LENGTH_SHORT).show();
                        b1 = Integer.parseInt(betOneString);

                         betTwoString = betTwo.getText().toString().replaceAll("[a-zA-Z$, \n\t]", "");
                        b2 = Integer.parseInt(betTwoString);
                    }
                    else
                    {
                        if (((betOne.getText().toString()).length() <= 0 && (betTwo.getText().toString()).length() >= 1)) {
                            Toast.makeText(MainActivity.this, "Enter Values In Bet# Fields, To Play A Single Bet", Toast.LENGTH_SHORT).show();
                        }

                        if(((betOne.getText().toString()).length() >=  1 && (betTwo.getText().toString()).length() <= 0)) {
                            Toast.makeText(MainActivity.this, "Enter Values For The Bet Fields, To Play A Single Bet", Toast.LENGTH_SHORT).show();
                        }
                    }

                    //set all other empty value strings as 0 to be converted to zero
                     betOddString = "0";
                     betEvenString = "0";
                     betRedString = "0";
                     betBlackString = "0";
                     betLowString = "0";
                     betHighString = "0";
                     betMidString = "0";

                    //if edit text lengths are greater than or equal to one character, convert to string, without extra special characters
                    if ((betOdd.getText().toString()).length() >= 1) {
                        betOddString = betOdd.getText().toString().replaceAll("[a-zA-Z$, \n\t]", "");
                    }
                    if ((betEven.getText().toString()).length() >= 1) {
                        betEvenString = betEven.getText().toString().replaceAll("[a-zA-Z$, \n\t]", "");
                    }
                    if ((betRed.getText().toString()).length() >= 1) {
                        betRedString = betRed.getText().toString().replaceAll("[a-zA-Z$, \n\t]", "");
                    }
                    if ((betBlack.getText().toString()).length() >= 1) {
                        betBlackString = betBlack.getText().toString().replaceAll("[a-zA-Z$, \n\t]", "");
                    }
                    if ((betLow.getText().toString()).length() >= 1) {
                        betLowString = betLow.getText().toString().replaceAll("[a-zA-Z$, \n\t]", "");
                    }
                    if ((betHigh.getText().toString()).length() >= 1) {
                        betHighString = betHigh.getText().toString().replaceAll("[a-zA-Z$, \n\t]", "");
                    }
                    if ((betMid.getText().toString()).length() >= 1) {
                        betMidString = betMid.getText().toString().replaceAll("[a-zA-Z$, \n\t]", "");
                    }

                    //convert strings to ints
                    bO = Integer.parseInt(betOddString);
                    bE = Integer.parseInt(betEvenString);
                    bR = Integer.parseInt(betRedString);
                    bB = Integer.parseInt(betBlackString);
                    bL = Integer.parseInt(betLowString);
                    bH = Integer.parseInt(betHighString);
                    bM = Integer.parseInt(betMidString);

                    //*************************************************************************************
                    //Log.d("mytag", "(b1: "+ b1+" & b2: "+ b2+"), bO: "+ bO+", bE: "+ bE+", bR: "+ bR+", bB: "+ bB+", bL: "+ bL+", bH: "+ bH+", bM: "+ bM);
                    int sum = bO + bE + bR + bB + bL + bH + bM + b2;
                    //Log.d("mytag", "SUM: " + sum);

                    //if total bet amount is larger than current balance, dont play
                    if ((bO + bE + bR + bB + bL + bH + bM+ b2) > cash) {
                        Toast.makeText(MainActivity.this, "Funds are insufficient", Toast.LENGTH_SHORT).show();

                    }
                    else {
                        //cash -= bH + bL + bB + bR + bM + bE + bO + b2;
                       // money.setText("$" + cash);
                       // Toast.makeText(MainActivity.this, "Money Deducted: " + (sum) , Toast.LENGTH_SHORT).show();
                        deduct = 0;

                        if (b1 < 0 || b1 > 36) {
                            Toast.makeText(MainActivity.this, "You must enter a betting number within the roulette wheel", Toast.LENGTH_SHORT).show();
                            //exit(0);
                        }
                        else {

                            if (lotto >= 1 && lotto <= 12 && bL > 0) {
                                //win low
                                cashWon += bL * 3;
                                //Toast.makeText(MainActivity.this, "You Won $" + bL * 3 + "!", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                deduct+=bL;
                            }
                            if (lotto >= 13 && lotto <= 24 && bM > 0) {
                                //win mid
                                cashWon += bM * 3;
                                //Toast.makeText(MainActivity.this, "You Won $" + bM * 3 + "!", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                deduct+=bM;
                            }
                            if (lotto >= 25 && lotto <= 36 && bH > 0) {
                                //win high
                                cashWon += bH * 3;
                                //Toast.makeText(MainActivity.this, "You Won $" + bH * 3 + "!", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                deduct+=bH;
                            }
                            if (lotto % 2 == 0 && bE > 0) {
                                //win even
                                cashWon += bE;
                                //Toast.makeText(MainActivity.this, "You Won $" + bE + "!", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                deduct+=bE;
                            }

                            if (lotto % 2 > 0 && bO > 0) {
                                //win odd
                                cashWon += bO;
                                //Toast.makeText(MainActivity.this, "You Won $" + bO + "!", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                deduct+=bO;
                            }


                            if (lotto == b1 && b2 > 0) {
                                //win bet one number
                                // win b2 amount
                                cashWon += b2 * 36;
                                //Toast.makeText(MainActivity.this, "You Won $" + b2 * 36 + "!", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                deduct+=b2;
                            }

                            if(lotto ==1 | lotto == 27 | lotto == 35 | lotto == 12 | lotto == 19 | lotto == 18 | lotto == 21 | lotto == 16  | lotto ==23 | lotto == 14 | lotto == 9  | lotto ==30 | lotto == 7 | lotto == 32 | lotto == 5 | lotto == 34 | lotto == 3 | lotto ==36)
                            {
                                cashWon += bR ;
                            }
                            else {
                            deduct+=bR;
                            }

                            if(lotto == 10 | lotto == 29 | lotto ==8 | lotto ==31 | lotto ==6 | lotto ==33 | lotto ==4 | lotto ==35 | lotto ==2 | lotto ==28 | lotto ==26 | lotto ==11 | lotto ==20 | lotto ==17 | lotto ==22 | lotto ==15 | lotto ==24 | lotto ==13)
                            {
                                cashWon+= bB;
                            }
                            else {
                                deduct+=bB;
                            }

                            /*
                            for (int i:redArr)
                            //for (int i = 0; i < redArr.length; i++)
                            {
                                if (lotto == redArr[i] && bR > 0) {
                                    //win red
                                    cashWon += bR ;
                                    //Toast.makeText(MainActivity.this, "You Won $" + bR + "!", Toast.LENGTH_SHORT).show();
                                    break;
                                    //exit(0);
                                }
                            }

                            //for (int j = 0; j < blackArr.length; j++)
                            for(int j : blackArr)
                            {
                                if (lotto == blackArr[j] && bB > 0) {
                                    //win black
                                    cashWon += bB ;
                                    //Toast.makeText(MainActivity.this, "You Won $" + bB + "!", Toast.LENGTH_SHORT).show();
                                    break;
                                    //exit(0);
                                }

                            }
                             */

                        }
                        /*
                         */
                    }


                    // money.setText("$" + cash);
                    cash+=cashWon;
                    cash -= deduct;

                    if((cashWon-deduct) > 0)
                    {
                        Toast.makeText(MainActivity.this, "You Won $" + (cashWon-deduct) + "!", Toast.LENGTH_SHORT).show();

                    }
                    if((cashWon-deduct) < 0)
                    {
                        Toast.makeText(MainActivity.this, "You Lost $" + -1*(cashWon-deduct) + "!", Toast.LENGTH_SHORT).show();
                    }

                    /*
                    if(combo >= 0)
                    {
                        cash+=cashWon;
                        Toast.makeText(MainActivity.this, "You Won $" + cashWon + "!", Toast.LENGTH_SHORT).show();
                    }
                    if(deduct > 0) {
                        cash -= deduct;
                        Toast.makeText(MainActivity.this, "Money Deducted: " + (deduct), Toast.LENGTH_SHORT).show();
                    }
                    */
                    Log.d("mytag", "Deducted Money: "+deduct);
                    money.setText("$" + cash);
                }

            }
        });

    }
}

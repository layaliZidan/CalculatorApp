package com.example.layali.simplecalculatorapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    private int memory;
    TextView numbers;
    private int Number1;
    private int Number2;
    private int buttonPlus=0;
    private int buttonMinus=0;
    private int buttonDiv=0;
    private int buttonMult=0;


  // addition of 2 numbers:
    private int addition(int firstNumber, int secondNumber)
    {
        int result = 0;
        result=firstNumber+secondNumber;
        return result;

    }
 //
    private int minus(int firstNumber , int secondNumber)
    {
        int result=0;
        result=firstNumber-secondNumber;
        return result;
    }

    // to find the multiplication of 2 numbers:
    private int multiplication(int firstNumber , int secondNumber)
    {
        int result=0;
        result=firstNumber*secondNumber;
        return result;
    }

    // to find the division of 2 numbers and check wither the second number is 0
    private double division(int firstNumber , int secondNumber)
    {
        int result=0;
        if(secondNumber != 0)
        {
            result=firstNumber/secondNumber;
            return result;
        }
        else
        {
            Toast.makeText(this, "you can't divide by zero! ", Toast.LENGTH_LONG).show();
            return 0;
        }

    }
    /*to give the negation of a number:
        if the number is positive, then the negation is negative
        if the number is negative , then the negation is positive

        */
    private int negation(int number)
    {
        /*if(number <0)
            return number* (-1);
        else if (number > 0)
            return number * (-1);
        else
            return number;*/
        return number*-1;
    }

    // for clear button , to clear the text view
    public void onClick_clear(View view)
    {
       numbers = (TextView)findViewById(R.id.textViewNumbers);
        numbers.setText("");

    //  numbers.setText(""+ view.getId());

      /*  if(view.getId()==R.id.buttonC){
            numbers.setText("yes");
        }*/
    }


  // M+ button , to save number and clear screen
    public void onClick_memory(View view)
    {
        numbers = (TextView)findViewById(R.id.textViewNumbers);

        if(numbers.getText() != "") {
            int m = Integer.parseInt(numbers.getText().toString());
            memory = m;
            numbers.setText("");
        }
    }

   // Mc to clear the saved number in memory
    public void onClick_clearMemory(View view)
    {
      memory=0;
    }

    // to get the saved number in memory
    public void onClick_recall(View view)
    {
        numbers = (TextView)findViewById(R.id.textViewNumbers);
       // numbers.setText("");
       // numbers = (TextView)findViewById(R.id.textViewNumbers);
        numbers.setText(""+numbers.getText() + memory);

    }


    // on click method for negation N button
    public void onClick_negation(View view)
    {   int number;
        numbers = (TextView)findViewById(R.id.textViewNumbers);

        number=Integer.parseInt(numbers.getText().toString()); //to get the number that we want to calculate the negation for it
       numbers.setText(""+negation(number)); // cal negation method
    }



    // to view the text of the pressed number on the text view
    public void onClick_numbers(View view) {
        numbers = (TextView)findViewById(R.id.textViewNumbers);
        Button b =(Button)view;
        String text=b.getText().toString();
      //  if(b.getId()==R.id.button0){
        numbers.setText(numbers.getText()+text);
       // }
    }


     // to do the calculation on the 2 numbers according to the chosen operation:
    public void onClick_operation(View view) {
        numbers = (TextView)findViewById(R.id.textViewNumbers);
        Button b =(Button)view;

        // the number before the sign which is the first number;
        Number1=Integer.parseInt(numbers.getText().toString());

        // to get the sign on the pressed button;
        String operation=b.getText().toString();

        // to make the text view equals to the first number and the sign on the button(+ - * /)
        String statement= ""+Number1+operation;
        //
         numbers.setText("");

        if(b.getId() == R.id.buttonPlus){ // to check if the pressed button is plus
           buttonPlus=1; // this is like a flag
          //  b.setText(statement);
        }
        if(b.getId() == R.id.buttonminus){  // to check if the pressed number is minus
          buttonMinus=1;
           // b.setText(statement);
        }
        if(b.getId() == R.id.buttonMult){  // to check if the pressed button is multiplication
          buttonMult=1;
           // b.setText(statement);
        }
        if(b.getId() == R.id.buttonDiv){  // to check if the pressed button is division
          buttonDiv=1;
           // b.setText(statement);
        }
    }


   // this is for the equals button , to find the result:
    public void onClick_equal(View view) {
        numbers = (TextView)findViewById(R.id.textViewNumbers);
      //  String statement = numbers.getText().toString();
//        numbers.setText("");
        Number2=Integer.parseInt(numbers.getText().toString());
        int result=0;
        if(buttonPlus>0){
            result=addition(Number1,Number2);
             numbers.setText(""+result);
              buttonPlus=0;}

        if(buttonMinus>0){
            result=minus(Number1,Number2);
            numbers.setText(""+result);
            buttonMinus=0;}

        if(buttonMult>0){
            result=multiplication(Number1,Number2);
            numbers.setText(""+result);
            buttonMult=0;}
        if(buttonDiv>0){
            result=(int)division(Number1,Number2);
            numbers.setText(""+result);
            buttonDiv=0;}


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }








    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}

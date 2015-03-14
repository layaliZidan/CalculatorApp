package com.example.layali.simplecalculatorapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    private int memory;
    TextView numbers;



    private int addition(int firstNumber, int secondNumber)
    {
        int result = 0;
        result=firstNumber+secondNumber;
        return result;

    }

    private int minus(int firstNumber , int secondNumber)
    {
        int result=0;
        result=firstNumber-secondNumber;
        return result;
    }
    private int multiplication(int firstNumber , int secondNumber)
    {
        int result=0;
        result=firstNumber*secondNumber;
        return result;
    }
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

    private int negation(int number)
    {
        if(number <0)
            return number* (-1);
        else if (number > 0)
            return number * (-1);
        else
        return number;
    }

    // for clear button:
    public void onClick_clear(View view)
    {
        numbers = (TextView)findViewById(R.id.textViewNumbers);
        numbers.setText(" ");
    }
  // M+ button , to save number and cleae screen
    public void onClick_memory(View view)
    {
        numbers = (TextView)findViewById(R.id.textViewNumbers);

         memory=Integer.parseInt(numbers.getText().toString());

        numbers.setText(" ");
    }

   // Mc to clear the saved number in memory
    public void onClick_clearMemory(View view)
    {
      memory=0;
    }

    // to get the saved number in memory
    public void onClick_recall(View view)
    {

    }


    public void onClick_negation(View view)
    {   int number;
        numbers = (TextView)findViewById(R.id.textViewNumbers);

        number=Integer.parseInt(numbers.getText().toString());
       numbers.setText(""+negation(number));
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

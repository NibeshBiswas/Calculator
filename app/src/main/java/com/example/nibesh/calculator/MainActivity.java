package com.example.nibesh.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText number;
    private double number1,number2;

    private Action action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }
        private void init() {
            number=(EditText)findViewById(R.id.nbrid);

        findViewById(R.id.bt_plus).setOnClickListener(this);
        findViewById(R.id.bt_subtract).setOnClickListener(this);
        findViewById(R.id.bt_mult).setOnClickListener(this);
        findViewById(R.id.bt_div).setOnClickListener(this);
        findViewById(R.id.bt_percent).setOnClickListener(this);
        findViewById(R.id.bt_equal).setOnClickListener(this);
        findViewById(R.id.bt_c).setOnClickListener(this);
        }


    @Override
    public void onClick(View view) {

        String temp=number.getText().toString();
        if(temp.isEmpty()){
            number.setError("No number is provided");
            return;
        }
        else {
            if (view.getId() != R.id.bt_equal){
                number1 = Double.valueOf(temp);
                number.setText(" ");
             }
        }
        switch (view.getId()){
            case R.id.bt_plus:
                action=Action.ADD;
                break;
            case R.id.bt_subtract:
                action=Action.MINUS;
                break;
            case R.id.bt_mult:
                action=Action.MULTIPLICATION;
                break;
            case R.id.bt_div:
                action=Action.DIVISION;
                break;
            case R.id.bt_percent:
                action=Action.PERCENT;
                break;
            case R.id.bt_c:
                action=Action.CUT;
                break;
            case R.id.bt_equal:
                process(temp);
                break;
        }

    }

    private void process(String temp){
        temp = number.getText().toString();

        number2=Double.valueOf(temp);

        switch (action){
              case ADD:
                  number.setText(number1+"+"+number2+"="+(number1 + number2));
                  break;
              case MINUS:
                  number.setText(number1+"-"+number2+"="+(number1 - number2));
                  break;
              case MULTIPLICATION:
                  number.setText(number1+"*"+number2+"="+(number1 * number2));
                  break;
              case DIVISION:
                  number.setText(number1+"/"+number2+"="+(number1 / number2));
                  break;
              case PERCENT:
                  number.setText(number1+"%"+number2+"="+(number1 * (number2/100)));
                  break;
              case CUT:
                  number.setText(0);
                  break;

        }
        number1=0;


    }

    private enum Action{ADD,MINUS,MULTIPLICATION,DIVISION, PERCENT,CUT}




}

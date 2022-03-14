package com.himans.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText edweg,edhei;
        TextView txtres;
        Button btnres,btnreset;
        edweg= (EditText) findViewById(R.id.edweg);
        edhei= (EditText) findViewById(R.id.edhei);
        txtres= (TextView) findViewById(R.id.txtres);
        btnres= (Button) findViewById(R.id.btnres);
        btnreset= (Button) findViewById(R.id.btnreset);
        btnres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strweg=edweg.getText().toString();
                String strhei=edhei.getText().toString();
                if(strweg.equals(""))
                {
                    edweg.setError("please enter your weight");
                    edweg.requestFocus();
                    return;
                }
                if(strhei.equals(""))
                {
                    edweg.setError("please enter your height");
                    edweg.requestFocus();
                    return;
                }
                float weight = Float.parseFloat(strweg);
                float height = Float.parseFloat(strhei)/100;
                float bmivalue = BMICalculate( weight,height);
                txtres.setText("BMI="+bmivalue+" " +"STATUS "+interpreteBMI(bmivalue));
            }
        });
        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edhei.setText("");
                edweg.setText("");
                txtres.setText("");
            }
        });

    }
    public float BMICalculate(float weight,float height)
    {
        return weight/(height*height);
    }
    public String interpreteBMI(float bmivalue)
    {
        if(bmivalue<16)
        {
            return "Severly Underweight";
        }
        else if(bmivalue<18.5)
        {
            return "Underweight";
        }
        else if(bmivalue<25)
        {
            return "Normal";
        }
        else if(bmivalue<30)
        {
            return "Overweight";
        }
        else
            return "Obese";

    }
}
package com.example.mihir.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.math.BigDecimal;

public class result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        float data[] = getIntent().getFloatArrayExtra("data");
        TextView rawMaterialCost = (TextView) findViewById(R.id.rawmaterialcost);
        TextView rawMixcost = (TextView) findViewById(R.id.rawmixcost);
        TextView fuelCost = (TextView)findViewById(R.id.fuelcost);
        TextView specificHeat = (TextView)findViewById(R.id.specificheat);
        TextView clinkerCost = (TextView)findViewById(R.id.clinkercost);
try {

            rawMaterialCost.setText((result.this.round(data[0], 2).toString()));
            rawMixcost.setText(result.this.round(data[1], 2).toString() );
            fuelCost.setText(result.this.round(data[2], 2).toString() );
            clinkerCost.setText(result.this.round(data[3], 2).toString() );
            specificHeat.setText(result.this.round(data[4], 2).toString() );
        }
        catch (Exception e){

        }
    }



    public static BigDecimal round(float d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd;
    }
}

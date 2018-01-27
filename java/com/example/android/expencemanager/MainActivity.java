package com.example.android.expencemanager;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import com.example.android.expencemanager.data.CategoryContract.CategoryEntry;
import android.view.View.OnClickListener;



import com.example.android.expencemanager.data.MoneyDbHelper;
import com.example.android.expencemanager.data.SpendContract;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import static android.R.attr.button;
import static android.R.id.button2;

public class MainActivity extends AppCompatActivity implements OnChartValueSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root);

        PieChart pieChart = (PieChart) findViewById(R.id.piechart);
        pieChart.setUsePercentValues(true);
        // IMPORTANT: In a PieChart, no values (Entry) should have the same
        // xIndex (even if from different DataSets), since no values can be
        // drawn above each other.
        ArrayList<Entry> yvalues = new ArrayList<Entry>();
        yvalues.add(new Entry(8f, 0));
        yvalues.add(new Entry(15f, 1));
        yvalues.add(new Entry(12f, 2));
        yvalues.add(new Entry(25f, 3));
        yvalues.add(new Entry(23f, 4));


        PieDataSet dataSet = new PieDataSet(yvalues, "Election Results");

        ArrayList<String> xVals = new ArrayList<String>();

        xVals.add("قبض");
        xVals.add("کتاب");
        xVals.add("لباس");
        xVals.add("خودرو");
        xVals.add("غذا");


        PieData data = new PieData(xVals, dataSet);
        // In Percentage
        data.setValueFormatter(new PercentFormatter());
        // Default value
        //data.setValueFormatter(new DefaultValueFormatter(0));
        pieChart.setData(data);
        pieChart.setDescription("This is Pie Chart");
        pieChart.setDrawHoleEnabled(true);
        pieChart.setTransparentCircleRadius(58f);

        pieChart.setHoleRadius(58f);
        dataSet.setColors(ColorTemplate.VORDIPLOM_COLORS);

        data.setValueTextSize(13f);
        data.setValueTextColor(Color.DKGRAY);

        pieChart.setOnChartValueSelectedListener(this);



        Button button1 = (Button) findViewById(R.id.p);


        // Capture button clicks
        button1.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {



                // Start NewActivity.class
                Intent myIntent = new Intent(MainActivity.this,
                        PlusActivity.class);
                startActivity(myIntent);
            }
        });

        Button button2 = (Button) findViewById(R.id.m);

        // Capture button clicks
        button2.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(MainActivity.this,
                        LessActivity.class);
                startActivity(myIntent);
            }
        });

    }
    @Override
    public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {

        if (e == null)
            return;
        Log.i("VAL SELECTED",
                "Value: " + e.getVal() + ", xIndex: " + e.getXIndex()
                        + ", DataSet index: " + dataSetIndex);
    }

    @Override
    public void onNothingSelected() {
        Log.i("PieChart", "nothing selected");
    }


}



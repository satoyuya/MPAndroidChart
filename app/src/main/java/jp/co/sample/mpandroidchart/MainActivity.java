package jp.co.sample.mpandroidchart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private LineChart mChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createChart();

    }

    private void createChart() {

        // in this example, a LineChart is initialized from xml
        LineChart lineChart = (LineChart) findViewById(R.id.line_chart);

        // LineChart DataSet
        ArrayList<LineDataSet> dataSets = new ArrayList<>();

        // x-coordinate format value
        XAxis xAxis = lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1f);   // only intervals of 1 day
//        xAxis.setValueFormatter(new DayAxisValueFormatter(lineChart));


        // x-coordinate value
        ArrayList<String> xValues = new ArrayList<>();
        xValues.add("No.1");
        xValues.add("No.2");
        xValues.add("No.3");
        xValues.add("No.4");
        xValues.add("No.5");

        // value
        ArrayList<Entry> value = new ArrayList<>();
        String measureItemName = "";
        value.add(new Entry(100, 0));
        value.add(new Entry(120, 1));
        value.add(new Entry(150, 2));
        value.add(new Entry(250, 3));
        value.add(new Entry(500, 4));


        // add value to LineChart's DataSet
        LineDataSet valueDataSet = new LineDataSet(value, measureItemName);
        dataSets.add(valueDataSet);

        // set LineChart's DataSet to LineChart
//        lineChart.setData(new LineData(xValues, dataSets));
        lineChart.setData(new LineData(valueDataSet));
    }

}

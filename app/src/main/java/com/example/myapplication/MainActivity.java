package com.example.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("dev2qa.com - Android Canvas Paint Drawing Example.");

        final Context context = getApplicationContext();

        final LinearLayout drawingExampleLayout = (LinearLayout)findViewById(R.id.exampleLinearLayout);

        // Must declare the custom view here, otherwise the custom view's onDraw method will not be invoked after call invalidate method.
        final CanvasExampleView canvasExampleView = new CanvasExampleView(context);

        final Resources resources = getResources();

        /* Get canvas spinner and set it's on item selected listener. */
        Spinner canvasSpinner = (Spinner)findViewById(R.id.canvasSpinner);
        canvasSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                // Remove all views first.
                drawingExampleLayout.removeAllViews();

                // Add custom canvasExampleView.
                drawingExampleLayout.addView(canvasExampleView);

                Object selectedItemObj = adapterView.getAdapter().getItem(i);

                String itemText = (String)selectedItemObj;

                if(itemText.equals(resources.getString(R.string.draw_text)))
                {
                    canvasExampleView.drawText();
                }else if(itemText.equals(resources.getString(R.string.draw_point)))
                {
                    canvasExampleView.drawPoint();
                }else if(itemText.equals(resources.getString(R.string.draw_two_point)))
                {
                    canvasExampleView.drawTwoPoint();
                }else if(itemText.equals(resources.getString(R.string.draw_line)))
                {
                    canvasExampleView.drawLine();
                }else if(itemText.equals(resources.getString(R.string.draw_two_line)))
                {
                    canvasExampleView.drawTwoLine();
                }else if(itemText.equals(resources.getString(R.string.draw_rectangle)))
                {
                    canvasExampleView.drawRectangle();
                }else if(itemText.equals(resources.getString(R.string.draw_round_rectangle)))
                {
                    canvasExampleView.drawRoundRectangle();
                }else if(itemText.equals(resources.getString(R.string.draw_arc)))
                {
                    canvasExampleView.drawArc();
                }else if(itemText.equals(resources.getString(R.string.draw_oval)))
                {
                    canvasExampleView.drawOval();
                }else if(itemText.equals(resources.getString(R.string.draw_path)))
                {
                    canvasExampleView.drawPath();
                }else if(itemText.equals(resources.getString(R.string.draw_circle_path_text)))
                {
                    canvasExampleView.drawCirclePathText();
                }else if(itemText.equals(resources.getString(R.string.draw_circle)))
                {
                    canvasExampleView.drawCircle();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}
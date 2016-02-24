package com.parkes.michael.mparkeslab7;

import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener, View.OnDragListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageView imgX = (ImageView) findViewById(R.id.imgBlueX);
        ImageView imgO = (ImageView) findViewById(R.id.imgRedO);
        imgX.setTag(R.drawable.x);
        imgO.setTag(R.drawable.o);
        imgX.setOnTouchListener(this);
        imgO.setOnTouchListener(this);
        if(savedInstanceState != null)
        {
            setSavedListeners(savedInstanceState);
        }
        else {
            setOnDragListeners();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Toast.makeText(MainActivity.this, "Michael Parkes, Lab 7 Winter 2016", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {

        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            View.DragShadowBuilder drag = new View.DragShadowBuilder(v);
            v.startDrag(null, drag, v, 0);
            return true;
        }
        return false;
    }

    @Override
    public boolean onDrag(View v, DragEvent event)
    {
        DragEvent e = event;
        if(event.getAction() == DragEvent.ACTION_DROP)
        {
            View view = (View)event.getLocalState();
            int id = (int)view.getTag();
            int tag = (int)v.getTag();
            int blank = R.drawable.blank;
            if(tag != blank)
                return false;
            ((ImageView)v).setImageResource(id);
            v.setTag(id);
            return true;
        }

        return true;
    }

    public void setOnDragListeners()
    {
        ImageView R11 = (ImageView) findViewById(R.id.Row1_1);
        R11.setTag(R.drawable.blank);
        R11.setOnDragListener(this);
        ImageView R12 = (ImageView) findViewById(R.id.Row1_2);
        R12.setTag(R.drawable.blank);
        R12.setOnDragListener(this);
        ImageView R13 = (ImageView) findViewById(R.id.Row1_3);
        R13.setTag(R.drawable.blank);
        R13.setOnDragListener(this);
        ImageView R21 = (ImageView) findViewById(R.id.Row2_1);
        R21.setTag(R.drawable.blank);
        R21.setOnDragListener(this);
        ImageView R22 = (ImageView) findViewById(R.id.Row2_2);
        R22.setTag(R.drawable.blank);
        R22.setOnDragListener(this);
        ImageView R23 = (ImageView) findViewById(R.id.Row2_3);
        R23.setTag(R.drawable.blank);
        R23.setOnDragListener(this);
        ImageView R31 = (ImageView) findViewById(R.id.Row3_1);
        R31.setTag(R.drawable.blank);
        R31.setOnDragListener(this);
        ImageView R32 = (ImageView) findViewById(R.id.Row3_2);
        R32.setTag(R.drawable.blank);
        R32.setOnDragListener(this);
        ImageView R33 = (ImageView) findViewById(R.id.Row3_3);
        R33.setTag(R.drawable.blank);
        R33.setOnDragListener(this);

    }

    public void setSavedListeners(Bundle SavedInstanceState)
    {
        ImageView R11 = (ImageView) findViewById(R.id.Row1_1);
        R11.setImageResource(SavedInstanceState.getInt("one"));
        R11.setTag(SavedInstanceState.getInt("one"));
        R11.setOnDragListener(this);

        ImageView R12 = (ImageView) findViewById(R.id.Row1_2);
        R12.setImageResource(SavedInstanceState.getInt("two"));
        R12.setTag(SavedInstanceState.getInt("two"));
        R12.setOnDragListener(this);

        ImageView R13 = (ImageView) findViewById(R.id.Row1_3);
        R13.setImageResource(SavedInstanceState.getInt("three"));
        R13.setTag(SavedInstanceState.getInt("three"));
        R13.setOnDragListener(this);

        ImageView R21 = (ImageView) findViewById(R.id.Row2_1);
        R21.setImageResource(SavedInstanceState.getInt("four"));
        R21.setTag(SavedInstanceState.getInt("four"));
        R21.setOnDragListener(this);

        ImageView R22 = (ImageView) findViewById(R.id.Row2_2);
        R22.setImageResource(SavedInstanceState.getInt("five"));
        R22.setTag(SavedInstanceState.getInt("five"));
        R22.setOnDragListener(this);

        ImageView R23 = (ImageView) findViewById(R.id.Row2_3);
        R23.setImageResource(SavedInstanceState.getInt("six"));
        R23.setTag(SavedInstanceState.getInt("six"));
        R23.setOnDragListener(this);

        ImageView R31 = (ImageView) findViewById(R.id.Row3_1);
        R31.setImageResource(SavedInstanceState.getInt("seven"));
        R31.setTag(SavedInstanceState.getInt("seven"));
        R31.setOnDragListener(this);

        ImageView R32 = (ImageView) findViewById(R.id.Row3_2);
        R32.setImageResource(SavedInstanceState.getInt("eight"));
        R32.setTag(SavedInstanceState.getInt("eight"));
        R32.setOnDragListener(this);

        ImageView R33 = (ImageView) findViewById(R.id.Row3_3);
        R33.setImageResource(SavedInstanceState.getInt("nine"));
        R33.setTag(SavedInstanceState.getInt("nine"));
        R33.setOnDragListener(this);
    }

    @Override
    public void onSaveInstanceState(Bundle outState)
    {
        ImageView R11 = (ImageView) findViewById(R.id.Row1_1);
        outState.putInt("one",(int)R11.getTag());

        ImageView R12 = (ImageView) findViewById(R.id.Row1_2);
        outState.putInt("two",(int)R12.getTag());

        ImageView R13 = (ImageView) findViewById(R.id.Row1_3);
        outState.putInt("three",(int)R13.getTag());

        ImageView R21 = (ImageView) findViewById(R.id.Row2_1);
        outState.putInt("four",(int)R21.getTag());

        ImageView R22 = (ImageView) findViewById(R.id.Row2_2);
        outState.putInt("five",(int)R22.getTag());

        ImageView R23 = (ImageView) findViewById(R.id.Row2_3);
        outState.putInt("six",(int)R23.getTag());

        ImageView R31 = (ImageView) findViewById(R.id.Row3_1);
        outState.putInt("seven",(int)R31.getTag());

        ImageView R32 = (ImageView) findViewById(R.id.Row3_2);
        outState.putInt("eight",(int)R32.getTag());

        ImageView R33 = (ImageView) findViewById(R.id.Row3_3);
        outState.putInt("nine",(int)R33.getTag());

        super.onSaveInstanceState(outState);

    }
}

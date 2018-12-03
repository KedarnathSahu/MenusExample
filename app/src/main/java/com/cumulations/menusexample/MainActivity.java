package com.cumulations.menusexample;

import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    private boolean flag=false;
    Button button;

    AnimationDrawable wifiAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text);
        button = findViewById(R.id.button);

        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/CustomFont.ttf");
        textView.setTypeface(custom_font);

        ImageView imageView=findViewById(R.id.imageView3);
        imageView.setBackgroundResource(R.drawable.animation);
        wifiAnimation=(AnimationDrawable) imageView.getBackground();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        wifiAnimation.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                textView.setText(item.getTitle());
                return true;
            case R.id.item2:
                textView.setText(item.getTitle());
                return true;
            case R.id.item3:
                textView.setText(item.getTitle());
                return true;
            case R.id.item4:
                textView.setText(item.getTitle());
                return true;
            case R.id.item5:
                textView.setText(item.getTitle());
                return true;
            case R.id.item6:
                textView.setText(item.getTitle());
                return true;
            case R.id.item7:
                textView.setText(item.getTitle());
                return true;
            case R.id.item8:
                textView.setText(item.getTitle());
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void updateMenu(View view) {
        if(!flag){
            flag=true;
            button.setText("add item7 & remove item6");
            invalidateOptionsMenu();
        }else {
            flag=false;
            button.setText("add item6 & remove item7");
            invalidateOptionsMenu();
        }
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        if(flag){
            if(menu.findItem(R.id.item7).isVisible()){
                menu.findItem(R.id.item6).setVisible(true);
                menu.findItem(R.id.item7).setVisible(false);
            }
        }else {
            menu.findItem(R.id.item6).setVisible(false);
            menu.findItem(R.id.item7).setVisible(true);
        }

        super.onPrepareOptionsMenu(menu);
        return true;

    }
}

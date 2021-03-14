package com.example.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Animation leftAnim, rightAnim,sloganAnim;

    ImageView Logo, Name;
    TextView slogan,underline;
    //Intent intent;
    private static int SPLASH_TIME_OUT=6000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //defining Animations
        leftAnim = AnimationUtils.loadAnimation(this,R.anim.left_animation);
        rightAnim = AnimationUtils.loadAnimation(this,R.anim.right_animation);
        sloganAnim = AnimationUtils.loadAnimation(this,R.anim.slogan_anim);

        //adding attributes
        Logo = findViewById(R.id.logo);
        Name = findViewById(R.id.name);
        slogan = findViewById(R.id.line);
        underline = findViewById(R.id.underLine);

        //setting Animation
        Logo.setAnimation(leftAnim);
        Name.setAnimation(rightAnim);
        slogan.setAnimation(sloganAnim);
        underline.setAnimation(sloganAnim);
        Logo.animate().translationX(-1200).setDuration(2000).setStartDelay(4000);
        Name.animate().translationX(1200).setDuration(2000).setStartDelay(4000);
        slogan.animate().translationX(1200).setDuration(2000).setStartDelay(4000);
        underline.animate().translationX(1200).setDuration(2000).setStartDelay(4000);

        nextScreen();

}



    private void nextScreen() {
        new Handler().postDelayed(()-> {
            Intent intent = new Intent(MainActivity.this, NewActivity.class);
            startActivity(intent);
            finish();
        }, SPLASH_TIME_OUT);
    }
}
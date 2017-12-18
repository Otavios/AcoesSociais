package com.otavios.acoessociais.telaSplashScreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.otavios.acoessociais.R;
import com.otavios.acoessociais.telaInicial.MainActivity;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally{
                    openMain();
                }
            }
        };
        timer.start();
    }

    protected void openMain(){
        Intent intentMain = new Intent(SplashScreen.this, MainActivity.class);
        startActivity(intentMain);
        finish();
    }
    
}

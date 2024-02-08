package com.arjun.imagetotext;

import android.content.Intent;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;

public class selection extends AppCompatActivity implements View.OnClickListener {

    private CardView card3, card2;
    private SoundPool soundPool;
    private int soundId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        card3 = (CardView) findViewById(R.id.card1234);
        card2 = (CardView) findViewById(R.id.card12345);

        card3.setOnClickListener(this);
        card2.setOnClickListener(this);

        // Initialize the SoundPool
        AudioAttributes attributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build();
        soundPool = new SoundPool.Builder()
                .setMaxStreams(1)
                .setAudioAttributes(attributes)
                .build();

        // Load the click sound from the resource
        soundId = soundPool.load(this, R.raw.reverse, 1);
    }

    @Override
    public void onClick(View v) {
        // Play the click sound when a card is clicked
        soundPool.play(soundId, 1.0f, 1.0f, 1, 0, 1.0f);

        switch (v.getId()) {
            case R.id.card1234:
                Intent ii = new Intent(selection.this, MainActivity.class);
                startActivity(ii);
                break;
            case R.id.card12345:
                Intent iz = new Intent(selection.this, MainActivity2.class);
                startActivity(iz);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Release the SoundPool resources
        soundPool.release();
        soundPool = null;
    }
}




//import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.support.v7.widget.CardView;
//import android.view.View;
//import android.widget.Button;
//
//public class selection extends AppCompatActivity implements View.OnClickListener{
// private CardView card3,card2;
//// ,card1,card4;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_selection);
//        card3=(CardView)findViewById(R.id.card1234);
//        card2=(CardView)findViewById(R.id.card12345);
////        card4=(CardView)findViewById(R.id.card123456);
////        card1=(CardView)findViewById(R.id.card1234567);
//
//        card3.setOnClickListener(this);
//        card2.setOnClickListener(this);
////        card4.setOnClickListener(this);
////        card1.setOnClickListener(this);
//
//    }
//
//    @Override
//    public void onClick(View v) {
//        switch(v.getId())
//        {
//            case R.id.card1234:
//                Intent ii=new Intent(selection.this,MainActivity.class);
//                startActivity(ii);
//                break;
//
//
//
//            case R.id.card12345:
//                Intent iz=new Intent(selection.this,MainActivity2.class);
//                startActivity(iz);
//                break;
//
//
////            case R.id.card123456:
////                Intent io=new Intent(selection.this,scrollview.class);
////                startActivity(io);
////                break;
////
////
////            case R.id.card1234567:
////                Intent ioo=new Intent(selection.this,MainActivity3.class);
////                startActivity(ioo);
////                break;
//
//        }
//
//    }
//}


package com.johnsandroidstudiotutorials.gettingstartedwithfirebase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    TextView textViewDislay;
    Button buttonDonut, buttonNougat;
    Firebase firebaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        textViewDislay = (TextView) findViewById(R.id.textview_displa);
        buttonDonut = (Button) findViewById(R.id.button_donut);
        buttonNougat = (Button) findViewById(R.id.button_nougat);

        firebaseReference = new Firebase("https://getting-started-tutorial-df52c.firebaseio.com/data/type");

        firebaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                textViewDislay.setText(text);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        buttonDonut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseReference.setValue("John's android studio Tutorials are the best");
            }
        });
        buttonNougat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseReference.setValue("John's android studio Tutorials are the best");
            }
        });
    }
}

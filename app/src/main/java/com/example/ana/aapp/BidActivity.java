package com.example.ana.aapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class BidActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bid);

        Button bidActButton = (Button) findViewById(R.id.bidButton);
        bidActButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendBid();
            }
        });

    }
    private void sendBid() {
        EditText editBidText = (EditText) findViewById(R.id.textBid);
        String ana = editBidText.getText().toString();
        Intent i = new Intent();
        i.putExtra("anakraljica",ana);

        setResult(RESULT_OK,i);
        finish();
    }


}
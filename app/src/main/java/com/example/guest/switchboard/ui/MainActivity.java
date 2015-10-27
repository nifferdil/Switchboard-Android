package com.example.guest.switchboard.ui;

import android.content.Intent;
import android.app.ListActivity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.guest.switchboard.R;
import com.example.guest.switchboard.adapters.AskAdapter;
import com.example.guest.switchboard.models.Ask;

import java.util.ArrayList;

public class MainActivity extends ListActivity {

    private Button mAsk;
    private Button mOffer;
    private AskAdapter mAskAdapter;
    private ArrayList<Ask> mAsks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAsk = (Button) findViewById(R.id.askSubmit);
        mOffer = (Button) findViewById(R.id.offerSubmit);
        mAsks = (ArrayList) Ask.all();

        mAskAdapter = new AskAdapter(this, mAsks);
        setListAdapter(mAskAdapter);

        mAsk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AskActivity.class);
                startActivity(intent);
            }
        });

        mOffer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OfferActivity.class);
                startActivity(intent);
            }
        });


    }
}

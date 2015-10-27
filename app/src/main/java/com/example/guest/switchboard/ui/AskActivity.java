package com.example.guest.switchboard.ui;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.guest.switchboard.R;
import com.example.guest.switchboard.adapters.AskAdapter;
import com.example.guest.switchboard.models.Ask;

import java.util.ArrayList;

public class AskActivity extends AppCompatActivity {

    private Button mAskSubmitButton;
    private EditText mAskText;
    private ArrayList<Ask> mAsks;
    private AskAdapter mAskAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask);


        mAskSubmitButton = (Button) findViewById(R.id.askSubmitButton);
        mAskText = (EditText) findViewById(R.id.askText);
        mAsks = (ArrayList) Ask.all();

        mAskSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String askContent = mAskText.getText().toString();
                Ask ask = new Ask(askContent);
                ask.save();
                mAsks.add(ask);
                Intent intent = new Intent(AskActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}

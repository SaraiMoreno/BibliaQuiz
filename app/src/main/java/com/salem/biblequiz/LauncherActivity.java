package com.salem.biblequiz;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.salem.biblequiz.dialogs.DialogInfo;
import com.salem.biblequiz.dialogs.DialogSettings;

public class LauncherActivity extends AppCompatActivity implements View.OnClickListener {
    ImageButton btn_play,btn_config,btn_info;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_launcher);
        btn_play=findViewById(R.id.ImgBtPlay);
        btn_play.setOnClickListener(this);

        btn_config=findViewById(R.id.button_config);
        btn_config.setOnClickListener(this);

        btn_info=findViewById(R.id.button_info);
        btn_info.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ImgBtPlay:
                Intent intent = new Intent(this, LevelsActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.button_config:
                Dialog settingsD=new DialogSettings(this);
                settingsD.show();
                break;
            case R.id.button_info:
                Dialog dialogInfo=new DialogInfo(this);
                dialogInfo.show();
                break;
        }
    }
}

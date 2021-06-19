package com.salem.biblequiz.dialogs;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.salem.biblequiz.Base.AppConfig;
import com.salem.biblequiz.R;

import java.util.Objects;

public class DialogSettings extends Dialog implements View.OnClickListener {

    private ImageView sonidos;
    private ImageView musica;
    private Button aceptar;
    private final SharedPreferences.Editor editor;
    private final Context mContext;
    private final String sound_keyPreferences;
    private final String music_keyPreferences;
    private boolean valueSound, valueMusic;

    @SuppressLint("CommitPrefEdits")
    public DialogSettings(@NonNull Context context) {
        super(context, R.style.Theme_AppCompat_Dialog);
        mContext=context;
        SharedPreferences sharedPref = AppConfig.getSharedPref();
        sound_keyPreferences= context.getResources().getString(R.string.preference_sonido_key);
        music_keyPreferences= context.getResources().getString(R.string.preference_musica_key);
        editor = sharedPref.edit();
        valueMusic = sharedPref.getBoolean(music_keyPreferences, true);
        valueSound = sharedPref.getBoolean(sound_keyPreferences, true);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(R.layout.dialog_settings);
        setCancelable(false);

        sonidos=findViewById(R.id.btn_sonido);
        sonidos.setOnClickListener(this);
        sonidos.setImageDrawable(mContext.getResources().getDrawable((valueSound)?R.drawable.btn_on:R.drawable.btn_off));

        musica=findViewById(R.id.btn_musica);
        musica.setOnClickListener(this);
        musica.setImageDrawable(mContext.getResources().getDrawable((valueMusic)?R.drawable.btn_on:R.drawable.btn_off));

        aceptar=findViewById(R.id.cerrarSettings);
        aceptar.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cerrarSettings:
                dismiss();
                break;
            case R.id.btn_sonido:
                valueSound=!valueSound;

                sonidos.setImageDrawable(mContext.getResources().getDrawable((!valueSound)?R.drawable.btn_off:R.drawable.btn_on));
                editor.putBoolean(sound_keyPreferences, valueSound);
                editor.commit();

                break;
            case R.id.btn_musica:
                valueMusic=!valueMusic;

                musica.setImageDrawable(mContext.getResources().getDrawable((!valueMusic)?R.drawable.btn_off:R.drawable.btn_on));
                editor.putBoolean(music_keyPreferences, valueMusic);
                editor.commit();



                break;
        }
    }
}

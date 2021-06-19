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

public class DialogInfo extends Dialog implements View.OnClickListener {


    private Button aceptar;


    @SuppressLint("CommitPrefEdits")
    public DialogInfo(@NonNull Context context) {
        super(context, R.style.Theme_AppCompat_Dialog);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(R.layout.dialog_info);
        setCancelable(false);

        aceptar=findViewById(R.id.btn_cerrarInfo);
        aceptar.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_cerrarInfo:
                dismiss();
                break;

        }
    }
}

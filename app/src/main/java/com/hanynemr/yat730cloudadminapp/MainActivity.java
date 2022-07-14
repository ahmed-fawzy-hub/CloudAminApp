package com.hanynemr.yat730cloudadminapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.backendless.Backendless;
import com.vansuita.pickimage.bean.PickResult;
import com.vansuita.pickimage.bundle.PickSetup;
import com.vansuita.pickimage.dialog.PickImageDialog;
import com.vansuita.pickimage.listeners.IPickResult;

public class MainActivity extends AppCompatActivity implements IPickResult {

    EditText titleText, genreText;
    ImageView posterImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        titleText = findViewById(R.id.titleText);
        genreText = findViewById(R.id.genreText);
        posterImage = findViewById(R.id.posterImage);

        Backendless.initApp(this, "850B5092-75E8-B993-FFFC-E4380B1C9900", "F09796D9-05F3-4C8B-BA3F-14A162602BA0");

    }

    public void take(View view) {
        PickImageDialog.build(new PickSetup()).show(this);

    }

    public void save(View view) {

    }

    @Override
    public void onPickResult(PickResult r) {
        if (r.getError() == null) {
            posterImage.setImageBitmap(r.getBitmap());

        } else
            Toast.makeText(this, "error taking image", Toast.LENGTH_SHORT).show();
    }
}
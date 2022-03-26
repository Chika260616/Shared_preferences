package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences shp;
    private EditText editSave;
    private final String save_key = "save_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init()
    {
        shp = getSharedPreferences("dataRow",MODE_PRIVATE);
        editSave = findViewById(R.id.editText);
        editSave.setText(shp.getString(save_key,"Text"));
    }

    public void onClickDelete(View view) {

        SharedPreferences.Editor edit = shp.edit();
        edit.clear();
        edit.commit();
        Toast.makeText(MainActivity.this, "Text Deleted", Toast.LENGTH_SHORT).show();

    }

    public void onClickGet(View view) {
        editSave.setText(shp.getString(save_key,"empty"));
        Toast.makeText(MainActivity.this, "Text Loaded", Toast.LENGTH_SHORT).show();
    }

    public void oClickSave(View view) {
        SharedPreferences.Editor edit = shp.edit();
        edit.putString(save_key, editSave.getText().toString());
        edit.commit();
        Toast.makeText(MainActivity.this,"Text Saved",Toast.LENGTH_SHORT).show();

    }
}
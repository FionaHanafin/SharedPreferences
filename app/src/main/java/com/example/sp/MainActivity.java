package com.example.sp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
SharedPreferences sp;
Button b,save;
EditText name,email,mobile1,mobile2,city;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    public static final String Phone1 = "phoneKey1";
    public static final String Phone2 = "phoneKey2";
    public static final String Email = "emailKey";
    public static final String City = "cityKey";
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = findViewById(R.id.save);

        sp = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        name = findViewById(R.id.nameEdit);
        email = findViewById(R.id.emailEdit);
        mobile1 = findViewById(R.id.mobileEdit);
        mobile2 = findViewById(R.id.mobileEdit2);
        city = findViewById(R.id.cityEdit);
        if (sp.getString("nameKey", "defaultValue").isEmpty()) {
            Toast.makeText(this, "No Information stored", Toast.LENGTH_SHORT).show();
        } else {
            name.setText(sp.getString("nameKey", ""));
            mobile1.setText(sp.getString("phoneKey1", ""));
            mobile2.setText(sp.getString("phoneKey2", ""));
            city.setText(sp.getString("cityKey", ""));
            email.setText(sp.getString("emailKey", ""));
        }
        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                AddData();
            }
        });
        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                AddData();
            }
        });
        mobile1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                AddData();
            }
        });
        mobile2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                AddData();
            }
        });
        city.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                AddData();
            }
        });
    }
    public void AddData(){
        if (name.getText().toString().trim().isEmpty() ||
                email.getText().toString().trim().isEmpty() ||
                mobile1.getText().toString().trim().isEmpty() ||
                mobile2.getText().toString().trim().isEmpty() ||
                city.getText().toString().trim().isEmpty()) {
            b.setEnabled(false);
        } else {
            b.setEnabled(true);
        }
    }
    public void SaveData(View v){

        editor = sp.edit();
        editor.putString(Name, name.getText().toString().trim());
        editor.putString(Email, email.getText().toString().trim());
        editor.putString(Phone1, mobile1.getText().toString().trim());
        editor.putString(Phone2, mobile2.getText().toString().trim());
        editor.putString(City, city.getText().toString().trim());
        Log.d("********", "before .apply()" +
        "");
        editor.apply();
        Log.d("********", "after .apply()");
        Toast.makeText(MainActivity.this, "Data has been saved", Toast.LENGTH_SHORT).show();

    }
    public void clearData(View v){
        name.setText("");
        mobile1.setText("");
        mobile2.setText("");
        city.setText("");
        email.setText("");
        sp.edit().remove(Name).apply();
        sp.edit().remove(Email).apply();
        sp.edit().remove(Phone1).apply();
        sp.edit().remove(Phone2).apply();
        sp.edit().remove(City).apply();

    }
    public void KillApp(View view){
        System.exit(0);

    }
}

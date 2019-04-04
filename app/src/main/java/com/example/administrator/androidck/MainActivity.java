package com.example.administrator.androidck;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText UserName;
    EditText Password;
    Button btnLogin;
    String Name;
    String Pass;
    static CheckBox ckRemember;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String USER_KEY = "User";
    String PASS_KEY = "Password";
    Boolean Check = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onIt();

        sharedPreferences = getSharedPreferences("loginPref",MODE_PRIVATE);
        UserName.setText(sharedPreferences.getString(USER_KEY,""));
        Password.setText(sharedPreferences.getString(PASS_KEY,""));
        ckRemember.setChecked(sharedPreferences.getBoolean(String.valueOf(Check),true));

        if(UserName.getText().length() > 0 ){
            login();
        }
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    public  void login() {
        Name = UserName.getText().toString();
        Pass = Password.getText().toString();
        if (checkText()){
            if(Name.equals("1606020053") && Pass.equals("1606020053")){
                if (ckRemember.isChecked() == true){
                    editor = sharedPreferences.edit();
                    editor.putString(USER_KEY,Name);
                    editor.putString(PASS_KEY,Pass);
                    editor.putBoolean(String.valueOf(Check),true);
                    editor.commit();
                }
                else {
                    editor = sharedPreferences.edit();
                    editor.putString(USER_KEY,"");
                    editor.putString(PASS_KEY,"");
                    editor.putBoolean(String.valueOf(Check),false);
                    editor.commit();
                }

                Intent intent = new Intent(MainActivity.this,ManHinhChinh.class);
                startActivity(intent);
            }
        }
        else {
            Toast.makeText(MainActivity.this,"User or Password is wrong",Toast.LENGTH_LONG).show();
        }
    }

    private boolean checkText() {
        if (Name.length()< 1){
            UserName.setError("UserName Can't be null");
            return false;
        }
        else if (Pass.length() < 1){
            Password.setError("Password Can't be null");
            return false;
        }
        return true;
    }

    private void onIt() {
        UserName = (EditText)findViewById(R.id.edt_User_login);
        Password = (EditText)findViewById(R.id.edt_Pas_login);
        btnLogin = (Button)findViewById(R.id.btnLogin);
        ckRemember = (CheckBox)findViewById(R.id.ck_Remember);
    }
}
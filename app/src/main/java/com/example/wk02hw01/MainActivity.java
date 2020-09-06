package com.example.wk02hw01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String M1 = "Button State";

    TextView mainDisplay;

    private EditText mName;
    private EditText mPassword;
    private TextView mInfo;
    private Button mLogin;

    Button button;
    TextView mTextView;

    boolean m1 = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mName = findViewById(R.id.usernameEditTxt);
        mPassword = findViewById(R.id.passwordEditTxt);

        button = findViewById(R.id.Login);

        if(savedInstanceState != null){
            m1 = savedInstanceState.getBoolean(M1,true);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m1 = !m1;
                validate(mName.getText().toString(),mPassword.getText().toString());
            }
        });
    }


//    Hard coded username since no DB

    public void validate(String userName, String userPassword){

        if ((userName.equals("din_djarin")) && (userPassword.equals("baby_yoda_ftw"))) {

            String message = "Login successfull";
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();

//            getIntent();

            //Correct
            Intent intent = new Intent(this, successfulLogIn.class);
            startActivity(intent);

        } else {
            String message = "Incorrect username or password";
            openDialog();
        }

    }

//    Fact design
//    public static Intent getIntent(Context context, int value){
//
//        Intent intent = new Intent(context, successfulLogIn.class);
//        intent.putExtra("INTENT_EX", value);
//
//
//        return intent;
//    }

// Opens error msg if faild login
    public void openDialog(){
        AcctErrorMsg errorMsg = new AcctErrorMsg();
        errorMsg.show(getSupportFragmentManager(), "We just got fragged");
    }

}
package com.nawwa.app1;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        //do something

        Button buttonSignIn = findViewById(R.id.buttonSignIn);
        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("QueryPermissionsNeeded")
            @Override
            public void onClick(View v) {
                EditText  editTextMobile = findViewById(R.id.editTextMobile);
                EditText  editTextPassword = findViewById(R.id.editTextPassword);


                if (editTextMobile.getText().toString().equals("0710507342")
                        && editTextPassword.getText().toString().equals("abc")){
                    Log.i("Log1","Success");
                    Toast.makeText(SignUpActivity.this,"Your credits are good success",Toast.LENGTH_SHORT).show();
                    new AlertDialog.Builder(SignUpActivity.this).setTitle("Message").setMessage("allGood").show();

                    //open another activity
//                    Intent i = new Intent(SignUpActivity.this,HomeActivity.class);

                    //open camera
//                    Intent i = new Intent("android.media.action.STILL_IMAGE_CAMERA");

                    //open map
//                    Intent i = new Intent(Intent.ACTION_VIEW);
//                    Uri uri = Uri.parse("geo:47.6,-122.3");
//                    i.setData(uri);

                    //making call
//                    Intent i = new Intent(Intent.ACTION_CALL);
//                    Uri uri = Uri.parse("tel:0372230024");
//                    i.setData(uri);

                    //sending data to other activity
                    Intent i = new Intent(SignUpActivity.this,HomeActivity.class);
                    i.putExtra("name","Lakshan");



                        if (i.resolveActivity(getPackageManager()) != null) {
                            startActivity(i);
                        } else {
                            Toast.makeText(SignUpActivity.this, "No app found to handle this action", Toast.LENGTH_SHORT).show();
                        }

                }else {
                    Log.e("Log1","Error");
                    Toast.makeText(SignUpActivity.this,"Your credits are wrong ",Toast.LENGTH_SHORT).show();
                    new AlertDialog.Builder(SignUpActivity.this).setTitle("Message").setMessage("notGood").show();
                }


            }
        });

        //register receiver to get broadcasting data
        X x = new X();
        registerReceiver(x, new IntentFilter("android.intent.action.AIRPLANE_MODE"));


    }
}
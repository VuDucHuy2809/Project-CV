package com.example.chatbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {

}

   /* private final EditText edtU = null;
    private EditText edtP = null;
    private Button btnLogin = null;
    private void doLogin() {
    edtU = (EditText)findViewById(R.id.edtUsername);
    edtP = (EditText)findViewById(R.id.edtPassword);
    btnLogin = (Button)findViewById(R.id.btLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkPassword(edtU.getText().toString(), edtP.getText().toString())) {
                    Intent intHello = new Intent(MainActivity.this, HelloActivity.class);
                    startActivityForResult(intHello, CODE_HELLO);
                } else {
                    Uri page = Uri.parse("http://vnexpress.net");
                    Intent intWeb = new Intent(Intent.ACTION_VIEW, page);
                    //startActivity(intWeb);
                    Intent chooser = Intent.createChooser(intWeb, "Chọn App để gọi");
                    startActivity(chooser);
                }
            }
        });
    }


            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_login);
            }
        }
*/
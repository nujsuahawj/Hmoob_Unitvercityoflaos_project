package com.developer.arsltech.fns_1;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class Login extends AppCompatActivity {
    Button btnlogin;

    private static final String apiurl="https://nriavtushlubplogteb.000webhostapp.com/project/login.php";
    EditText t1,t2;
    TextView tv;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        btnlogin = findViewById(R.id.btnlogin);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog = new ProgressDialog(Login.this);
                progressDialog.show();
                progressDialog.setMessage("ກຳລັງປະມວນຜົນ...");
                login();
            }
        });
    }

    private void login() {

        t1 = (EditText)findViewById(R.id.txt1);
        t2 = (EditText)findViewById(R.id.txt2);
        tv=(TextView)findViewById(R.id.tv);

        final String name = t1.getText().toString().trim();
        final String pass = t2.getText().toString().trim();

        if(name.isEmpty()){
            progressDialog.dismiss();
            Toast.makeText(this, "ກະລຸນາປ້ອນຊື່", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(pass.isEmpty()){
            progressDialog.dismiss();
            Toast.makeText(this, "ກະລຸນາປ້ອນລະຫັດຜ່ານ", Toast.LENGTH_SHORT).show();
            return;
        }

        else{

            String qry="?t1="+t1.getText().toString().trim()+"&t2="+t2.getText().toString().trim();

            class dbprocess extends AsyncTask<String,Void,String>
            {
                @Override
                protected  void onPostExecute(String data)
                {

                    if(data.equals("found"))
                    {


                        SharedPreferences sn=getSharedPreferences("credentials",MODE_PRIVATE);
                        SharedPreferences.Editor editor=sn.edit();
                        editor.putString("uname",t1.getText().toString());
                        editor.commit();
                        SharedPreferences sp=getSharedPreferences("credentials",MODE_PRIVATE);
                        SharedPreferences.Editor editors=sp.edit();
                        editor.putString("upass",t2.getText().toString());
                        editors.commit();

                        progressDialog.dismiss();
                        startActivity(new Intent(getApplicationContext(),Userprofile.class));
                    }
                    else
                    {
                        t1.setText("");
                        t2.setText("");
                        tv.setTextColor(Color.parseColor("#8B0000"));
                        tv.setText(data);
                        progressDialog.dismiss();
                    }
                }
                @Override
                protected String doInBackground(String... params)
                {
                    String furl=params[0];

                    try
                    {
                        URL url=new URL(furl);
                        HttpURLConnection conn=(HttpURLConnection)url.openConnection();
                        BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream()));


                        return br.readLine();

                    }catch (Exception ex)
                    {
                        return ex.getMessage();
                    }
                }
            }
            dbprocess obj=new dbprocess();
            obj.execute(apiurl+qry);

        }

    }

    public void checklogoutmsg(View view)
    {
        tv=(TextView)findViewById(R.id.tv);

        SharedPreferences sp=getSharedPreferences("credentials",MODE_PRIVATE);
        if(sp.contains("msg"))
        {
            tv.setText(sp.getString("msg", ""));
            SharedPreferences.Editor ed=sp.edit();
            ed.remove("msg");
            ed.commit();
        }
    }






    public void Regist(View view) {
        startActivity(new Intent(getApplicationContext(),Register.class));
    }


}

package com.developer.arsltech.fns_1;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {
    EditText uid;
    EditText uname;
    EditText uday;
    EditText uemail;
    EditText unumber;
    EditText umagor;
    EditText upassword;
    Button btnregister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        uid=findViewById(R.id.userid);
        uname=findViewById(R.id.username);
        uday=findViewById(R.id.birthday);
        uemail=findViewById(R.id.email);
        unumber=findViewById(R.id.number);
        umagor=findViewById(R.id.major);
        upassword=findViewById(R.id.password);
        btnregister=findViewById(R.id.register);

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
            }
        });

    }

    private void insertData() {

        final String userid = uid.getText().toString().trim();
        final String username = uname.getText().toString().trim();
        final String birthday = uday.getText().toString().trim();
        final String email = uemail.getText().toString().trim();
        final String number =unumber.getText().toString().trim();
        final String major =umagor.getText().toString().trim();
        final String password =upassword.getText().toString().trim();

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("ກຳລັງປະມວນຜົນ...");

        if(userid.isEmpty()){
            Toast.makeText(this, "ກະລຸນາປ້ອນລຫັດນັກສຶກສາ", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(username.isEmpty()){
            Toast.makeText(this, "ກະລຸນາປ້ອນຊື່", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(birthday.isEmpty()){
            Toast.makeText(this, "ກະລຸນາປ້ອນວັນເດືອນປີເກີດ ", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(email.isEmpty()){
            Toast.makeText(this, "ກະລຸນາປ້ອນອີເມວ", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(number.isEmpty()){
            Toast.makeText(this, "ກະລຸນາປ້ອນເບີໂທລະສັຍ", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(major.isEmpty()){
            Toast.makeText(this, "ກະລຸນາປ້ອນສາຂາຮຽນ", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(password.isEmpty()){
            Toast.makeText(this, "ກະລຸນາປ້ອນລະຫັດຜ່ານ", Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            progressDialog.show();
            StringRequest request = new StringRequest(Request.Method.POST, "https://nriavtushlubplogteb.000webhostapp.com/project/inset.php",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            if(response.equalsIgnoreCase("Data Inserted")){
                                Toast.makeText(Register.this, "ການລົງທະບຽມຂອງທ່ານສຳເລັດແລ້ວ", Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                                startActivity(new Intent(getApplicationContext(),Login.class));
                            }
                            else{
                                Toast.makeText(Register.this, response, Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(Register.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }

            ){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {

                    Map<String,String> params = new HashMap<String,String>();
                    params.put("userid",userid);
                    params.put("name",username);
                    params.put("birthday",birthday);
                    params.put("email",email);
                    params.put("number",number);
                    params.put("major",major);
                    params.put("password",password);
                    return params;
                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(Register.this);
            requestQueue.add(request);
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }



    public void Login(View view) {
        startActivity(new Intent(getApplicationContext(),Login.class));
    }
}

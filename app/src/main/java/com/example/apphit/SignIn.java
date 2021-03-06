package com.example.apphit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.apphit.configs.Constant;

import org.json.JSONObject;

public class SignIn extends AppCompatActivity {

    EditText edttenDN, edtMKDN;
    Button btnDangNhap;
    TextView tvDK, tvQuenMK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dangnhap);
        AnhXa();

        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = edttenDN.getText().toString().trim();
                String password = edtMKDN.getText().toString().trim();
                DangNhap(userName, password);
                kiemTraDN();
            }
        });

        tvQuenMK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iQuenMK = new Intent(SignIn.this, SendEmail.class);
                startActivity(iQuenMK);
            }
        });

        tvDK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iDangKy = new Intent(SignIn.this, SignUp.class);
                startActivity(iDangKy);
            }
        });
    }

    public void AnhXa() {
        edttenDN = (EditText) findViewById(R.id.edttenDN);
        edtMKDN = (EditText) findViewById(R.id.edtMKDN);
        btnDangNhap = (Button) findViewById(R.id.btnDangNhap);
        tvDK = (TextView) findViewById(R.id.tvDK);
        tvQuenMK = (TextView) findViewById(R.id.tvquenMK);
    }

    public boolean DangNhap(String sTenDN, String sMatKhau) {
        if (sTenDN.isEmpty()){
            edttenDN.setError("Field can't be empty");
            Toast.makeText(SignIn.this, "?????i m???t kh???u kh??ng th??nh c??ng", Toast.LENGTH_SHORT).show();
            return false;
        } else if (sMatKhau.isEmpty()) {
            edtMKDN.setError("Field can't be empty");
            Toast.makeText(SignIn.this, "?????i m???t kh???u kh??ng th??nh c??ng", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public void kiemTraDN() {
        RequestQueue requestQueue = Volley.newRequestQueue(SignIn.this);

        JSONObject objectLogin = new JSONObject();
        try {
            objectLogin.put("username", edttenDN.getText().toString());
            objectLogin.put("password", edtMKDN.getText().toString());
        } catch (Exception e) {
            System.out.println(e);
        }

        JsonObjectRequest loginRequest = new JsonObjectRequest(Request.Method.POST, Constant.BASE_API + "/api/v1/auth/login",
                objectLogin, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(getBaseContext(), "????ng nh???p th??nh c??ng", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SignIn.this, MainActivity.class);
                startActivity(intent);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getBaseContext(), "M???t kh???u ho???c t??n t??i kho???n kh??ng ????ng", Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(loginRequest);
    }
}
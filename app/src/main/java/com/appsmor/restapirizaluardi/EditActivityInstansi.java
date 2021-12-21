package com.appsmor.restapirizaluardi;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.appsmor.restapirizaluardi.model.PostPutDelInstansi;
import com.appsmor.restapirizaluardi.rest.ApiClient3;
import com.appsmor.restapirizaluardi.rest.ApiInterfaceInstansi;

public class EditActivityInstansi extends AppCompatActivity {
    EditText edtId, edtInstansi, edtTelepon;
    Button btUpdateInstansi, btDeleteInstansi, btBackInstansi;
    ApiInterfaceInstansi mApiInterfaceInstansi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        edtId = (EditText) findViewById(R.id.edtIdInstansi);
        edtInstansi = (EditText) findViewById(R.id.edtInstansi);
        edtTelepon = (EditText) findViewById(R.id.edtTelepon);

        Intent mIntentInstansi = getIntent();
        edtId.setText(mIntentInstansi.getStringExtra("Id"));
        edtId.setTag(edtId.getKeyListener());
        edtId.setKeyListener(null);
        edtInstansi.setText(mIntentInstansi.getStringExtra("Instansi"));
        edtTelepon.setText(mIntentInstansi.getStringExtra("Telepon"));
        mApiInterfaceInstansi = ApiClient3.getClient3().create(ApiInterfaceInstansi.class);

        btUpdateInstansi = (Button) findViewById(R.id.btUpdateInstansii2);
        btUpdateInstansi.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Call<PostPutDelInstansi> updateInstansiCall = mApiInterfaceInstansi.putInstansi(
                        edtId.getText().toString(),
                        edtInstansi.getText().toString(),
                        edtTelepon.getText().toString());
                updateInstansiCall.enqueue(new Callback<PostPutDelInstansi>(){
                    @Override
                    public void onResponse(Call<PostPutDelInstansi> call, Response<PostPutDelInstansi> response) {
                        MainActivityInstansi.mai.refresh();
                        finish();
                    }
                    @Override
                    public void onFailure(Call<PostPutDelInstansi> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),
                                "Error", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        btDeleteInstansi = (Button) findViewById(R.id.btDeleteInstansii2);
        btDeleteInstansi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtId.getText().toString().trim().isEmpty()==false){
                    Call<PostPutDelInstansi> deleteInstansi = mApiInterfaceInstansi.deleteInstansi(edtId.getText().toString());
                    deleteInstansi.enqueue(new Callback<PostPutDelInstansi>() {
                        @Override
                        public void onResponse(Call<PostPutDelInstansi>call, Response<PostPutDelInstansi> response) {
                            MainActivityInstansi.mai.refresh();
                            finish();
                        }
                        @Override
                        public void onFailure(Call<PostPutDelInstansi> call, Throwable t) {
                            Toast.makeText(getApplicationContext(),"Error", Toast.LENGTH_LONG).show();
                        }
                    });
                }else{
                    Toast.makeText(getApplicationContext(), "Error",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
        btBackInstansi = (Button) findViewById(R.id.btBackGoInstansii);
        btBackInstansi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityInstansi.mai.refresh();
                finish();
            }
        });
    }
}
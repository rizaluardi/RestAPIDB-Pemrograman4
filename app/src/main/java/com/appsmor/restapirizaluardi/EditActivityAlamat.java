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

import com.appsmor.restapirizaluardi.model.PostPutDelAlamat;
import com.appsmor.restapirizaluardi.rest.ApiClient2;
import com.appsmor.restapirizaluardi.rest.ApiInterfaceAlamat;

public class EditActivityAlamat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_alamat);
        EditText edtId, edtAlamat, edtKodepos;
        Button btUpdate, btDelete, btBack;
        ApiInterfaceAlamat mApiInterfaceAlamat;

        edtId = (EditText) findViewById(R.id.edtIdAlamat);
        edtAlamat = (EditText) findViewById(R.id.edtAlamat);
        edtKodepos = (EditText) findViewById(R.id.edtKodepos);

        Intent mIntentAlamat = getIntent();
        edtId.setText(mIntentAlamat.getStringExtra("Id"));
        edtId.setTag(edtId.getKeyListener());
        edtId.setKeyListener(null);
        edtAlamat.setText(mIntentAlamat.getStringExtra("Alamat"));
        edtKodepos.setText(mIntentAlamat.getStringExtra("Kodepos"));
        mApiInterfaceAlamat = ApiClient2.getClient2().create(ApiInterfaceAlamat.class);

        btUpdate = (Button) findViewById(R.id.btUpdateAlamat2);
        btUpdate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Call<PostPutDelAlamat> updateAlamatCall = mApiInterfaceAlamat.putAlamat(
                        edtId.getText().toString(),
                        edtAlamat.getText().toString(),
                        edtKodepos.getText().toString());
                updateAlamatCall.enqueue(new Callback<PostPutDelAlamat>(){
                    @Override
                    public void onResponse(Call<PostPutDelAlamat> call, Response<PostPutDelAlamat> response) {
                        MainActivityAlamat.maa.refresh();
                        finish();
                    }
                    @Override
                    public void onFailure(Call<PostPutDelAlamat> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),
                                "Error", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        btDelete = (Button) findViewById(R.id.btDeleteAlamat2);
        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtId.getText().toString().trim().isEmpty()==false){
                    Call<PostPutDelAlamat> deleteAlamat = mApiInterfaceAlamat.deleteAlamat(edtId.getText().toString());
                    deleteAlamat.enqueue(new Callback<PostPutDelAlamat>() {
                        @Override
                        public void onResponse(Call<PostPutDelAlamat>call, Response<PostPutDelAlamat> response) {
                            MainActivityAlamat.maa.refresh();
                            finish();
                        }
                        @Override
                        public void onFailure(Call<PostPutDelAlamat> call, Throwable t) {
                            Toast.makeText(getApplicationContext(),"Error", Toast.LENGTH_LONG).show();
                        }
                    });
                }else{
                    Toast.makeText(getApplicationContext(), "Error",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
        btBack = (Button) findViewById(R.id.btBackGoAlamat);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityAlamat.maa.refresh();
                finish();
            }
        });
    }
}
package com.appsmor.restapirizaluardi;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.appsmor.restapirizaluardi.model.PostPutDelAlamat;
import com.appsmor.restapirizaluardi.rest.ApiClient2;
import com.appsmor.restapirizaluardi.rest.ApiInterfaceAlamat;

public class InsertActivityAlamat extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_alamat);
        EditText edtAlamat, edtKodepos;
        Button btInsert, btBack;
        ApiInterfaceAlamat mApiInterfaceAlamat;
        edtAlamat = (EditText) findViewById(R.id.edtAlamat);
        edtKodepos = (EditText) findViewById(R.id.edtKodepos);
        mApiInterfaceAlamat = ApiClient2.getClient2().create(ApiInterfaceAlamat.class);
        btInsert = (Button) findViewById(R.id.btInsertingAlamat);
        btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<PostPutDelAlamat> postAlamatCall =
                        mApiInterfaceAlamat.postAlamat(edtAlamat.getText().toString(),
                                edtKodepos.getText().toString());
                postAlamatCall.enqueue(new Callback<PostPutDelAlamat>()
                {
                    @Override
                    public void onResponse(Call<PostPutDelAlamat> call,
                                           Response<PostPutDelAlamat> response) {
                        MainActivity.ma.refresh();
                        finish();
                    }
                    @Override
                    public void onFailure(Call<PostPutDelAlamat> call,
                                          Throwable t) {
                        Toast.makeText(getApplicationContext(),
                                "Error", Toast.LENGTH_LONG).show();
                    }
                });
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

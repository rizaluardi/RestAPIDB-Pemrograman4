package com.appsmor.restapirizaluardi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.appsmor.restapirizaluardi.adapter.InstansiAdapter;
import com.appsmor.restapirizaluardi.model.GetInstansi;
import com.appsmor.restapirizaluardi.model.Instansi;
import com.appsmor.restapirizaluardi.rest.ApiClient3;
import com.appsmor.restapirizaluardi.rest.ApiInterface;
import com.appsmor.restapirizaluardi.rest.ApiInterfaceInstansi;

import java.util.List;

public class MainActivityInstansi extends AppCompatActivity {

    Button btInsInstansi;
    ApiInterfaceInstansi mApiInterfaceInstansi;
    private RecyclerView mRecyclerViewInstansi;
    private RecyclerView.Adapter mAdapterInstansi;
    private RecyclerView.LayoutManager mLayoutManagerInstansi;
    public static MainActivityInstansi mai;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_instansi);
        btInsInstansi = (Button) findViewById(R.id.btInsInstansi);
        btInsInstansi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivityInstansi.this,
                        InsertActivityInstansi.class));
            }
        });
        mRecyclerViewInstansi = (RecyclerView) findViewById(R.id.recyclerViewInstansi);
        mLayoutManagerInstansi = new LinearLayoutManager(this);
        mRecyclerViewInstansi.setLayoutManager(mLayoutManagerInstansi);
        mApiInterfaceInstansi = ApiClient3.getClient3().create(ApiInterfaceInstansi.class);
        mai=this;
        refresh();
    }
    public void refresh() {
        Call<GetInstansi> instansiCall = mApiInterfaceInstansi.getInstansi();
        instansiCall.enqueue(new Callback<GetInstansi>() {
            @Override
            public void onResponse(Call<GetInstansi> call,
                                   Response<GetInstansi>
                                           response) {
                List<Instansi> InstansiList =
                        response.body().getListDataInstansi();
                Log.d("Retrofit Get", "Jumlah data Instansi: " +
                        String.valueOf(InstansiList.size()));
                mAdapterInstansi = new InstansiAdapter(InstansiList);
                mRecyclerViewInstansi.setAdapter(mAdapterInstansi);
            }
            @Override
            public void onFailure(Call<GetInstansi> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }
}
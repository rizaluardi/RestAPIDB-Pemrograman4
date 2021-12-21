package com.appsmor.restapirizaluardi.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.appsmor.restapirizaluardi.EditActivityInstansi;
import com.appsmor.restapirizaluardi.R;
import com.appsmor.restapirizaluardi.model.Instansi;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class InstansiAdapter extends
        RecyclerView.Adapter<InstansiAdapter.MyViewHolderInstansi>{
    List<Instansi> mInstansiList;
    public InstansiAdapter(List <Instansi> InstansiList) {
        mInstansiList = InstansiList;
    }
    @Override
    public MyViewHolderInstansi onCreateViewHolder (ViewGroup parent, int
            viewType){
        View mViewInstnansi = LayoutInflater.from(parent.getContext()).inflate(R.layout.instansi_list,parent, false);
        MyViewHolderInstansi mViewHolderInstansi = new MyViewHolderInstansi(mViewInstnansi);
        return mViewHolderInstansi;
    }
    @Override
    public void onBindViewHolder (MyViewHolderInstansi holder,final int
            position){
        holder.mTextViewIdInstansi.setText("Id = " + mInstansiList.get(position).getId());
        holder.mTextViewInstansi.setText("Instansi = " + mInstansiList.get(position).getInstansi());
        holder.mTextViewTelepon.setText("Telepon = " + mInstansiList.get(position).getTelepon());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntentInstansi = new Intent(view.getContext(), EditActivityInstansi.class);
                mIntentInstansi.putExtra("IdInstansi", mInstansiList.get(position).getId());
                mIntentInstansi.putExtra("Instansi", mInstansiList.get(position).getInstansi());
                mIntentInstansi.putExtra("Telepon", mInstansiList.get(position).getTelepon());
                view.getContext().startActivity(mIntentInstansi); }
        });
    }
    @Override
    public int getItemCount () {
        return mInstansiList.size();
    }
    public class MyViewHolderInstansi extends RecyclerView.ViewHolder {
        public TextView mTextViewIdInstansi, mTextViewInstansi, mTextViewTelepon;
        public MyViewHolderInstansi(View itemView) {
            super(itemView);
            mTextViewIdInstansi = (TextView) itemView.findViewById(R.id.tvIdInstansi);
            mTextViewInstansi = (TextView)
                    itemView.findViewById(R.id.tvInstansi);
            mTextViewTelepon = (TextView)
                    itemView.findViewById(R.id.tvTelepon);
        }
    }
}

package com.appsmor.restapirizaluardi.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.appsmor.restapirizaluardi.EditActivityAlamat;
import com.appsmor.restapirizaluardi.R;
import com.appsmor.restapirizaluardi.model.Alamat;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class AlamatAdapter extends RecyclerView.Adapter<AlamatAdapter.MyViewHolderAlamat>{
    List<Alamat> mAlamatList;
    public AlamatAdapter(List <Alamat> AlamatList) {
        mAlamatList = AlamatList;
    }
    @Override
    public MyViewHolderAlamat onCreateViewHolder (ViewGroup parent, int
            viewType){
        View mViewAlamat =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.alamat_list,parent, false);
        MyViewHolderAlamat myViewHolderAlamat = new MyViewHolderAlamat(mViewAlamat);
        return myViewHolderAlamat;
    }
    @Override
    public void onBindViewHolder (MyViewHolderAlamat holder,final int
            position){
        holder.mTextViewId.setText("Id = " + mAlamatList.get(position).getId());
        holder.mTextViewAlamat.setText("Alamat = " + mAlamatList.get(position).getAlamat());
        holder.mTextViewKodepos.setText("Kodepos = " + mAlamatList.get(position).getKodepos());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), EditActivityAlamat.class);
                mIntent.putExtra("Id", mAlamatList.get(position).getId());
                mIntent.putExtra("Alamat", mAlamatList.get(position).getAlamat());
                mIntent.putExtra("Kodepos", mAlamatList.get(position).getKodepos());
                view.getContext().startActivity(mIntent); }
        });
    }
    @Override
    public int getItemCount () {
        return mAlamatList.size();
    }
    public class MyViewHolderAlamat extends RecyclerView.ViewHolder {
        public TextView mTextViewId, mTextViewAlamat, mTextViewKodepos;
        public MyViewHolderAlamat(View itemView) {
            super(itemView);
            mTextViewId = (TextView) itemView.findViewById(R.id.tvIdAlamat);
            mTextViewAlamat = (TextView)
                    itemView.findViewById(R.id.tvAlamat);
            mTextViewKodepos = (TextView)
                    itemView.findViewById(R.id.tvKodepos);
        }
    }
}

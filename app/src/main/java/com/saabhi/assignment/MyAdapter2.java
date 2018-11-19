package com.saabhi.assignment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class MyAdapter2 extends RecyclerView.Adapter<MyHolder> {

        Context c;
        ArrayList<Workshop> workshops;


public MyAdapter2(Context c, ArrayList<Workshop> workshops) {
        this.c = c;
        this.workshops = workshops;

        }

@Override
public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.rcylv2,parent,false);
        MyHolder holder=new MyHolder(v);
        return holder;
        }

@Override
public void onBindViewHolder(MyHolder holder, int position) {
    holder.txtV1.setText(workshops.get(position).getName());
    holder.txtV2.setText(workshops.get(position).getCompany());
    holder.txtV3.setText(workshops.get(position).getLocation());
    holder.txtV4.setText(workshops.get(position).getFee());
    holder.txtV5.setText(workshops.get(position).getDescr());

}
    @Override
    public int getItemCount () {
        return workshops.size();
    }


}
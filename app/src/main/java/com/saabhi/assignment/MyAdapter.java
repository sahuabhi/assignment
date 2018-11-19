package com.saabhi.assignment;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class MyAdapter extends RecyclerView.Adapter<MyHolder> {

    Context c;
    ArrayList<Workshop> workshops;


    public MyAdapter(Context c, ArrayList<Workshop> workshops) {
        this.c = c;
        this.workshops = workshops;

    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_items,parent,false);
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

        holder.apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    Intent intent = new Intent(c, Dialog.class);

                    c.startActivity(intent);

            }

        });


    }

    @Override
    public int getItemCount() {
        return workshops.size();
    }


}
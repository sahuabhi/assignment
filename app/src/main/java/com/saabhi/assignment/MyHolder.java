package com.saabhi.assignment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MyHolder extends RecyclerView.ViewHolder {

    TextView txtV1,txtV2,txtV3,txtV4,txtV5;
    Button apply;

    public MyHolder(View itemView) {
        super(itemView);

        this.txtV1= (TextView) itemView.findViewById(R.id.textView1);
        this.txtV2= (TextView) itemView.findViewById(R.id.textView2);
        this.txtV3= (TextView) itemView.findViewById(R.id.textView3);
        this.txtV4= (TextView) itemView.findViewById(R.id.textView4);
        this.txtV5= (TextView) itemView.findViewById(R.id.textView5);
        this.apply=(Button)itemView.findViewById(R.id.buttonApply);
    }
}

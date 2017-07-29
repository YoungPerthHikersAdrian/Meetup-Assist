package com.journaldev.retrofitintro.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.journaldev.retrofitintro.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Created by aj_wi on 28/07/2017.
 */

//https://stackoverflow.com/questions/39971350/recycle-view-inflating-different-row-getting-exception-while-binding-the-data/39972276#39972276

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<String> mData = Collections.emptyList();
    private ArrayList<Boolean> mChkitems= new ArrayList<>();
    private Context mInflater;
    private ItemClickListener mClickListener;
    private String mlayout= null;
    CheckBox checkBox;
    private static final Boolean TYPE_Event = Boolean.FALSE;
    private static final Boolean TYPE_Attend = Boolean.TRUE;

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder0 extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView myTextView;
        public CheckBox chkbox;

        public ViewHolder0(View itemView) {
            super(itemView);
            myTextView = (TextView) itemView.findViewById(R.id.data);
            chkbox = (CheckBox) itemView.findViewById(R.id.CheckBox01);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());


        }
    }
    public class ViewHolder1 extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView myTextView;
        //public CheckBox chkbox;
        public ViewHolder1(View itemView) {
            super(itemView);
            myTextView = (TextView) itemView.findViewById(R.id.data);

            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());


        }

    }

    // inflates the row layout from xml when needed
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView;
        if (TYPE_Event){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout, parent, false);
            return new ViewHolder1(view);


        } else  {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.checkbox_layout, parent, false);
            return new ViewHolder0(view);

        }

    @Override
    public void onBindViewHolder( RecyclerView.ViewHolder holder,int position) {
        String animal = mData.get(position);
       // Boolean chkstat = mChkitems.get(position);
        //attend
        if(holder.getItemViewType() == 1){
            Boolean chkstat = mChkitems.get(position);

            ((ViewHolder0)holder).myTextView.setText((animal));
            ((ViewHolder0)holder).chkbox.setChecked((chkstat));



        }

        //event
        else {

        }



    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }

    // data is passed into the constructor
    public MyRecyclerViewAdapter(Context context, ArrayList<String> data, ArrayList chkbxpattern) {

        this.mInflater = context;
        this.mData = data;
        this.mChkitems = chkbxpattern;



    }


    // convenience method for getting data at click position
    public String getItem(int id) {
        return mData.get(id);
    }

    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
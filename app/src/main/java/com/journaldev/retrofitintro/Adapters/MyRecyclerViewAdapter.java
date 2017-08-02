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
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    CheckBox checkBox;
    public static final int NCROW =0;
    public static final int CHECKROW =1;
    private Integer mType;


    // data is passed into the constructor
    public MyRecyclerViewAdapter(Context context, List<String> data, ArrayList chkbxpattern, int VIEWTYPE) {

        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.mChkitems = chkbxpattern;
        this.mType = VIEWTYPE;


    }

    // inflates the row layout from xml when needed
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if(viewType == NCROW) {

            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout, parent, false);
            return new AlphaViewHolder(view);

        }else{
            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.checkbox_layout,parent,false);
            return new NumerViewHolder(view);
        }


    }

    // binds the data to the textview in each row



    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        String animal = mData.get(position);
        if(animal!= null){
            switch (mType){
                case NCROW:

                    //((AlphaViewHolder) holder).chkbox.setChecked(chkstat);
                    AlphaViewHolder vh1 = (AlphaViewHolder)holder;
                    vh1.myTextView.setText(animal);
                    break;
                case CHECKROW:
                    Boolean chkstat;
                    if(mChkitems.get(position)!= null) {
                        chkstat = mChkitems.get(position);
                        NumerViewHolder vh2 = (NumerViewHolder) holder;
                        vh2.myTextView1.setText(animal);
                        //((NumerViewHolder) holder).myTextView1.setText(animal);
                        vh2.chkbox1.setChecked(chkstat);
                        //((NumerViewHolder) holder).chkbox1.setChecked(chkstat);
                        break;
                    }

            }
        }

    }


    public int getViewTypeCount() {
        return 2;
    }
    @Override
    public int getItemViewType(int position) {
        // return a value between zero (inclusive) and the total item type count (exclusive)
        if (mType ==1) {
            return CHECKROW;
        }
        return NCROW;
    }

    // total number of rows
    @Override
    public int getItemCount() {
        if (mData == null) {
            return 0;

        }
        return mData.size();
    }

/*@Override
public int getItemViewType(int position) {
    if (mData != null) {
        String animal = mData.get(position);
        if (animal != null) {
            return 1;
        }
    }
        return 0;

}*/

    // stores and recycles views as they are scrolled off screen
    public class NumerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView myTextView1;
        public CheckBox chkbox1;
        public NumerViewHolder(View itemView) {
            super(itemView);
            myTextView1 = (TextView) itemView.findViewById(R.id.data1);
            chkbox1 = (CheckBox) itemView.findViewById(R.id.CheckBox01);
            itemView.setOnClickListener(NumerViewHolder.this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());

            //update pattern holder for checkboxes
/*            if(chkbox.isChecked()){
                mChkitems.add(getAdapterPosition(),Boolean.TRUE);

            } else{
                mChkitems.add(getAdapterPosition(),Boolean.FALSE);
            }*/
        }

    }

    public class AlphaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView myTextView;


        public AlphaViewHolder(View itemView) {
            super(itemView);
            myTextView = (TextView) itemView.findViewById(R.id.data);

            itemView.setOnClickListener(AlphaViewHolder.this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());

        }

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
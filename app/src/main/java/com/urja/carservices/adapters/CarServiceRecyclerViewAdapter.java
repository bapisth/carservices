package com.urja.carservices.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.urja.carservices.R;
import com.urja.carservices.models.Accessories;
import com.urja.carservices.models.DentPaint;
import com.urja.carservices.models.ServiceRepair;
import com.urja.carservices.models.TyreWheel;
import com.urja.carservices.models.WashDetailing;

import java.util.List;

/**
 * Created by florentchampigny on 24/04/15.
 */
public class CarServiceRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Object> contents;

    static final int TYPE_HEADER = 0;
    static final int TYPE_CELL = 1;
    private TextView mlargeDesc;
    private TextView mCode;
    private TextView mItemDesc;
    private CheckBox mCheckBox;
    private Context mContext;

    public CarServiceRecyclerViewAdapter(List<Object> contents, Context context) {
        this.contents = contents;
        this.mContext = context;
    }

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 0:
                return TYPE_HEADER;
            default:
                return TYPE_CELL;
        }
    }

    @Override
    public int getItemCount() {
        return contents.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;

        switch (viewType) {
            case TYPE_HEADER: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.list_item_card_big, parent, false);
                mlargeDesc = (TextView) view.findViewById(R.id.washDetailDesription);
                mlargeDesc.setText(mContext.getString(R.string.tab_wash_desc));
                mlargeDesc.setMovementMethod(new ScrollingMovementMethod());
                return new RecyclerView.ViewHolder(view) {
                };
            }
            case TYPE_CELL: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.list_item_card_small, parent, false);
                mCode = (TextView) view.findViewById(R.id.code);
                mItemDesc = (TextView) view.findViewById(R.id.item_desc);
                mCheckBox = (CheckBox) view.findViewById(R.id.washDetailCheckBox);
                return new RecyclerView.ViewHolder(view) {
                };
            }
        }
        return null;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case TYPE_HEADER:
                break;
            case TYPE_CELL:
                if (contents != null && contents.get(position) instanceof  WashDetailing){
                    WashDetailing washDetailing = (WashDetailing)contents.get(position);
                    mCode.setText(washDetailing.getCode());
                    mCheckBox.setText(washDetailing.getDesc());
                }else if (contents != null && contents.get(position) instanceof ServiceRepair){
                    ServiceRepair serviceRepair = (ServiceRepair)contents.get(position);
                    mCode.setText(serviceRepair.getCode());
                    mCheckBox.setText(serviceRepair.getDesc());
                }else if (contents != null && contents.get(position) instanceof TyreWheel){
                    TyreWheel tyreWheel = (TyreWheel)contents.get(position);
                    mCode.setText(tyreWheel.getCode());
                    mCheckBox.setText(tyreWheel.getDesc());
                }else if (contents != null && contents.get(position) instanceof DentPaint){
                    DentPaint dentPaint = (DentPaint)contents.get(position);
                    mCode.setText(dentPaint.getCode());
                    mCheckBox.setText(dentPaint.getDesc());
                }else if (contents != null && contents.get(position) instanceof Accessories){
                    Accessories accessories = (Accessories)contents.get(position);
                    mCode.setText(accessories.getCode());
                    mCheckBox.setText(accessories.getDesc());
                }
                break;
        }
    }
}
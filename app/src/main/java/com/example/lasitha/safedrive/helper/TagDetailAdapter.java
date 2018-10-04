package com.example.lasitha.safedrive.helper;

/*
 *  Created 01/10/2018 @09.26am
 *  RL Dilshan
 */

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.lasitha.safedrive.R;
import com.example.lasitha.safedrive.models.TagDetail;

import java.util.List;


public class TagDetailAdapter extends RecyclerView.Adapter<TagDetailAdapter.ViewHolder> {

    private List<TagDetail> tagsDetails;
    private Context mCtx;

    public TagDetailAdapter(Context mCtx,List<TagDetail> tagsDetails) {
        this.tagsDetails = tagsDetails;
        this.mCtx = mCtx;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mCtx)
                .inflate(R.layout.list_view_tags, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TagDetail tagDetail = tagsDetails.get(position);
        holder.tagID.setText(tagDetail.getTagId());
        holder.vehicleType.setText(tagDetail.getVehicleType());
        holder.speedLimit.setText(tagDetail.getSpeedLimit());
    }


    @Override
    public int getItemCount() {
        return tagsDetails.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tagID, vehicleType, speedLimit;
        public ImageButton edit, delete;

        public ViewHolder(View itemView) {
            super(itemView);

            tagID = itemView.findViewById(R.id.view_tag_id_tv);
            vehicleType = itemView.findViewById(R.id.view_vehicle_type_tv);
            speedLimit = itemView.findViewById(R.id.view_speed_limit_tv);
            edit = itemView.findViewById(R.id.view_edit_btn);
            delete = itemView.findViewById(R.id.view_delete_btn);
        }
    }
}
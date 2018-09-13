package com.example.ivan.viborbl2018;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.example.ivan.viborbl2018.R;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{
    private Context context;
private List<Device_id>device_id;
    public RecyclerAdapter(Context context,List<Device_id> device_id){
        this.device_id=device_id;
        this.context=context;
    }




    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.ViewHolder holder, int position) {
        holder.firstName.setText(device_id.get(position).getFirstname());
        holder.secondName.setText(device_id.get(position).getSecondname());
        holder.party.setText(device_id.get(position).getParty());
        holder.web.setText(device_id.get(position).getWeb());
        holder.votes.setText(device_id.get(position).getVotes());
    }

    @Override
    public int getItemCount() {
        return device_id.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView firstName, secondName, party, web, votes;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            firstName=(TextView)itemView.findViewById(R.id.firstName);
            secondName=(TextView)itemView.findViewById(R.id.secondName);
            party=(TextView)itemView.findViewById(R.id.party);
            web=(TextView)itemView.findViewById(R.id.web);
            votes=(TextView)itemView.findViewById(R.id.votes);

        }
    }
}


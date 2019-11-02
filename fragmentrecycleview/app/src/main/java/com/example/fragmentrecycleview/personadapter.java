package com.example.fragmentrecycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class personadapter extends RecyclerView.Adapter<personadapter.ViewHolder>{

    itemclicked activity;

    private ArrayList<person> people;


    public interface itemclicked{
        void onitemclick(int index);
    }


    public personadapter(Context context , ArrayList<person> list){

        this.people = list;
        this.activity=(itemclicked)context;

    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView tvname;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvname=itemView.findViewById(R.id.textView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    activity.onitemclick(people.indexOf((person)view.getTag()));
                }
            });

        }
    }

    @NonNull
    @Override
    public personadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull personadapter.ViewHolder holder, int position) {
  person p=people.get(position);
        holder.itemView.setTag(people.get(position));

        holder.tvname.setText(p.getName());


    }

    @Override
    public int getItemCount() {
        return people.size();
    }
}

package com.example.recyclerviewworking;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class person_adapter extends RecyclerView.Adapter<person_adapter.ViewHolder> {


    itemclicked activity;

    //specifies the no of items in the list
    private ArrayList<person> people ;

    public interface itemclicked{
        void onitemclicked(int index);
    }



    public person_adapter(MainActivity context, ArrayList<person> list){

        people=list;
        activity=(itemclicked) context;

    }



    //set connection to the layout list_items
    public class ViewHolder extends RecyclerView.ViewHolder
    {

        ImageView ivpref;
        TextView tvName;
        TextView tvSurname;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName=itemView.findViewById(R.id.tvname);
            tvSurname=itemView.findViewById(R.id.tvsurname);
            ivpref=itemView.findViewById(R.id.ivpreference);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    activity.onitemclicked(people.indexOf((person)view.getTag()));
                }
            });

        }
    }


    //passing the view of the layout list_items to the Viewholder
    @NonNull
    @Override
    public person_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items , parent,false);
        return new ViewHolder(v);
    }


    //loop till the no of items in arraylist
    //set tvname, tvsurname , ivpref for each object in array
    @Override
    public void onBindViewHolder(@NonNull person_adapter.ViewHolder holder, int position) {
        holder.itemView.setTag(people.get(position));

        holder.tvName.setText(people.get(position).getName());
        holder.tvSurname.setText(people.get(position).getSurname());

        if (people.get(position).getPreferences().equals("bus")) {

            holder.ivpref.setImageResource(R.drawable.bus);

        }else
        {
            holder.ivpref.setImageResource(R.drawable.plane);
        }


    }


    //get the count of objects in arraylist
    @Override
    public int getItemCount() {
        return people.size();
    }
}

package com.kharazmiuniversity.khu;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.kharazmiuniversity.khu.models.Group;

import java.util.List;

public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.ViewHolder>
{
    List<Group> items;
    private Context mContext;


    public GroupAdapter(List<Group> items, Context context)
    {
        this.items = items;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup viewGroup, int i)
    {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.template_objects, viewGroup , false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        holder.name.setText(items.get(position).getName());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                Intent groupChatIntent = new Intent(mContext,GroupChatActivity.class);

                mContext.startActivity(groupChatIntent);

            }
        });

    }

    @Override
    public int getItemCount()
    {
        return items.size();
    }





    class ViewHolder extends RecyclerView.ViewHolder
    {

        public TextView name;

        public ViewHolder(@NonNull final View itemView)
        {
            super(itemView);

            name = itemView.findViewById(R.id.name);

        }



    }
}

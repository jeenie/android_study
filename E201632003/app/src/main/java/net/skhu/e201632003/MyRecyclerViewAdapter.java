package net.skhu.e201632003;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {
    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener

    {
        TextView stuNumber, stuName;

        public ViewHolder(View view) {
            super(view);
            this.stuNumber = view.findViewById(R.id.stuNumber);
            this.stuName = view.findViewById(R.id.stuName);
            view.setOnClickListener(this);
        }

        public void setData() {
            Item item = arrayList.get(getAdapterPosition());
            stuNumber.setText(item.getStuNumber());
            stuName.setText(item.getStuName());
        }

        @Override
        public void onClick(View view) {
            int id = super.getAdapterPosition();
            Item item = arrayList.get(id);
            for (int i = arrayList.size() - 1; i >= 0; --i)
                if(item.getStuNumber().equals(arrayList.get(i).getStuNumber()))
                    arrayList.remove(i);
            notifyItemRemoved(getAdapterPosition());
            notifyItemRangeChanged(getAdapterPosition(), arrayList.size());
        }
    }

    LayoutInflater layoutInflater;
    ArrayList<Item> arrayList;

    public MyRecyclerViewAdapter(Context context, ArrayList<Item> arrayList) {
        this.layoutInflater = LayoutInflater.from(context);
        this.arrayList = arrayList;
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = layoutInflater.inflate(R.layout.item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int index) {
        viewHolder.setData();
    }
}


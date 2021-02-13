package com.aplicatie.listacumparaturi20;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter_class  extends RecyclerView.Adapter<Adapter_class.ViewHolder> {

    List<Model_class> products;
    Context context;
    DatabaseHelperClass databaseHelperClass;

    public Adapter_class(List<Model_class> products, Context context) {
        this.products = products;
        this.context = context;
        databaseHelperClass = new DatabaseHelperClass(context);
    }
// put data in item_layout
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_layout,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final Model_class model_class= products.get(position);


        holder.editText_Product.setText(model_class.getProduct());



        holder.button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelperClass.deleteProducts(model_class.getId());
                products.remove(position);
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
       CheckBox editText_Product;
        ImageButton button_delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            editText_Product = itemView.findViewById(R.id.checkBox);
            button_delete = itemView.findViewById(R.id.imageButtonDelete);


        }
    }
}

package com.reinaldoveazey.movieme;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by a2016951561 on 05/04/18.
 */

public class MyAdapter extends BaseAdapter {
    private ArrayList<Place> places; // lista que conterá os lugares a serem exibidos
    private Context context;

    public MyAdapter(Context context) {
        this.context = context;
        places = new ArrayList<>();

        //... carrega dados da lista

    }
    @Override
    public int getCount() {
        return this.places.size();
    }
    @Override
    public Object getItem(int i) {
        return this.places.get(i);
    }
    @Override
    public long getItemId(int i) {
        return i;
    }
    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        Place placeSelected = this.places.get(i);

        // recupera a view do adapter que será customizada
        View newView = LayoutInflater.from(this.context).inflate(R.layout.list_item_place, viewGroup, false);

        // recupera cada um dos campos do item
        ImageView foto = newView.findViewById(R.id.img_place_photo);
        TextView nome = newView.findViewById(R.id.txt_place_name);
        TextView desc = newView.findViewById(R.id.txt_place_description);
        RatingBar nota = newView.findViewById(R.id.nota);
        TextView dist = newView.findViewById(R.id.txt_place_distance);

        // define o valor de cada um dos campos
        foto.setImageResource(placeSelected.getPhotoId());
        nome.setText(placeSelected.getName());
        desc.setText(placeSelected.getDesc());
        nota.setRating(placeSelected.getRate().floatValue());
        dist.setText(placeSelected.getDistance().toString() + " KM");

        newView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Clicou no " + (i+1) + "°", Toast.LENGTH_SHORT).show();
            }
        });

        return newView;
    }

}
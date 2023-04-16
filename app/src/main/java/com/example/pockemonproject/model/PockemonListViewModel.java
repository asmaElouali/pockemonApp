package com.example.pockemonproject.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.net.URL;
import java.util.List;

import androidx.annotation.NonNull;

import com.example.pockemonproject.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class PockemonListViewModel extends ArrayAdapter<GitRepo> {
    private int resource;
    public PockemonListViewModel(@NonNull Context context, int resource, List<GitRepo> pokemons){
        super(context,resource,pokemons);
        this.resource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent){
        View listViewItem=convertView;
        if(listViewItem==null){
            listViewItem= LayoutInflater.from(getContext()).inflate(resource,parent,false);
        }
        CircleImageView imageViewPokemon=listViewItem.findViewById(R.id.imageViewPokemon);
        TextView textViewName=listViewItem.findViewById(R.id.textViewName);
        textViewName.setText(getItem(position).name);
        try {
            URL url=new URL("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+position+".png");
            Bitmap bitmap= BitmapFactory.decodeStream(url.openStream());
            imageViewPokemon.setImageBitmap(bitmap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //imageViewPokemon.setImageBitmap();
        return listViewItem;
    }

}

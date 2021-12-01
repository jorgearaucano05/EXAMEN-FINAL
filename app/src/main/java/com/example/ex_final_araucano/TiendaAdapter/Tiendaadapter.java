package com.example.ex_final_araucano.TiendaAdapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ex_final_araucano.Model.Tienda;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Tiendaadapter   {

    List<Tienda> classList;
    Context mContext;

    public Tiendaadapter(List<Tienda> classList, Context mContext) {
        this.classList = classList;
        this.mContext = mContext;
    }



}


package com.example.coderescue;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coderescue.Fragments.HomeFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.mongodb.stitch.android.services.mongodb.remote.RemoteFindIterable;
import com.mongodb.stitch.android.services.mongodb.remote.RemoteMongoClient;
import com.mongodb.stitch.android.services.mongodb.remote.RemoteMongoCollection;
import com.mongodb.stitch.core.services.mongodb.remote.RemoteInsertOneResult;
import com.mongodb.stitch.core.services.mongodb.remote.RemoteUpdateResult;

import org.bson.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

public class VictimHomeAdapter extends RecyclerView.Adapter<VictimHomeHolder>{

    Context c;
    public static RemoteMongoClient mongoClient;
    ArrayList<VictimHomeCardModel> models;

    public VictimHomeAdapter(Context c, ArrayList<VictimHomeCardModel> models) {
        this.c = c;
        this.models = models;
    }

    @NonNull
    @Override
    public VictimHomeHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.victim_home_card, null);
        view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));

        return new VictimHomeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VictimHomeHolder myHolder, int i) {
        String dis_id = models.get(i).getDescription();
        String lat = models.get(i).getLatitude();
        String longi = models.get(i).getLongitude();
        // String longi = models.get(i).getDescription();
        // String username = models.get(i).getRescueUsername();
        myHolder.mTitle.setText(models.get(i).getTitle());
        // myHolder.mDes.setText(models.get(i).getDescription());
        // System.out.println("jai shree ram2");

        //WHEN ITEM IS CLICKED
        myHolder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {


            }
        });

    }

    @Override
    public int getItemCount() {
        return models.size();
    }

}

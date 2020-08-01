package com.example.coderescue.Fragments;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coderescue.Activities.VictimHomeActivity;
import com.example.coderescue.Classes.NetworkConnectivity;
import com.example.coderescue.R;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.mongodb.stitch.android.services.mongodb.remote.RemoteFindIterable;
import com.mongodb.stitch.android.services.mongodb.remote.RemoteMongoClient;
import com.mongodb.stitch.android.services.mongodb.remote.RemoteMongoCollection;

import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

public class VictimHomeFragment extends Fragment {

    private Button snd, button_send_msg;

    public static RemoteMongoClient mongoClient;
    public String lat, longi;
    private static final int REQUEST_CODE_LOCATION_PERMISSION = 1;
    public String deviceid;
    private ProgressBar prog;
    public static String state;
    RecyclerView mRecyclerView;
    Context c;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_victim_home, container, false);
        deviceid = "temp";
        c = getActivity();

        prog = root.findViewById(R.id.progressBar2);
        snd = root.findViewById(R.id.snd_msg);
        button_send_msg = root.findViewById(R.id.button_send_msg);
        mRecyclerView = root.findViewById(R.id.recylcerView5);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return root;
    }


}

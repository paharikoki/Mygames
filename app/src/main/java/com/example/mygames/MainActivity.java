package com.example.mygames;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.mygames.API.APICall;
import com.example.mygames.API.RetroServer;
import com.example.mygames.Adapter.AdapterData;
import com.example.mygames.Model.DataModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvData;
    private RecyclerView.Adapter adData;
    private RecyclerView.LayoutManager lmData;
    private List<DataModel> modelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvData = findViewById(R.id.rv_data);
        lmData = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rvData.setLayoutManager(lmData);
        retrieveDataDetails();
    }

    public void retrieveDataDetails(){
        APICall ardData = RetroServer.konekRetrofit().create(APICall.class);
        Call<DataModel> dataModelCall = ardData.getGameDetails();

        dataModelCall.enqueue(new Callback<DataModel>() {
            @Override
            public void onResponse(Call<DataModel> call, Response<DataModel> response) {
                if (response.code() != 200){
                    Toast.makeText(MainActivity.this, "Check The Connections!", Toast.LENGTH_SHORT).show();
                    return;
                }
                adData = new AdapterData(modelList);
                rvData.setAdapter(adData);
                adData.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<DataModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Check The Connections!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
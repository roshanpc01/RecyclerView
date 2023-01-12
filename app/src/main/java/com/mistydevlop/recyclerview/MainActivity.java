package com.mistydevlop.recyclerview;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<ModelCostomer> modelCostomers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycer);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ModelCostomer modelCostomer = new ModelCostomer("Owner", "9876534567", R.drawable.i);
        modelCostomers.add(modelCostomer);
        modelCostomers.add(modelCostomer);
        modelCostomers.add(modelCostomer);
        modelCostomers.add(modelCostomer);
        modelCostomers.add(modelCostomer);
        modelCostomers.add(modelCostomer);
        modelCostomers.add(modelCostomer);
        modelCostomers.add(modelCostomer);
        modelCostomers.add(modelCostomer);
        modelCostomers.add(modelCostomer);


        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(this, modelCostomers);
        recyclerView.setAdapter(recyclerAdapter);


    }
}
package com.mistydevlop.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    FloatingActionButton fb;
    ArrayList<ModelCostomer> modelCostomers = new ArrayList<>();
  //  RecyclerAdapter recyclerAdapter;
    RecyclerAdapter recyclerAdapter = new RecyclerAdapter(this, modelCostomers);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycer);
        fb = findViewById(R.id.fb);
    fb.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Dialog dialog=new Dialog(MainActivity.this);
            dialog.setContentView(R.layout.costomlayout_dialog);
            EditText et1=dialog.findViewById(R.id.name);
            EditText et2=dialog.findViewById(R.id.number);
            Button btn=dialog.findViewById(R.id.button);
dialog.show();


btn.setOnClickListener(new View.OnClickListener()
{
    @Override
    public void onClick(View v) {
        String name="";
        String number="";
        if(!et1.getText().toString().equals("")&&!et2.getText().toString().equals(""))
        {
            name = et1.getText().toString();
            number = et2.getText().toString();


            modelCostomers.add(new ModelCostomer(name,number,R.drawable.a));
            recyclerAdapter.notifyItemInserted(modelCostomers.size()-1);
            recyclerView.scrollToPosition(modelCostomers.size()-1);
        }else
        {
            Toast.makeText(MainActivity.this, "is empty", Toast.LENGTH_SHORT).show();
        }

         dialog.dismiss();



    }
});











        }
    });












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
package com.mistydevlop.recyclerview;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    Context context;
    ArrayList<ModelCostomer> arrayList;

    public RecyclerAdapter(Context context, ArrayList<ModelCostomer> modelCostomers) {
        this.context = context;
        this.arrayList = modelCostomers;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.customerlayout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //   ModelCostomer costomer=(ModelCostomer) arrayList.get(position);
setanimation(holder.itemView,position);
        holder.img.setImageResource(arrayList.get(position).img);
        holder.textView1.setText(arrayList.get(position).name);
        holder.textView1.getText().toString();
        holder.textView2.setText(arrayList.get(position).number);
        holder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Dialog da = new Dialog(context);
                da.setContentView(R.layout.costomlayout_dialog);
                EditText et1 = da.findViewById(R.id.name);
                EditText et2 = da.findViewById(R.id.number);
                TextView tx = da.findViewById(R.id.text);
                Button btn = da.findViewById(R.id.button);
                et1.setText(arrayList.get(position).name);
                et2.setText(arrayList.get(position).number);
                tx.setText("Update memeber");
                btn.setText("update");
                da.show();
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name = "";
                        String number = "";
                        if (!et1.getText().toString().equals("") && !et2.getText().toString().equals("")) {
                            name = et1.getText().toString();
                            number = et2.getText().toString();


                            arrayList.set(position, new ModelCostomer(name, number, arrayList.get(position).img));
                            notifyItemChanged(position);

                        } else {
                            Toast.makeText(context, "is empty", Toast.LENGTH_SHORT).show();
                        }

                        da.dismiss();


                    }
                });


            }
        });
        holder.ll.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder al = new AlertDialog.Builder(context);
                al.setMessage("are u sure want to delete").
                        setTitle("delete?").setIcon(R.drawable.baseline_delete_24).
                        setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                arrayList.remove(position);
                                notifyItemRemoved(position);

                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });

                al.show();


                return true;


            }
        });


    }

    private void setanimation(View view,int position)
    {
        Animation slide= AnimationUtils.loadAnimation(context,android.R.anim.slide_in_left);
view.startAnimation(slide);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView1, textView2;
        ImageView img;
        LinearLayout ll;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView1 = itemView.findViewById(R.id.name);
            textView2 = itemView.findViewById(R.id.phone);
            img = itemView.findViewById(R.id.img);
            ll = itemView.findViewById(R.id.lll);


        }
    }


}

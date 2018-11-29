package com.example.src.smartpantry.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.src.smartpantry.R;
import com.example.src.smartpantry.pojos.Manager;

import java.util.List;

public class AdapterManager extends ArrayAdapter<Manager> {

    List<Manager>managerList;


    public AdapterManager(@NonNull Context context, int resource, @NonNull List<Manager> managerList) {
        super(context, resource, managerList);
        this.managerList=managerList;
    }
    public AdapterManager(Context context,List<Manager>managerList){
        super(context,0,0);

        this.managerList=managerList;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Nullable
    @Override
    public Manager getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public int getPosition(@Nullable Manager item) {
        return super.getPosition(item);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView = convertView;
        Context context = parent.getContext();

        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.detail_list_layout, parent, false);

        }

        TextView textfirst,textlast,textemail,textpas,textcontact,textcity,textstate,textcountry;
        textfirst=(TextView)itemView.findViewById(R.id.textFN);
        textlast=(TextView)itemView.findViewById(R.id.textLN);
        textemail=(TextView)itemView.findViewById(R.id.textEm);
        textpas=(TextView)itemView.findViewById(R.id.textPs);
        textcontact=(TextView)itemView.findViewById(R.id.textCn);
        textcity=(TextView)itemView.findViewById(R.id.textCity);
        textstate=(TextView)itemView.findViewById(R.id.textSt);
        textcountry=(TextView)itemView.findViewById(R.id.textcontry);

        Manager manager=new Manager();
//        manager=managerList.get(position);
        manager=getItem(position);
        String fn=manager.getManagerFirstName();
        textfirst.setText(fn);
        String ln=manager.getManagerLastName();
        textlast.setText(ln);
        String em= manager.getManagerEmailId();
        textemail.setText(em);
        String contact= manager.getManagerContact();
        textcontact.setText(contact);
        String city=manager.getManagerCity();
        textcity.setText(city);
        String st=manager.getManagerState();
        textstate.setText(st);
        String country= manager.getManagerCountry();
        textcountry.setText(country);

        return itemView;
    }
}



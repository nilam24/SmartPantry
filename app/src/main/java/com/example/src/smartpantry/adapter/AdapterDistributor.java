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
import com.example.src.smartpantry.pojos.Distributor;

import java.util.List;

public class AdapterDistributor extends ArrayAdapter<Distributor> {

    List<Distributor>distributorList;


    public AdapterDistributor(@NonNull Context context, int resource, @NonNull List<Distributor> distributorList) {
        super(context, resource, distributorList);
        this.distributorList=distributorList;
    }
    public AdapterDistributor(Context context, List<Distributor>distributorList){
        super(context,0,0);

        this.distributorList=distributorList;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Nullable
    @Override
    public Distributor getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public int getPosition(@Nullable Distributor item) {
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

        Distributor distributor=new Distributor();
//        manager=managerList.get(position);
        distributor=getItem(position);
        String fn=distributor.getDistributorFirstName();

        textfirst.setText(fn);
        String ln=distributor.getDistributorLastName();
        textlast.setText(ln);
        String em= distributor.getDistributorEmailId();
        textemail.setText(em);
        String contact= distributor.getDistributorContact();
        textcontact.setText(contact);
        String city=distributor.getDistributorCity();
        textcity.setText(city);
        String st=distributor.getDistributorState();
        textstate.setText(st);
        String country= distributor.getDistributorCountry();
        textcountry.setText(country);

        return itemView;
    }
}



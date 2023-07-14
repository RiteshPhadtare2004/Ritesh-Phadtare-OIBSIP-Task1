package com.example.unitconverter.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.unitconverter.MainActivity;
import com.example.unitconverter.R;


public class AreaFragment extends Fragment {

    String[] item1={"cm^2","m^2","km^2"};
    String[] item2={"cm^2","m^2","km^2"};
    AutoCompleteTextView autoCompleteTextView1,autoCompleteTextView2;
    ArrayAdapter<String> adapterItems1,adapterItems2;

    EditText fromText;
    TextView toText;
    ImageButton btnconvert,back;
    ImageView area;
    String fromArea=null,toArea=null;
    LinearLayout l2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_area, container, false);

        autoCompleteTextView1=view.findViewById(R.id.fromlist);
        adapterItems1=new ArrayAdapter<String>(getActivity().getApplication(),R.layout.list_item,item1);
        autoCompleteTextView1.setAdapter(adapterItems1);
        autoCompleteTextView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                fromArea= parent.getItemAtPosition(position).toString();
            }
        });

        autoCompleteTextView2=view.findViewById(R.id.tolist);
        adapterItems2=new ArrayAdapter<String>(getActivity().getApplication(),R.layout.list_item,item2);
        autoCompleteTextView2.setAdapter(adapterItems2);
        autoCompleteTextView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                toArea= parent.getItemAtPosition(position).toString();
            }
        });

        fromText=view.findViewById(R.id.from);
        toText=view.findViewById(R.id.to);
        btnconvert=view.findViewById(R.id.btnconvert);
        back=view.findViewById(R.id.back);
        area=view.findViewById(R.id.area);
        l2 =view.findViewById(R.id.l2);

        btnconvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double fromNum= Double.parseDouble(fromText.getText().toString());
                if(fromNum==0){
                    Toast.makeText(getActivity().getApplication(), "Enter from value", Toast.LENGTH_SHORT).show();
                }else if(fromArea==null){
                    Toast.makeText(getActivity().getApplication(), "Select Area from", Toast.LENGTH_SHORT).show();
                }else if(toArea==null){
                    Toast.makeText(getActivity().getApplication(), "Select Area to", Toast.LENGTH_SHORT).show();
                }else{
                    double num1=fromNum;
                    String a=fromArea;
                    String b=toArea;
                    toText=view.findViewById(R.id.to);
                    double ans = 0;
                    switch (a){
                        case "cm^2":
                            switch (b){
                                case "m^2":
                                    ans=(num1/10000);
                                    break;
                                case "km^2":
                                    ans=(num1/1e+10);
                                    break;
                                case "cm^2":
                                    ans=num1;
                                    break;
                            }
                            break;
                        case "m^2":
                            switch (b){
                                case "cm^2":
                                    ans=(num1*10000);
                                    break;
                                case "km^2":
                                    ans=(num1/1e+6);
                                    break;
                                case "m^2":
                                    ans=num1;
                                    break;
                            }
                            break;
                        case "km^2":
                            switch (b){
                                case "cm^2":
                                    ans=(num1*1e+10);
                                    break;
                                case "m^2":
                                    ans=(num1*1e+6);
                                    break;
                                case "km^2":
                                    ans=num1;
                                    break;
                            }
                            break;
                    }
                    String answer= String.valueOf(ans);
                    toText.setText(answer);

                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new LengthFragment());
            }
        });
        return view;
    }
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }




}
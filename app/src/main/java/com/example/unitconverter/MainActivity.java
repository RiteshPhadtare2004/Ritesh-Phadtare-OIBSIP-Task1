package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.unitconverter.Fragments.AreaFragment;
import com.example.unitconverter.Fragments.InfoFragment;
import com.example.unitconverter.Fragments.LengthFragment;
import com.example.unitconverter.Fragments.MassFragment;
import com.example.unitconverter.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ImageView btnarea,btnmass,infobtn;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        replaceFragment(new LengthFragment());
        btnarea=findViewById(R.id.btnarea);
        btnmass=findViewById(R.id.btnmass);
        infobtn=findViewById(R.id.infobtn);
        btnarea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new AreaFragment());
            }
        });
        btnmass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new MassFragment());
            }
        });
        infobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new InfoFragment());
            }
        });


    }
    public void ConvertLength(double num1,String a,String b){

    }
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }

}
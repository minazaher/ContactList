package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv_name, tv_number, contact_number, contact_name;
    Button btn_add;
    EditText et_name, et_number;
    RecviewFrag recviewFrag;
    FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_name = findViewById(R.id.tv_CName);
        tv_number = findViewById(R.id.tv_CNumber);
        et_name = findViewById(R.id.et_name);
        et_number = findViewById(R.id.et_number);
        btn_add = findViewById(R.id.btn_add);
        contact_name = findViewById(R.id.contact_name);
        contact_number = findViewById(R.id.contact_number);


        fragmentManager = this.getSupportFragmentManager();
        recviewFrag = (RecviewFrag) fragmentManager.findFragmentById(R.id.fragmentContainerView);


        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApplicationClass.contacts.add(new Contact(et_name.getText().toString().trim(), et_number.getText().toString().trim()));
                Toast.makeText(MainActivity.this, "Added Successfully", Toast.LENGTH_SHORT).show();
                et_name.setText(null);
                et_number.setText(null);
                System.out.println(ApplicationClass.contacts.toString());
                recviewFrag.notifyData();
            }
        });
    }
}
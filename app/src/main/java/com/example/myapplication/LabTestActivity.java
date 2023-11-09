package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class LabTestActivity extends AppCompatActivity {
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    Button btnGoToCart;
    ImageView btnBack;
    ListView listView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);

        btnGoToCart = findViewById(R.id.buttonGoToCart2);
        btnBack = findViewById(R.id.imageButtonLTBack);
        listView = findViewById(R.id.listViewLT);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LabTestActivity.this, HomeActivity.class));
            }
        });
        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LabTestActivity.this, CartLabActivity.class));
            }
        });



        list = new ArrayList();
        for (int i = 0; i < packages.length; i++) {
            item = new HashMap<String,String>();
            item.put("line 1",packages[i][0]);
            item.put("line 2",packages[i][1]);
            item.put("line 3",packages[i][2]);
            item.put("line 4",packages[i][3]);
            item.put("line 5","Total Cost: "+packages[i][4]+"/-");
            list.add(item);
        }

        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[] {"line 1","line 2","line 3","line 4","line 5"},
                new int[] {R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
                );
        listView.setAdapter(sa);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(LabTestActivity.this, LabTestDetailsActivity.class);
                it.putExtra("text1",packages[i][0]);
                it.putExtra("text2",package_details[i]);
                it.putExtra("text3",packages[i][4]);
                startActivity(it);
            }
        });
    }

    private String[][] packages =
            {
                    {"package 1 : Full Body Checkup","","","","999"},
                    {"package 2 : Blood Glucose Fasting","","","","299"},
                    {"package 3 : COVID-19 Antibody","","","","899"},
                    {"package 4 : Thyroid Check","","","","499"},
                    {"package 5 : Immunity Check","","","","699"}
            };

    private String[] package_details =
            {
                    "Blood Glucose Fasting\n" +
                            " Complete Hemogram\n" +
                            "HbA1c\n" +
                            " Iron Studies\n" +
                            "Kideny Function Test\n" +
                            "LDH Lactate Dehydrogenase, Serum\n" +
                            "Lipid Profile\n" +
                            "Liver Function Test",
                    "Blood Glucose Fasting",
                    "COVID-19 Antibody",
                    "Thyroid Profile-Total (T3, T4 & TSH Ultra-sensitive)",
                    "Complete Hemogram\n" +
                            "CRP (C Reactive Protein) Quantitative, Serum\n" +
                            " Iron Studies\n" +
                            "Kidney Function Test\n" +
                            "Vitamin D Total-25 Hydroxy\n" +
                            "Liver Function Test\n" +
                            "Lipid Profile"
            };

}

package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class ActivityDoctorDetails extends AppCompatActivity {
    private String doctor_details_1[][] = {
            {"Doctor name : Dr. Priya Sharma","Hospital : ABC Hospital","Experience : 10 years","Email : priyasharma@gmail.com","Visiting Fee : Rs. 800"},
            {"Doctor name : Dr. Rajesh Kapoor","Hospital : XYZ Medical Center","Experience : 15 years","Email : rajesh.kapoor@xyzmedical.com","Visiting Fee : Rs. 750"},
            {"Doctor name : Dr. Anjali Gupta","Hospital : XYZ Medical Center","Experience : 10 years","Email : priyasharma@gmail.com","Visiting Fee : Rs. 800"},
            {"Doctor name : Dr. Meenakshi Reddy","Hospital : XYZ Medical Center","Experience : 10 years","Email : priyasharma@gmail.com","Visiting Fee : Rs. 800"},
            {"Doctor name : Dr. Sanjay Verma","Hospital : XYZ Medical Center","Experience : 10 years","Email : priyasharma@gmail.com","Visiting Fee : Rs. 800"}
    };

    private String doctor_details_2[][] = {
            {"Doctor name : Dr. Priya Sharma","Hospital : ABC Hospital","Experience : 10 years","Email : priyasharma@gmail.com","Visiting Fee : Rs. 800"},
            {"Doctor name : Dr. Rajesh Kapoor","Hospital : XYZ Medical Center","Experience : 15 years","Email : rajesh.kapoor@xyzmedical.com","Visiting Fee : Rs. 750"},
            {"Doctor name : Dr. Anjali Gupta","Hospital : XYZ Medical Center","Experience : 10 years","Email : priyasharma@gmail.com","Visiting Fee : Rs. 800"},
            {"Doctor name : Dr. Meenakshi Reddy","Hospital : XYZ Medical Center","Experience : 10 years","Email : priyasharma@gmail.com","Visiting Fee : Rs. 800"},
            {"Doctor name : Dr. Sanjay Verma","Hospital : XYZ Medical Center","Experience : 10 years","Email : priyasharma@gmail.com","Visiting Fee : Rs. 800"}
    };

    private String doctor_details_3[][] = {
            {"Doctor name : Dr. Riya Sharma","Hospital : ABC Hospital","Experience : 10 years","Email : priyasharma@gmail.com","Visiting Fee : Rs. 800"},
            {"Doctor name : Dr. Rajesh Kapoor","Hospital : XYZ Medical Center","Experience : 15 years","Email : rajesh.kapoor@xyzmedical.com","Visiting Fee : Rs. 750"},
            {"Doctor name : Dr. Anjali Gupta","Hospital : XYZ Medical Center","Experience : 10 years","Email : priyasharma@gmail.com","Visiting Fee : Rs. 800"},
            {"Doctor name : Dr. Meenakshi Reddy","Hospital : XYZ Medical Center","Experience : 10 years","Email : priyasharma@gmail.com","Visiting Fee : Rs. 800"},
            {"Doctor name : Dr. Sanjay Verma","Hospital : XYZ Medical Center","Experience : 10 years","Email : priyasharma@gmail.com","Visiting Fee : Rs. 800"}
    };

    private String doctor_details_4[][] = {
            {"Doctor name : Dr. Priya Sharma","Hospital : ABC Hospital","Experience : 10 years","Email : priyasharma@gmail.com","Visiting Fee : Rs. 800"},
            {"Doctor name : Dr. Rajesh Kapoor","Hospital : XYZ Medical Center","Experience : 15 years","Email : rajesh.kapoor@xyzmedical.com","Visiting Fee : Rs. 750"},
            {"Doctor name : Dr. Anjali Gupta","Hospital : XYZ Medical Center","Experience : 10 years","Email : priyasharma@gmail.com","Visiting Fee : Rs. 800"},
            {"Doctor name : Dr. Meenakshi Reddy","Hospital : XYZ Medical Center","Experience : 10 years","Email : priyasharma@gmail.com","Visiting Fee : Rs. 800"},
            {"Doctor name : Dr. Sanjay Verma","Hospital : XYZ Medical Center","Experience : 10 years","Email : priyasharma@gmail.com","Visiting Fee : Rs. 800"}
    };

    private String doctor_details_5[][] = {
            {"Doctor name : Dr. Priya Sharma","Hospital : ABC Hospital","Experience : 10 years","Email : priyasharma@gmail.com","Visiting Fee : Rs. 800"},
            {"Doctor name : Dr. Rajesh Kapoor","Hospital : XYZ Medical Center","Experience : 15 years","Email : rajesh.kapoor@xyzmedical.com","Visiting Fee : Rs. 750"},
            {"Doctor name : Dr. Anjali Gupta","Hospital : XYZ Medical Center","Experience : 10 years","Email : priyasharma@gmail.com","Visiting Fee : Rs. 800"},
            {"Doctor name : Dr. Meenakshi Reddy","Hospital : XYZ Medical Center","Experience : 10 years","Email : priyasharma@gmail.com","Visiting Fee : Rs. 800"},
            {"Doctor name : Dr. Sanjay Verma","Hospital : XYZ Medical Center","Experience : 10 years","Email : priyasharma@gmail.com","Visiting Fee : Rs. 800"}
    };

    String[][] doctor_details = {};
    ArrayList List;
    TextView tv;
//    ImageView imgback;
    SimpleAdapter sa;
    HashMap<String,String> item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        TextView displayHeadingTextView = findViewById(R.id.textViewLocation);
        ImageView img = findViewById(R.id.imageButtonLTBack);
        // Get the title from the Intent
        Intent intent = getIntent();
        String title = intent.getStringExtra("Title");
        displayHeadingTextView.setText(title);

        // Retrieve the corresponding doctor details based on the title
        if (title.equals("Family Physician")) {
            doctor_details= doctor_details_1;
        } else if (title.equals("Dietician")) {
            doctor_details = doctor_details_2;
        } else if (title.equals("Dentist")) {
            doctor_details = doctor_details_3;
        } else if (title.equals("Surgeon")) {
            doctor_details = doctor_details_4;
        } else if (title.equals("Cardiologist")) {
            doctor_details = doctor_details_5;
        }

        ArrayList<HashMap<String, String>> list = new ArrayList<>();

        for (int i = 0; i<doctor_details.length; i++) {
            HashMap<String, String> item = new HashMap<>();
            item.put("line 1", doctor_details_1[i][0]);
            item.put("line 2", doctor_details_2[i][1]);
            item.put("line 3", doctor_details_3[i][2]);
            item.put("line 4", doctor_details_4[i][3]);
            item.put("line 5", "Consultation Fee: " + doctor_details_5[i][4]);
            list.add(item);
        }



        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityDoctorDetails.this, FindDoctorActivity.class);
                startActivity(intent);


            }
        });

        SimpleAdapter sa = new SimpleAdapter(
                this,
                list,
                R.layout.multi_lines,
                new String[] {"line 1", "line 2", "line 3", "line 4", "line 5"},
                new int[] {R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e}
        );

        ListView lst = findViewById(R.id.listViewLT);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(ActivityDoctorDetails.this, BookAppointmentActivity.class);

                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });


    }
}

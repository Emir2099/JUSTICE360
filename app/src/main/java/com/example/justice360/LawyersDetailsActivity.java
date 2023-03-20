package com.example.justice360;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class LawyersDetailsActivity extends AppCompatActivity {

    private String[][] lawyer_details1 =
            {
                    {"Lawyer Name : Binny Bhatia", "Chamber Address : Nala Supara, Maharashtra", "Exp : 5 years", "Mobile Number : 1000000000","600"},
                    {"Lawyer Name : Timothy Gupta", "Chamber Address : Colava,Goa", "Exp : 7 years", "Mobile Number : 2000000000","900"},
                    {"Lawyer Name : Alex Bhati", "Chamber Address : Babua, Bihar", "Exp : 3 years", "Mobile Number : 3000000000","300"},
                    {"Lawyer Name : Binny Bhatia", "Chamber Address : Panoti, UttarPradesh", "Experience : 4 years", "Mobile Number : 4000000000","500"},
                    {"Lawyer Name : Jasmine Acharya", "Chamber Address : Lapataganj, WestBengal", "Exp : 9 years", "Mobile Number : 5000000000","800"},
            };

    private String[][] lawyer_details2 =
            {
                    {"Lawyer Name : Binny Bhatia", "Chamber Address : Nala Supara, Maharashtra", "Exp : 5 years", "Mobile Number : 1000000000","600"},
                    {"Lawyer Name : Timothy Gupta", "Chamber Address : Colava,Goa", "Exp : 7 years", "Mobile Number : 2000000000","900"},
                    {"Lawyer Name : Alex Bhati", "Chamber Address : Babua, Bihar", "Exp : 3 years", "Mobile Number : 3000000000","300"},
                    {"Lawyer Name : Binny Bhatia", "Chamber Address : Panoti, UttarPradesh", "Exp : 4 years", "Mobile Number : 4000000000","500"},
                    {"Lawyer Name : Jasmine Acharya", "Chamber Address : Lapataganj, WestBengal", "Exp : 9 years", "Mobile Number : 5000000000","800"},
            };

    private String[][] lawyer_details3 =
            {
                    {"Lawyer Name : Binny Bhatia", "Chamber Address : Nala Supara, Maharashtra", "Exp : 5 years", "Mobile Number : 1000000000","600"},
                    {"Lawyer Name : Timothy Gupta", "Chamber Address : Colava,Goa", "Exp : 7 years", "Mobile Number : 2000000000","900"},
                    {"Lawyer Name : Alex Bhati", "Chamber Address : Babua, Bihar", "Exp : 3 years", "Mobile Number : 3000000000","300"},
                    {"Lawyer Name : Binny Bhatia", "Chamber Address : Panoti, UttarPradesh", "Exp : 4 years", "Mobile Number : 4000000000","500"},
                    {"Lawyer Name : Jasmine Acharya", "Chamber Address : Lapataganj, WestBengal", "Exp : 9 years", "Mobile Number : 5000000000","800"},
            };

    TextView tv;
    Button btn;
    String[][] lawyer_details = {};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lawyers_details);

        tv = findViewById(R.id.subtitleAD);
        btn = findViewById(R.id.buttonAD);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Litigators")==0)
            lawyer_details = lawyer_details1;
        else
        if(title.compareTo("Criminal Defense Lawyers")==0)
            lawyer_details = lawyer_details2;
        else
            lawyer_details = lawyer_details3;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LawyersDetailsActivity.this,FindLawyersActivity.class));
            }
        });

        list = new ArrayList();
        for(int i = 0;i<lawyer_details.length;i++){
            item = new HashMap<String,String>();
            item.put( "line1",lawyer_details[i][0]);
            item.put( "line2",lawyer_details[i][1]);
            item.put( "line3",lawyer_details[i][2]);
            item.put( "line4",lawyer_details[i][3]);
            item.put( "line5","Consultancy Fees:"+"Rs."+lawyer_details[i][4]);
            list.add(item);
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
        );
     ListView lst = findViewById(R.id.ListViewAD);
     lst.setAdapter(sa);

     lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
         @Override
         public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
             Intent it = new Intent(LawyersDetailsActivity.this, BookAppointmentActivity.class);
             it.putExtra("text1",title);
             it.putExtra("text2",lawyer_details[i][0]);
             it.putExtra("text3",lawyer_details[i][1]);
             it.putExtra("text4",lawyer_details[i][3]);
             it.putExtra("text5",lawyer_details[i][4]);
             startActivity(it);
         }
     });
    }
}
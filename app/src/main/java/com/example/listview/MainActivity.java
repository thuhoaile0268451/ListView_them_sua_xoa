package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String gioitinh;
    int vitri;
    private Object Adaptertt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //anh xa
        EditText edten=findViewById(R.id.edten);
        Spinner spiner = findViewById(R.id.spinner);
        ListView lv = findViewById(R.id.lv);
        Button btnthem, btnxoa, btnsua;
        btnsua=findViewById(R.id.btnsua);
        btnthem=findViewById(R.id.btnthem);
        btnxoa=findViewById(R.id.btnxoa);


        ArrayList<String> ar=new ArrayList<>();
        ar.add("Nam");
        ar.add("Nu");
        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_spinner_dropdown_item,ar);
        spiner.setAdapter(arrayAdapter);
        //lay gia tri gioi tinh dang duoc chon
        spiner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                gioitinh=ar.get(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayList<ThongTin> dsthongtin = new ArrayList<>();
        Adaptertt adaptertt = new Adaptertt(dsthongtin);
        lv.setAdapter(adaptertt);

        //them
        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dsthongtin.add(new ThongTin(edten.getText().toString(), gioitinh));
                adaptertt.notifyDataSetChanged();

            }
        });
        //lay vi tri view dang duoc chon
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                vitri=i;
            }
        });
        //xoa
        btnxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            dsthongtin.remove(vitri);
            adaptertt.notifyDataSetChanged();//cap nhat lai listview
            }
        });
        //sua
        btnsua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dsthongtin.set(vitri, new ThongTin(edten.getText().toString(), gioitinh));
                adaptertt.notifyDataSetChanged();
            }
        });

    }
}
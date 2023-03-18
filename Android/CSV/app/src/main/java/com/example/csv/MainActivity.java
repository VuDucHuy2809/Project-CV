package com.example.csv;

import androidx.appcompat.app.AppCompatActivity;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileReader;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String DATE_FORMAT = "dd/MM/yyyy";
    private static final String TIME_FORMAT_12 = "hh:mm:ss a";
    private static final String TIME_FORMAT_24 = "HH:mm:ss";
    Button btnStorage, btnResource, btnSave;
    ListView lst;
    List<ItemData> items;
    DataAdapter adapter;
    Boolean isRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStorage = (Button) findViewById(R.id.btnStorage);
        btnResource = (Button) findViewById(R.id.btnRes);
        btnSave = (Button) findViewById(R.id.btnSave);
        lst = (ListView) findViewById(R.id.lst);
        isRes = true;
        items = prepareData();
        adapter = new DataAdapter(this, R.layout.list_item, items);
        lst.setAdapter(adapter);

        btnStorage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isRes = false;
                items = loadFile();
                adapter = new DataAdapter(v.getContext(), R.layout.list_item, items);
                lst.setAdapter(adapter);
            }
        });

        btnResource.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isRes = true;
                items = prepareData();
                adapter = new DataAdapter(v.getContext(), R.layout.list_item, items);
                lst.setAdapter(adapter);
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                kiemDien(view, position);
            }
        });

    }

    private List<ItemData> prepareData() {
        InputStream is = getResources().openRawResource(R.raw.data);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is,
                Charset.forName("UTF-8")));
        CSVReader csvReader = new CSVReader(reader);
        ArrayList<ItemData> lstItems = new ArrayList<>();
        String[] nextLine;
        try {
            while ((nextLine = csvReader.readNext()) != null) {
                // nextLine[] is an array of values from the line
                if (nextLine.length != 6)
                    continue;
                ItemData item = new ItemData(nextLine[0], nextLine[1], nextLine[2],
                        nextLine[3], nextLine[4], nextLine[5]);
                lstItems.add(item);
            }
        } catch (IOException e) {
            //e.printStackTrace();
            Toast.makeText(this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
        }
        return lstItems;
    }

    private List<ItemData> loadFile() {
        File csvfile;
        BufferedReader reader;
        CSVReader csvReader;
        ArrayList<ItemData> lstItems = new ArrayList<>();

        String[] nextLine;
        try {
            csvfile = new File(this.getFilesDir().getAbsolutePath() + "/data.csv");
            FileInputStream fis = new FileInputStream(csvfile);
            reader = new BufferedReader(new InputStreamReader(fis, Charset.forName("UTF-8")));
            csvReader = new CSVReader(reader);

            while ((nextLine = csvReader.readNext()) != null) {
                // nextLine[] is an array of values from the line
                if (nextLine.length != 6)
                    continue;
                ItemData item = new ItemData(nextLine[0], nextLine[1], nextLine[2],
                        nextLine[3], nextLine[4], nextLine[5]);
                lstItems.add(item);
            }
        }
        catch(IOException e) {
        //e.printStackTrace();
            Toast.makeText(this, e.getCause().toString() + ": " + e.getMessage().toString(), Toast.LENGTH_SHORT).show();
        }
        return lstItems;
    }

    private void kiemDien(View view, int position) {
        Date d = new Date();
        items.get(position).ngay = (new SimpleDateFormat(DATE_FORMAT)).format(d);
        items.get(position).gio = (new SimpleDateFormat(TIME_FORMAT_24)).format(d);
        lst.setAdapter(adapter);
    }

    private void saveData() {
        try {
            if (isRes == true) {
                Toast.makeText(this, "Resource không thể ghi khi trong run-time", Toast.LENGTH_SHORT).show();
            }
            else {
                CSVWriter csvWriter = new CSVWriter(new OutputStreamWriter(
                    new FileOutputStream(this.getFilesDir().getAbsolutePath() + "/data.csv"), "UTF-8"));
                for (ItemData item : items) {
                    String[] line = new String[]{item.maso, item.mavach, item.holot, item.ten, item.ngay, item.gio};
                    csvWriter.writeNext(line);
                }
                csvWriter.close();
                Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
            }
        }
        catch (IOException e) {
            Toast.makeText(this, e.getCause().toString() + ": " + e.getMessage().toString(), Toast.LENGTH_SHORT).show();
        }
    }

}

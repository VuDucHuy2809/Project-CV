package com.example.thanhnguyen.currencyconversion;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.Configuration;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.thanhnguyen.adapter.CurrencyAdapter;
import com.example.thanhnguyen.model.Currency;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvCurrrency;
    ArrayList<Currency> arrCurrency;
    CurrencyAdapter currencyAdapter;

    //Source
    Spinner spSource;
    ArrayList<String> arrCurrencySource;
    ArrayAdapter<String> adapterCurrencySource;
    //Destination
    Spinner spDestination;
    ArrayList<String> arrCurrencyDestination;
    ArrayAdapter<String> adapterCurrencyDestination;

    Button btnConvert;
    EditText txtResource, txtDestination;

    //Tạo Dialog đợi load dữ liệu khi có mạng
    ProgressDialog progressDialog;


    // Index
    int indexResource = 0, indexDestination = 0;

    //Setting database sqlite
    String DATABASE_NAME = "dbCurrency.sqlite";
    String DB_PATH_SUFFIX="/databases/";
    SQLiteDatabase database = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        processCopyDatabaseFromAssetIntoSystem();

        addControls();
        addEvents();

        if(isInternetWorking())
        {
            CurrencyTask task = new CurrencyTask();
            task.execute();
        }
        else{
            Toast.makeText(this, "Thiết bị chưa được kết nối Internet.", Toast.LENGTH_SHORT).show();
            SQLiteDatabase database = openOrCreateDatabase("dbCurrency.sqlite", MODE_PRIVATE, null);
            Cursor cursor =database.rawQuery("select * from Currency", new String[]{});
            while (cursor.moveToNext())
            {
                Currency currency = new Currency();
                currency.setType(cursor.getString(2));
                currency.setPrice(String.valueOf(cursor.getFloat(3)));
                byte[] byteArray = cursor.getBlob(1);
                currency.setBitmap(BitmapFactory.decodeByteArray(byteArray, 0 ,byteArray.length));
                arrCurrency.add(currency);
                arrCurrencySource.add(currency.getType());
                arrCurrencyDestination.add(currency.getType());
            }
            currencyAdapter.addAll(arrCurrency);
            //currencyAdapter.notifyDataSetChanged();
        }
    }

    public boolean isInternetWorking() {
        boolean connected = false;
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //we are connected to a network
            connected = true;
        }
        else
            connected = false;
        return connected;
    }

    private void processCopyDatabaseFromAssetIntoSystem() {
        //Kiểm tra hệ thống tồn tại database chưa.
        File dbFile = getDatabasePath(DATABASE_NAME);
        if(!dbFile.exists()){
            try{
                copyDatabaseFromAsset();
            }
            catch (Exception ex){
                Log.e("ERROR", ex.toString());
            }
        }
    }

    private void copyDatabaseFromAsset() {
        try{
            InputStream inputStream = getAssets().open(DATABASE_NAME);
            //Đường dẫn cần trữ database
            String outputFileName = getApplicationInfo().dataDir + DB_PATH_SUFFIX + DATABASE_NAME;
            File f = new File(getApplicationInfo().dataDir + DB_PATH_SUFFIX);
            //Kiểm tra đường dẫn tồn tại chưa.
            if(!f.exists())
            {
                f.mkdir();
            }
            //Cơ sở dữ liệu được tạo là rỗng
            OutputStream outputStream = new FileOutputStream(outputFileName);
            //Di chuyển byte
            byte[]buffer = new byte[1024];
            int length;
            while ((length=inputStream.read(buffer))>0)
            {
                outputStream.write(buffer,0, length);
            }
            outputStream.flush();
            outputStream.close();
            inputStream.close();
        }
        catch (Exception ex){
            Log.e("ERROR_COPY", ex.toString());
        }
    }

    private void addEvents() {
        spSource.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                indexResource = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spDestination.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                indexDestination = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtResource.getText().toString().equals(""))
                    return;
                if(indexDestination == 0)
                {
                    if(indexResource==0)
                        txtDestination.setText(txtResource.getText());
                    else{
                        float unit = Float.parseFloat(arrCurrency.get(indexResource-1).getPrice());
                        float result = unit * Float.parseFloat(txtResource.getText().toString());
                        txtDestination.setText(Float.toString(result));
                    }
                }
                if(indexResource==0 && indexDestination!=0)
                {
                    float unit = 1.0f/ Float.parseFloat(arrCurrency.get(indexDestination-1).getPrice());
                    float result = unit * Float.parseFloat(txtResource.getText().toString());
                    txtDestination.setText(Float.toString(result));
                }
                if(indexResource!=0&&indexDestination!=0)
                {
                    float unit = Float.parseFloat(arrCurrency.get(indexResource-1).getPrice())/
                            Float.parseFloat(arrCurrency.get(indexDestination-1).getPrice());
                    float result = unit* Float.parseFloat(txtResource.getText().toString());
                    txtDestination.setText(Float.toString(result));
                }
            }
        });
    }

    private void addControls() {
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setTitle("Thông báo");
        progressDialog.setMessage("Đang tải dữ liệu, vui lòng chờ ...");
        progressDialog.setCanceledOnTouchOutside(false);

        lvCurrrency = (ListView) findViewById(R.id.lvCurrrency);
        arrCurrency = new ArrayList<>();
        currencyAdapter = new CurrencyAdapter(MainActivity.this, R.layout.item, arrCurrency);
        lvCurrrency.setAdapter(currencyAdapter);

        btnConvert = (Button) findViewById(R.id.btnConvert);
        txtResource = (EditText) findViewById(R.id.txtResource);
        txtDestination = (EditText) findViewById(R.id.txtDestination);

        spSource = (Spinner) findViewById(R.id.spSource);
        spDestination = (Spinner) findViewById(R.id.spDestination);
        arrCurrencySource = new ArrayList<>();
        arrCurrencySource.add("VND");
        adapterCurrencySource = new ArrayAdapter<String>
                (MainActivity.this,android.R.layout.simple_spinner_item, arrCurrencySource);
        adapterCurrencySource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spSource.setAdapter(adapterCurrencySource);

        arrCurrencyDestination = new ArrayList<>();
        arrCurrencyDestination.add("VND");
        adapterCurrencyDestination = new ArrayAdapter<String>
                (MainActivity.this,android.R.layout.simple_spinner_item, arrCurrencyDestination);
        adapterCurrencyDestination.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spDestination.setAdapter(adapterCurrencyDestination);

    }

    class CurrencyTask extends AsyncTask<Void, Void, ArrayList<Currency>>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            currencyAdapter.clear();
            progressDialog.show();
        }

        @Override
        protected void onPostExecute(ArrayList<Currency> currencies) {
            super.onPostExecute(currencies);
            currencyAdapter.clear();
            //currencyAdapter.addAll(currencies);
            /*
            Tương tác với cơ sở dữ liệu
             */
            SQLiteDatabase database = openOrCreateDatabase("dbCurrency.sqlite", MODE_PRIVATE, null);
            Cursor cursor =database.rawQuery("select count(*) as count from Currency", new String[]{});
            int count = 0;
            while (cursor.moveToNext())
            {
                count=Integer.parseInt(cursor.getString(0));
            }
            //Toast.makeText(MainActivity.this, "" + count, Toast.LENGTH_SHORT).show();
            if(count==0)
                insertCurrency(currencies,database);
            else
                updateCurrency(currencies, database);
            // Load data
            cursor =database.rawQuery("select * from Currency", new String[]{});
            while (cursor.moveToNext())
            {
                Currency currency = new Currency();
                currency.setType(cursor.getString(2));
                currency.setPrice(String.valueOf(cursor.getFloat(3)));
                byte[] byteArray = cursor.getBlob(1);
                currency.setBitmap(BitmapFactory.decodeByteArray(byteArray, 0 ,byteArray.length));
                arrCurrency.add(currency);
                arrCurrencySource.add(currency.getType());
                arrCurrencyDestination.add(currency.getType());
            }
            currencyAdapter.addAll(arrCurrency);




            progressDialog.dismiss();
        }


        /*
        Xử lý lần đầu get data
         */
        private void insertCurrency(ArrayList<Currency> currencies, SQLiteDatabase database) {
            for(int i = 0;i<currencies.size();i++)
            {
                ContentValues  contentValues = new ContentValues();
                contentValues.put("type",currencies.get(i).getType());
                contentValues.put("rate", Float.parseFloat(currencies.get(i).getPrice()));
                contentValues.put("flag", getBitmapAsByteArray(currencies.get(i).getBitmap()));
                database.insert("Currency",null, contentValues);
            }
        }
        public byte[] getBitmapAsByteArray(Bitmap bitmap) {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 0, outputStream);
            return outputStream.toByteArray();
        }

        /*
        Upload data khi co internet
         */
        private void updateCurrency(ArrayList<Currency> currencies, SQLiteDatabase database) {
            for(int i = 0;i<currencies.size();i++){
                ContentValues  contentValues = new ContentValues();
                contentValues.put("rate", Float.parseFloat(currencies.get(i).getPrice()));
                database.update("Currency", contentValues,"type=?", new String[]{currencies.get(i).getType()});
            }
        }

        @Override
        protected ArrayList<Currency> doInBackground(Void... voids) {
            ArrayList<Currency> currencies = new ArrayList<>();
            try{
                // Cấu hình url
                URL url = new URL("http://www.dongabank.com.vn/exchange/export");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setRequestProperty("Content-type", "application/json; charset=utf-8");
                connection.setRequestProperty("User-Agent","Mozilla/5.0 ( compatible ) ");
                connection.setRequestProperty("Accept", "*/*");
                //Lấy Json Array
                InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream(),"UTF-8");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                StringBuilder builder = new StringBuilder();
                String line = bufferedReader.readLine();
                while (line!=null)
                {
                    builder.append(line);
                    line = bufferedReader.readLine();
                }
                String json = builder.toString().replace("(","");
                json = json.replace(")","");
                //Xử lý dữ liệu
                JSONArray jsonArray = (new JSONObject(json)).getJSONArray("items");
                for(int i =0; i<jsonArray.length();i++)
                {
                    JSONObject item = jsonArray.getJSONObject(i);
                    String except = item.getString("type");
                    if(except.equals("XAU")||except.equals("PNJ_DAB")||except.equals("SJC"))
                        continue;
                    Currency currency = new Currency();
                    if(item.has("imageurl")){
                        currency.setImage_url(item.getString("imageurl"));
                        url = new URL(item.getString("imageurl"));
                        connection = (HttpURLConnection) url.openConnection();
                        connection.setRequestMethod("GET");
                        connection.setRequestProperty("Content-type", "application/json; charset=utf-8");
                        connection.setRequestProperty("User-Agent","Mozilla/5.0 ( compatible ) ");
                        connection.setRequestProperty("Accept", "*/*");
                        Bitmap bitmap = BitmapFactory.decodeStream(connection.getInputStream());
                        currency.setBitmap(bitmap);
                    }
                    currency.setType(item.getString("type"));
                    currency.setPrice(item.getString("banck"));
                    currencies.add(currency);
                }


            }catch (Exception ex){
                Log.e("ERROR",ex.toString());
            }
            return currencies;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);

        }
    }
}

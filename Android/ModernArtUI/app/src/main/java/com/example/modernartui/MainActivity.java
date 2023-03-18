package com.example.modernartui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView ret1, ret2, ret3, ret4, ret5;
    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        khoitao();
        changeSeekBar();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_demo, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menuMoreInformation) {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
            alertDialog.setTitle("Lấy cảm hứng từ các tác phẩm của các nghệ sĩ như \nPiet Mondrian và Ben Nicholson.");
            alertDialog.setMessage("Nhấp vào bên dưới để tìm hiểu thêm!");
            alertDialog.setPositiveButton("Not Now", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            alertDialog.setNegativeButton("Visit MOMA", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://www.moma.org/"));
                    startActivity(intent);
                }
            });
            alertDialog.show();
        }
        return super.onOptionsItemSelected(item);
    }

    private void changeSeekBar() {
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int mau1 = 100 + i,
                    mau2 = 153 - i,
                    mau3 = 0 + i,
                    mau4 = 255 - i,
                    mau5 = 0 + i;
                ret1.setBackgroundColor(Color.rgb(mau1, mau1, 250));
                ret2.setBackgroundColor(Color.rgb(230, mau2, mau2));
                ret3.setBackgroundColor(Color.rgb(mau3, mau3, 153));
                ret4.setBackgroundColor(Color.rgb(mau4, mau4, 102));
                ret5.setBackgroundColor(Color.rgb(255, mau5, mau5));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void khoitao() {
        ret1 = (TextView) findViewById(R.id.textView1);
        ret2 = (TextView) findViewById(R.id.textView2);
        ret3 = (TextView) findViewById(R.id.textView3);
        ret4 = (TextView) findViewById(R.id.textView4);
        ret5 = (TextView) findViewById(R.id.textView5);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        ret1.setBackgroundColor(Color.rgb(100, 100, 250));
        ret2.setBackgroundColor(Color.rgb(230, 153, 153));
        ret3.setBackgroundColor(Color.rgb(0, 0, 153));
        ret4.setBackgroundColor(Color.rgb(255, 255, 102));
        ret5.setBackgroundColor(Color.rgb(255, 0, 0));
    }
}
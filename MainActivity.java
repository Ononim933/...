package com.example.zinatullin_timurka91;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.OnlinRadio.R;

    public class MainActivity extends AppCompatActivity {
        ListView listView;
        int[] images = {R.drawable.record, R.drawable.super1, R.drawable.trancemission, R.drawable.russianmix, R.drawable.medliakfm, R.drawable.recordchillout, R.drawable.recordclub, R.drawable.gopfm, R.drawable.vipmix, R.drawable.pirate, R.drawable.deep, R.drawable.breaks, R.drawable.dancecore, R.drawable.recorddubstep, R.drawable.recordtrap, R.drawable.teodor, R.drawable.yofm, R.drawable.pump};
        final String[] title = {"Radio Record", "Супердискотека 90-х", "Trancemission", "Russian Mix", "Медляк FM", "Record Chill-Out", "Record Club", "Гоп FM", "Vip Mix", "Pirate Station", "Record Deep", "Record Breaks", "Record Dancecore", "Record Dubstep", "Record Trap", "Teodor Hardstyle", "Yo! FM", "Pump'n'Klubb"};
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @SuppressLint({"ClickableViewAccessibility", "NewApi"})
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.list);
            listView = findViewById(R.id.listView);
            MyAdapter adapter = new MyAdapter(this, title, images);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    intent.putExtra("pos", position);
                    startActivityForResult(intent, 0);
                    overridePendingTransition(0, 0);

                }
            });

        }
        class MyAdapter extends ArrayAdapter<String> {
            Context context;
            String tittle1[];
            int images1[];
            MyAdapter(Context c,String tittle[],int imgs[]){
                super(c, R.layout.item,tittle);
                this.context = c;
                this.tittle1 = tittle;
                this.images1 = imgs;
            }

            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View item = layoutInflater.inflate(R.layout.item,parent,false);
                ImageView images = item.findViewById(R.id.icon);
                TextView textView = item.findViewById(R.id.label);
                images.setImageResource(images1[position]);
                textView.setText(tittle1[position]);
                return item;
            }
        }

    }

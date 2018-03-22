package com.example.aaron.imageorganizer;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Integer[] Pictures = {R.drawable.bull, R.drawable.butterfly, R.drawable.pineapple, R.drawable.seagul,
    R.drawable.waterlily, R.drawable.wolf};
    ImageView pic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView grid = findViewById(R.id.gridView);
        final ImageView pic = findViewById(R.id.imgLarge);

        grid.setAdapter(new ImageAdapter(this));
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                pic.setImageResource(Pictures[position]);
            }
        });


    }

    public class ImageAdapter extends BaseAdapter{
        private Context context;
        public ImageAdapter(Context c){
            context = c;
        }

        @Override
        public int getCount() {
            return Pictures.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            pic = new ImageView(context);
            pic.setImageResource(Pictures[position]);
            pic.setScaleType(ImageView.ScaleType.FIT_XY);
            pic.setLayoutParams(new GridView.LayoutParams(330,300));

            return pic;
        }
    }
}

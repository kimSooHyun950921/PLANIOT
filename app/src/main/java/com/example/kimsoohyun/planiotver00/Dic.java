package com.example.kimsoohyun.planiotver00;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Dic extends AppCompatActivity {

    ListView list;
    String[] names = {"튤립"};
    Integer[] image = {R.drawable.tulip};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dic);
        CustomList adapter = new CustomList(Dic.this);
        final Intent intent = new Intent(Dic.this,Dic_info.class);
        list = (ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Toast.makeText(getBaseContext(), names[+position], Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
    }

    public class CustomList extends ArrayAdapter<String>{
        private final Activity context;
        public CustomList(Activity contexts) {
            super(contexts,R.layout.listitem,names);
            this.context = contexts;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent){
            LayoutInflater inflater = context.getLayoutInflater();
            View rowView = inflater.inflate(R.layout.listitem, null, true);
            ImageView imageView = (ImageView) rowView.findViewById(R.id.image);
            TextView name = (TextView) rowView.findViewById(R.id.name);
            TextView content = (TextView) rowView.findViewById(R.id.content);
            name.setText(names[position]);
            imageView.setImageResource(image[position]);
            content.setText("내용");
            return rowView;
        }

    }
}

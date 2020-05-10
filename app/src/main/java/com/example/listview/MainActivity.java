package com.example.listview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends Activity {

    ListView listView ;
    ArrayList<ListValues> values = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get ListView object from xml
        listView = (ListView) findViewById(R.id.list);

        // Defined Array values to show in ListView


        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data

        final ArrayAdapter<ListValues> adapter = new ArrayAdapter<ListValues>(this,
                R.layout.list_item, values)
        {
            public View getView(int position, View convertView, ViewGroup parent){

                LayoutInflater inflater = (LayoutInflater) getApplicationContext()
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                @SuppressLint("ViewHolder") View rowView= Objects.requireNonNull(inflater).inflate(R.layout.list_item, null,true);

                TextView RowNo = (TextView) rowView.findViewById(R.id.list_itemtxt);
                TextView RowText = (TextView) rowView.findViewById(R.id.secondtxt);

                RowNo.setText(values.get(position).getLeftItem());
                RowText.setText(values.get(position).getRightItem());

                return rowView;
            }
        };


        // Assign adapter to ListView
        listView.setAdapter(adapter);

        values.add(new ListValues("hello","world"));
        // ListView Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                view.setSelected(true);
                listView.setItemChecked(position,true);
                values.add(new ListValues("item*","item*"));
                adapter.notifyDataSetChanged();

            }

        });
    }

}
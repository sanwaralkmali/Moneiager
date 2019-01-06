package com.example.salah.moneiager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class History extends AppCompatActivity {
    DataBaseHelper db;
    CalendarView calendarView;
    List<historyModel> list = new ArrayList<>();
    MyCustomerAdaptor myCustomerAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        db = new DataBaseHelper(this);

        calendarView = (CalendarView) findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                Toast.makeText(getApplicationContext(),year+"/"+(month+1)+"/"+dayOfMonth,Toast.LENGTH_SHORT).show();
                try {
                    list = db.getAllNotes(year+"/"+(month+1)+"/"+dayOfMonth);
                }catch (NullPointerException e){

                }
            }
        });

        try {
            list = db.getAllNotes();
        }catch (NullPointerException e){

        }
        ListView lvList = (ListView) findViewById(R.id.historyList);

        myCustomerAdaptor = new MyCustomerAdaptor();

        lvList.setAdapter(myCustomerAdaptor);

    }

    public class MyCustomerAdaptor extends BaseAdapter {


        @Override
        public int getCount() {
            return list.size();

        }

        @Override
        public String getItem(int postion) {
            return null;
        }

        @Override
        public long getItemId(int postion) {
            return postion;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater mInflater = getLayoutInflater();

            View view = mInflater.inflate(R.layout.listview_history, null);

            historyModel s = list.get(position);

            TextView txDate = (TextView) view.findViewById(R.id.Date);
            TextView txDescription = (TextView) view.findViewById(R.id.Description);
            TextView txPrice = (TextView) view.findViewById(R.id.Price);
            txDate.setText(s.getTimestamp());
            txDescription.setText(s.getdescription());
            txPrice.setText(String.valueOf(s.getPrice()));

            return view;

        }


    }
}

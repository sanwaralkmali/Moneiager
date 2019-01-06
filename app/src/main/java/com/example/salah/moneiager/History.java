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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class History extends AppCompatActivity {
    DataBaseHelper db;
    CalendarView calendarView;
    static List<historyModel> list = new ArrayList<>();
    MyCustomerAdaptor myCustomerAdaptor;
    public static String date;
    ListView lvList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        db = new DataBaseHelper(this);
        calendarView = (CalendarView) findViewById(R.id.calendarView);
        date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        try {
            list = db.getAllNotes(date);
        }catch (NullPointerException e){

        }

        lvList = (ListView) findViewById(R.id.historyList);
        myCustomerAdaptor = new MyCustomerAdaptor();
        lvList.setAdapter(myCustomerAdaptor);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                if(month<9 && dayOfMonth <9)
                    date=year+"-0"+(month+1)+"-0"+dayOfMonth;
                else if(month<9)
                    date=year+"-0"+(month+1)+"-"+dayOfMonth;
                else if(dayOfMonth<9)
                    date=year+"-"+(month+1)+"-0"+dayOfMonth;
                else
                    date=year+"-"+(month+1)+"-"+dayOfMonth;


                list = db.getAllNotes(date);
                lvList = (ListView) findViewById(R.id.historyList);
                myCustomerAdaptor = new MyCustomerAdaptor();
                lvList.setAdapter(myCustomerAdaptor);

            }
        });


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
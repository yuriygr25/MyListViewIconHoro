package com.example.yura.mylistviewiconhoro;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListViewWithIconsActivity extends ListActivity {

    String[] mSign = { "Овен", "Телец", "Близнецы", "Рак", "Лев", "Дева",
            "Весы", "Скорпион", "Стрелец", "Козерог", "Водолей", "Рыбы" };

    String[] mDate = { "21 марта - 20 апреля", "21 апреля - 20 мая",
            "21 мая - 21 июня", "22 июня - 22 июля", "23 июля - 23 августа",
            "24 августа - 23 сентября", "24 сентября - 23 октября",
            "24 октября - 22 ноября", "23 ноября - 21 декабря",
            "22 декабря - 20 января", "21 января - 20 февраля",
            "21 февраля - 20 марта" };

    Integer[] mImage = { R.drawable.aries, R.drawable.taurus,
            R.drawable.gemini, R.drawable.cancer, R.drawable.lion,
            R.drawable.virgo, R.drawable.libra, R.drawable.scorpio,
            R.drawable.sagittarius, R.drawable.capricorn, R.drawable.aquarius,
            R.drawable.pisces };

    myAdapter mAdapter;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);

        mAdapter = new myAdapter(this);
        setListAdapter(mAdapter);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        String selection = mAdapter.getString(position);

        Intent intent = new Intent();
        intent.setClass(ListViewWithIconsActivity.this, DetailActivity.class);

        intent.putExtra("title", position);

        //запускаем вторую активность
        startActivity(intent);


        //Toast.makeText(this, selection, Toast.LENGTH_LONG).show();
    }

    public class myAdapter extends BaseAdapter {
        private LayoutInflater mLayoutInflater;

        public myAdapter(Context ctx) {
            mLayoutInflater = LayoutInflater.from(ctx);
        }

        public int getCount() {
            return mSign.length;
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        public String getString(int position) {
            return mSign[position] + " (" + mDate[position] + ")";
        }

        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null)
                convertView = mLayoutInflater.inflate(R.layout.list_item, null);

            ImageView image = (ImageView) convertView.findViewById(R.id.icon);
            image.setImageResource(mImage[position]);

            TextView sign = (TextView) convertView.findViewById(R.id.sign);
            sign.setText(mSign[position]);

            TextView date = (TextView) convertView.findViewById(R.id.date);
            date.setText(mDate[position]);
            convertView.setBackgroundColor((position & 1) == 1 ? Color.WHITE : Color.LTGRAY);

            return convertView;
        }
    } // end myAdapter
}
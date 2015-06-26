package id.co.flipbox.magang.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import id.co.flipbox.magang.R;
import id.co.flipbox.magang.objects.Timesheet;

/**
 * Ini adalah adapter untuk tampilan Monthly Timesheet
 * (Screen - Timesheet List)
 * Created by Taufik on 25 Jun 2015.
 */
public class TsMonthAdapter extends BaseAdapter {
    private Activity act;
    private ArrayList<Timesheet> arr;
    private static LayoutInflater inflater=null;

    public TsMonthAdapter(Activity act, ArrayList<Timesheet> arr) {
        this.act = act;
        this.arr = arr;
        inflater = (LayoutInflater)act.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return arr.size();
    }

    @Override
    public Timesheet getItem(int position) {
        return arr.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(convertView==null) {
            view = inflater.inflate(R.layout.listrow_tsmonth,null);
        }

        TextView day = (TextView) view.findViewById(R.id.tsmonthDay);
        TextView date = (TextView) view.findViewById(R.id.tsmonthDate);
        TextView duration = (TextView) view.findViewById(R.id.tsmonthDuration);
        TextView hours = (TextView) view.findViewById(R.id.tsmonthHours);

        day.setText("Sunday"); // harusnya ambil dari tanggal
        date.setText(position + " Januari 2015");
        //Time start = getItem(position).getMulai();
        //Time end = getItem(position).getSelesai();
        hours.setText("14:00 - 17.00");
        duration.setText("5h");

        return view;
    }
}

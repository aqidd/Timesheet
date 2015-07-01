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
 * Ini adalah adapter untuk tampilan Daily Timesheet
 * (Screen - Timesheet Daily)
 * Created by Taufik on 30 Jun 2015.
 */
public class TsDailyAdapter extends BaseAdapter {
    private Activity act;
    private ArrayList<Timesheet> arr;
    private static LayoutInflater inflater=null;

    public TsDailyAdapter(Activity act, ArrayList<Timesheet> arr) {
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
            view = inflater.inflate(R.layout.listrow_tsdaily,null);
        }

        TextView project = (TextView) view.findViewById(R.id.tsdailyProject);
        TextView duration = (TextView) view.findViewById(R.id.tsdailyDuration);
        TextView hours = (TextView) view.findViewById(R.id.tsdailyHours);

        project.setText("JKT48 Banyak Rasa");
        //Time start = getItem(position).getMulai();
        //Time end = getItem(position).getSelesai();
        hours.setText("14:00 - 17.00");
        duration.setText("5h");

        return view;
    }
}

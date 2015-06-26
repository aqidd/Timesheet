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
import id.co.flipbox.magang.objects.Leave;

/**
 * Ini adalah adapter untuk tampilan Leave
 * (Screen - Leave List)
 * Created by Taufik on 25 Jun 2015.
 */
public class LeaveAdapter extends BaseAdapter {
    private Activity act;
    private ArrayList<Leave> arr;
    private static LayoutInflater inflater=null;

    public LeaveAdapter(Activity act, ArrayList<Leave> arr) {
        this.act = act;
        this.arr = arr;
        inflater = (LayoutInflater)act.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return arr.size();
    }

    @Override
    public Leave getItem(int position) {
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
            view = inflater.inflate(R.layout.listrow_leave,null);
        }

        TextView type = (TextView) view.findViewById(R.id.leaveType);
        TextView date = (TextView) view.findViewById(R.id.leaveDate);
        TextView duration = (TextView) view.findViewById(R.id.leaveDuration);

        type.setText("Paid Personal Leave: Istri Melahirkan");
        date.setText(position + " Jan - "+(position+5)+" Jan");
        //Time start = getItem(position).getMulai();
        //Time end = getItem(position).getSelesai();
        duration.setText("5d");

        return view;
    }
}

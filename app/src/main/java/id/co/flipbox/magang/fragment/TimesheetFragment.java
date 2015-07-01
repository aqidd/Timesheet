package id.co.flipbox.magang.fragment;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;

import com.getbase.floatingactionbutton.FloatingActionButton;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;

import id.co.flipbox.magang.R;
import id.co.flipbox.magang.activity.AddActivity;
import id.co.flipbox.magang.activity.TimesheetDailyActivity;
import id.co.flipbox.magang.adapter.TsMonthAdapter;
import id.co.flipbox.magang.objects.Project;
import id.co.flipbox.magang.objects.Timesheet;
import id.co.flipbox.magang.objects.User;

//import android.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TimesheetFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TimesheetFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TimesheetFragment extends Fragment {

    private View myFragmentView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TimesheetFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TimesheetFragment newInstance(String param1, String param2) {
        TimesheetFragment fragment = new TimesheetFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public TimesheetFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        myFragmentView = inflater.inflate(R.layout.fragment_timesheet, container, false);

        // Populate list of Timesheet (by month)
        ArrayList<Timesheet> arr = new ArrayList<>();

        // Populate by dummy data
        User me = new User(1,"a@a.com","thelaw","Ahmad Dhani","Bos","00","Majaer",null);
        Project mine = new Project(1,"Republik");
        arr.add(new Timesheet(1, new Date(2015,6,25), new Time(14,0,0), new Time(16,0,0), "Magang gan!", "H", "OK", me, mine));
        arr.add(new Timesheet(1, new Date(2015,6,25), new Time(14,0,0), new Time(16,0,0), "Magang gan!", "H", "OK", me, mine));
        arr.add(new Timesheet(1, new Date(2015,6,25), new Time(14,0,0), new Time(16,0,0), "Magang gan!", "H", "OK", me, mine));
        arr.add(new Timesheet(1, new Date(2015,6,25), new Time(14,0,0), new Time(16,0,0), "Magang gan!", "H", "OK", me, mine));
        arr.add(new Timesheet(1, new Date(2015,6,25), new Time(14,0,0), new Time(16,0,0), "Magang gan!", "H", "OK", me, mine));
        arr.add(new Timesheet(1, new Date(2015,6,25), new Time(14,0,0), new Time(16,0,0), "Magang gan!", "H", "OK", me, mine));
        arr.add(new Timesheet(1, new Date(2015,6,25), new Time(14,0,0), new Time(16,0,0), "Magang gan!", "H", "OK", me, mine));
        arr.add(new Timesheet(1, new Date(2015,6,25), new Time(14,0,0), new Time(16,0,0), "Magang gan!", "H", "OK", me, mine));
        arr.add(new Timesheet(1, new Date(2015,6,25), new Time(14,0,0), new Time(16,0,0), "Magang gan!", "H", "OK", me, mine));
        arr.add(new Timesheet(1, new Date(2015,6,25), new Time(14,0,0), new Time(16,0,0), "Magang gan!", "H", "OK", me, mine));
        arr.add(new Timesheet(1, new Date(2015,6,25), new Time(14,0,0), new Time(16,0,0), "Magang gan!", "H", "OK", me, mine));
        arr.add(new Timesheet(1, new Date(2015,6,25), new Time(14,0,0), new Time(16,0,0), "Magang gan!", "H", "OK", me, mine));

        // Create list view
        ListView list = (ListView) myFragmentView.findViewById(R.id.tsmonthList);
        TsMonthAdapter adapter = new TsMonthAdapter(getActivity(),arr);
        list.setAdapter(adapter);

        // Set listener for each row (later boyz)
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Timesheet clickedDetail = (Timesheet) parent.getItemAtPosition(position);
//                AcaraFragment fragment = new AcaraFragment();
//                fragment.setAcara(clickedDetail);
//                MainActivity mainAct = (MainActivity) getActivity();
//                mainAct.goToFragment(fragment,clickedDetail.getNama());
                Intent intent = new Intent(getActivity(), TimesheetDailyActivity.class);
                //intent.putExtra("currentOvertime", clickedDetail);
                Bundle extras = new Bundle();
                //extras.putSerializable("current",clickedDetail);
                startActivity(intent);
            }
        });

        // Create and populate spinners
        final Spinner month = (Spinner) myFragmentView.findViewById(R.id.tsmonthMonthPicker);
        final Spinner year = (Spinner) myFragmentView.findViewById(R.id.tsmonthYearPicker);
        int thisMonth = Calendar.getInstance().get(Calendar.MONTH);
        int thisYear = Calendar.getInstance().get(Calendar.YEAR);
        month.setSelection(thisMonth);
        year.setSelection(thisYear-2015);
        month.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getActivity(), month.getSelectedItem() + " " + year.getSelectedItem(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Toast.makeText(getActivity(), "NOTHINGNESSs", Toast.LENGTH_SHORT).show();
            }
        });
        year.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getActivity(), month.getSelectedItem() + " " + year.getSelectedItem(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Toast.makeText(getActivity(), "NOTHINGNESSs", Toast.LENGTH_SHORT).show();
            }
        });

        // Create add FAB
        FloatingActionButton adder = (FloatingActionButton) myFragmentView.findViewById(R.id.tsmonthAdder);
        adder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddActivity.class);
                intent.putExtra("addType",1);
                startActivity(intent);
            }
        });


        // Inflate the layout for this fragment
        return myFragmentView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}

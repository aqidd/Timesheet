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

import com.getbase.floatingactionbutton.FloatingActionButton;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

import id.co.flipbox.magang.R;
import id.co.flipbox.magang.activity.AddActivity;
import id.co.flipbox.magang.activity.DetailsActivity;
import id.co.flipbox.magang.adapter.TsDailyAdapter;
import id.co.flipbox.magang.objects.Project;
import id.co.flipbox.magang.objects.Timesheet;
import id.co.flipbox.magang.objects.User;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TimesheetDailyFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TimesheetDailyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TimesheetDailyFragment extends Fragment {

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
     * @return A new instance of fragment TimesheetDailyFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TimesheetDailyFragment newInstance(String param1, String param2) {
        TimesheetDailyFragment fragment = new TimesheetDailyFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public TimesheetDailyFragment() {
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
        myFragmentView = inflater.inflate(R.layout.fragment_timesheet_daily, container, false);

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
        ListView list = (ListView) myFragmentView.findViewById(R.id.tsdailyList);
        TsDailyAdapter adapter = new TsDailyAdapter(getActivity(),arr);
        list.setAdapter(adapter);

        // Set listener for each row (later boyz)
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Timesheet clickedDetail = (Timesheet) parent.getItemAtPosition(position);
                Intent intent = new Intent(getActivity(), DetailsActivity.class);
                intent.putExtra("detailType", 1);
                startActivity(intent);
            }
        });

        // Create add FAB
        FloatingActionButton adder = (FloatingActionButton) myFragmentView.findViewById(R.id.tsdailyAdder);
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

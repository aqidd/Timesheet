package id.co.flipbox.magang.fragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import id.co.flipbox.magang.R;

/**
 * A Fragment which represents the "Leave Details" view
 */

public class DetailsTimesheetFragment extends Fragment {
    private View myFragmentView;

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "ot_date";
    private static final String ARG_PARAM2 = "ot_duration";
    private static final String ARG_PARAM3 = "ot_project";
    private static final String ARG_PARAM4 = "ot_status";
    private static final String ARG_PARAM5 = "ot_absent";
    private static final String ARG_PARAM6 = "ot_desc";

    private String date,duration,status,desc,absent,project;

    private OnFragmentInteractionListener mListener;

    /**
     * Details of the Timesheet
     *
     * @param date Date of Timesheet.
     * @param duration Duration of Timesheet.
     * @param project Project of Timesheet.
     * @param status Timesheet Status of Timesheet.
     * @param absent Absent Status of Timesheet..
     * @param desc Description of Timesheet.
     * @return A new instance of fragment DetailsTimesheetFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailsTimesheetFragment newInstance(String date, String duration, String project, String status, String absent, String desc) {
        DetailsTimesheetFragment fragment = new DetailsTimesheetFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, date);
        args.putString(ARG_PARAM2, duration);
        args.putString(ARG_PARAM3, project);
        args.putString(ARG_PARAM4, status);
        args.putString(ARG_PARAM5, absent);
        args.putString(ARG_PARAM6, desc);
        fragment.setArguments(args);
        return fragment;
    }

    public DetailsTimesheetFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            date = getArguments().getString(ARG_PARAM1);
            duration = getArguments().getString(ARG_PARAM2);
            project = getArguments().getString(ARG_PARAM3);
            status = getArguments().getString(ARG_PARAM4);
            absent = getArguments().getString(ARG_PARAM5);
            desc = getArguments().getString(ARG_PARAM6);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        myFragmentView = inflater.inflate(R.layout.fragment_details_timesheet, container, false);
        TextView dateField =  (TextView) myFragmentView.findViewById(R.id.detailTsDateContent);
        dateField.setText(date);
        TextView durationField =  (TextView) myFragmentView.findViewById(R.id.detailTsDurationContent);
        durationField.setText(duration);
        TextView statusField =  (TextView) myFragmentView.findViewById(R.id.detailTsStatusContent);
        statusField.setText(status);
        TextView descField =  (TextView) myFragmentView.findViewById(R.id.detailTsDescContent);
        descField.setText(desc);
        TextView absentField =  (TextView) myFragmentView.findViewById(R.id.detailTsAbsentContent);
        absentField.setText(absent);
        TextView projectField =  (TextView) myFragmentView.findViewById(R.id.detailTsProjectContent);
        projectField.setText(project);
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

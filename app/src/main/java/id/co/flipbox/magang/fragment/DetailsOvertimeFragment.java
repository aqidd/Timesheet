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

public class DetailsOvertimeFragment extends Fragment {
    private View myFragmentView;

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "ot_date";
    private static final String ARG_PARAM2 = "ot_duration";
    private static final String ARG_PARAM3 = "ot_status";
    private static final String ARG_PARAM4 = "ot_desc";

    private String date,duration,status,desc;

    private OnFragmentInteractionListener mListener;

    /**
     * Details of the Overtime
     *
     * @param date Date of Overtime.
     * @param duration Duration of Overtime.
     * @param status Status of Overtime.
     * @param desc Description of Overtime.
     * @return A new instance of fragment DetailsOvertimeFragment.
     */

    public static DetailsOvertimeFragment newInstance(String date, String duration, String status, String desc) {
        DetailsOvertimeFragment fragment = new DetailsOvertimeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, date);
        args.putString(ARG_PARAM2, duration);
        args.putString(ARG_PARAM3, status);
        args.putString(ARG_PARAM4, desc);
        fragment.setArguments(args);
        return fragment;
    }

    public DetailsOvertimeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            date = getArguments().getString(ARG_PARAM1);
            duration = getArguments().getString(ARG_PARAM2);
            status = getArguments().getString(ARG_PARAM3);
            desc = getArguments().getString(ARG_PARAM4);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        myFragmentView = inflater.inflate(R.layout.fragment_details_overtime, container, false);
        TextView dateField =  (TextView) myFragmentView.findViewById(R.id.detailOtDateContent);
        dateField.setText(date);
        TextView durationField =  (TextView) myFragmentView.findViewById(R.id.detailOtDurationContent);
        durationField.setText(duration);
        TextView statusField =  (TextView) myFragmentView.findViewById(R.id.detailOtStatusContent);
        statusField.setText(status);
        TextView descField =  (TextView) myFragmentView.findViewById(R.id.detailOtDescContent);
        descField.setText(desc);
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

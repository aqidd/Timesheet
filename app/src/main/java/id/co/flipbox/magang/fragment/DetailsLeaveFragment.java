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

public class DetailsLeaveFragment extends Fragment {

    private View myFragmentView;

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "leave_type";
    private static final String ARG_PARAM2 = "leave_duration";
    private static final String ARG_PARAM3 = "leave_status";
    private static final String ARG_PARAM4 = "leave_desc";

    private String type,duration,status,desc;

    private OnFragmentInteractionListener mListener;

    /**
     * Details of the Leave
     *
     * @param type Type of leave.
     * @param duration Duration of leave.
     * @param status Status of leave.
     * @param desc Description of leave.
     * @return A new instance of fragment DetailsLeaveFragment.
     */

    public static DetailsLeaveFragment newInstance(String type, String duration, String status, String desc) {
        DetailsLeaveFragment fragment = new DetailsLeaveFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, type);
        args.putString(ARG_PARAM2, duration);
        args.putString(ARG_PARAM3, status);
        args.putString(ARG_PARAM4, desc);
        fragment.setArguments(args);
        return fragment;
    }

    public DetailsLeaveFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            type = getArguments().getString(ARG_PARAM1);
            duration = getArguments().getString(ARG_PARAM2);
            status = getArguments().getString(ARG_PARAM3);
            desc = getArguments().getString(ARG_PARAM4);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        myFragmentView = inflater.inflate(R.layout.fragment_details_leave, container, false);
        TextView typeField =  (TextView) myFragmentView.findViewById(R.id.detailLeaveTypeContent);
        typeField.setText(type);
        TextView durationField =  (TextView) myFragmentView.findViewById(R.id.detailLeaveDurationContent);
        durationField.setText(duration);
        TextView statusField =  (TextView) myFragmentView.findViewById(R.id.detailLeaveStatusContent);
        statusField.setText(status);
        TextView descField =  (TextView) myFragmentView.findViewById(R.id.detailLeaveDescContent);
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

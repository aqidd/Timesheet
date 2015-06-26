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

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

import id.co.flipbox.magang.DetailsActivity;
import id.co.flipbox.magang.R;
import id.co.flipbox.magang.adapter.OtAdapter;
import id.co.flipbox.magang.objects.Overtime;
import id.co.flipbox.magang.objects.User;

//import android.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OvertimeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link OvertimeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OvertimeFragment extends Fragment {
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
     * @return A new instance of fragment OvertimeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OvertimeFragment newInstance(String param1, String param2) {
        OvertimeFragment fragment = new OvertimeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public OvertimeFragment() {
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
        myFragmentView = inflater.inflate(R.layout.fragment_overtime, container, false);

        // Populate list of Overtime
        ArrayList<Overtime> arr = new ArrayList<>();

        // Populate by dummy data
        User me = new User(1,"a@a.com","thelaw","Ahmad Dhani","Bos","00","Majaer");
        arr.add(new Overtime(1, "Nonton Theater JKT48", new Time(14,0,0), new Time(16,0,0), me, new Date(2015,6,30)));
        arr.add(new Overtime(1, "Nonton Theater JKT48", new Time(14,0,0), new Time(16,0,0), me, new Date(2015,6,30)));
        arr.add(new Overtime(1, "Nonton Theater JKT48", new Time(14,0,0), new Time(16,0,0), me, new Date(2015,6,30)));
        arr.add(new Overtime(1, "Nonton Theater JKT48", new Time(14,0,0), new Time(16,0,0), me, new Date(2015,6,30)));
        arr.add(new Overtime(1, "Nonton Theater JKT48", new Time(14,0,0), new Time(16,0,0), me, new Date(2015,6,30)));
        arr.add(new Overtime(1, "Nonton Theater JKT48", new Time(14,0,0), new Time(16,0,0), me, new Date(2015,6,30)));
        arr.add(new Overtime(1, "Nonton Theater JKT48", new Time(14,0,0), new Time(16,0,0), me, new Date(2015,6,30)));
        arr.add(new Overtime(1, "Nonton Theater JKT48", new Time(14,0,0), new Time(16,0,0), me, new Date(2015,6,30)));
        arr.add(new Overtime(1, "Nonton Theater JKT48", new Time(14,0,0), new Time(16,0,0), me, new Date(2015,6,30)));
        arr.add(new Overtime(1, "Nonton Theater JKT48", new Time(14,0,0), new Time(16,0,0), me, new Date(2015,6,30)));
        arr.add(new Overtime(1, "Nonton Theater JKT48", new Time(14,0,0), new Time(16,0,0), me, new Date(2015,6,30)));
        arr.add(new Overtime(1, "Nonton Theater JKT48", new Time(14,0,0), new Time(16,0,0), me, new Date(2015,6,30)));

        // Create list view
        ListView list = (ListView) myFragmentView.findViewById(R.id.otList);
        OtAdapter adapter = new OtAdapter(getActivity(),arr);
        list.setAdapter(adapter);

        // Set listener for each row (later boyz)
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Overtime clickedDetail = (Overtime) parent.getItemAtPosition(position);
//                AcaraFragment fragment = new AcaraFragment();
//                fragment.setAcara(clickedDetail);
//                MainActivity mainAct = (MainActivity) getActivity();
//                mainAct.goToFragment(fragment,clickedDetail.getNama());
                Intent intent = new Intent(getActivity(), DetailsActivity.class);
                //intent.putExtra("currentOvertime", clickedDetail);
                Bundle extras = new Bundle();
                //extras.putSerializable("current",clickedDetail);
                intent.putExtras(extras);
                intent.putExtra("frameType",1);
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

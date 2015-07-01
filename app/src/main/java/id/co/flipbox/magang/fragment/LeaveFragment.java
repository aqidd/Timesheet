package id.co.flipbox.magang.fragment;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
//import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.getbase.floatingactionbutton.FloatingActionButton;

import java.sql.Date;
import java.util.ArrayList;

import id.co.flipbox.magang.R;
import id.co.flipbox.magang.activity.AddActivity;
import id.co.flipbox.magang.activity.DetailsActivity;
import id.co.flipbox.magang.adapter.LeaveAdapter;
import id.co.flipbox.magang.objects.Leave;
import id.co.flipbox.magang.objects.User;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link LeaveFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link LeaveFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LeaveFragment extends Fragment {
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
     * @return A new instance of fragment LeaveFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LeaveFragment newInstance(String param1, String param2) {
        LeaveFragment fragment = new LeaveFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public LeaveFragment() {
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
        myFragmentView = inflater.inflate(R.layout.fragment_leave, container, false);

        // Populate list of Leave
        ArrayList<Leave> arr = new ArrayList<>();

        // Populate by dummy data
        User me = new User(1,"a@a.com","thelaw","Ahmad Dhani","Bos","00","Majaer",null);
        arr.add(new Leave(1, "Paid Personal Leave: Istri Melahirkan", "Kasihan anak saya! 1", new Date(2015,6,25), new Date(2015,6,30), me));
        arr.add(new Leave(1, "Paid Personal Leave: Istri Melahirkan Lagi", "Kasihan anak saya! 2", new Date(2015,6,25), new Date(2015,6,30), me));
        arr.add(new Leave(1, "Paid Personal Leave: Istri Melahirkan Terus", "Kasihan anak saya! 4", new Date(2015,6,25), new Date(2015,6,30), me));
        arr.add(new Leave(1, "Paid Personal Leave: Istri Melahirkan, Bapaknya Bukan saya", "Kasihan anak saya! 5", new Date(2015,6,25), new Date(2015,6,30), me));
        arr.add(new Leave(1, "Paid Personal Leave: Istri Melahirkan", "Kasihan anak saya!", new Date(2015,6,25), new Date(2015,6,30), me));
        arr.add(new Leave(1, "Paid Personal Leave: Istri Melahirkan", "Kasihan anak saya! 55", new Date(2015,6,25), new Date(2015,6,30), me));
        arr.add(new Leave(1, "Paid Personal Leave: Istri Melahirkan", "Kasihan anak saya!", new Date(2015,6,25), new Date(2015,6,30), me));
        arr.add(new Leave(1, "Paid Personal Leave: Istri Melahirkan", "Kasihan anak saya!", new Date(2015,6,25), new Date(2015,6,30), me));
        arr.add(new Leave(1, "Paid Personal Leave: Istri Melahirkan", "Kasihan anak saya!", new Date(2015,6,25), new Date(2015,6,30), me));
        arr.add(new Leave(1, "Paid Personal Leave: Istri Melahirkan", "Kasihan anak saya!", new Date(2015,6,25), new Date(2015,6,30), me));
        arr.add(new Leave(1, "Paid Personal Leave: Istri Melahirkan", "Kasihan anak saya!", new Date(2015,6,25), new Date(2015,6,30), me));

        // Create list view
        ListView list = (ListView) myFragmentView.findViewById(R.id.leaveList);
        LeaveAdapter adapter = new LeaveAdapter(getActivity(),arr);
        list.setAdapter(adapter);

        // Set listener for each row
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Leave clickedDetail = (Leave) parent.getItemAtPosition(position);
                Intent intent = new Intent(getActivity(), DetailsActivity.class);
                intent.putExtra("detailType", 3);
                intent.putExtra("leave_type", clickedDetail.getJenis());
                intent.putExtra("leave_duration", clickedDetail.getMulai()+" - "+clickedDetail.getSelesai());
                intent.putExtra("leave_status", clickedDetail.getStatus());
                intent.putExtra("leave_desc", clickedDetail.getDesc());
                startActivity(intent);
            }
        });

        // Create add FAB
        FloatingActionButton adder = (FloatingActionButton) myFragmentView.findViewById(R.id.leaveAdder);
        adder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddActivity.class);
                intent.putExtra("addType",3);
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

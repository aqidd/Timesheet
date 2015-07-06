package id.co.flipbox.magang.fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.sql.Date;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import helper.MySingleton;
import id.co.flipbox.magang.R;

/**
 * A Fragment which represents the "Add New Overtime" view
 */

public class AddOvertimeFragment extends Fragment {

    private View myFragmentView;

    private String mDate, mDesc, mStart, mEnd;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment AddOvertimeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddOvertimeFragment newInstance() {
        AddOvertimeFragment fragment = new AddOvertimeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public AddOvertimeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        myFragmentView = inflater.inflate(R.layout.fragment_add_overtime, container, false);

        // Get current date
        Date date = new Date(Calendar.getInstance().getTimeInMillis());
        EditText dateField = (EditText) myFragmentView.findViewById(R.id.addOtDateForm);

        // Populate TimePickers
        final EditText startField = (EditText) myFragmentView.findViewById(R.id.addOtStartForm);
        startField.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        startField.setText( selectedHour + ":" + String.format("%02d", selectedMinute));
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.show();
            }
        });

        final EditText endField = (EditText) myFragmentView.findViewById(R.id.addOtEndForm);
        endField.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        endField.setText( selectedHour + ":" + String.format("%02d", selectedMinute));
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.show();
            }
        });


        dateField.setText((date.getYear()+1900)+ "-" + String.format("%02d", date.getMonth()+1) + "-" + String.format("%02d", date.getDay()));

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


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_confirm) {
            final EditText dateField = (EditText) myFragmentView.findViewById(R.id.addOtDateForm);
            final EditText startField = (EditText) myFragmentView.findViewById(R.id.addOtStartForm);
            final EditText endField = (EditText) myFragmentView.findViewById(R.id.addOtEndForm);
            final EditText descField = (EditText) myFragmentView.findViewById(R.id.addOtDescForm);
            // Get inputs
            mDate = dateField.getText()+"";
            mDesc = descField.getText()+"";
            mStart = startField.getText()+"";
            mEnd = endField.getText()+"";
            if(mDate.length()==0 || mDesc.length()==0 || mStart.length()==0 || mEnd.length()==0) {
                Toast.makeText(getActivity(), "All fields are required. Please fill the empty field(s).", Toast.LENGTH_SHORT).show();
            }
            else if(!isValidTime(mStart,mEnd)) {
                Toast.makeText(getActivity(), "Time range is not valid.", Toast.LENGTH_SHORT).show();
            }
            else {
                new AlertDialog.Builder(this.getActivity())
                        .setTitle("Add New Overtime?")
                        .setMessage(mDate+"\n"+mStart+" - "+mEnd+"\n\n"+mDesc)
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Coba volley
                                RequestQueue queue = MySingleton.getInstance(getActivity()).
                                        getRequestQueue();

                                StringRequest postReq = new StringRequest(Request.Method.POST, "http://propensi.flipbox.co.id/elmis/api/index.php/timesheet", new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String response) {
                                        Toast.makeText(getActivity(),response,Toast.LENGTH_SHORT).show();
                                        NavUtils.navigateUpFromSameTask(getActivity());
                                        //tv.setText(response); // We set the response data in the TextView
                                    }
                                }, new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {
                                        System.out.println("Error [" + error + "]");

                                    }
                                }) {
                                    @Override
                                    protected Map<String, String> getParams() throws AuthFailureError {
                                        Map<String, String> params = new HashMap<String, String>();

                                        params.put("tanggal", mDate);
                                        params.put("waktu_mulai", mStart);
                                        params.put("kegiatan", mDesc);
                                        params.put("waktu_selesai", mEnd);
                                        params.put("nip_pekerja", "1");
                                        params.put("project_id", "1");
                                        return params;
                                    }
                                };

                                queue.add(postReq);
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .show();
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private boolean isValidTime(String a, String b) {
        String[] aA = a.split(":");
        String[] bB = b.split(":");

        if(Integer.parseInt(aA[0])>Integer.parseInt(bB[0]))
            return false;
        else if (Integer.parseInt(aA[0])==Integer.parseInt(bB[1]) && Integer.parseInt(aA[1])>Integer.parseInt(bB[1]))
            return false;
        else
            return true;
    }

}

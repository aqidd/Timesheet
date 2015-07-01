package id.co.flipbox.magang.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import id.co.flipbox.magang.R;
import id.co.flipbox.magang.fragment.DetailsLeaveFragment;
import id.co.flipbox.magang.fragment.DetailsOvertimeFragment;
import id.co.flipbox.magang.fragment.DetailsTimesheetFragment;

/**
 * Activity for knowing details of a list element
 * Specially made so it can have different parent (because it's accessed not via home activity
 *
 */

public class DetailsTsActivity extends ActionBarActivity implements DetailsLeaveFragment.OnFragmentInteractionListener, DetailsOvertimeFragment.OnFragmentInteractionListener, DetailsTimesheetFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        if (savedInstanceState == null) {
            if (getIntent().getIntExtra("detailType",0)==1) {
                setTitle("Timesheet Details");
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.container, DetailsTimesheetFragment.newInstance(getIntent().getStringExtra("ts_date"),getIntent().getStringExtra("ts_duration"),getIntent().getStringExtra("ts_project"),getIntent().getStringExtra("ts_status"),getIntent().getStringExtra("ts_absent"),getIntent().getStringExtra("ts_desc")))
                        .commit();
            }
            else if (getIntent().getIntExtra("detailType",0)==2) {
                setTitle("Overtime Details");
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.container, DetailsOvertimeFragment.newInstance(getIntent().getStringExtra("ot_date"),getIntent().getStringExtra("ot_duration"),getIntent().getStringExtra("ot_status"),getIntent().getStringExtra("ot_desc")))
                        .commit();
            }
            else if (getIntent().getIntExtra("detailType",0)==3) {
                setTitle("Leave Details");
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.container, DetailsLeaveFragment.newInstance(getIntent().getStringExtra("leave_type"),getIntent().getStringExtra("leave_duration"),getIntent().getStringExtra("leave_status"),getIntent().getStringExtra("leave_desc")))
                        .commit();
            }
        }
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //if (id == R.id.action_settings) {
        //    return true;
        //}

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_add_timesheet, container, false);
            getActivity().setTitle("Add Leave");
            return rootView;
        }
    }
}

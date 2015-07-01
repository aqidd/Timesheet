package id.co.flipbox.magang.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
 *
 */

public class DetailsActivity extends ActionBarActivity implements DetailsLeaveFragment.OnFragmentInteractionListener, DetailsOvertimeFragment.OnFragmentInteractionListener, DetailsTimesheetFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        if (savedInstanceState == null) {
            if (getIntent().getIntExtra("detailType",0)==1) {
                setTitle("Timesheet Details");
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.container, new DetailsTimesheetFragment())
                        .commit();
            }
            else if (getIntent().getIntExtra("detailType",0)==2) {
                setTitle("Overtime Details");
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.container, new DetailsOvertimeFragment())
                        .commit();
            }
            else if (getIntent().getIntExtra("detailType",0)==3) {
                setTitle("Leave Details");
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.container, new DetailsLeaveFragment())
                        .commit();
            }
        }
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
        if (id == R.id.action_settings) {
            return true;
        }

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

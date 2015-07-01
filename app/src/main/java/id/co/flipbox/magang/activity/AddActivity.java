package id.co.flipbox.magang.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import id.co.flipbox.magang.R;
import id.co.flipbox.magang.fragment.AddLeaveFragment;
import id.co.flipbox.magang.fragment.AddOvertimeFragment;
import id.co.flipbox.magang.fragment.AddTimesheetFragment;

/**
 * Activity for adding a new element
 *
 */

public class AddActivity extends ActionBarActivity implements AddOvertimeFragment.OnFragmentInteractionListener, AddLeaveFragment.OnFragmentInteractionListener, AddTimesheetFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        if (savedInstanceState == null) {
            if (getIntent().getIntExtra("addType",0)==1) {
                setTitle("Add New Timesheet");
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.container, new AddTimesheetFragment())
                        .commit();
            }
            else if (getIntent().getIntExtra("addType",0)==2) {
                setTitle("Add New Overtime");
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.container, new AddOvertimeFragment())
                        .commit();
            }
            else if (getIntent().getIntExtra("addType",0)==3) {
                setTitle("Add New Leave");
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.container, new AddLeaveFragment())
                        .commit();
            }

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add, menu);
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
}

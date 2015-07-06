package id.co.flipbox.magang.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import id.co.flipbox.magang.R;
import id.co.flipbox.magang.activity.LoginActivity;

/**
 * A placeholder fragment containing a simple view.
 */
public class SplashActivityFragment extends Fragment {

    View myFragmentView;

    public SplashActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        myFragmentView = inflater.inflate(R.layout.fragment_splash, container, false);
        Button login = (Button) myFragmentView.findViewById(R.id.buttonSplashLogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });
        return myFragmentView;
    }
}

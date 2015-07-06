package id.co.flipbox.magang.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import id.co.flipbox.magang.R;
import id.co.flipbox.magang.activity.HomeActivity;

/**
 * A placeholder fragment containing a simple view.
 */
public class LoginActivityFragment extends Fragment {

    View myFragmentView;

    public LoginActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        myFragmentView = inflater.inflate(R.layout.fragment_login, container, false);
        final EditText email = (EditText) myFragmentView.findViewById(R.id.loginEmailForm);
        final EditText pwd = (EditText) myFragmentView.findViewById(R.id.loginPwdForm);
        Button login = (Button) myFragmentView.findViewById(R.id.loginButton);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isValidEmail(email.getText())) {
                    Toast.makeText(getActivity(), "Email is invalid.", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(getActivity(), HomeActivity.class);
                    startActivity(intent);
                }
            }
        });
        return myFragmentView;
    }

    public final static boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }
}

package com.miracle.partyapp.activity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.miracle.partyapp.R;
import com.miracle.partyapp.fragment.AuthorizationFragment;
import com.miracle.partyapp.fragment.RegistrationFragment;
import com.miracle.partyapp.fragment.WelcomeFragment;

public class LoginActivity extends AppCompatActivity {

    private WelcomeFragment welcomeFragment;
    private RegistrationFragment registrationFragment;
    private AuthorizationFragment authorizationFragment;
    private Button registrationButton;
    private Button authorizationButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        welcomeFragment = new WelcomeFragment();
        registrationFragment = new RegistrationFragment();
        authorizationFragment = new AuthorizationFragment();
        changeFragment(welcomeFragment);
        registrationButton = findViewById(R.id.mainRegistrationButton);
        registrationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragment(registrationFragment);
                registrationButton.setVisibility(View.GONE);
                authorizationButton.setVisibility(View.VISIBLE);
            }
        });
        authorizationButton = findViewById(R.id.mainAuthorizationButton);
        authorizationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragment(authorizationFragment);
                authorizationButton.setVisibility(View.GONE);
                registrationButton.setVisibility(View.VISIBLE);

            }
        });
    }

    public void changeFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .disallowAddToBackStack()
                .replace(R.id.frameLayoutSwap, fragment)
                .commit();
    }


}

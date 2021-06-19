package com.miracle.partyapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.miracle.partyapp.R;
import com.miracle.partyapp.api.NetworkService;
import com.miracle.partyapp.model.LoginPhUser;
import com.miracle.partyapp.model.PhResponse;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthorizationFragment extends Fragment {
    private EditText editTextUsername;
    private EditText editTextPassword;
    private TextView textViewTest;
    private Button buttonAuthorization;

    public AuthorizationFragment() {
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_authorization, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NotNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editTextUsername = view.findViewById(R.id.editTextUsername);
        editTextPassword = view.findViewById(R.id.editTextPassword);
        textViewTest = view.findViewById(R.id.textViewTest);
        buttonAuthorization = view.findViewById(R.id.authorizationButton);
        buttonAuthorization.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    doResponse();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void doResponse() {
        LoginPhUser user = new LoginPhUser(editTextUsername.getText().toString(), editTextPassword.getText().toString());
        user.toString();
        NetworkService
                .getInstance()
                .getPhApi()
                .getUserToken(user)
                .enqueue(new Callback<PhResponse>() {
                    @Override
                    public void onResponse(Call<PhResponse> call, Response<PhResponse> response) {

                        textViewTest.setText(response.body().getMessage());
                        response.body().toString();
                    }

                    @Override
                    public void onFailure(Call<PhResponse> call, Throwable t) {

                        textViewTest.setText(t.getMessage());
                    }
                });
    }
}

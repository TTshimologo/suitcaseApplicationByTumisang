package com.example.suitcaseapplicationbytumisang;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.suitcaseapplicationbytumisang.fragment_navigator.SuitCaseApplicationNavigatorActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginFragment extends Fragment {

    TextInputEditText email, password;
    MaterialButton loginBTN;

    //Creating a DatabaseReference class to access firebase's Realtime Database
    DatabaseReference databaseReference = FirebaseDatabase.getInstance()
            .getReferenceFromUrl("https://suitcase-application-d8aea-default-rtdb.firebaseio.com/");

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View loginScreen = inflater.inflate(R.layout.fragment_login, container, false);

        email = loginScreen.findViewById(R.id.loginEmailTextInputEditText);
        password = loginScreen.findViewById(R.id.loginPasswordTextInputEditText);
        loginBTN = loginScreen.findViewById(R.id.loginButton);

        loginBTN.setOnClickListener(View -> {

            final String loginEmail = email.getText().toString();
            final String loginPassword = password.getText().toString();

            //Accounting for empty fields
            if (loginEmail.isEmpty()) {
                this.email.setError("Required");
            } else if (loginPassword.isEmpty()) {
                Toast.makeText(requireContext(), "Password Required", Toast.LENGTH_SHORT).show();
            } else {

                // Sanitize the email address to create a valid Firebase Database path
                String sanitizedEmail = loginEmail.replace(".", "_");

                databaseReference.child("Users").addListenerForSingleValueEvent
                        (new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        //Checking if the sanitized email address exists in the Firebase database
                        if (snapshot.hasChild(sanitizedEmail)) {
                            DataSnapshot userSnapshot = snapshot.child(sanitizedEmail);

                            if (userSnapshot.child("password").exists()) {
                                String storedPassword = userSnapshot.child("password")
                                        .getValue(String.class);

                                if (loginPassword.equals(storedPassword)) {
                                    // Start the new activity
                                    Intent intent = new Intent(getContext(),
                                            SuitCaseApplicationNavigatorActivity.class);
                                    startActivity(intent);

                                    Toast.makeText(getContext(), "Login Successful",
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(getContext(), "Wrong Password",
                                            Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(getContext(), "No password found for the user",
                                        Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(getContext(), "No account found",
                                    Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }

        });

        return loginScreen;
    }
}
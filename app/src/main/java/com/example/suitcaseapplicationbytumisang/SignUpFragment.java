package com.example.suitcaseapplicationbytumisang;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.suitcaseapplicationbytumisang.fragments_navigator.LoginAndSignUpScreenNavigatorActivity;
import com.example.suitcaseapplicationbytumisang.fragments_navigator.SuitCaseApplicationNavigatorActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignUpFragment extends Fragment {

    TextInputEditText email, firstname, lastname, contact, password;
    MaterialButton signUpBTN;

    //Creating a DatabaseReference class to access firebase's Realtime Database
    DatabaseReference databaseReference = FirebaseDatabase.getInstance()
            .getReferenceFromUrl("https://suitcase-application-d8aea-default-rtdb.firebaseio.com/");

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View signUpScreen = inflater.inflate(R.layout.fragment_sign_up, container, false);

        email = signUpScreen.findViewById(R.id.signUpEmailTextInputEditText);
        firstname = signUpScreen.findViewById(R.id.signUpFirstNameTextInputEditText);
        lastname = signUpScreen.findViewById(R.id.signUpLastNameTextInputEditText);
        contact = signUpScreen.findViewById(R.id.signUpContactTextInputEditText);
        password = signUpScreen.findViewById(R.id.signUpPasswordTextInputEditText);
        signUpBTN = signUpScreen.findViewById(R.id.signUpButton);

        /* Being I handle how the input texts that would be received from all this TextInputEditText
           will be proceeded upon the clicking of the register button */
        signUpBTN.setOnClickListener(View -> {


            final String signUpEmail = email.getText().toString();
            final String signUpFirstName = firstname.getText().toString();
            final String signUpLastName = lastname.getText().toString();
            final String signUpContact = contact.getText().toString();
            final String signUpPassword = password.getText().toString();

            //Accounting for empty fields
            if (signUpEmail.isEmpty()) {
                this.email.setError("Required");
            } else if (signUpFirstName.isEmpty()) {
                this.firstname.setError("Required");
            } else if (signUpLastName.isEmpty()) {
                this.lastname.setError("Required");
            } else if (signUpContact.isEmpty()) {
                this.contact.setError("Required");
            } else if (signUpPassword.isEmpty()) {
                Toast.makeText(requireContext(), "Password Required", Toast.LENGTH_SHORT).show();
            } else {

                // Sanitize the email address to create a valid Firebase Database path
                String sanitizedEmail = signUpEmail.replace(".", "_");
                databaseReference.child("Users").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        //Checking if the email being added doesn't already exist.
                        if (snapshot.hasChild(sanitizedEmail)) {

                            Toast.makeText(getContext(),
                                    "The email entered is already linked to an account",
                                    Toast.LENGTH_SHORT).show();

                        } else {

                            //Sending the data entered to firebase Realtime Database.
                            //I shall be using the user's email address as the primary key.
                            databaseReference.child("Users").child(sanitizedEmail)
                                    .child("firstName")
                                    .setValue(signUpFirstName);
                            databaseReference.child("Users").child(sanitizedEmail)
                                    .child("lastName")
                                    .setValue(signUpLastName);
                            databaseReference.child("Users").child(sanitizedEmail)
                                    .child("contact")
                                    .setValue(signUpContact);
                            databaseReference.child("Users").child(sanitizedEmail)
                                    .child("password")
                                    .setValue(signUpPassword);

                            //On success show this message
                            Toast.makeText(getContext(), "Account Created", Toast.LENGTH_SHORT).show();

                            // Finish the hosting activity (if it's not null)
                            if (getActivity() != null) {
                                getActivity().finish();
                            }

                            // Start the new activity
                            Intent intent = new Intent(getContext(),
                                    LoginAndSignUpScreenNavigatorActivity.class);
                            startActivity(intent);

                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }


        });

        return signUpScreen;
    }
}
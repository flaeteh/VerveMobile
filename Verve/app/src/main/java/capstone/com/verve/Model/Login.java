package capstone.com.verve.Model;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.*;

public class Login {
    Users users = new Users();
    String patient = "Patient";

    public void allowUserToLogin(EditText email, EditText password, Context context, FirebaseAuth auth) {
        String emailAdd = email.getText().toString().trim();
        String userPassword = password.getText().toString().trim();

        if (emailAdd.isEmpty()) {
            Toast.makeText(context, "Please Enter your email", Toast.LENGTH_LONG).show();
        }
        if (userPassword.isEmpty()) {
            Toast.makeText(context, "Please Enter you password", Toast.LENGTH_LONG).show();
        }

        userLogin(emailAdd, userPassword, context, auth);

    }


    private void userLogin(String email, String password, final Context context, FirebaseAuth auth) {


        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            DatabaseReference mRef = FirebaseDatabase.getInstance().getReference();

            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
                    mRef.child("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (dataSnapshot.exists()) {
                                String role = dataSnapshot.child("role").getValue(String.class);
                                if (role.equals(patient)) {
                                    Toast.makeText(context, "patient", Toast.LENGTH_LONG).show();
                                }
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });


                }
            }
        });
    }
}



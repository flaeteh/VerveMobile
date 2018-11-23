package capstone.com.verve.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import capstone.com.verve.Model.Login;
import capstone.com.verve.R;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    Login login = new Login();
    EditText etUsername, etPassword;
    FirebaseAuth auth = null;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.etxt_username);
        etPassword = findViewById(R.id.etxt_password);

        auth = FirebaseAuth.getInstance();

        setHintTextColor();
    }

    public void option (View v){
        Intent i= null, chooser = null;

        if (v.getId() == R.id.click_signup){
            i = new Intent(this, RegisterPatientActivity.class);
            startActivity(i);
        }

        if (v.getId() == R.id.click_forgotpass){
            i = new Intent(this, ForgotPasswordActivity.class);
            startActivity(i);
        }

        if (v.getId() == R.id.btn_login){
            login.allowUserToLogin(etUsername, etPassword, LoginActivity.this, auth);
        }
    }

    private void setHintTextColor(){
        EditText etUsername = findViewById(R.id.etxt_username);
        EditText etPassword = findViewById(R.id.etxt_password);

        etUsername.setHintTextColor(getResources().getColor(R.color.Pale));
        etPassword.setHintTextColor(getResources().getColor(R.color.Pale));
    }

}

package capstone.com.verve.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import capstone.com.verve.R;

public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

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
    }

    private void setHintTextColor(){
        EditText etUsername = findViewById(R.id.et_username);
        EditText etPassword = findViewById(R.id.et_password);

        etUsername.setHintTextColor(getResources().getColor(R.color.Pale));
        etPassword.setHintTextColor(getResources().getColor(R.color.Pale));
    }
}

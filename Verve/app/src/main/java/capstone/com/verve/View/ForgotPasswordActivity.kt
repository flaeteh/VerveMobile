package capstone.com.verve.View

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import capstone.com.verve.R

class ForgotPasswordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
    }

    fun option(v: View) {
        var i: Intent? = null
        val chooser: Intent? = null

        if (v.id == R.id.click_signup) {
            i = Intent(this, RegisterPatientActivity::class.java)
            startActivity(i)
        }

        if (v.id == R.id.click_login) {
            i = Intent(this, LoginActivity::class.java)
            startActivity(i)
        }
    }
}

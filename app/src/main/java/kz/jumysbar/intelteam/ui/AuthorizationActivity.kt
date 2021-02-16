package kz.jumysbar.intelteam.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.google.android.gms.common.SignInButton
import kotlinx.android.synthetic.main.activity_authorization.*
import kz.jumysbar.intelteam.R

open class AuthorizationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authorization)
       signInBtn?.let { setGooglePlusButtonText(it, "Войти с помощью Google") }

    }


     private fun setGooglePlusButtonText(signInBtn: SignInButton?, btnTxt: String) {
        for (i in 0 until signInBtn?.childCount!!) {
            val v: View = signInBtn.getChildAt(i)
            if (v is TextView) {
                v.text = btnTxt
                return
            }
        }
    }

}
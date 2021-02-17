package kz.jumysbar.intelteam.ui.authorization

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.gms.common.SignInButton
import kotlinx.android.synthetic.main.activity_authorization.*
import kz.jumysbar.intelteam.R

open class AuthorizationActivity : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
    : View? {
        return inflater.inflate(R.layout.activity_authorization, container, false)

        signInBtn?.let { setGooglePlusButtonText(it, "Войти с помощью Google") }
    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_authorization)
//       signInBtn?.let { setGooglePlusButtonText(it, "Войти с помощью Google") }
//
//    }


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
package kz.jumysbar.intelteam.ui.authorization

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceManager
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.authorization_fragment.*
import kz.jumysbar.intelteam.R
import kz.jumysbar.intelteam.fragment.PersonalPageFragment
import kz.jumysbar.intelteam.model.User

private const val GOOGLE_SIGN_IN = 1005
class AuthorizationFragment : Fragment() {

        private var googleSignInClient: GoogleSignInClient? = null
        private var firebaseAuth: FirebaseAuth? = null
        private lateinit var prefs: SharedPreferences
        private val db = Firebase.database

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.authorization_fragment, container, false)
    }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            prefs = PreferenceManager.getDefaultSharedPreferences(context?.applicationContext)
            val isSigned = prefs.getBoolean("googleUserSigned", false)
            if(isSigned){
                activity?.supportFragmentManager?.beginTransaction()
                    ?.replace(R.id.auth_container, PersonalPageFragment())
                    ?.addToBackStack(PersonalPageFragment::class.simpleName)
                    ?.commit()
            }else {
                signInBtn?.let { setGooglePlusButtonText(it, getString(R.string.login_with_google)) }
                signInBtn?.setOnClickListener {
                    signIn()
                }
            }


        }

        private fun signIn() {
            firebaseAuth = FirebaseAuth.getInstance()
            val options = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(this.getString(R.string.default_web_client_id))
                .requestEmail()
                .build()

            googleSignInClient = GoogleSignIn.getClient(requireContext(), options)
            val signInIntent = googleSignInClient?.signInIntent
            startActivityForResult(signInIntent, GOOGLE_SIGN_IN)
        }

        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)

            if (requestCode == GOOGLE_SIGN_IN) {
                val task = GoogleSignIn.getSignedInAccountFromIntent(data)
                try {
                    val account = task.getResult(ApiException::class.java)
                    val credential = GoogleAuthProvider.getCredential(account?.idToken, null)

                    firebaseAuth?.signInWithCredential(credential)
                        ?.addOnCompleteListener { authResult ->
                            if (authResult.isSuccessful) {
                                firebaseAuth?.currentUser?.let { user ->
                                    user.getIdToken(true).addOnCompleteListener { result ->
                                        result.result?.token
                                        db.getReference("users").child(user.uid)
                                            .addValueEventListener(object : ValueEventListener {
                                                override fun onDataChange(snapshot: DataSnapshot) {
                                                    val userApp = User(
                                                        user.displayName,
                                                        user.email,
                                                        user.photoUrl.toString()
                                                    )
                                                    db.getReference("users").child(user.uid)
                                                        .setValue(userApp)
                                                }
                                                override fun onCancelled(error: DatabaseError) {
                                                    Log.e("error", "onCancelled: $error.message ")
                                                }
                                            })

                                        prefs = PreferenceManager.getDefaultSharedPreferences(requireContext())
                                        prefs.edit()?.putBoolean("googleUserSigned", true)?.apply()
                                        prefs.edit()?. putString("googleUserID", user.uid)?.apply()
                                    }
                                    activity?.supportFragmentManager
                                        ?.beginTransaction()
                                        ?.replace(R.id.auth_container, PersonalPageFragment.newInstance(user.uid))
                                        ?.commit()
                                }

                            } else {
                                Log.e("SigIn", "Failure signInWithCredential")
                            }
                        }
                } catch (e: ApiException) {
                    Log.e(e.toString(), "Google sign in failed")
                }
            }
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
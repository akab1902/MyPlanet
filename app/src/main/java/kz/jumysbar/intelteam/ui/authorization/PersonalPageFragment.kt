package kz.jumysbar.intelteam.fragment

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceManager
import com.bumptech.glide.Glide
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.personal_page_fragment.*
import kz.jumysbar.intelteam.R
import kz.jumysbar.intelteam.model.User

class PersonalPageFragment : Fragment(R.layout.personal_page_fragment) {
    private lateinit var prefs: SharedPreferences
    private val db = Firebase.database
    private lateinit var userId: String

    companion object {
        fun newInstance(userId: String): PersonalPageFragment {
            val args = Bundle()
            args.putString("googleUId", userId)
            val fragment = PersonalPageFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        prefs = PreferenceManager.getDefaultSharedPreferences(requireContext())
        val prefsUserId = prefs.getString("googleUserID", "").orEmpty()
        userId = if (prefsUserId.isEmpty()) {
            arguments?.getString("googleUId", "").orEmpty()
        } else {
            prefsUserId
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recognizeUser(userId)
    }

    private fun recognizeUser(userId: String) {
        val ref = db.getReference("users").child(userId)
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val username = snapshot.getValue(User::class.java)?.username.toString()
                val email = snapshot.getValue(User::class.java)?.email.toString()
                val avatarUrl = snapshot.getValue(User::class.java)?.userPhotoURL?.toUri()

                userName?.text = username
                userEmail?.text = email
                userAvatar?.let {
                    Glide.with(this@PersonalPageFragment)
                        .load(avatarUrl).into(it)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.d("onCancelled", error.message)
            }
        })
    }
}
package org.videolan.aop

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun login(view: View) {
        LoginManager.isLogin = true;
    }

    @LoginState
    fun jump(view: View) {
        Toast.makeText(this, "2323232", Toast.LENGTH_SHORT).show()
    }
}

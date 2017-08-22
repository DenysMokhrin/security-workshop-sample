package co.temy.securitysample

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.view.View

class HomeActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var btnAddPassword: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        btnAddPassword = findViewById(R.id.btnAddPassword)

        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener { item -> onNavigationItemSelected(item) }

        showTab(PasswordsFragment())
    }

    fun onAddPasswordClick(view: View) {
        val intent = Intent(this, AddSecretActivity::class.java)
        startActivity(intent)
    }

    private fun onNavigationItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menuPasswords) {
            showTab(PasswordsFragment())
            btnAddPassword.show()
            return true
        } else if (item.itemId == R.id.menuEncryption) {
            showTab(EncryptionFragment())
            btnAddPassword.hide()
            return true
        }
        return false
    }

    private fun showTab(tab: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.tabContainer, tab)
        fragmentTransaction.commitNow()
    }
}
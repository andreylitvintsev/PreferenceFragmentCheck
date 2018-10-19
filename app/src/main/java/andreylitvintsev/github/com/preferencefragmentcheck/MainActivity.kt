package andreylitvintsev.github.com.preferencefragmentcheck

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

interface FragmentNavigator {
    fun showStatusFragment()
    fun showSettingsFragment()
}

// TODO: посмотреть как реализуется навигация между фрагментами
class MainActivity : AppCompatActivity(), FragmentNavigator {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (supportFragmentManager.findFragmentById(android.R.id.content) == null) {
            showStatusFragment()
        }
    }

    override fun showStatusFragment() {
        supportFragmentManager.beginTransaction()
            .replace(android.R.id.content, StatusFragment())
            .commit()
    }

    override fun showSettingsFragment() {
        supportFragmentManager.beginTransaction()
            .replace(android.R.id.content, SettingsFragment())
            .addToBackStack(null)
            .commit()
    }

}

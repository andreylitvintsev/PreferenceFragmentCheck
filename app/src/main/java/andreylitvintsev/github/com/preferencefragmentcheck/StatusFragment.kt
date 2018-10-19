package andreylitvintsev.github.com.preferencefragmentcheck

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.preference.PreferenceManager
import android.support.v7.widget.Toolbar
import android.view.*
import android.widget.TextView

class StatusFragment : Fragment() {

    private var toolbar: Toolbar? = null
    private var firstSwitchView: TextView? = null
    private var editTextView: TextView? = null
    private var secondSwitchView: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_status, container, false).also {
            firstSwitchView = it.findViewById(R.id.firstSwitchPreferenceView)
            editTextView = it.findViewById(R.id.editPreferenceView)
            secondSwitchView = it.findViewById(R.id.secondSwitchPreferenceView)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.menu_main, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.settings) {
            (activity as? FragmentNavigator)?.showSettingsFragment()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onResume() {
        super.onResume()

        updatePreferencesViews()
    }

    private fun updatePreferencesViews() {
        val preferences = PreferenceManager.getDefaultSharedPreferences(activity)

        val preferencesDefaultStringValue = context!!.getString(R.string.preferenceDefaultValue)
        val preferencesDefaultBooleanValue = false

        firstSwitchView?.text = preferences
            .getBoolean("firstSwitchPreference", preferencesDefaultBooleanValue)
            .toString()

        editTextView?.text = preferences
            .getString("editTextPreference", preferencesDefaultStringValue)

        secondSwitchView?.text = preferences
            .getBoolean("secondSwitchPreference", preferencesDefaultBooleanValue)
            .toString()
    }

}

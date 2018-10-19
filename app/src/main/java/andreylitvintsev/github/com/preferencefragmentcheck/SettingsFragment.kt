package andreylitvintsev.github.com.preferencefragmentcheck

import android.os.Bundle
import android.support.v7.preference.PreferenceFragmentCompat

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(p0: Bundle?, p1: String?) {
        addPreferencesFromResource(R.xml.settings_description)
    }

}

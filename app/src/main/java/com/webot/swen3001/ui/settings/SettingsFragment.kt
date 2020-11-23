package com.webot.swen3001.ui.settings

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.webot.swen3001.R

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.activity_preferences)
    }
}
/*
 * Copyright (C) 2025 AxionOS Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.infinity.suite.fragments

import android.os.Bundle

import android.provider.Settings
import androidx.preference.SwitchPreferenceCompat
import com.android.internal.logging.nano.MetricsProto
import com.android.settings.R
import com.android.settings.SettingsPreferenceFragment

class PowerOffVerify : SettingsPreferenceFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addPreferencesFromResource(R.xml.power_off_verify)
    }

override fun onResume() {
    super.onResume()

    val pref = findPreference<SwitchPreferenceCompat>("power_off_verify")
    pref?.isChecked = Settings.Secure.getInt(
        requireContext().contentResolver,
        "power_off_verify",
        0
    ) == 1
}

    override fun getMetricsCategory(): Int {
        return MetricsProto.MetricsEvent.INFINITY
    }
}

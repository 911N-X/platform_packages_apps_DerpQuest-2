/*
 * Copyright (C) 2017-2019 The PixelDust Project
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
package com.derpquest.settings.fragments;

import com.android.internal.logging.nano.MetricsProto;

import android.os.Bundle;
import com.android.settings.R;
import android.content.Context;
import android.content.ContentResolver;
import android.content.Intent;
import android.provider.Settings;
import androidx.preference.PreferenceCategory;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;
import androidx.preference.Preference.OnPreferenceChangeListener;
import androidx.preference.SwitchPreference;
import com.android.settings.SettingsPreferenceFragment;

import java.util.ArrayList;
import java.util.List;


public class RecentsSettings extends SettingsPreferenceFragment {

    private static final String RECENTS_COMPONENT_TYPE = "recents_component";

    private ListPreference mRecentsComponentType;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        addPreferencesFromResource(R.xml.derpquest_settings_recents);
        ContentResolver resolver = getActivity().getContentResolver();

        // recents component type
        mRecentsComponentType = (ListPreference) findPreference(RECENTS_COMPONENT_TYPE);
        mRecentsComponentType.setSummary(mRecentsComponentType.getEntry());
   }

    public boolean onPreferenceChange(Preference preference, Object newValue) {
        ContentResolver resolver = getActivity().getContentResolver();

        if (preference == mRecentsComponentType) {
            int type = Integer.valueOf((String) newValue);
            int index = mRecentsComponentType.findIndexOfValue((String) newValue);
            mRecentsComponentType.setSummary(mRecentsComponentType.getEntries()[index]);
            if (type == 1) { // Disable swipe up gesture, if oreo type selected
            }
        return true;
        }
      return false;
    }

    @Override public int getMetricsCategory() {
        return MetricsProto.MetricsEvent.OWLSNEST;
    }
}

/*
 * Copyright (C) 2016 The Android Open Source Project
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
package dev.techasyluminfo.old_languanges;



import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import dev.techasyluminfo.old_languanges.Fragment.ColorFragment;
import dev.techasyluminfo.old_languanges.Fragment.FamilyFragment;
import dev.techasyluminfo.old_languanges.Fragment.Number_Fragment;
import dev.techasyluminfo.old_languanges.Fragment.PhraseFragment;

/**
 * Provides the appropriate {@link Fragment} for a view pager.
 */
public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

  private Context mContext;
    public SimpleFragmentPagerAdapter(@NonNull FragmentManager fm,Context context) {
        super(fm);
        mContext=context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new Number_Fragment();
        } else if (position == 1){
            return new ColorFragment();
        } else if (position == 2) {
            return new FamilyFragment();
        } else {
            return new PhraseFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.category_numbers);
        } else if (position == 1) {
            return mContext.getString(R.string.category_family);
        } else if (position == 2) {
            return mContext.getString(R.string.category_colors);
        } else {
            return mContext.getString(R.string.category_phrases);
        }
    }
}

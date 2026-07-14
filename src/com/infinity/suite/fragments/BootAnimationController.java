/*
 * SPDX-FileCopyrightText: Evolution X
 * SPDX-License-Identifier: Apache-2.0
 */

package com.infinity.suite.fragments;

import android.content.Context;

import com.android.settings.core.BasePreferenceController;

import com.infinity.suite.utils.BootAnimationUtils;

public class BootAnimationController extends BasePreferenceController {

    public BootAnimationController(Context context, String preferenceKey) {
        super(context, preferenceKey);
    }

    @Override
    public int getAvailabilityStatus() {
        if (BootAnimationUtils.isBootAnimationSelectorDisabled()) {
            return UNSUPPORTED_ON_DEVICE;
        }
        // Hide on genuine Pixel devices where boot animation overrides have no effect.
        // Delegates to PixelPropsUtils which checks ro.product.model and ro.soc.manufacturer.
        return BootAnimationUtils.isPixelDevice()
                ? UNSUPPORTED_ON_DEVICE
                : AVAILABLE;
    }
}

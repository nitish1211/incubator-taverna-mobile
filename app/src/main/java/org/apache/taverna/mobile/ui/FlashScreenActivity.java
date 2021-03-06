/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.taverna.mobile.ui;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import org.apache.taverna.mobile.R;
import org.apache.taverna.mobile.data.DataManager;
import org.apache.taverna.mobile.data.local.PreferencesHelper;
import org.apache.taverna.mobile.ui.login.LoginActivity;

public class FlashScreenActivity extends AppCompatActivity {

    private DataManager dataManager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_screen);

        dataManager = new DataManager(new PreferencesHelper(this));

        if (!dataManager.getPreferencesHelper().isLoggedInFlag()) {
            dataManager.getPreferencesHelper().clear();
            startActivity(new Intent(FlashScreenActivity.this, LoginActivity.class));
            (FlashScreenActivity.this).finish();
        } else {
            startActivity(new Intent(FlashScreenActivity.this, DashboardActivity.class));
            (FlashScreenActivity.this).finish();
        }
    }



}

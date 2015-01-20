package com.api_hackathon.app.views;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import com.api_hackathon.app.R;
import com.api_hackathon.app.animations.BasicAnimations;
import com.api_hackathon.app.utils.AppConstants;

public class MainActivity extends Activity {
    private static final String TAG = "MainActivity";
    private BasicAnimations basicAnimations;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
        SharedPreferences sharedPreference = getSharedPreferences(
                AppConstants.APP_SHARED_PREFERENCE, Context.MODE_PRIVATE);
//        if (sharedPreference.getString(AppConstants.myContactPrefKey, "").length() > 0) {
//            Intent intent = new Intent(MainActivity.this, IvrActivity.class);
//            startActivity(intent);
//            finish();
//        }
        basicAnimations = new BasicAnimations(this);

        registerButton = (Button) findViewById(R.id.register_button);
        registerButton.setOnClickListener(onClickListener);

    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.register_button: {
                    registerButton.startAnimation(basicAnimations.zoomIn);
                    EditText editText = (EditText) findViewById(R.id.my_contact_number_edit_text);
                    SharedPreferences sharedPreference = getSharedPreferences(
                            AppConstants.APP_SHARED_PREFERENCE, Context.MODE_PRIVATE);
                    sharedPreference.edit().putString(AppConstants.myContactPrefKey, editText.getText().toString()).commit();
                    Log.w(TAG, "Number : " + sharedPreference.getString(AppConstants.myContactPrefKey, ""));
//                    Intent intent = new Intent(MainActivity.this, IvrActivity.class);
//                    startActivity(intent);
                    new GCMAcitivityRegister(MainActivity.this, editText.getText().toString());
                    break;
                }
            }
        }
    };
}

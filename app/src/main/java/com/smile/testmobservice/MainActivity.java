package com.smile.testmobservice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.mob.mobapi.API;
import com.mob.mobapi.APICallback;
import com.mob.mobapi.MobAPI;
import com.mob.mobapi.apis.Mobile;
import com.mob.mobapi.apis.Weather;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private String TAG = "face_wu";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Weather weather = (Weather) MobAPI.getAPI(Weather.NAME);
        weather.getSupportedCities(new APICallback() {
            @Override
            public void onSuccess(API api, int i, Map<String, Object> map) {
                Log.i(TAG,"weatherInfo = " + map);
            }

            @Override
            public void onError(API api, int i, Throwable throwable) {
                Log.i(TAG,"onError = " + throwable);
            }
        });

        // 获取一个手机归属地API
        Mobile api = (Mobile) MobAPI.getAPI(Mobile.NAME);
// 执行归属地查询
        api.phoneNumberToAddress("13202721906", new APICallback() {
            public void onSuccess(API api, int action, Map<String, Object> result) {
                Log.i(TAG,"onSuccess = " + result);
            }

            public void onError(API api, int action, Throwable details) {
                Log.i(TAG,"onError = " + details);
            }
        });

    }
}

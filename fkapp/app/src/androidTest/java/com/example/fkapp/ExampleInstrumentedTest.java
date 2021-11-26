package com.example.fkapp;

import android.content.Context;
import android.util.Log;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.fkapp.utils.IdUtils;
import com.example.fkapp.utils.SendGetThread;
import com.example.fkapp.utils.china.ChinaEpidemic;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.ling.epidemicinfo", appContext.getPackageName());
    }
    @Test
    public void test() throws IOException, InterruptedException, JSONException {
        String url = "https://api.inews.qq.com/newsqa/v1/automation/foreign/country/ranklist";
        SendGetThread sendGetThread = new SendGetThread(url);
        sendGetThread.start();
        sendGetThread.join();
        String s1= sendGetThread.getResult();
        url = "https://api.inews.qq.com/newsqa/v1/automation/modules/list?modules=FAutoGlobalStatis,FAutoCountryConfirmAdd";
        sendGetThread = new SendGetThread(url);
        sendGetThread.start();
        sendGetThread.join();
        String s2= sendGetThread.getResult();

    }
}
package com.fanli.uiautomator;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.Until;
import android.util.Log;

import com.fanli.uiautomator.handleData.Fps;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

import static java.lang.System.out;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class Action {
    private static final String BASIC_SAMPLE_PACKAGE
            = "com.fanli.android.apps";
    private static final int LAUNCH_TIMEOUT = 5000;
    private static final String STRING_TO_BE_TYPED = "UiAutomator";
    private static UiDevice mDevice;

    private static int a = 1;

    @Before
    public void setUp() throws InterruptedException {
        a = 3;
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        mDevice.pressHome();

        // Wait for launcher
        final String launcherPackage = mDevice.getLauncherPackageName();
        assertThat(launcherPackage, notNullValue());
        mDevice.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)),
                LAUNCH_TIMEOUT);

        // Launch the app
        Context context = InstrumentationRegistry.getContext();
        final Intent intent = context.getPackageManager().getLaunchIntentForPackage(BASIC_SAMPLE_PACKAGE);
        //Clear out any previous instances
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);

        // Wait for the app to appear
        mDevice.wait(Until.hasObject(By.pkg(BASIC_SAMPLE_PACKAGE).depth(0)),
                LAUNCH_TIMEOUT);
        Thread.sleep(10000);
    }

    @Test
    public void enterFanli() throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
//                String workpath1 = System.getProperty("user.dir");
                File directory = new File("");
                String workPath1 = directory.getPath();
                Log.v("test",workPath1);
            }
        }).start();
//        mDevice.findObject(By.text("超级返")).click();
        Thread.sleep(3000);
        Switch.fpsEnd=true;
        Log.v("test","3333 ");

    }

    @After
    public void tearDown(){
        mDevice.pressHome();
    }
}

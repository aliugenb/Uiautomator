package com.fanli.uiautomator.getData;

import com.fanli.uiautomator.handleData.Fps;

/**
 * Created by Roger on 2018/3/27.
 */

public class GetData implements Runnable {
    @Override
    public void run() {
        new Fps().writeExcel("fps");
    }
}

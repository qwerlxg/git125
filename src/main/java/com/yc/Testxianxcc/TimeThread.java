package com.yc.Testxianxcc;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeThread extends Thread {

    @Override
    public void run() {
        while (true) {
            // 获取当前时间
            Date currentTime = new Date();

            // 定义时间格式
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            // 格式化时间
            String formattedTime = sdf.format(currentTime);

            // 输出当前时间
            System.out.println(Thread.currentThread().getName() + ": " + formattedTime);

            try {
                // 线程休眠1秒
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            Thread thread = new TimeThread();
            // 设置线程名称
            thread.setName("Thread-" + i);
            // 启动线程
            thread.start();
        }
    }
}
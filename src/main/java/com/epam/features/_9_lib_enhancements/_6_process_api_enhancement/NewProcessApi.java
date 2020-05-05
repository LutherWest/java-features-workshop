package com.epam.features._9_lib_enhancements._6_process_api_enhancement;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * @since 9
 */
public class NewProcessApi {
    public static void main(String[] args) throws Exception {
        final Process jshellProcess = Runtime.getRuntime().exec("C:\\Program Files\\Java\\jdk-14.0.1\\bin\\jshell");

        jshellProcess.toHandle().onExit().thenAccept(process -> System.out.println("OnExit"));
        System.out.println("Is alive: " + jshellProcess.isAlive());
        System.out.println("Info: " + jshellProcess.info());
        System.out.println("Pid: " + jshellProcess.pid());

        InputStream out = jshellProcess.getInputStream();
        OutputStream in = jshellProcess.getOutputStream();

        byte[] buffer = new byte[4000];
        while (jshellProcess.toHandle().isAlive()) {
            int no = out.available();
            if (no > 0) {
                int n = out.read(buffer, 0, Math.min(no, buffer.length));
                System.out.println(new String(buffer, 0, n));
            }

            int ni = System.in.available();
            if (ni > 0) {
                int n = System.in.read(buffer, 0, Math.min(ni, buffer.length));
                in.write(buffer, 0, n);
                in.flush();
            }

            Thread.sleep(10);
        }

        Thread.sleep(1000);
    }
}

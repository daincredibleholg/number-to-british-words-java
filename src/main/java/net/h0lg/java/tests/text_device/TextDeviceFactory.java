package net.h0lg.java.tests.text_device;

import java.io.BufferedReader;
import java.io.Console;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * This factory returns a valid and working text device (aka console) the
 * application can use to interact with the user.
 * The text device is instantiated once per application run (Singleton pattern).
 */
public class TextDeviceFactory {

    private static TextDevice device;

    /**
     * This class should not be instantiated...
     */
    private TextDeviceFactory() {  }

    /**
     * Returns a usable TextDevice implementation. On most systems
     * Java's Console will be used behind the scenes.
     *
     * @return Appropriate TextDevice implementation instance
     * @throws Exception If something goes wrong during implementation lookup and instantiation
     */
    public static TextDevice createTextDevice() throws Exception {
        // once the device is known, we can return it directly
        if (device != null) {
            return device;
        }

        Console console = System.console();

        if (console == null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter writer = new PrintWriter(System.out);

            device = new CharacterTextDevice(reader, writer);
        } else {
            device = new ConsoleTextDevice(console);
        }
        return device;
    }
}
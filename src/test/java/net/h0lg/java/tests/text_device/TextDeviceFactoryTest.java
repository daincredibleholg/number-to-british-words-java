package net.h0lg.java.tests.text_device;

import org.junit.Assert;
import org.junit.Test;

/**
 * Testing the factory for console abstraction.
 *
 */
public class TextDeviceFactoryTest {

    @Test
    public void createTextDevice() throws Exception{
        TextDevice textDevice = TextDeviceFactory.createTextDevice();
        Assert.assertNotNull(textDevice);
    }
}

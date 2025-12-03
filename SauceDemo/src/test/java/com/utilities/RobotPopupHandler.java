package com.utilities;

import java.awt.*;
import java.awt.event.KeyEvent;

public class RobotPopupHandler {

    public static void handlePopup() {
        try {
            Robot robot = new Robot();
            robot.setAutoDelay(300);

            // Press ESC to close password popup
            robot.keyPress(KeyEvent.VK_ESCAPE);
            robot.keyRelease(KeyEvent.VK_ESCAPE);

        } catch (Exception e) {
            System.out.println("Robot popup handler failed: " + e.getMessage());
        }
    }
}
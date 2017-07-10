package _002_Robot;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.net.URI;


public class RobotTest {


    public static void main(String[] args) throws Exception {

       Desktop.getDesktop().browse(new URI("https://www.google.com/"));
       Thread.sleep(5000);
       int tabsAmount = 45;
        String login = "login";
        String password = "passw";
        Robot robot = new Robot();

        pressAndReleaseKey(robot, KeyEvent.VK_TAB, tabsAmount);

        pressAndReleaseKeysForString(robot, login);

        pressAndReleaseKey(robot, KeyEvent.VK_TAB, 1);

        pressAndReleaseKeysForString(robot, password);

        pressAndReleaseKey(robot, KeyEvent.VK_TAB, 1);

        pressAndReleaseKey(robot, KeyEvent.VK_ENTER, 1);



    }

    private static void pressAndReleaseKeysForString(Robot robot, String text) {
        for (char c : text.toCharArray()){
            pressAndReleaseKey(robot, getKeyEvent(c), 1);
        }
    }

    private static void pressAndReleaseKey(Robot robot, int keyEvent , int amount){
        for(int i =0; i<amount; i++) {
            robot.keyPress(keyEvent);
            robot.keyRelease(keyEvent);
        }
    }

    private static int getKeyEvent(char c) {
        int keyEvent;
        switch (c){
            case 'a': keyEvent = KeyEvent.VK_A; break;
            case 'b': keyEvent = KeyEvent.VK_B; break;
            case 'c': keyEvent = KeyEvent.VK_C; break;
            case 'd': keyEvent = KeyEvent.VK_D; break;
            case 'e': keyEvent = KeyEvent.VK_E; break;
            case 'f': keyEvent = KeyEvent.VK_F; break;
            case 'g': keyEvent = KeyEvent.VK_G; break;
            case 'h': keyEvent = KeyEvent.VK_H; break;
            case 'i': keyEvent = KeyEvent.VK_I; break;
            case 'j': keyEvent = KeyEvent.VK_J; break;
            case 'k': keyEvent = KeyEvent.VK_K; break;
            case 'l': keyEvent = KeyEvent.VK_L; break;
            case 'ł': keyEvent = KeyEvent.VK_L; break;
            case 'm': keyEvent = KeyEvent.VK_M; break;
            case 'n': keyEvent = KeyEvent.VK_N; break;
            case 'o': keyEvent = KeyEvent.VK_O; break;
            case 'p': keyEvent = KeyEvent.VK_P; break;
            case 'q': keyEvent = KeyEvent.VK_Q; break;
            case 'r': keyEvent = KeyEvent.VK_R; break;
            case 's': keyEvent = KeyEvent.VK_S; break;
            case 't': keyEvent = KeyEvent.VK_T; break;
            case 'u': keyEvent = KeyEvent.VK_U; break;
            case 'v': keyEvent = KeyEvent.VK_V; break;
            case 'w': keyEvent = KeyEvent.VK_W; break;
            case 'z': keyEvent = KeyEvent.VK_Z; break;
            default : keyEvent = -1;

        }
        return keyEvent;
    }

}
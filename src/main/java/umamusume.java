import org.python.google.common.base.Stopwatch;
import org.sikuli.script.*;
import org.springframework.util.StopWatch;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Timer;

public class umamusume {

    public static boolean isRelicBuster;
    public static int intTotalLoop;
    public static int intWaitTime;

    public static void main(String[] args)throws Exception {
        String[] strPath = umamusume.class.getProtectionDomain().getCodeSource().getLocation().getPath().split("/");
        String strImagePath = getPathExisting(strPath) + "image\\";
        Properties prop = new Properties();
        String strConfigName = "config.cfg";
        loadConfig(prop,strConfigName);
        Screen screen = new Screen();
        String strAutomationType = prop.get("automation_type").toString();
        intTotalLoop = Integer.parseInt(prop.get("total_loop").toString());
        intWaitTime = Integer.parseInt(prop.get("wait_time").toString());
        isRelicBuster = Boolean.parseBoolean(prop.get("Relic_Buster").toString());
        if(strAutomationType.equals("event_auto")){
            event_auto objEventAuto = new event_auto();
            objEventAuto.run(screen, strImagePath, intTotalLoop, intWaitTime);
        }else if(strAutomationType.equals("raid_auto")){
            raid_auto objRaidAuto = new raid_auto();
            objRaidAuto.run(screen, strImagePath, intTotalLoop, intWaitTime);
        }
    }

    public static void useElixir(Screen screen, String imgPath, String imgName){
        String img = imgPath+imgName;
        boolean isClicked = false;
        while (!isClicked) {
            try {
                List<Match> arrayMatch = screen.findAllByRow(new Pattern(img));
                Match matchImage = arrayMatch.get(1);
                matchImage.mouseMove();
                matchImage.click();
                isClicked = true;
            } catch (Exception e) {
                System.out.println("Retrying to click the image..." + imgName);
            }
        }
    }

    public static void clickImage(Screen screen, String imgPath, String imgName)throws Exception {
        String img = imgPath+imgName;
        StopWatch stopWatch = new StopWatch();
        boolean isClicked = false;
        stopWatch.start();
        while (!isClicked && stopWatch.getTotalTimeSeconds() <= 10.00) {
            try {
                if(img.contains("btnUse")){
                   List<Match> iterMatch = screen.findAllList(new Pattern(img));
                   Match matchImage = iterMatch.get(1);
                   matchImage.mouseMove();
                   matchImage.click();
                }else{
                    Match matchImage = screen.find(new Pattern(img));
                    matchImage.mouseMove();
                    matchImage.click();
                }
                isClicked = true;
            } catch (FindFailed e) {
                System.out.println("Retrying to click the image..." + imgName);
            }
        }
        stopWatch.stop();
    }

    public static void doubleClickImage(Screen screen, String imgPath, String imgName) {
        String img = imgPath+imgName;
        boolean isClicked = false;
        while (!isClicked) {
            try {
                screen.find(new Pattern(img)).doubleClick();
                isClicked = true;
            } catch (FindFailed e) {
                System.out.println("Retrying to click the image..." + imgName);
            }
        }
    }

    public static void pasteRaidCode(Screen screen){
        screen.type("v", Key.CTRL);
    }

    public static boolean isExistScreen(Screen screen, String imgPath, String imgName){
        String img = imgPath + imgName;
        boolean isExist;
        try {
            isExist = screen.find(new Pattern(img)).isValid();
        } catch (FindFailed e) {
            System.out.println("Retrying to click the image..." + imgName);
            isExist = false;
        }
        return isExist;
    }

    public static void clearPendingBattles(Screen screen,String strImagePath)throws Exception{
        clickImage(screen,strImagePath , "btnOK" + ".png");
        Thread.sleep(2000);
        while(isExistScreen(screen,strImagePath , "btnSelectSummon" + ".png")){
            clickImage(screen,strImagePath , "btnSelectSummon" + ".png");

            if(isExistScreen(screen,strImagePath , "btnOK" + ".png")) {
                clickImage(screen, strImagePath, "btnOK" + ".png");
            }
            Thread.sleep(2000);

            if(isExistScreen(screen,strImagePath , "btnPendingBattle" + ".png")){
                clickImage(screen,strImagePath , "btnPendingBattle" + ".png");
            }
            Thread.sleep(1000);
        }
    }

    public static String getPathExisting(String[] strAbsolutePath) {
        String strTemp = "";
        for (int i = 0; i < strAbsolutePath.length - 1; i++) {
            strTemp += strAbsolutePath[i].replace("%20"," ") + "\\";
        }
        return strTemp;
    }

    public static void waitUntilImage(Screen screen, String imgPath, String imgName)throws Exception{
        String img = imgPath+imgName;
        boolean isExist = false;
        while (!isExist) {
            try {
                Match matchImage = screen.find(new Pattern(img));
                isExist = true;
            }catch (FindFailed e) {
                System.out.println("Retrying to click the image..." + imgName);
            }
        }
    }

    public static Properties loadConfig(Properties prop, String strConfigName){
        try(FileInputStream fis = new FileInputStream(strConfigName)){
            prop.load(fis);
        }catch(Exception e){
            System.out.println("FAILED READING CONFIG FILE...");
        }
        return prop;
    }

    //end of line
}
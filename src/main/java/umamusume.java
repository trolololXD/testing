import javazoom.jl.player.JavaSoundAudioDevice;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.python.google.common.base.Stopwatch;
import org.sikuli.script.*;
import org.springframework.util.StopWatch;
import javazoom.jl.player.Player;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Mixer;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Timer;

public class umamusume {
    public static WebDriver webDriver;
    public static boolean isRelicBuster;
    public static int intTotalLoop;
    public static int intWaitTime;
    public static boolean isOugi,QuickSummon;
    public static String strImagePath, Summon1,Summon2,Summon3,strPhone;
    public static Screen screen;

    public static void main(String[] args)throws Exception {
        String[] strPath = umamusume.class.getProtectionDomain().getCodeSource().getLocation().getPath().split("/");
        strImagePath = getPathExisting(strPath) + "image\\";
        Properties prop = new Properties();
        String strConfigName = "config.cfg";
        loadConfig(prop,strConfigName);
        screen = new Screen();

        //get config data
        String strAutomationType = prop.get("automation_type").toString();
        intTotalLoop = Integer.parseInt(prop.get("total_loop").toString());
        intWaitTime = Integer.parseInt(prop.get("wait_time").toString());
        isRelicBuster = Boolean.parseBoolean(prop.get("Relic_Buster").toString());
        isOugi = Boolean.parseBoolean(prop.get("Ougi").toString());
        Summon1 = prop.get("Summon1").toString();
        Summon2 = prop.get("Summon2").toString();
        QuickSummon = Boolean.parseBoolean(prop.get("Quick_Summon").toString());
        strPhone = prop.get("Phone").toString();

        //set chromedriver path
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
        System.out.println(System.getProperty("webdriver.chrome.driver"));

        try{
            if(strAutomationType.equals("event_auto")){
                event_auto objEventAuto = new event_auto();
                objEventAuto.run(screen, strImagePath, intTotalLoop, intWaitTime);
            }else if(strAutomationType.equals("raid_auto")){
                raid_auto objRaidAuto = new raid_auto();
                objRaidAuto.run(screen, strImagePath, intTotalLoop, intWaitTime);
            }else if(strAutomationType.equals("full_auto")){
                full_auto objFullAuto = new full_auto();
                objFullAuto.run(screen, strImagePath, intTotalLoop, intWaitTime);
            }
        }catch(Exception e){
            e.printStackTrace();
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
                if(umamusume.isExistScreen(screen, imgPath, "imgBuff" + ".png")){
                    umamusume.clickImage(screen,imgPath , "btnSummon" + ".png");
                }
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

    public static void findSummon(Screen screen, String imgPath)throws Exception{
        boolean isFound = false;
        String img = imgPath + Summon1;
        int Counter = 0;
        while(!isFound){
            try{
                Match matchByText = screen.find(img);
                matchByText.click();
                isFound = true;
            }catch(Exception e){
                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_PAGE_DOWN);
                Thread.sleep(1000);
                Counter++;
                if(Counter >= 4){
                    robot.keyPress(KeyEvent.VK_HOME);
                    Thread.sleep(1000);
                    img = imgPath + Summon2;
                }
            }
        }
    }

    public static void PlaySong(String imgPath)throws Exception{
        FileInputStream fs = new FileInputStream(imgPath + "Hatsune Miku - Levan Polka.mp3");
        Player player = new Player(fs);
        player.play();
    }

    public static void CaptchaCheck(Screen screen, String imgPath)throws Exception{
        if(umamusume.isExistScreen(screen,imgPath, "txtCaptcha" + ".png") || umamusume.isExistScreen(screen,imgPath, "txtEnterVerification" + ".png") ||
                umamusume.isExistScreen(screen,imgPath, "txtVerification" + ".png")){
            do{
                umamusume.PlaySong(imgPath);
                sendWA(strPhone);
            }while(umamusume.isExistScreen(screen,imgPath, "txtCaptcha" + ".png"));
        }
    }

    public static void sendWA(String strPhone)throws Exception{
        webDriver = new ChromeDriver();
        String strUrlWA = "https://api.whatsapp.com/send?phone="+strPhone+"&text=CAPTCHA";
        webDriver.get(strUrlWA);
        clickImage(screen, strImagePath, "openWhatsapp.png");
        Thread.sleep(5000);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
    }

    //end of line
}
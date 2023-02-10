import org.sikuli.script.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
public class umamusume {
    public static String isRelicBuster;
    public static int intTotalLoop;
    public static int intWaitTime;
    public static boolean isOugi,QuickSummon;
    public static String strImagePath, Summon1,Summon2,strPhone, strEventType, strAutomationType, strMCSkin, strDjeetaOrSarasa, V1orV2, strArcarumType, strArcarumDefender , strArcarumTreasure;
    public static Screen screen;
    public static String characterName, characterSkill;
    public static boolean isReset = false;
    public static String strImageToCheck;

    public static void main(String[] args)throws Exception {
        String[] strPath = umamusume.class.getProtectionDomain().getCodeSource().getLocation().getPath().split("/");
        strImagePath = getPathExisting(strPath) + "..\\image\\"; //prod
        System.out.println("Image Folder : " + strImagePath);
        //strImagePath = getPathExisting(strPath) + "image\\"; //dev
        Properties prop = new Properties();
        String strConfigName = "..\\config.cfg"; //prod
        //String strConfigName = "config.cfg"; //dev
        loadConfig(prop,strConfigName);
        screen = new Screen();

        //get config data
        strAutomationType = prop.get("automation_type").toString();
        intTotalLoop = Integer.parseInt(prop.get("total_loop").toString());
        intWaitTime = Integer.parseInt(prop.get("wait_time").toString());
        isRelicBuster = prop.get("Raid_Auto_Type").toString();
        isOugi = Boolean.parseBoolean(prop.get("Ougi").toString());
        Summon1 = prop.get("Summon1").toString();
        Summon2 = prop.get("Summon2").toString();
        QuickSummon = Boolean.parseBoolean(prop.get("Quick_Summon").toString());
        //strPhone = prop.get("Phone").toString();
        strEventType = prop.get("event_type").toString();
        strMCSkin = prop.get("MC_Skin").toString();
        strDjeetaOrSarasa = prop.get("DjeetaOrSarasa").toString();
        V1orV2 = prop.get("V1orV2").toString();
        strImageToCheck = prop.get("Image_to_Check").toString();
        characterName = prop.get("Character_Name").toString();
        characterSkill = prop.get("Character_Skill").toString();
        //add arcarum
        strArcarumType = prop.get("arcarum_type"). toString();
        strArcarumDefender = prop.get("arcarum_defender"). toString();
        strArcarumTreasure = prop.get("arcarum_treasure"). toString();



        try{
            if(args[0].equalsIgnoreCase("CheckImage")) {
                ImageCheck.run();
            }
        }catch(Exception e){
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
                }else if(strAutomationType.equalsIgnoreCase("arcarum")){
                    Arcarum objArcarum = new Arcarum();
                    objArcarum.run(screen, strImagePath, intTotalLoop, intWaitTime);
                }
            }catch(Exception f){
                e.printStackTrace();
            }
        }







    }

    public static void useElixir(Screen screen, String imgPath, String imgName)throws Exception{
        String img = imgPath+imgName;
        Robot robot = new Robot();
        boolean isClicked = false;
        while (!isClicked) {
            try {
                List<Match> arrayMatch = screen.findAllByRow(new Pattern(img));
                Match matchImage = arrayMatch.get(1);
                matchImage.mouseMove();
                matchImage.click();
                robot.keyPress(KeyEvent.VK_END);
                robot.keyPress(KeyEvent.VK_ENTER);
                isClicked = true;
                umamusume.clickImage(screen,strImagePath , "btnUse" + ".png");
            } catch (Exception e) {
                System.out.println("Retrying to click the image..." + imgName);
            }
        }
    }

    public static boolean clickImage(Screen screen, String imgPath, String imgName)throws Exception {
        Thread.sleep(100);
        String img = imgPath+imgName;
        boolean isClicked = false;
        int Counter = 0;
        while (!isClicked && Counter <= 100) {
            try {
                if (img.contains("btnUse")) {
                    List<Match> arrayMatch = screen.findAllByRow(new Pattern(img));
                    Match matchImage = arrayMatch.get(1);
                    if(matchImage.getScore() > 0.90) matchImage.click();
                } else {
                    Match matchImage = screen.find(new Pattern(img));
                    matchImage.click();
                }
                isClicked = true;
                System.out.println("Clicking on the image - " + imgName);
            } catch (FindFailed e) {
                System.out.println("Retrying to click the image..." + imgName);
                Counter++;
            }
        }
        if(Counter >= 100){
            throw new Exception ("Click Image Failed After Trying 100 Times");
        }
        return isClicked;
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
        boolean isExist = false;
        try {
             if(screen.find(new Pattern(img)).getScore() > 0.90)
                 isExist = true;
        } catch (FindFailed e) {
            System.out.println("Image Not Exist On Screen...");
        }
        return isExist;
    }

    public static void clearPendingBattles(Screen screen,String strImagePath)throws Exception{
        clickImage(screen,strImagePath , "btnOK" + ".png");
        Thread.sleep(2000);
        while(isExistScreen(screen,strImagePath , "btnSelectSummon" + ".png")){
            clickImage(screen,strImagePath , "btnSelectSummon" + ".png");
            Thread.sleep(3000);

            PressBack();


//            if(umamusume.isExistScreen(screen, strImagePath, "btnQuest.png")){
//                umamusume.clickImage(screen,strImagePath , "imgInputRaid" + ".png");
//            }
//
//            if(isExistScreen(screen,strImagePath , "btnOK" + ".png")) {
//                clickImage(screen, strImagePath, "btnOK" + ".png");
//                Thread.sleep(2000);
//            }
//
//            if(isExistScreen(screen,strImagePath , "btnPendingBattle" + ".png")) {
//                clickImage(screen, strImagePath, "btnPendingBattle" + ".png");
//                Thread.sleep(2000);
//            }
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
        int counter = 0;
        while (!isExist) {
            try {
                Match matchImage = screen.find(new Pattern(img));
                isExist = true;
            }catch (FindFailed e) {
                System.out.println("Waiting for image - " + imgName + " to be displayed.");
                if(strAutomationType.equals("full_auto")){
                   checkTrigger(screen, strImagePath);
                   checkDead(screen, strImagePath);
                }else if(strAutomationType.equalsIgnoreCase("raid_auto")){
                    if(umamusume.isExistScreen(screen, strImagePath, "imgDjeetaBattleEnded.png")){
                        umamusume.clickImage(screen,strImagePath , "imgInputRaid" + ".png");
                    }else if(umamusume.isExistScreen(screen, strImagePath, "btnQuest.png")){
                        umamusume.clickImage(screen,strImagePath , "imgInputRaid" + ".png");
                    }else if(umamusume.isExistScreen(screen, strImagePath, "btnNext.png")){
                        throw new Exception ("Button Next Found - Restarting Bot");
                    }else if(umamusume.isExistScreen(screen, strImagePath, "imgPartyDead.png")){
                        throw new Exception ("Party MODYAR - Restarting Bot");
                    }
                }
            }
        }
    }

    public static void checkTrigger(Screen screen, String imgPath)throws Exception{
        System.out.println("Check Trigger...");
            if(umamusume.isExistScreen(screen, imgPath, "imgBuff" + ".png")){
                    umamusume.clickImage(screen, strImagePath , "imgUmamusume" + ".png");
                    ExplicitWait(intWaitTime);
                    umamusume.waitUntilImage(screen,strImagePath , "btnAtk" + ".png");
                    umamusume.clickImage(screen, strImagePath , "btnSummon" + ".png");
                    ExplicitWait(2*intWaitTime);
                    for (int i = 0; i < 2; i++) {
                        umamusume.clickImage(screen, strImagePath, "btnHeal" + ".png");
                        umamusume.clickImage(screen, strImagePath, "btnBluePot" + ".png");
                        umamusume.clickImage(screen,strImagePath , "btnOK" + ".png");
                    }
                    umamusume.clickImage(screen,strImagePath , "btnFullAuto" + ".png");
            }
    }

    public static void checkDead(Screen screen, String imgPath)throws Exception{
        System.out.println("Check Dead...");
        if(umamusume.isExistScreen(screen, imgPath, "imgPartyDead" + ".png")){
            ExplicitWait(2*intWaitTime);
            umamusume.clickImage(screen, strImagePath , "imgPartyDead" + ".png");
            umamusume.clickImage(screen, strImagePath , "imgUmamusume" + ".png");
            umamusume.waitUntilImage(screen,strImagePath , "btnCancel" + ".png");
            umamusume.clickImage(screen, strImagePath , "btnCancel" + ".png");
            Thread.sleep(1000);
            umamusume.clickImage(screen, strImagePath , "btnCancel" + ".png");
            Thread.sleep(1000);
            umamusume.clickImage(screen, strImagePath , "btnClose" + ".png");
            Thread.sleep(1000);
            umamusume.clickImage(screen, strImagePath , "btnHeal" + ".png");
            Thread.sleep(1000);
            umamusume.clickImage(screen, strImagePath , "imgRevive" + ".png");
            Thread.sleep(1000);
            umamusume.clickImage(screen,strImagePath , "btnOK" + ".png");
            Thread.sleep(1000);
            for (int i = 0; i < 2; i++) {
                umamusume.clickImage(screen, strImagePath, "btnHeal" + ".png");
                umamusume.clickImage(screen, strImagePath, "btnBluePot" + ".png");
                Thread.sleep(1000);
                if(umamusume.isExistScreen(screen, strImagePath , "btnOK" + ".png")){
                    umamusume.clickImage(screen, strImagePath , "btnOK" + ".png");
                }else{
                    umamusume.clickImage(screen,strImagePath , "btnCancel" + ".png");
                }
            }

            umamusume.clickImage(screen,strImagePath , "btnFullAuto" + ".png");
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
                if(Counter == 4){
                    robot.keyPress(KeyEvent.VK_HOME);
                    Thread.sleep(1000);
                    img = imgPath + Summon2;
                }
                if(Counter >= 10)
                {
                    clickImage(screen,strImagePath , "btnSelectSummon" + ".png");
                    isFound = true;
                }

            }
        }
    }

    public static void CaptchaCheck(Screen screen, String imgPath)throws Exception{
        if(umamusume.isExistScreen(screen,imgPath, "txtCaptcha" + ".png") || umamusume.isExistScreen(screen,imgPath, "txtEnterVerification" + ".png") ||
                umamusume.isExistScreen(screen,imgPath, "txtVerification" + ".png")){
            do{
                //sendWA(strPhone);
            }while(umamusume.isExistScreen(screen,imgPath, "txtCaptcha" + ".png"));
        }
    }

//    public static void sendWA(String strPhone)throws Exception{
//        webDriver = new ChromeDriver();
//        String strUrlWA = "https://api.whatsapp.com/send?phone="+strPhone+"&text=CAPTCHA";
//        webDriver.get(strUrlWA);
//        clickImage(screen, strImagePath, "openWhatsapp.png");
//        Thread.sleep(5000);
//        Robot robot = new Robot();
//        robot.keyPress(KeyEvent.VK_ENTER);
//    }

    public static void ExplicitWait(int intWaitTime)throws Exception{
        System.out.println("Waiting for " + intWaitTime/1000 + " seconds");
        Thread.sleep(intWaitTime);
    }

    public static void PressBack()throws Exception{
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_LEFT);
        Thread.sleep(500);
        robot.keyRelease(KeyEvent.VK_ALT);
        robot.keyRelease(KeyEvent.VK_LEFT);
    }



    //end of line
}
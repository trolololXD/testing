import org.sikuli.script.*;

public class raid {
    public static void main(String[] args)throws Exception {
        String[] strPath = raid.class.getProtectionDomain().getCodeSource().getLocation().getPath().split("/");
        String strImagePath = getPathExisting(strPath) + "image\\";
        Screen screen = new Screen();

        for (int i = 0; i < 100; i++) {
            clickImage(screen,strImagePath + "tabGBFLife" + ".png");
            Thread.sleep(500);
            clickImage(screen,strImagePath + "tabRaidCode" + ".png");
            clickImage(screen,strImagePath + "tabGBF" + ".png");
            clickImage(screen,strImagePath + "imgInputRaid" + ".png");
            if(!isExistScreen(screen,strImagePath + "inputRaidCode" + ".png")){
                clickImage(screen,strImagePath + "txtEnterID" + ".png");
            }
            doubleClickImage(screen,strImagePath + "inputRaidCode" + ".png");
            pasteRaidCode(screen);
            clickImage(screen,strImagePath + "btnJoinRoom" + ".png");
            Thread.sleep(2000);
            if(isExistScreen(screen,strImagePath + "imgBerry" + ".png")){
                clickImage(screen,strImagePath + "btnUse" + ".png");
                clickImage(screen,strImagePath + "btnOK" + ".png");
            }
            if(isExistScreen(screen,strImagePath + "txtLimit" + ".png")){
                clickImage(screen,strImagePath + "btnOK" + ".png");
                Thread.sleep(5000);
                continue;
            }
            if(isExistScreen(screen,strImagePath + "txtPendingBattle" + ".png")){
                clearPendingBattles(screen,strImagePath);
                continue;
            }
            clickImage(screen,strImagePath + "btnSelectSummon" + ".png");
            clickImage(screen,strImagePath + "btnOK" + ".png");
            clickImage(screen,strImagePath + "btnAtk" + ".png");
            clickImage(screen,strImagePath + "imgInputRaid" + ".png");
        }
    }


    private static void clickImage(Screen screen, String img)throws Exception {
        boolean isClicked = false;
        while (!isClicked) {
            try {
                Match matchImage = screen.find(new Pattern(img));
                matchImage.mouseMove();
                matchImage.click();
                isClicked = true;
            } catch (FindFailed e) {
                System.out.println("Retrying to click the image...");
            }
        }
    }

    private static void doubleClickImage(Screen screen, String img) {
        boolean isClicked = false;
        while (!isClicked) {
            try {
                screen.find(new Pattern(img)).doubleClick();
                isClicked = true;
            } catch (FindFailed e) {
                System.out.println("Retrying to click the image..." + img.split("\\\\")[8]);
            }
        }
    }

    private static void pasteRaidCode(Screen screen){
        screen.type("v",Key.CTRL);
    }

    private static boolean isExistScreen(Screen screen, String img){
        boolean isExist;
        try {
            isExist = screen.find(new Pattern(img)).isValid();
        } catch (FindFailed e) {
            System.out.println("Retrying to click the image...");
            isExist = false;
        }
        return isExist;
    }

    private static void clearPendingBattles(Screen screen,String strImagePath)throws Exception{
        clickImage(screen,strImagePath + "btnOK" + ".png");
        Thread.sleep(2000);
        while(isExistScreen(screen,strImagePath + "btnSelectSummon" + ".png")){
            clickImage(screen,strImagePath + "btnSelectSummon" + ".png");
            clickImage(screen,strImagePath + "btnOK" + ".png");
            Thread.sleep(2000);
            if(isExistScreen(screen,strImagePath + "btnPendingBattle" + ".png")){
                clickImage(screen,strImagePath + "btnPendingBattle" + ".png");
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
    //end of line
}

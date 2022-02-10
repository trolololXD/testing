import org.sikuli.script.*;

import java.util.Iterator;
import java.util.List;

public class umamusume {
    public static void main(String[] args)throws Exception {
        String[] strPath = umamusume.class.getProtectionDomain().getCodeSource().getLocation().getPath().split("/");
        String strImagePath = getPathExisting(strPath) + "image\\";
        Screen screen = new Screen();

        for (int i = 0; i < 100; i++) {
            clickImage(screen, strImagePath , "imgUmamusume" + ".png");
            clickImage(screen,strImagePath , "btnSelectSummon" + ".png");
            Thread.sleep(1000);
            clickImage(screen,strImagePath , "btnOK" + ".png");
            Thread.sleep(1000);
            if(isExistScreen(screen,strImagePath , "imgElixir" + ".png")){
                clickImage(screen,strImagePath , "btnUse" + ".png");
                clickImage(screen,strImagePath , "btnOK" + ".png");
            }
            clickImage(screen,strImagePath , "btnAtk" + ".png");
            clickImage(screen,strImagePath , "btnSemiAuto" + ".png");
            clickImage(screen,strImagePath , "btnOK" + ".png");
        }
    }

    private static void clickImage(Screen screen, String imgPath, String imgName)throws Exception {
        String img = imgPath+imgName;
        boolean isClicked = false;
        while (!isClicked) {
            try {
                if(img.contains("btnUse")){
                   Iterator<Match> iterMatch = screen.findAll(new Pattern(img));
                   while(iterMatch.hasNext()){
                     iterMatch.next().mouseMove();
                     iterMatch.next().click();
                    }
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
    }

    private static void doubleClickImage(Screen screen, String imgPath, String imgName) {
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

    private static void pasteRaidCode(Screen screen){
        screen.type("v", Key.CTRL);
    }

    private static boolean isExistScreen(Screen screen, String imgPath, String imgName){
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

    private static void clearPendingBattles(Screen screen,String strImagePath)throws Exception{
        clickImage(screen,strImagePath , "btnOK" + ".png");
        Thread.sleep(2000);
        while(isExistScreen(screen,strImagePath , "btnSelectSummon" + ".png")){
            clickImage(screen,strImagePath , "btnSelectSummon" + ".png");
            clickImage(screen,strImagePath , "btnOK" + ".png");
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
    //end of line
}

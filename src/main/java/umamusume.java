import org.sikuli.script.*;
import java.util.List;

public class umamusume {
    public static void main(String[] args)throws Exception {
        String strImagePath = raid.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "image\\";
        Screen screen = new Screen();

        for (int i = 0; i < 100; i++) {
            clickImage(screen,strImagePath + "imgUmamusume" + ".png");
            clickImage(screen,strImagePath + "btnSelectSummon" + ".png");
            clickImage(screen,strImagePath + "btnOK" + ".png");
            Thread.sleep(1000);
            if(isExistScreen(screen,strImagePath + "imgElixir" + ".png")){
                clickImage(screen,strImagePath + "btnUse" + ".png");
                clickImage(screen,strImagePath + "btnOK" + ".png");
            }
            clickImage(screen,strImagePath + "btnAtk" + ".png");
            clickImage(screen,strImagePath + "btnSemiAuto" + ".png");
            clickImage(screen,strImagePath + "btnOK" + ".png");
        }
    }

    private static void clickImage(Screen screen, String img)throws Exception {
        boolean isClicked = false;
        while (!isClicked) {
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
                System.out.println("Retrying to click the image..." + img.split("\\\\")[8]);
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
        screen.type("v", Key.CTRL);
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
    //end of line
}

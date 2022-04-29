import org.sikuli.script.Screen;

public class full_auto {
    public void run(Screen screen, String strImagePath, int intTotalLoop, int intWaitTime)throws Exception{
        for (int i = 0; i < intTotalLoop; i++) {
            umamusume.clickImage(screen, strImagePath , "imgUmamusume" + ".png");
            umamusume.waitUntilImage(screen,strImagePath , "btnSelectSummon" + ".png");
            umamusume.findSummon(screen,strImagePath);
            umamusume.clickImage(screen,strImagePath , "btnOK" + ".png");
            Thread.sleep(intWaitTime);

            umamusume.CaptchaCheck(screen, strImagePath);

            if(umamusume.isExistScreen(screen,strImagePath , "imgElixir" + ".png")){
                umamusume.waitUntilImage(screen,strImagePath , "btnUse" + ".png");
                umamusume.useElixir(screen,strImagePath , "btnUse" + ".png");
                umamusume.clickImage(screen,strImagePath , "btnOK" + ".png");
            }

            if(umamusume.isOugi){
              if(umamusume.isExistScreen(screen,strImagePath , "btnOugiOff" + ".png"))
                  umamusume.clickImage(screen,strImagePath , "btnOugiOff" + ".png");
            }
            umamusume.waitUntilImage(screen,strImagePath , "btnFullAuto" + ".png");
            Thread.sleep(intWaitTime);
            umamusume.clickImage(screen,strImagePath , "btnFullAuto" + ".png");
            umamusume.clickImage(screen,strImagePath , "imgSummon" + ".png");
            umamusume.waitUntilImage(screen,strImagePath , "imgSummonToCall" + ".png");
            umamusume.clickImage(screen,strImagePath , "imgSummonToCall" + ".png");
            umamusume.clickImage(screen,strImagePath , "btnOK" + ".png");
            Thread.sleep(intWaitTime);
            umamusume.waitUntilImage(screen,strImagePath , "btnOK" + ".png");
            umamusume.clickImage(screen,strImagePath , "btnOK" + ".png");
        }
        System.exit(0);
    }


}


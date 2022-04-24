import org.sikuli.script.Screen;

public class event_auto {
    public void run(Screen screen, String strImagePath, int intTotalLoop, int intWaitTime)throws Exception{
         for (int i = 0; i < intTotalLoop; i++) {
            umamusume.clickImage(screen, strImagePath , "imgUmamusume" + ".png");
            umamusume.clickImage(screen,strImagePath , "btnSelectSummon" + ".png");
            umamusume.clickImage(screen,strImagePath , "btnOK" + ".png");
            Thread.sleep(intWaitTime);

             if(umamusume.isExistScreen(screen,strImagePath, "txtCaptcha" + ".png")){
                 umamusume.PlaySong(strImagePath);
             }

            if(umamusume.isExistScreen(screen,strImagePath , "imgElixir" + ".png")){
                umamusume.waitUntilImage(screen,strImagePath , "btnUse" + ".png");
                umamusume.useElixir(screen,strImagePath , "btnUse" + ".png");
                umamusume.clickImage(screen,strImagePath , "btnOK" + ".png");
            }

             umamusume.waitUntilImage(screen,strImagePath , "btnSummon" + ".png");
             Thread.sleep(intWaitTime);
             if(umamusume.QuickSummon){
                 umamusume.clickImage(screen,strImagePath , "btnSummon" + ".png");
             }

            if(umamusume.isRelicBuster){
                if(umamusume.isExistScreen(screen,strImagePath , "btnOugiOff" + ".png")){
                    umamusume.clickImage(screen,strImagePath , "btnOugiOff" + ".png");
                }
                umamusume.clickImage(screen,strImagePath , "imgDjeetaRelicBuster" + ".png");
                umamusume.clickImage(screen,strImagePath , "btnEngage" + ".png");
                //v.1.2.0
                umamusume.clickImage(screen,strImagePath , "btnLimitBurst" + ".png");
            }

            umamusume.clickImage(screen,strImagePath , "btnAtk" + ".png");
            umamusume.clickImage(screen,strImagePath , "btnSemiAuto" + ".png");
             Thread.sleep(2*intWaitTime);
            umamusume.clickImage(screen, strImagePath , "imgUmamusume" + ".png");
            umamusume.waitUntilImage(screen,strImagePath , "btnOK" + ".png");
            umamusume.clickImage(screen,strImagePath , "btnOK" + ".png");
        }
        System.exit(0);
    }


}


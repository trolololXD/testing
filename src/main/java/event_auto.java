import org.sikuli.script.Screen;

public class event_auto {
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

             umamusume.waitUntilImage(screen,strImagePath , "btnAtk" + ".png");
             Thread.sleep(intWaitTime);

            if(umamusume.strEventType.equals("Ougi")){
                if(umamusume.isExistScreen(screen,strImagePath , "btnOugiOff" + ".png")){
                    umamusume.clickImage(screen,strImagePath , "btnOugiOff" + ".png");
                }
                umamusume.clickImage(screen,strImagePath , "imgDjeetaRelicBuster" + ".png");
                umamusume.clickImage(screen,strImagePath , "btnEngage" + ".png");
                umamusume.clickImage(screen,strImagePath , "btnLimitBurst" + ".png");
                umamusume.clickImage(screen,strImagePath , "btnAtk" + ".png");
                Thread.sleep(2000);
                umamusume.clickImage(screen, strImagePath , "imgUmamusume" + ".png");
            }else if(umamusume.strEventType.equals("Auto")){
                umamusume.clickImage(screen,strImagePath , "btnAtk" + ".png");
                umamusume.clickImage(screen,strImagePath , "btnSemiAuto" + ".png");
            }else if (umamusume.strEventType.equals("Bubs")) {
                umamusume.clickImage(screen, strImagePath , "btnSummon" + ".png");
                Thread.sleep(1000);
                umamusume.clickImage(screen, strImagePath , "imgUmamusume" + ".png");
            }else if(umamusume.strEventType.equals("Slime Blast")) {
                umamusume.clickImage(screen,strImagePath , "DjeetaSwordmaster" + ".png");
                umamusume.clickImage(screen,strImagePath , "Awakening" + ".png");
                umamusume.waitUntilImage(screen,strImagePath , "btnNext" + ".png");
                umamusume.clickImage(screen,strImagePath , "btnNext" + ".png");
                umamusume.waitUntilImage(screen,strImagePath , "btnAtk" + ".png");
                Thread.sleep(intWaitTime);
                umamusume.clickImage(screen,strImagePath , "Sarasa" + ".png");
                umamusume.clickImage(screen,strImagePath , "GroundZero" + ".png");
                umamusume.waitUntilImage(screen,strImagePath , "btnNext" + ".png");
                umamusume.clickImage(screen,strImagePath , "btnNext" + ".png");
            }

             umamusume.waitUntilImage(screen,strImagePath , "btnOK" + ".png");
             umamusume.clickImage(screen,strImagePath , "btnOK" + ".png");
             umamusume.clickImage(screen, strImagePath , "imgUmamusume" + ".png");
        }
        System.exit(0);
    }


}


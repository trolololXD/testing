import org.sikuli.script.Screen;


public class event_auto {
    public void run(Screen screen, String strImagePath, int intTotalLoop, int intWaitTime)throws Exception{
         for (int i = 0; i < intTotalLoop; i++) {
             System.out.println("Start of Loop");
            umamusume.clickImage(screen, strImagePath , "imgUmamusume" + ".png");
            umamusume.waitUntilImage(screen,strImagePath , "btnSelectSummon" + ".png");
            umamusume.findSummon(screen,strImagePath);
            umamusume.clickImage(screen,strImagePath , "btnOK" + ".png");
            umamusume.ExplicitWait(intWaitTime);

             umamusume.CaptchaCheck(screen, strImagePath);

            if(umamusume.isExistScreen(screen,strImagePath , "imgElixir" + ".png")){
                umamusume.waitUntilImage(screen,strImagePath , "btnUse" + ".png");
                umamusume.useElixir(screen,strImagePath , "qtyElixir" + ".png");
                umamusume.waitUntilImage(screen,strImagePath , "btnOK" + ".png");
                Thread.sleep(1000);
                umamusume.clickImage(screen,strImagePath , "btnOK" + ".png");
                Thread.sleep(1000);
            }

             umamusume.waitUntilImage(screen,strImagePath , "btnAtk" + ".png");
             umamusume.ExplicitWait(intWaitTime);

            if(umamusume.strEventType.equalsIgnoreCase("Ougi")){
                if(umamusume.isExistScreen(screen,strImagePath , "btnOugiOff" + ".png")){
                    umamusume.clickImage(screen,strImagePath , "btnOugiOff" + ".png");
                }
                umamusume.clickImage(screen,strImagePath , umamusume.strMCSkin + ".png");
                umamusume.clickImage(screen,strImagePath , "btnEngage" + ".png");
                umamusume.clickImage(screen,strImagePath , "btnLimitBurst" + ".png");
                umamusume.clickImage(screen,strImagePath , "btnAtk" + ".png");
                umamusume.ExplicitWait(intWaitTime);
                umamusume.clickImage(screen, strImagePath , "imgUmamusume" + ".png");
            }else if(umamusume.strEventType.equalsIgnoreCase("Auto")){
                umamusume.clickImage(screen,strImagePath , "btnAtk" + ".png");
                umamusume.clickImage(screen,strImagePath , "btnSemiAuto" + ".png");
            }else if (umamusume.strEventType.equalsIgnoreCase("Bubs")) {
                umamusume.clickImage(screen, strImagePath , "btnSummon" + ".png");
                //umamusume.clickImage(screen,strImagePath , "btnAtk" + ".png");
                Thread.sleep(1000);
                umamusume.clickImage(screen, strImagePath , "imgUmamusume" + ".png");
            }else if(umamusume.strEventType.equalsIgnoreCase("Slime Blast")) {
                if(umamusume.strDjeetaOrSarasa.equalsIgnoreCase("Djeeta")){
                    umamusume.clickImage(screen,strImagePath , "DjeetaSwordmaster" + ".png");
                    umamusume.clickImage(screen,strImagePath , "Awakening" + ".png");
                }else{
                    umamusume.clickImage(screen,strImagePath , "Sarasa" + ".png");
                    umamusume.clickImage(screen,strImagePath , "GroundZero" + ".png");
                }
                Thread.sleep(1500);
                umamusume.PressBack();
                umamusume.waitUntilImage(screen,strImagePath , "btnAtk" + ".png");
                umamusume.ExplicitWait(intWaitTime);
                umamusume.clickImage(screen,strImagePath , "btnSummon" + ".png");
                umamusume.clickImage(screen, strImagePath , "imgUmamusume" + ".png");
            }

             umamusume.waitUntilImage(screen,strImagePath , "btnOK" + ".png");
             umamusume.clickImage(screen,strImagePath , "btnOK" + ".png");
             umamusume.clickImage(screen, strImagePath , "imgUmamusume" + ".png");
             System.out.println("End of Loop");
        }
        System.exit(0);
    }


}


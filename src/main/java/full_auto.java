import org.sikuli.script.Screen;

public class full_auto {
    boolean isRunning = true;
    public void run(Screen screen, String strImagePath, int intTotalLoop, int intWaitTime)throws Exception{
        while(isRunning){
            try{
                System.out.println("Start of Loop");
                umamusume.clickImage(screen, strImagePath , "imgUmamusume" + ".png");
                umamusume.waitUntilImage(screen,strImagePath , "btnSelectSummon" + ".png");
                umamusume.findSummon(screen,strImagePath);
                Thread.sleep(1000);
                if(umamusume.isExistScreen(screen, strImagePath, "txtCaptcha" + ".png")){
                    isRunning = false;
                    throw new Exception ("CAPTCHA FOUND! Stopping bot...");
                }
                umamusume.clickImage(screen,strImagePath , "btnOK" + ".png");
                umamusume.ExplicitWait(intWaitTime);




                if(umamusume.isExistScreen(screen,strImagePath , "imgElixir" + ".png")){
                    umamusume.waitUntilImage(screen,strImagePath , "btnUse" + ".png");
                    umamusume.useElixir(screen,strImagePath , "qtyElixir" + ".png");
                    umamusume.clickImage(screen,strImagePath , "btnOK" + ".png");
                }

                if(umamusume.isOugi){
                    if(umamusume.isExistScreen(screen,strImagePath , "btnOugiOff" + ".png"))
                        umamusume.clickImage(screen,strImagePath , "btnOugiOff" + ".png");
                }
                umamusume.waitUntilImage(screen,strImagePath , "btnFullAuto" + ".png");
                if(umamusume.isExistScreen(screen, strImagePath, "KubiraSummer" + ".png")){
                    umamusume.clickImage(screen, strImagePath, "KubiraSummer" + ".png");
                    umamusume.clickImage(screen, strImagePath, "KubiraSummer3rdSkill" + ".png");
                    umamusume.clickImage(screen, strImagePath, "btnBack" + ".png");
                }
                umamusume.ExplicitWait(intWaitTime);
                umamusume.clickImage(screen,strImagePath , "btnFullAuto" + ".png");
                umamusume.clickImage(screen,strImagePath , "imgSummon" + ".png");
                umamusume.waitUntilImage(screen,strImagePath , "imgSummonToCall" + ".png");
                umamusume.clickImage(screen,strImagePath , "imgSummonToCall" + ".png");
                umamusume.clickImage(screen,strImagePath , "btnOK" + ".png");
                umamusume.ExplicitWait(intWaitTime);
                umamusume.waitUntilImage(screen,strImagePath , "txtExpGained" + ".png");
                umamusume.clickImage(screen,strImagePath , "btnOK" + ".png");
                System.out.println("End of Loop");
            }catch (Exception e) {
                if(e.toString().contains("CAPTCHA")){
                    System.out.println("Captcha Found - Stopping Bot");
                }else{
                    System.out.println("Error Found - Restarting Bot");
                    umamusume.clickImage(screen, strImagePath, "imgRefresh" + ".png");
                }
            }
        }
    }


}


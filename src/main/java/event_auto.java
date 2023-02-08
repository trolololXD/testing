import org.sikuli.script.Screen;


public class event_auto {
    boolean isRunning = true;

    public void run(Screen screen, String strImagePath, int intTotalLoop, int intWaitTime) throws Exception {
        while (isRunning) {
            try {
                System.out.println("Start of Loop");
                umamusume.clickImage(screen, strImagePath, "imgUmamusume" + ".png");
                umamusume.waitUntilImage(screen, strImagePath, "btnSelectSummon" + ".png");
                umamusume.findSummon(screen, strImagePath);
                Thread.sleep(1000);
                if(umamusume.isExistScreen(screen, strImagePath, "txtCaptcha" + ".png")){
                    isRunning = false;
                    throw new Exception ("CAPTCHA FOUND! Stopping bot...");
                }

                if (umamusume.isExistScreen(screen, strImagePath, "imgElixir" + ".png")) {
                    umamusume.waitUntilImage(screen, strImagePath, "btnUse" + ".png");
                    umamusume.useElixir(screen, strImagePath, "qtyElixir" + ".png");
                    umamusume.waitUntilImage(screen, strImagePath, "btnOK" + ".png");
                    Thread.sleep(1000);
                    umamusume.clickImage(screen, strImagePath, "btnOK" + ".png");
                    Thread.sleep(1000);
                }


                umamusume.clickImage(screen, strImagePath, "btnOK" + ".png");
                umamusume.ExplicitWait(intWaitTime);


                if (umamusume.isExistScreen(screen, strImagePath, "imgElixir" + ".png")) {
                    umamusume.waitUntilImage(screen, strImagePath, "btnUse" + ".png");
                    umamusume.useElixir(screen, strImagePath, "qtyElixir" + ".png");
                    umamusume.waitUntilImage(screen, strImagePath, "btnOK" + ".png");
                    Thread.sleep(1000);
                    umamusume.clickImage(screen, strImagePath, "btnOK" + ".png");
                    Thread.sleep(1000);
                }

                if(!umamusume.strEventType.equals("Proving Grounds")){
                    umamusume.waitUntilImage(screen, strImagePath, "btnAtk" + ".png");
                    umamusume.ExplicitWait(intWaitTime);
                }

                if (umamusume.strEventType.equalsIgnoreCase("Ougi")) {
                    if (umamusume.isExistScreen(screen, strImagePath, "btnOugiOff" + ".png")) {
                        umamusume.clickImage(screen, strImagePath, "btnOugiOff" + ".png");
                    }
                    umamusume.clickImage(screen, strImagePath, umamusume.strMCSkin + ".png");
                    umamusume.clickImage(screen, strImagePath, "btnEngage" + ".png");
                    umamusume.clickImage(screen, strImagePath, "btnLimitBurst" + ".png");
                    Thread.sleep(2000);
                    umamusume.clickImage(screen, strImagePath, "btnAtk" + ".png");
                    umamusume.ExplicitWait(intWaitTime);
                    umamusume.clickImage(screen, strImagePath, "imgUmamusume" + ".png");
                } else if (umamusume.strEventType.equalsIgnoreCase("Auto")) {
                    umamusume.clickImage(screen, strImagePath, "btnAtk" + ".png");
                    umamusume.clickImage(screen, strImagePath, "btnSemiAuto" + ".png");
                } else if (umamusume.strEventType.equalsIgnoreCase("Bubs")) {
                    umamusume.clickImage(screen, strImagePath, "btnSummon" + ".png");
                    //umamusume.clickImage(screen,strImagePath , "btnAtk" + ".png");
                    umamusume.ExplicitWait(intWaitTime);
                    umamusume.clickImage(screen, strImagePath, "imgUmamusume" + ".png");
                } else if (umamusume.strEventType.equalsIgnoreCase("Slime Blast")) {
                    if (umamusume.strDjeetaOrSarasa.equalsIgnoreCase("Djeeta")) {
                        umamusume.clickImage(screen, strImagePath, "DjeetaSwordmaster" + ".png");
                        umamusume.clickImage(screen, strImagePath, "Awakening" + ".png");
                    } else {
                        umamusume.clickImage(screen, strImagePath, "Sarasa" + ".png");
                        umamusume.clickImage(screen, strImagePath, "GroundZero" + ".png");
                    }
                    Thread.sleep(1500);
                    umamusume.PressBack();
                    umamusume.waitUntilImage(screen, strImagePath, "btnAtk" + ".png");
                    umamusume.ExplicitWait(intWaitTime);
                    umamusume.clickImage(screen, strImagePath, "btnSummon" + ".png");
                    umamusume.clickImage(screen, strImagePath, "imgUmamusume" + ".png");
                } else if(umamusume.strEventType.equalsIgnoreCase("Proving Grounds")){
                    umamusume.waitUntilImage(screen, strImagePath, "btnStart" + ".png");
                    umamusume.clickImage(screen, strImagePath, "btnStart" + ".png");
                    umamusume.waitUntilImage(screen, strImagePath, "btnAtk" + ".png");
                    umamusume.clickImage(screen, strImagePath, umamusume.strMCSkin + ".png");
                    umamusume.clickImage(screen, strImagePath, "btnEngage" + ".png");
                    umamusume.clickImage(screen, strImagePath, "btnLimitBurst" + ".png");
                    Thread.sleep(2000);
                    umamusume.clickImage(screen, strImagePath, "btnAtk" + ".png");
                    umamusume.ExplicitWait(intWaitTime);
                    umamusume.clickImage(screen, strImagePath, "btnBackBelow" + ".png");

                    umamusume.waitUntilImage(screen, strImagePath, "txtExpGained" + ".png");
                    umamusume.clickImage(screen, strImagePath, "btnOK" + ".png");
                    Thread.sleep(2000);
                    umamusume.clickImage(screen, strImagePath, "imgUmamusume" + ".png");
                    umamusume.waitUntilImage(screen, strImagePath, "btnStart" + ".png");
                    umamusume.clickImage(screen, strImagePath, "btnStart" + ".png");

                    umamusume.waitUntilImage(screen, strImagePath, "btnAtk" + ".png");
                    umamusume.clickImage(screen, strImagePath, umamusume.strMCSkin + ".png");
                    umamusume.clickImage(screen, strImagePath, "btnEngage" + ".png");
                    umamusume.clickImage(screen, strImagePath, "btnLimitBurst" + ".png");
                    Thread.sleep(2000);
                    umamusume.clickImage(screen, strImagePath, "btnAtk" + ".png");
                    umamusume.ExplicitWait(intWaitTime);
                    umamusume.clickImage(screen, strImagePath, "btnBackBelow" + ".png");

                    umamusume.waitUntilImage(screen, strImagePath, "txtExpGained" + ".png");
                    umamusume.clickImage(screen, strImagePath, "btnEventHome" + ".png");
                    Thread.sleep(2000);
                    continue;
                }
                umamusume.waitUntilImage(screen, strImagePath, "btnOK" + ".png");
                umamusume.clickImage(screen, strImagePath, "btnOK" + ".png");
                umamusume.clickImage(screen, strImagePath, "imgUmamusume" + ".png");
                System.out.println("End of Loop : ");
            } catch (Exception e) {
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


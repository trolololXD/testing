import org.sikuli.script.Screen;

public class raid_auto {
    public void run(Screen screen, String strImagePath, int intTotalLoop, int intWaitTime)throws Exception{
        for (int i = 0; i < intTotalLoop; i++) {
            System.out.println("Start of Loop");
                umamusume.clickImage(screen,strImagePath , "tabGBFLife" + ".png");
                Thread.sleep(intWaitTime);
                umamusume.clickImage(screen,strImagePath , "tabRaidCode" + ".png");
                umamusume.clickImage(screen,strImagePath , "tabGBF" + ".png");
                umamusume.clickImage(screen,strImagePath , "imgInputRaid" + ".png");

                if(umamusume.isExistScreen(screen,strImagePath , "btnJoinRoom" + ".png")){
                    Thread.sleep(1000);
                }else{
                    umamusume.clickImage(screen,strImagePath , "txtEnterID" + ".png");
                }

                umamusume.doubleClickImage(screen,strImagePath , "inputRaidCode" + ".png");
                umamusume.pasteRaidCode(screen);
                umamusume.clickImage(screen,strImagePath , "btnJoinRoom" + ".png");
                Thread.sleep(intWaitTime);

                if(umamusume.isExistScreen(screen,strImagePath , "imgBerry" + ".png")){
                    umamusume.waitUntilImage(screen,strImagePath , "btnUse" + ".png");
                    umamusume.useElixir(screen,strImagePath , "qtyElixir" + ".png");
                    umamusume.waitUntilImage(screen,strImagePath , "btnOK" + ".png");
                    Thread.sleep(1000);
                    umamusume.clickImage(screen,strImagePath , "btnOK" + ".png");
                    Thread.sleep(1000);
                }

                if(umamusume.isExistScreen(screen,strImagePath , "txtBattleEnded" + ".png")){
                    umamusume.clickImage(screen,strImagePath , "btnOK" + ".png");
                    Thread.sleep(5000);
                    continue;
                }

                if(umamusume.isExistScreen(screen,strImagePath , "txtLimit" + ".png")){
                    umamusume.clickImage(screen,strImagePath , "btnOK" + ".png");
                    Thread.sleep(5000);
                    continue;
                }

                if(umamusume.isExistScreen(screen,strImagePath , "txtPendingBattle" + ".png")){
                    umamusume.clearPendingBattles(screen,strImagePath);
                    continue;
                }

            if(umamusume.isExistScreen(screen,strImagePath , "txtDoesnotMatch" + ".png")){
                umamusume.clickImage(screen,strImagePath , "btnOK" + ".png");
                Thread.sleep(5000);
                continue;
            }

                umamusume.findSummon(screen,strImagePath);
                umamusume.clickImage(screen,strImagePath , "btnOK" + ".png");
                if(umamusume.isExistScreen(screen, strImagePath, "txtBattleEnded2" + ".png")){
                    continue;
                }

                if(umamusume.isRelicBuster.equalsIgnoreCase("Relic Buster")){
                    System.out.println("Raid Auto Type : Relic Buster");
                    if(umamusume.isExistScreen(screen,strImagePath , "btnOugiOff" + ".png")){
                        umamusume.clickImage(screen,strImagePath , "btnOugiOff" + ".png");
                    }
                    umamusume.waitUntilImage(screen,strImagePath , "btnAtk" + ".png");
                    umamusume.clickImage(screen,strImagePath , "imgDjeetaRelicBuster" + ".png");
                    umamusume.waitUntilImage(screen,strImagePath , "btnEngage" + ".png");
                    umamusume.clickImage(screen,strImagePath , "btnEngage" + ".png");
                    umamusume.clickImage(screen,strImagePath , "btnLimitBurst" + ".png");
                    Thread.sleep(2000);
                    umamusume.clickImage(screen,strImagePath , "btnAtk" + ".png");
                }else if(umamusume.isRelicBuster.equalsIgnoreCase("Full Auto")){
                    System.out.println("Raid Auto Type : Relic Buster");
                    if(umamusume.V1orV2.equalsIgnoreCase("V1")){
                        umamusume.waitUntilImage(screen,strImagePath , "btnFullAuto" + ".png");
                        umamusume.clickImage(screen,strImagePath , "btnFullAuto" + ".png");
                    }else{
                        umamusume.waitUntilImage(screen,strImagePath , "btnFullAutoV2" + ".png");
                        umamusume.clickImage(screen,strImagePath , "btnFullAutoV2" + ".png");
                    }

                    umamusume.waitUntilImage(screen,strImagePath , "txtExpGained" + ".png");
                }else if(umamusume.isRelicBuster.equalsIgnoreCase("Wanpan")){
                    System.out.println("Raid Auto Type : Wanpan");
                    umamusume.clickImage(screen,strImagePath , "btnAtk" + ".png");
                }

                Thread.sleep(3000);
                umamusume.clickImage(screen,strImagePath , "imgInputRaid" + ".png");
            System.out.println("End of Loop");
            }
        }
    }



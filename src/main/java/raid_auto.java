import org.sikuli.script.Screen;

public class raid_auto {
    public void run(Screen screen, String strImagePath, int intTotalLoop, int intWaitTime)throws Exception{
        for (int i = 0; i < intTotalLoop; i++) {
                umamusume.clickImage(screen,strImagePath , "tabGBFLife" + ".png");
                Thread.sleep(intWaitTime);
                umamusume.clickImage(screen,strImagePath , "tabRaidCode" + ".png");
                umamusume.clickImage(screen,strImagePath , "tabGBF" + ".png");
                umamusume.clickImage(screen,strImagePath , "imgInputRaid" + ".png");

                if(!umamusume.isExistScreen(screen,strImagePath , "inputRaidCode" + ".png")){
                    umamusume.clickImage(screen,strImagePath , "txtEnterID" + ".png");
                }

                umamusume.doubleClickImage(screen,strImagePath , "inputRaidCode" + ".png");
                umamusume.pasteRaidCode(screen);
                umamusume.clickImage(screen,strImagePath , "btnJoinRoom" + ".png");
                Thread.sleep(intWaitTime);

                if(umamusume.isExistScreen(screen,strImagePath , "imgBerry" + ".png")){
                    umamusume.clickImage(screen,strImagePath , "btnUse" + ".png");
                    umamusume.clickImage(screen,strImagePath , "btnOK" + ".png");
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
                umamusume.clickImage(screen,strImagePath , "btnSelectSummon" + ".png");
                umamusume.clickImage(screen,strImagePath , "btnOK" + ".png");

                if(umamusume.isRelicBuster){
                    if(umamusume.isExistScreen(screen,strImagePath , "btnOugiOff" + ".png")){
                        umamusume.clickImage(screen,strImagePath , "btnOugiOff" + ".png");
                    }
                    umamusume.clickImage(screen,strImagePath , "imgDjeetaRelicBuster" + ".png");
                    umamusume.clickImage(screen,strImagePath , "btnEngage" + ".png");
                    umamusume.clickImage(screen,strImagePath , "btnLimitBurst" + ".png");
                }

                umamusume.clickImage(screen,strImagePath , "btnAtk" + ".png");
                umamusume.clickImage(screen,strImagePath , "imgInputRaid" + ".png");
            }
        }
    }



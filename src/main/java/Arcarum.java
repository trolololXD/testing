import org.sikuli.script.Screen;

public class Arcarum {
    boolean isRunning = true;

    public void run(Screen screen, String strImagePath, int intTotalLoop, int intWaitTime) throws Exception {
        while (isRunning) {
            try {
                System.out.println("Start of Loop");
                umamusume.clickImage(screen, strImagePath, "btnSandboxStage" + ".png");
                umamusume.isExistScreen(screen, strImagePath, "arcarumimgzone" + ".png");
                umamusume.waitUntilImage(screen,strImagePath, "arcarumimgzone" + ".png");
                //arcarum treasure = true
                if (umamusume.isExistScreen(screen, strImagePath, "treasurebox" + ".png")) {
                    if (umamusume.strArcarumTreasure.equalsIgnoreCase("yes")) {
                        System.out.println("arcarum treasure : yes");
                        umamusume.clickImage(screen, strImagePath, "treasurebox" + ".png");
                        umamusume.isExistScreen(screen, strImagePath, "opentreasure" + ".png");
                        umamusume.waitUntilImage(screen, strImagePath, "btnOK" + ".png");
                        umamusume.clickImage(screen, strImagePath, "btnOK" + ".png");
                        Thread.sleep(3000);
                        if (umamusume.isExistScreen(screen, strImagePath, "arcarummimic" + ".png")) {
                            umamusume.waitUntilImage(screen, strImagePath, "arcarummimic" + ".png");
                            umamusume.clickImage(screen, strImagePath, "arcarummimic" + ".png");
                            umamusume.waitUntilImage(screen, strImagePath, "btnOK" + ".png");
                            umamusume.clickImage(screen, strImagePath, "btnOK" + ".png");
                            umamusume.waitUntilImage(screen, strImagePath, "btnAtk" + ".png");
                            umamusume.clickImage(screen, strImagePath, "btnAtk" + ".png");
                            Thread.sleep(1000);
                            umamusume.clickImage(screen, strImagePath, "btnBackBelow" + ".png");
                            umamusume.waitUntilImage(screen, strImagePath, "txtExpGained" + ".png");
                            umamusume.clickImage(screen, strImagePath, "btnSandboxStage" + ".png");
                            umamusume.isExistScreen(screen, strImagePath, "arcarumimgzone"+ ".png");
                            umamusume.waitUntilImage(screen, strImagePath, "arcarumimgzone" + ".png");
                            umamusume.clickImage(screen, strImagePath, "imgRefresh" + ".png");
                        }
                        if (umamusume.isExistScreen(screen, strImagePath, "btnOK" + ".png")) {
                            umamusume.waitUntilImage(screen, strImagePath, "btnOK" + ".png");
                            umamusume.clickImage(screen, strImagePath, "btnOK" + ".png");
                        }
                    } else System.out.println("arcarum treasure : no");
                }

                if (umamusume.isExistScreen(screen, strImagePath, "arcarumdefender" + ".png")) {
                    if (umamusume.strArcarumDefender.equalsIgnoreCase("yes")) {
                        System.out.println("arcarum defender : yes");
                        umamusume.clickImage(screen, strImagePath, "arcarumdefender" + ".png");
                        umamusume.waitUntilImage(screen, strImagePath, "btnOK" + ".png");
                        umamusume.clickImage(screen, strImagePath, "btnOK" + ".png");
                        //elixir
                        if (umamusume.isExistScreen(screen, strImagePath, "imgElixir" + ".png")) {
                            umamusume.waitUntilImage(screen, strImagePath, "btnUse" + ".png");
                            umamusume.useElixir(screen, strImagePath, "qtyElixir" + ".png");
                            umamusume.waitUntilImage(screen, strImagePath, "btnOK" + ".png");
                            Thread.sleep(1000);
                            umamusume.clickImage(screen, strImagePath, "btnOK" + ".png");
                            Thread.sleep(1000);
                        }
                        umamusume.waitUntilImage(screen, strImagePath, "btnFullAuto" + ".png");
                        umamusume.clickImage(screen, strImagePath, "btnFullAuto" + ".png");
                        umamusume.waitUntilImage(screen, strImagePath, "txtExpGained" + ".png");
                        umamusume.clickImage(screen, strImagePath, "btnSandboxStage" + ".png");
                        umamusume.isExistScreen(screen, strImagePath, "arcarumimgzone"+ ".png");
                        umamusume.waitUntilImage(screen, strImagePath, "arcarumimgzone" + ".png");
                        umamusume.clickImage(screen, strImagePath, "imgRefresh" + ".png");
                    } else System.out.println("arcarum defender : no");
                }

                if (umamusume.isExistScreen(screen, strImagePath, "arcarumimgzone" + ".png")) { //original
                    Thread.sleep(1000);
                    umamusume.clickImage(screen, strImagePath, "imgUmamusume" + ".png");
                    umamusume.waitUntilImage(screen, strImagePath, "btnOK" + ".png");
                    umamusume.clickImage(screen, strImagePath, "btnOK" + ".png");
                    Thread.sleep(2000);
                    //elixir
                    if (umamusume.isExistScreen(screen, strImagePath, "imgElixir" + ".png")) {
                        umamusume.waitUntilImage(screen, strImagePath, "btnUse" + ".png");
                        umamusume.useElixir(screen, strImagePath, "qtyElixir" + ".png");
                        umamusume.waitUntilImage(screen, strImagePath, "btnOK" + ".png");
                        Thread.sleep(1000);
                        umamusume.clickImage(screen, strImagePath, "btnOK" + ".png");
                        Thread.sleep(1000);
                    }
                    //tambahan arcarum type relic buster / wanpan / full auto
                    if (umamusume.strArcarumType.equalsIgnoreCase("RBarc")) {
                        System.out.println("arcarum type : RBarc");
                        if (umamusume.isExistScreen(screen, strImagePath, "btnOugiOff" + ".png")) {
                            umamusume.clickImage(screen, strImagePath, "btnOugiOff" + ".png");
                        }
                        umamusume.waitUntilImage(screen, strImagePath, "btnAtk" + ".png");
                        umamusume.clickImage(screen, strImagePath, "imgDjeetaRelicBuster" + ".png");
                        umamusume.waitUntilImage(screen, strImagePath, "btnEngage" + ".png");
                        umamusume.clickImage(screen, strImagePath, "btnEngage" + ".png");
                        umamusume.clickImage(screen, strImagePath, "btnLimitBurst" + ".png");
                        Thread.sleep(2000);
                        umamusume.clickImage(screen, strImagePath, "btnAtk" + ".png");
                        Thread.sleep(2000);
                        umamusume.clickImage(screen, strImagePath, "btnBackBelow" + ".png");
                        umamusume.waitUntilImage(screen, strImagePath, "txtExpGained" + ".png");
                        umamusume.clickImage(screen, strImagePath, "btnSandboxStage" + ".png");
                        umamusume.isExistScreen(screen, strImagePath, "arcarumimgzone"+ ".png");
                        umamusume.waitUntilImage(screen, strImagePath, "arcarumimgzone" + ".png");
                        umamusume.clickImage(screen, strImagePath, "imgRefresh" + ".png");
                    } else if (umamusume.strArcarumType.equalsIgnoreCase("otkarc")) {
                        System.out.println("arcarum type : otkarc");
                        if (umamusume.isExistScreen(screen, strImagePath, "btnOugiOff" + ".png")) {
                            umamusume.clickImage(screen, strImagePath, "btnOugiOff" + ".png");
                        }
                        umamusume.waitUntilImage(screen, strImagePath, "btnAtk" + ".png");
                        umamusume.clickImage(screen, strImagePath, "btnAtk" + ".png");
                        Thread.sleep(1000);
                        umamusume.clickImage(screen, strImagePath, "btnBackBelow" + ".png");
                        umamusume.waitUntilImage(screen, strImagePath, "txtExpGained" + ".png");
                        umamusume.clickImage(screen, strImagePath, "btnSandboxStage" + ".png");
                        umamusume.isExistScreen(screen, strImagePath, "arcarumimgzone"+ ".png");
                        umamusume.waitUntilImage(screen, strImagePath, "arcarumimgzone" + ".png");
                        umamusume.clickImage(screen, strImagePath, "imgRefresh" + ".png");
                    } else if (umamusume.strArcarumType.equalsIgnoreCase("FA")) {
                        System.out.println("arcarum type : FA");
                        umamusume.waitUntilImage(screen, strImagePath, "btnFullAuto" + ".png");
                        umamusume.clickImage(screen, strImagePath, "btnFullAuto" + ".png");
                        umamusume.waitUntilImage(screen, strImagePath, "txtExpGained" + ".png");
                        umamusume.clickImage(screen, strImagePath, "btnSandboxStage" + ".png");
                        umamusume.isExistScreen(screen, strImagePath, "arcarumimgzone"+ ".png");
                        umamusume.waitUntilImage(screen, strImagePath, "arcarumimgzone" + ".png");
                        umamusume.clickImage(screen, strImagePath, "imgRefresh" + ".png");

                    } else if (umamusume.strArcarumType.equalsIgnoreCase("otkfast")) {
                        System.out.println("arcarum type : otkfast");
                        if (umamusume.isExistScreen(screen, strImagePath, "btnOugiOff" + ".png")) {
                            umamusume.clickImage(screen, strImagePath, "btnOugiOff" + ".png");
                        }
                        umamusume.waitUntilImage(screen, strImagePath, "btnAtk" + ".png");
                        umamusume.clickImage(screen, strImagePath, "btnAtk" + ".png");
                        Thread.sleep(1000);
                        umamusume.clickImage(screen, strImagePath, "btnBackBelow" + ".png");
                        umamusume.waitUntilImage(screen, strImagePath, "txtExpGained" + ".png");
                        umamusume.clickImage(screen, strImagePath, "btnSandboxStage" + ".png");
                    }
                }
                System.out.println("End of Loop : ");
            } catch (Exception e) {
                if (e.toString().contains("CAPTCHA")) {
                    System.out.println("Captcha Found - Stopping Bot");
                } else {
                    System.out.println("Error Found - Restarting Bot");
                    umamusume.clickImage(screen, strImagePath, "imgRefresh" + ".png");
                }
            }
        }
    }
}

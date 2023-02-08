import org.sikuli.script.Screen;

public class Arcarum {
    boolean isRunning = true;

    public void run(Screen screen, String strImagePath, int intTotalLoop, int intWaitTime) throws Exception {
        while (isRunning) {
            try {
                System.out.println("Start of Loop");
                umamusume.clickImage(screen, strImagePath , "imgUmamusume" + ".png");
                umamusume.waitUntilImage(screen, strImagePath, "btnOK" + ".png");
                umamusume.clickImage(screen, strImagePath , "btnOK" + ".png");
                Thread.sleep(2000);

                if (umamusume.isExistScreen(screen, strImagePath, "imgElixir" + ".png")) {
                    umamusume.waitUntilImage(screen, strImagePath, "btnUse" + ".png");
                    umamusume.useElixir(screen, strImagePath, "qtyElixir" + ".png");
                    umamusume.waitUntilImage(screen, strImagePath, "btnOK" + ".png");
                    Thread.sleep(1000);
                    umamusume.clickImage(screen, strImagePath, "btnOK" + ".png");
                    Thread.sleep(1000);
                }

                umamusume.waitUntilImage(screen, strImagePath, "btnAtk" + ".png");
                umamusume.clickImage(screen, strImagePath, "btnAtk" + ".png");
                Thread.sleep(2000);
                umamusume.clickImage(screen, strImagePath, "btnBackBelow" + ".png");
                umamusume.waitUntilImage(screen, strImagePath, "txtExpGained" + ".png");
                umamusume.clickImage(screen, strImagePath, "btnSandboxStage" + ".png");
                Thread.sleep(3000);
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

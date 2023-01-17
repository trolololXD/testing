import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class ImageCheck {

    public static void main(String[] args){
        run();
    }
    public static void run(){
        String[] strPath = umamusume.class.getProtectionDomain().getCodeSource().getLocation().getPath().split("/");
        String strImagePath = umamusume.getPathExisting(strPath) + "image\\"; //dev
        Screen screenCheckImage = umamusume.screen;
        screenCheckImage = new Screen();

        try{
            Match matchCheck = screenCheckImage.find(new Pattern(strImagePath + umamusume.strImageToCheck));
            matchCheck.mouseMove();
            System.out.println("IMAGE FOUND WITH SCORE OF : " + matchCheck.getScore());
        }catch(Exception e){
            System.out.println("IMAGE NOT FOUND");
        }

    }

}

import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class ImageCheck {

    public static void main(String[] args){
        run();
    }
    public static void run(){
        String strImagePath = umamusume.strImagePath;
        String imgToCheck = strImagePath + umamusume.strImageToCheck;
        System.out.println("Image Folder : " + imgToCheck);

        try{
            Match matchCheck = umamusume.screen.find(new Pattern(imgToCheck));
            matchCheck.mouseMove();
            System.out.println("IMAGE FOUND WITH SCORE OF : " + matchCheck.getScore());
        }catch(Exception e){
            System.out.println("IMAGE NOT FOUND");
        }

    }

}

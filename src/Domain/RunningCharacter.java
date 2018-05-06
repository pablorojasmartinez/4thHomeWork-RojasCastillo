package Domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.image.Image;

public class RunningCharacter extends Character {

    public RunningCharacter(int x, int y, int imgNum) throws FileNotFoundException {
        super(x, y, imgNum);
        setSprite();
    }

    public void setSprite() throws FileNotFoundException {
        ArrayList<Image> sprite = super.getSprite();
        for (int i = 0; i < 8; i++) {
            sprite.add(new Image(new FileInputStream("src/Assets/Running" + i + ".png")));
        }
        super.setSprite(sprite);
    }

    @Override
    public void run() {
        ArrayList<Image> sprite = super.getSprite();
        super.setImage(sprite.get(0));
        int num = 0;
        while (true) {
            try {
                for (int i = 1; i < 820; i += 50) {
                    super.setImage(sprite.get(num));
                    if (num == 7) {
                        num = 0;
                    } else {
                        num++;
                    }
                    super.setX(i);
                    Thread.sleep(200);
                }
            } catch (InterruptedException ex) {
            }
        }
    }
}

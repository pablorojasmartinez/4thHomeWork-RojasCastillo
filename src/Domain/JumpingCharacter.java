package Domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.image.Image;

public class JumpingCharacter extends Character {

    public JumpingCharacter(int x, int y, int imgNum) throws FileNotFoundException {
        super(x, y, imgNum);
        setSprite();
    }

    public void setSprite() throws FileNotFoundException {
        ArrayList<Image> sprite = super.getSprite();
        for (int i = 0; i < 3; i++) {
            sprite.add(new Image(new FileInputStream("src/Assets/Jumping" + i + ".png")));
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

                this.setY(100);
                for (int i = 270; i < 380; i += 25) {
                    super.setImage(sprite.get(num));
                    if (num == 2) {
                        num = 0;
                    } else {
                        num++;
                    }
                    super.setY(i);
                    Thread.sleep(400);
                }
            } catch (InterruptedException ex) {
            }
        }
    }

}

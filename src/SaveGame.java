import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SaveGame {
    public static void saveGame(Card[][] cards) {

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("save.bin"))) {

            System.out.println("Oyun kaydediliyor...");
            out.writeObject(cards);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Card[][] takeTheRegister() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("save.bin"))) {

            Card[][] data = (Card[][]) in.readObject();
            return data;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import  javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        Scanner scanner = new Scanner(System.in);
        File file = new File("screamvillain.wav");
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);


        String response = "";

        while (!response.equals("Q")) {
            System.out.println("P = play, S = stop, R = reset, Q = quit.");
            System.out.println("Enter your choice: ");
            response = scanner.nextLine();
            response = response.toUpperCase();

            switch(response) {
                case "P": clip.start();
                    break;
                case "S": clip.stop();
                    break;
                case "R": clip.setFramePosition(0);
                // We use setFramePosition to set its position to 0 to make the song to be reset.
                    break;
                case "Q": clip.close();
                            System.out.println("Quitting.");
                            break;
                default: System.out.println("Invalid input");
            }
        }

    System.out.println("Thank you for using this program!");
    }
}
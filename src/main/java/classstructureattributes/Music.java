package classstructureattributes;

import java.util.Scanner;

public class Music {

    public static void main(String[] args) {
        Song song = new Song();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Favourite musician/band?");
        song.band = scanner.nextLine();

        System.out.println("Favourite song?");
        song.title = scanner.nextLine();

        System.out.println("Length of song?");
        song.length = scanner.nextInt();

        System.out.println(song.band + ", " + song.title + " (" + song.length + ")");
    }

}

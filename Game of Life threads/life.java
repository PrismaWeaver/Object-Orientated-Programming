import java.io.File;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class life {
    private Boolean live[][];
    private ArrayList<String> lines = new ArrayList<String>();
    private int u; //number of update rounds
    private int r; //# of rows total
    private int c; //# of columns total
    private char a = 'X'; //alive character

    private void fileReader() {
            File start = new File("game.txt");
            String line = "";
            try (Scanner reader = new Scanner(new FileReader(start))) {
                while (reader.hasNextLine()) {
                    line = reader.nextLine(); //one row
                    lines.add(line);
                }
            } catch (IOException e) {System.out.println(e);}
            u = Integer.parseInt(line); //the last line holds the # of update rounds
            r = lines.size() - 1; //the -1 is to ignore the last line
            c = (lines.get(0)).length(); //technically I should check all rows to make sure they have equal numbers of columns, but I'm not
    }

    private void running() {
        fileReader();
        live = new Boolean[r][c];
        char chara = ' ';
        for (int i = 0; i < r; i++) {
            for (int u = 0; u < c; u++) {
                chara = lines.get(i).charAt(u);
                live[i][u] = (chara == a);
            }
        }
        board gameOfLife = new board(live, u, r, c);
        gameOfLife.print();
        try {gameOfLife.play();} catch (InterruptedException e) { e.printStackTrace();}
    }
     
    public static void main(String[] args) {
        life program = new life();
        program.running();
    }
};

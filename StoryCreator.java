import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class StoryCreator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> storyNames = new ArrayList<>(Arrays.asList());
        ArrayList<String> storyTamplate = new ArrayList<>(Arrays.asList());
        System.out.println(
            "<---------------------------------------------Story Constructor------------------------------------------------->");
        System.out.println(
            "Here is how it works\nYou first select a stroy template\nYou provide required details\nYou preview your Stroy and edit if you want\nYou save your created story by copying it from terminal\n");
        System.out.println("Select the story template by writing its number:");
    }
}
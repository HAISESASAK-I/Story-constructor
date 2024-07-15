import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class StoryCreator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int index;
        ArrayList<String> storyNames = new ArrayList<>(Arrays.asList(
            "The Lost Amulet", "The Enchanted Mirror", "The Cursed Ring",
            "The Whispering Scroll", "The Crystal Orb", "The Starlight Compass",
            "The Eternal Rose", "The Phoenix Feather", "The Lunar Pendant",
            "The Whispering Oak Staff"));
        ArrayList<String> storyTamplate = new ArrayList<>(Arrays.asList(
            "In a remote jungle temple, [name] stumbled upon an ancient amulet.\n"
                +
                "At [age], [name] discovered the amulet's hidden power to control minds.\n"
                +
                "[name] embarked on a quest in [place] to uncover the amulet's origins in [year].",

            "Within a forgotten castle, [name] found a mirror that showed glimpses of the future.\n"
                +
                "At [age], [name] witnessed a prophecy in the mirror about [occupation].\n"
                +
                "[name] ventured across [place] to understand the mirror's mysteries in [year].",

            "While exploring a haunted mansion, [name] uncovered a ring with a dark curse.\n"
                +
                "At [age], [name] experienced the ring's ability to manipulate time.\n"
                +
                "[name] braved the depths of [place] to break the curse in [year].",

            "Deep within an ancient library, [name] stumbled upon a scroll that whispered secrets.\n"
                +
                "At [age], [name] deciphered the scroll's ancient language revealing hidden knowledge.\n"
                +
                "[name] journeyed through [place] to protect the scroll from evil forces in [year].",

            "In a mystical cavern, [name] discovered a crystal orb that revealed distant lands.\n"
                +
                "At [age], [name] glimpsed the future through visions in the orb.\n"
                +
                "[name] embarked on a voyage across [place] to uncover the orb's purpose in [year].",

            "On a starlit beach, [name] found a compass that guided journeys across dimensions.\n"
                +
                "At [age], [name] unlocked the compass's ability to navigate through time.\n"
                +
                "[name] traveled through [place] to unlock the compass's full potential in [year].",

            "Within a magical garden, [name] discovered a rose that bloomed endlessly.\n"
                +
                "At [age], [name] witnessed the rose's power to heal wounds and grant eternal life.\n"
                +
                "[name] embarked on a quest across [place] to protect the rose from darkness in [year].",

            "Amidst the ruins of an ancient battlefield, [name] found a phoenix feather imbued with fiery magic.\n"
                +
                "At [age], [name] harnessed the feather's ability to summon flames and rebirth.\n"
                +
                "[name] journeyed through [place] to understand the feather's significance in [year].",

            "Beneath a celestial observatory, [name] unearthed a pendant that glowed with moonlight.\n"
                +
                "At [age], [name] uncovered the pendant's power to control tides and emotions.\n"
                +
                "[name] ventured across [place] to protect the pendant from falling into the wrong hands in [year].",

            "In the heart of an enchanted forest, [name] discovered a staff carved from the whispering oak tree.\n"
                +
                "At [age], [name] mastered the staff's ability to commune with forest spirits and command nature.\n"
                +
                "[name] strode through [place] to restore balance to the forest in [year]."));
        do {
            System.out.println(
                "<---------------------------------------------Story Constructor------------------------------------------------->");
            System.out.println(
                "Here is how it works:\n\nYou first select a stroy template.\nYou provide required details.\nYou preview your Stroy and edit it if you want.\nYou get the display of your story on terminal.\nYou save your created story by copying it from terminal.\n");
            System.out.println(
                "Select the story template by writing its number:");
            for (int i = 0; i < storyNames.size(); i++) {
                System.out.println(i + 1 + " " + storyNames.get(i));
            }
            do {
                System.out.print("\nEnter number:");
                index = scanner.nextInt();
                if (index > 10 || index <= 0) {
                    System.out.println(
                        "You have entered an invalid number\nTry Again!");
                } else
                    break;

            } while (true);
            index = index - 1;
            scanner.nextLine();
            stroyDetails(scanner, index, storyTamplate);
            System.out.println(
                "Would you like to generate another Story?(true/false)");

            Boolean choice = Boolean.valueOf(scanner.nextLine());
            if (!choice) {
                break;
            }
        } while (true);
    }
    public static void stroyDetails(Scanner scanner, int index,
                                    ArrayList<String> storyTamplate) {
        String userDetails;
        String userStory = storyTamplate.get(index);
        System.out.println("Enter name of your character:");
        userDetails = scanner.nextLine();
        userStory = userStory.replace("[name]", userDetails);
        System.out.println("Enter age of your character:");
        userDetails = scanner.nextLine();
        userStory = userStory.replace("[age]", userDetails);
        if (userStory.contains("occupation")) {
            System.out.println("Enter occupation of your character:");
            userDetails = scanner.nextLine();
            userStory = userStory.replace("[occupation]", userDetails);
        }
        System.out.println("Enter place in which story takes place:");
        userDetails = scanner.nextLine();
        userStory = userStory.replace("[place]", userDetails);
        System.out.println("Enter year in which story takes place:");
        userDetails = scanner.nextLine();
        userStory = userStory.replace("[year]", userDetails);
        System.out.println("Your stroy is created successfully");
        System.out.println("Here is the preview of your story:");
        String[] partsOfStory = userStory.split("\n");
        displayStory(userStory, partsOfStory);

        do {
            System.out.println(
                "\nWhat do you like to do?\nEnter \"1\" to edit your story.\nEnter \"2\" to display the final version of your story.");
            int choice = scanner.nextInt();
            switch (choice) {
            case 1: {
                editStory(scanner, userStory, partsOfStory);
                break;
            }
            case 2: {
                displayStory(userStory, partsOfStory);
                System.out.println(
                    "You can copy the story by selecting it from the terminal");
                break;
            }
            default: {
                System.out.println(
                    "You have entered an invalid input\nTryAgain!");
            }
            }
            if (choice == 1 || choice == 2) {
                break;
            }
        } while (true);
    }
    public static void editStory(Scanner scanner, String story,
                                 String[] partsOfStory) {
        String edit;
        System.out.println("Here is the preview of your stroy again:");
        displayStory(story, partsOfStory);
        scanner.nextLine();
        while (true) {
            System.out.println("Enter the line or word you like to edit:");

            edit = scanner.nextLine();

            if (story.contains(edit)) {
                break;
            }
            System.out.println(
                "You have entered invalid input kindly enter valid input info to edit.\n");
        }
        System.out.println("Enter the script you want to edit \"" + edit +
                           "\" with?");
        String userScript = scanner.nextLine();

        story = story.replace(edit, userScript);

        System.out.println("You have edited the story successfully!");
        System.out.println("Here is the final version of you story:");
        partsOfStory = story.split("\n");
        displayStory(story, partsOfStory);
        System.out.println(
            "You can copy the story by selecting and copying it from the terminal!");
    }
    public static void displayStory(String story, String[] partsOfStory) {

        for (int i = 0; i < partsOfStory.length; i++) {
            System.out.print("                                 ");
            if (i == 0) {
                System.out.print("\"");
            }
            if (i == partsOfStory.length - 1) {
                System.out.println(partsOfStory[i] + "\"");
            } else
                System.out.println(partsOfStory[i]);
        }
    }
}
public class SuperheroRoster {

    public static void main(String[] args) {
        // 1. Declare and initialize arrays for hero names, abilities, and power levels
        String[] heroNames = {"Spider-Man", "Iron Man", "Black Widow", "Thor", "Hulk"};
        String[] abilities = {
            "Web-slinging",
            "Flying and high-tech armor",
            "Stealth and combat",
            "God of Thunder",
            "Super strength"
        };
        int[] powerLevels = {85, 90, 80, 95, 92};

        // 2. Print each hero's details using a loop
        System.out.println("== Superhero Roster ==");
        for (int i = 0; i < heroNames.length; i++) {
            System.out.println("Name: " + heroNames[i]);
            System.out.println("Ability: " + abilities[i]);
            System.out.println("Power Level: " + powerLevels[i]);
            System.out.println("-----------------------");
        }

        // 3. Search for a specific hero
        System.out.println("== Searching for a Hero ==");
        searchHero(heroNames, abilities, powerLevels, "Thor");

        // 4. Calculate and display average power level
        double avg = calculateAveragePower(powerLevels);
        System.out.println("Average Power Level: " + avg);

        // 5. Create and display Superhero objects
        System.out.println("\n== Superhero Objects ==");
        Superhero[] heroes = new Superhero[heroNames.length];
        for (int i = 0; i < heroNames.length; i++) {
            heroes[i] = new Superhero(heroNames[i], abilities[i], powerLevels[i]);
            heroes[i].displayHero();
        }

        // 6. (Optional) Sort heroes by power level in descending order
        System.out.println("\n== Heroes Sorted by Power Level ==");
        sortHeroesByPower(heroes);
        for (Superhero hero : heroes) {
            hero.displayHero();
        }
    }

    public static void searchHero(String[] names, String[] abilities, int[] powerLevels, String target) {
        boolean found = false;
        for (int i = 0; i < names.length; i++) {
            if (names[i].equalsIgnoreCase(target)) {
                System.out.println("Hero found!");
                System.out.println("Name: " + names[i]);
                System.out.println("Ability: " + abilities[i]);
                System.out.println("Power Level: " + powerLevels[i]);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Hero not found.");
        }
    }

    public static double calculateAveragePower(int[] powerLevels) {
        int sum = 0;
        for (int power : powerLevels) {
            sum += power;
        }
        return (double) sum / powerLevels.length;
    }

    public static void sortHeroesByPower(Superhero[] heroes) {
        for (int i = 0; i < heroes.length - 1; i++) {
            for (int j = i + 1; j < heroes.length; j++) {
                if (heroes[j].powerLevel > heroes[i].powerLevel) {
                    Superhero temp = heroes[i];
                    heroes[i] = heroes[j];
                    heroes[j] = temp;
                }
            }
        }
    }
}

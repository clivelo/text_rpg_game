package text_adventure_game;

public class Warrior extends Adventurer {
    public Warrior() {
        super("Warrior", 350, 80, 10, 9, 6, 4, 10);
    }

    @Override
    public void attack() {
        System.out.println("Warrior used Sword Rend!");
    }

    @Override
    public void magic_attack() {
        System.out.println("Warrior used Sword Of Light!");
    }

    public void level_up() {
        super.level_up(10, 5, 5, 3, 1, 2, 3);
    }
}

package text_adventure_game;

public class Mage extends Adventurer {
    public Mage() {
        super("Mage", 210, 220, 3, 6, 12, 10, 10);
    }

    @Override
    public void attack() {
        System.out.println("Mage uses Staff Slash!");
    }

    @Override
    public void magic_attack() {
        System.out.println("Mage uses Firestorm!");
    }

    public void level_up() {
        super.level_up(4, 10, 1, 2, 6, 4, 3);
    }
}

package text_adventure_game;

public class Mage extends Adventurer {
    private static int base_hp = 210;
    private static int base_mp = 220;
    private static int base_attack = 3;
    private static int base_defense = 6;
    private static int base_magic_attack = 12;
    private static int base_magic_defense = 10;
    private static int base_speed = 10;

    private static int hp_modifier = 4;
    private static int mp_modifier = 10;
    private static int attack_modifier = 1;
    private static int defense_modifier = 2;
    private static int magic_attack_modifier = 6;
    private static int magic_defense_modifier = 4;
    private static int speed_modifier = 3;

    public Mage() {
        super("Mage", base_hp, base_mp, base_attack, base_defense, base_magic_attack, base_magic_defense, base_speed);
    }

    @Override
    public void attack(Enemy enemy) {
        System.out.println("Mage uses Staff Slash!");
    }

    @Override
    public void magic_attack(Enemy enemy) {
        System.out.println("Mage uses Firestorm!");
    }

    public void level_up() {
        super.level_up(hp_modifier, mp_modifier, attack_modifier, defense_modifier, magic_attack_modifier, magic_defense_modifier, speed_modifier);
    }
}

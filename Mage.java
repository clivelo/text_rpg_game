package text_adventure_game;

public class Mage extends Adventurer {
    private static final String player_class = "Mage";

    private static int base_hp = 210;
    private static int base_mp = 220;
    private static int base_attack = 3;
    private static int base_defense = 5;
    private static int base_magic_attack = 12;
    private static int base_magic_defense = 10;
    private static int base_speed = 10;

    private static int hp_modifier = 4;
    private static int mp_modifier = 10;
    private static int attack_modifier = 1;
    private static int defense_modifier = 2;
    private static int magic_attack_modifier = 5;
    private static int magic_defense_modifier = 3;
    private static int speed_modifier = 3;

    private String attack_name = "Staff Slash";
    private String magic_attack_name = "Firestorm";

    public Mage() {
        super(player_class, base_hp, base_mp, base_attack, base_defense, base_magic_attack, base_magic_defense, base_speed, 
        hp_modifier, mp_modifier, attack_modifier, defense_modifier, magic_attack_modifier, magic_defense_modifier, speed_modifier);
    }

    public void attack(Enemy enemy, int amount, int attack_type) {
        if (attack_type == 1) {
            System.out.println(player_class + " uses " + this.attack_name + "!");
        } else {
            System.out.println(player_class + " uses " + this.magic_attack_name + "!");
        }
        enemy.set_curr_hp(enemy.get_curr_hp() - amount);
    }
}

package text_adventure_game;

public class Goblin extends Enemy {
    private static final String enemy_class = "Goblin";

    private static int base_hp = 130;
    private static int base_mp = 40;
    private static int base_attack = 8;
    private static int base_defense = 5;
    private static int base_magic_attack = 1;
    private static int base_magic_defense = 4;
    private static int base_speed = 9;

    private static int hp_modifier = 20;
    private static int mp_modifier = 6;
    private static int attack_modifier = 3;
    private static int defense_modifier = 3;
    private static int magic_attack_modifier = 1;
    private static int magic_defense_modifier = 2;
    private static int speed_modifier = 2;

    private static double random_variance = 0.2;

    private String attack_name = "Club Bash";
    private String magic_attack_name = "Goblin Rush";

    public Goblin(int player_level) {
        super(enemy_class,
        (int) ((base_hp + (player_level - 1) * hp_modifier) * (1 + random_scaling())),
        (int) ((base_mp + (player_level - 1) * mp_modifier) * (1 + random_scaling())),
        (int) ((base_attack + (player_level - 1) * attack_modifier) * (1 + random_scaling())),
        (int) ((base_defense + (player_level - 1) * defense_modifier) * (1 + random_scaling())),
        (int) ((base_magic_attack + (player_level - 1) * magic_attack_modifier) * (1 + random_scaling())),
        (int) ((base_magic_defense + (player_level - 1) * magic_defense_modifier) * (1 + random_scaling())),
        (int) ((base_speed + (player_level - 1) * speed_modifier) * (1 + random_scaling())));
    }

    public void attack(Adventurer player, int amount, int attack_type) {
        if (attack_type == 1) {
            System.out.println(enemy_class + " uses " + this.attack_name + "!");
        } else {
            System.out.println(enemy_class + " uses " + this.magic_attack_name + "!");
        }
        player.set_curr_hp(player.get_curr_hp() - amount);
    }

    private static double random_scaling() {
        return (Math.random() / 1) * (random_variance * 2) - random_variance;
    }
    
}

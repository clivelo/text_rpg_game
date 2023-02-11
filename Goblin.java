package text_adventure_game;

public class Goblin extends Enemy {
    private static int base_hp = 110;
    private static int base_mp = 40;
    private static int base_attack = 7;
    private static int base_defense = 5;
    private static int base_magic_attack = 1;
    private static int base_magic_defense = 4;
    private static int base_speed = 9;

    private static int hp_modifier = 7;
    private static int mp_modifier = 3;
    private static int attack_modifier = 4;
    private static int defense_modifier = 3;
    private static int magic_attack_modifier = 1;
    private static int magic_defense_modifier = 2;
    private static int speed_modifier = 4;

    private static double random_variance = 0.2;

    public Goblin(int player_level) {
        super("Goblin",
        (int) ((base_hp + (player_level - 1) * hp_modifier) * (1 + random_scaling())),
        (int) ((base_mp + (player_level - 1) * mp_modifier) * (1 + random_scaling())),
        (int) ((base_attack + (player_level - 1) * attack_modifier) * (1 + random_scaling())),
        (int) ((base_defense + (player_level - 1) * defense_modifier) * (1 + random_scaling())),
        (int) ((base_magic_attack + (player_level - 1) * magic_attack_modifier) * (1 + random_scaling())),
        (int) ((base_magic_defense + (player_level - 1) * magic_defense_modifier) * (1 + random_scaling())),
        (int) ((base_speed + (player_level - 1) * speed_modifier) * (1 + random_scaling())));
    }

    @Override
    public void attack(Adventurer player) {
        System.out.println("Goblin uses Club Bash!");
    }

    @Override
    public void magic_attack(Adventurer player) {
        System.out.println("Globin uses Goblin Rush!");
    }

    private static double random_scaling() {
        return (Math.random() / 1) * (random_variance * 2) - random_variance;
    }
    
}

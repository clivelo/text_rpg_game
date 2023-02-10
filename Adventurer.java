package text_adventure_game;

public abstract class Adventurer {
    private String player_class;
    private int max_hp;
    private int curr_hp;
    private int max_magic;
    private int curr_magic;
    private int level;
    private int max_exp;
    private int curr_exp;
    private int attack;
    private int defense;
    private int magic_attack;
    private int magic_defense;
    private int speed;

    public Adventurer(String player_class, int max_hp, int max_magic, int attack, int defense, int magic_attack, int magic_defense, int speed) {
        this.player_class = player_class;
        this.max_hp = max_hp;
        this.curr_hp = max_hp;
        this.max_magic = max_magic;
        this.curr_magic = max_magic;
        this.level = 1;
        this.max_exp = 100;
        this.curr_exp = 0;
        this.attack = attack;
        this.defense = defense;
        this.magic_attack = magic_attack;
        this.magic_defense = magic_defense;
        this.speed = speed;
    }

    public abstract void attack();

    public abstract void magic_attack();

    public void level_up(int hp_modifier, int magic_modifier, int attack_modifier, int defense_modifier, int magic_attack_modifier, int magic_defense_modifier, int speed_modifier) {
        this.level++;
        this.curr_exp = 0;
        this.max_hp += hp_modifier;
        this.curr_hp = this.max_hp;
        this.max_magic += magic_modifier;
        this.curr_magic = this.max_magic;
        this.attack += attack_modifier;
        this.defense += defense_modifier;
        this.magic_attack += magic_attack_modifier;
        this.magic_defense += magic_defense_modifier;
        this.speed += speed_modifier;
    }

    public String toString() {
        String s = "---------------\n  Stats Sheet  \n---------------\n";
        s += String.format("%s\nLVL: %d\n\nHP: %d/%d\nMP: %d/%d\n\nAttack: %d\nDefense: %d\nM. Attack: %d\nM. Defense: %d\nSpeed: %d\n\n%d EXP to next level\n---------------\n",
        this.get_player_class(), this.get_level(), this.get_curr_hp(), this.get_max_hp(), this.get_curr_magic(), this.get_max_magic(), this.get_attack(), this.get_defense(),
        this.get_magic_attack(), this.get_magic_defense(), this.get_speed(), this.get_max_exp() - this.get_curr_exp());
        return s;
    }

    public String get_player_class() {
        return this.player_class;
    }

    public int get_max_hp() {
        return this.max_hp;
    }

    public int get_curr_hp() {
        return this.curr_hp;
    }

    public int get_max_magic() {
        return this.max_magic;
    }

    public int get_curr_magic() {
        return this.curr_magic;
    }

    public int get_level() {
        return this.level;
    }

    public int get_max_exp() {
        return this.max_exp;
    }

    public int get_curr_exp() {
        return this.curr_exp;
    }

    public int get_attack() {
        return this.attack;
    }

    public int get_defense() {
        return this.defense;
    }

    public int get_magic_attack() {
        return this.magic_attack;
    }

    public int get_magic_defense() {
        return this.magic_defense;
    }

    public int get_speed() {
        return this.speed;
    }
}

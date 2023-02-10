package text_adventure_game;

public abstract class Enemy {
    private String enemy_class;
    private int max_hp;
    private int curr_hp;
    private int max_magic;
    private int curr_magic;
    private int attack;
    private int defense;
    private int magic_attack;
    private int magic_defense;
    private int speed;

    public Enemy(String enemy_class, int max_hp, int max_magic, int attack, int defense, int magic_attack, int magic_defense, int speed) {
        this.enemy_class = enemy_class;
        this.max_hp = max_hp;
        this.curr_hp = max_hp;
        this.max_magic = max_magic;
        this.curr_magic = max_magic;
        this.attack = attack;
        this.defense = defense;
        this.magic_attack = magic_attack;
        this.magic_defense = magic_defense;
        this.speed = speed;
    }

    public abstract void attack();

    public abstract void magic_attack();

    public String toString() {
        String s = "---------------------\n  ENEMY ENCOUNTERED  \n---------------------\n";
        s += String.format("%s\n\nHP: %d/%d\nMP: %d/%d\n\nAttack: %d\nDefense: %d\nM. Attack: %d\nM. Defense: %d\nSpeed: %d\n---------------------\n",
        this.get_enemy_class(), this.get_curr_hp(), this.get_max_hp(), this.get_curr_magic(), this.get_max_magic(), this.get_attack(), this.get_defense(),
        this.get_magic_attack(), this.get_magic_defense(), this.get_speed());
        return s;
    }

    public String get_enemy_class() {
        return this.enemy_class;
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

package text_adventure_game;

public abstract class Enemy {
    private String enemy_class;
    private int max_hp;
    private int curr_hp;
    private int max_mp;
    private int curr_mp;
    private int attack;
    private int defense;
    private int magic_attack;
    private int magic_defense;
    private int speed;
    private int exp;
    private int gold;

    public Enemy(String enemy_class, int max_hp, int max_mp, int attack, int defense, int magic_attack, int magic_defense, int speed) {
        this.enemy_class = enemy_class;
        this.max_hp = max_hp;
        this.curr_hp = max_hp;
        this.max_mp = max_mp;
        this.curr_mp = max_mp;
        this.attack = attack;
        this.defense = defense;
        this.magic_attack = magic_attack;
        this.magic_defense = magic_defense;
        this.speed = speed;
        this.exp = (int) ((this.max_hp + this.max_mp) / 7 * (1 + Math.random() - 0.5));
        this.gold = (int) (this.speed * (1 + Math.random() - 0.5));
    }

    public abstract void attack(Adventurer player, int amount, int attack_type);

    public boolean isAlive() {
        return this.curr_hp > 0;
    }

    // public String toString() {
    //     String s = "---------------------\n  ENEMY ENCOUNTERED  \n---------------------\n";
    //     s += String.format("%s\n\nHP: %d/%d\nMP: %d/%d\n---------------------\n",
    //     this.get_enemy_class(), this.get_curr_hp(), this.get_max_hp(), this.get_curr_mp(), this.get_max_mp());
    //     return s;
    // }

    public String toString() {
        String s = "---------------------\n  ENEMY ENCOUNTERED  \n---------------------\n";
        s += String.format("%s\n\nHP: %d/%d\nMP: %d/%d\n\nAttack: %d\nDefense: %d\nM. Attack: %d\nM. Defense: %d\nSpeed: %d\n---------------------\n",
        this.get_enemy_class(), this.get_curr_hp(), this.get_max_hp(), this.get_curr_mp(), this.get_max_mp(), this.get_attack(), this.get_defense(),
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

    public void set_curr_hp(int curr_hp) {
        this.curr_hp = curr_hp;
    }

    public int get_max_mp() {
        return this.max_mp;
    }

    public int get_curr_mp() {
        return this.curr_mp;
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

    public int get_exp() {
        return this.exp;
    }

    public int get_gold() {
        return this.gold;
    }
}

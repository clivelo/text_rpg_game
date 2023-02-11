package text_adventure_game;

public abstract class Adventurer {
    private String player_class;
    private int max_hp;
    private int curr_hp;
    private int max_mp;
    private int curr_mp;
    private int level;
    private int max_exp;
    private int curr_exp;
    private int attack;
    private int defense;
    private int magic_attack;
    private int magic_defense;
    private int speed;

    private int hp_modifier;
    private int mp_modifier;
    private int attack_modifier;
    private int defense_modifier;
    private int magic_attack_modifier;
    private int magic_defense_modifier;
    private int speed_modifier;

    private int gold = 20;

    public Adventurer(String player_class, int max_hp, int max_mp, int attack, int defense, int magic_attack, int magic_defense, int speed,
    int hp_modifier, int mp_modifier, int attack_modifier, int defense_modifier, int magic_attack_modifier, int magic_defense_modifier, int speed_modifier) {
        this.player_class = player_class;
        this.max_hp = max_hp;
        this.curr_hp = max_hp;
        this.max_mp = max_mp;
        this.curr_mp = max_mp;
        this.level = 1;
        this.max_exp = 100;
        this.curr_exp = 0;
        this.attack = attack;
        this.defense = defense;
        this.magic_attack = magic_attack;
        this.magic_defense = magic_defense;
        this.speed = speed;

        this.hp_modifier = hp_modifier;
        this.mp_modifier = mp_modifier;
        this.attack_modifier = attack_modifier;
        this.defense_modifier = defense_modifier;
        this.magic_attack_modifier = magic_attack_modifier;
        this.magic_defense_modifier = magic_defense_modifier;
        this.speed_modifier = speed_modifier;
    }

    public abstract void attack(Enemy enemy, int amount, int attack_type);

    public void level_up() {
        this.level++;
        this.max_hp += this.hp_modifier;
        this.curr_hp = this.max_hp;
        this.max_mp += this.mp_modifier;
        this.curr_mp = this.max_mp;
        this.attack += this.attack_modifier;
        this.defense += this.defense_modifier;
        this.magic_attack += this.magic_attack_modifier;
        this.magic_defense += this.magic_defense_modifier;
        this.speed += this.speed_modifier;
        this.max_exp = (int) (this.max_exp * 1.2);

        System.out.printf("Congratulations! You are now LEVEL %d!\n", this.level);
    }

    public void revive() {
        int revive_cost = (int) (this.level * this.level * 1.5);
        if (this.gold < revive_cost) {
            System.out.println("You don't have enough GOLD to revive.");
        } else {
            this.gold -= revive_cost;
            System.out.printf("You paid %d GOLD to revive. You have %d GOLD left.\n", revive_cost, this.gold);
            this.curr_hp = this.max_hp;
        }
    }

    public boolean isAlive() {
        return this.curr_hp > 0;
    }

    public String toString() {
        String s = "---------------\n  Stats Sheet  \n---------------\n";
        s += String.format("%s\nLVL: %d\nGOLD: %d\n\nHP: %d/%d\nMP: %d/%d\n\nAttack: %d\nDefense: %d\nM. Attack: %d\nM. Defense: %d\nSpeed: %d\n\n%d EXP to next level\n---------------\n",
        this.get_player_class(), this.get_level(), this.get_gold(), this.get_curr_hp(), this.get_max_hp(), this.get_curr_mp(), this.get_max_mp(), this.get_attack(), this.get_defense(),
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

    public void set_curr_hp(int curr_hp) {
        this.curr_hp = curr_hp;
    }

    public int get_max_mp() {
        return this.max_mp;
    }

    public int get_curr_mp() {
        return this.curr_mp;
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

    public void set_curr_exp(int exp) {
        this.curr_exp = exp;
        if (this.curr_exp >= this.max_exp) {
            this.curr_exp = this.curr_exp - this.max_exp;
            this.level_up();
        }
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

    public int get_gold() {
        return this.gold;
    }

    public void set_gold(int gold) {
        this.gold = gold;
    }
}

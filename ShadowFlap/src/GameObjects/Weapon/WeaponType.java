package GameObjects.Weapon;

public enum WeaponType {

    BOMB,
    ROCK;

    public static final int NUM = WeaponType.values().length;
    public static final WeaponType[] TYPES = WeaponType.values();

}

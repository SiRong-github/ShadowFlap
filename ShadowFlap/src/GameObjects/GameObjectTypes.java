package GameObjects;

public enum GameObjectTypes {

    BIRD,
    PIPE,
    WEAPON;

    public static final int GAME_OBJECT_TYPES_NUM = GameObjectTypes.values().length;
    public static final GameObjectTypes[] GAME_OBJECT_TYPES = GameObjectTypes.values();

}

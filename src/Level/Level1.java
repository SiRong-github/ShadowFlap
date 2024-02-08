/**
 * Level1 Class
 */
package Level;

import GameObjects.Bird.Bird1;
import GameObjects.PipeSet.PipeType.PipeSet;
import GameObjects.Weapon.Weapon;
import GameObjects.Weapon.WeaponFactory;
import Message.Message;
import bagel.Input;
import bagel.util.Rectangle;

import java.util.*;

public class Level1 extends Level {

    protected static final String BG_PATH = "ShadowFlap/res/level-1/background.png";
    protected static final int MAX_LIFE = 5;
    protected static final int MAX_SCORE = 30;
    protected HashMap<Weapon, String> weapons;
    protected Iterator<HashMap.Entry<Weapon, String>> itrW;
    protected Iterator<Weapon> itrSW;
    protected List<Weapon> shotWeapons;
    protected Bird1 bird1;
    protected boolean hasWeapon;

    Level1() {
        super(1, BG_PATH, MAX_LIFE, MAX_SCORE);
        bird1 = (Bird1) bird;
        weapons = new HashMap<>();
        shotWeapons = new ArrayList<>();
        hasWeapon = false;
    }

    @Override
    protected void createGameObjects() {
        super.createGameObjects();
        /* Creates weapons */
        if (frame % Weapon.SPAWN_FRAME == 0) {
            Weapon w;
            /* Checks whether position has to be given further consideration based on spawned pipe sets, if any */
            if (newPipeSets.size() != 0) {
                PipeSet p = newPipeSets.get(newPipeSets.size()-1);
                Rectangle[] justPipes = new Rectangle[]{p.getBoundingBoxes()[0], p.getBoundingBoxes()[1]};
                w = WeaponFactory.getInstance().getWeapon(justPipes);
            } else {
                w = WeaponFactory.getInstance().getWeapon(null);
            }
            weapons.put(w, "new");
        }
    }

    @Override
    protected void updateGameObjects(Input input) {
        super.updateGameObjects(input);
        /* Updates weapons */
        itrW = weapons.entrySet().iterator();
        while (itrW.hasNext()) {
            HashMap.Entry<Weapon, String> entry = itrW.next();
            Weapon w = entry.getKey();
            String v = entry.getValue();
            if (w.outOfBounds()) {
                if (v.equals("shot")) {
                    shotWeapons.remove(w);
                }
                itrW.remove();
            } else if (!hasWeapon && v.equals("new") && CollisionDetector.hasCollided(bird1.getBoundingBox(), w.getBoundingBox())) {
                weapons.replace(w, "carried");
                hasWeapon = true;
            } else if (hasWeapon && bird1.hasShot() && v.equals("carried")) {
                shotWeapons.add(w);
                weapons.replace(w, "shot");
                w.isShot(bird1.getBeakPos().x);
                hasWeapon = false;
            } else if (v.equals("carried")) {
                w.update(bird1.getBeakPos());
            } else if (v.equals("shot")){
                w.updateShot();
            } else {
                w.update(speed);
            }
        }

    }

    @Override
    protected void updateScore() {
        /* Updates score based on the number of weapons hitting their targeted pipe sets */
        itrSW = shotWeapons.iterator();
        itrP = pipeSets.entrySet().iterator();
        while (itrSW.hasNext()) {
            Weapon w = itrSW.next();
            while (itrP.hasNext()) {
                HashMap.Entry<PipeSet, String> entry = itrP.next();
                PipeSet p = entry.getKey();
                if (CollisionDetector.weaponHitPipe(w.getBoundingBox(), p.getBoundingBoxes())) {
                    if (Arrays.asList(w.getTarget()).contains(p.getType())) {
                        itrP.remove();
                        score++;
                    }
                    weapons.remove(w);
                    itrSW.remove();
                    break;
                }
            }
        }
        super.updateScore();
    }

    @Override
    protected void renderStartScreen() {
        super.renderStartScreen();
        Message.printMsgBelowCentre(Message.SHOOT,Message.getShootSpace());
    }

    @Override
    protected void renderWinScreen() {
        Message.printMsgCentre(Message.CONGRATS);
    }
}

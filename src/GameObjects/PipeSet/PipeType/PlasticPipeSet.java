/**
 * PlasticPipeSet Class
 */
package GameObjects.PipeSet.PipeType;

public class PlasticPipeSet extends PipeSet {

    private static final String PATH = "res/level/plasticPipe.png";

    public PlasticPipeSet(double gapPos) {
        super(PipeSetType.PLASTIC, PATH, gapPos);
    }

}

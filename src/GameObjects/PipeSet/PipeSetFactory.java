/**
 * PipeSetFactory Class
 */
package GameObjects.PipeSet;

import GameObjects.PipeSet.PipeType.*;

public class PipeSetFactory {

    private static final PipeSetFactory _instance = new PipeSetFactory();

    private PipeSetFactory() {

    }

    /**
     * Gets the instance of the pipe factory
     * @return pipe factory instance
     */
    public static PipeSetFactory getInstance() {
        return _instance;
    }

    /**
     * Creates the pipe type based on level
     * @param level level number
     * @return pipe
     * @throws IllegalArgumentException level number is not found
     */
    public PipeSet getPipe(int level) throws IllegalArgumentException {
        String pipeSetType = PipeSetLevel.getPipeType(level).toString();
        double pipeGap = PipeSetLevel.getPipeGap(level);
        if (pipeSetType.equals("PLASTIC")) {
            return new PlasticPipeSet(pipeGap);
        } else {
            return new SteelPipeSet(pipeGap);
        }
    }

}

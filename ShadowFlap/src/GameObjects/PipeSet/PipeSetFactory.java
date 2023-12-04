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
     * Gets the pipe type based on level
     * @param level level number
     * @return pipe
     * @throws IllegalArgumentException level number is not found
     */
    public PipeSet getPipe(int level) throws IllegalArgumentException {

        PipeSetType pipeSetType = PipeSetLevel.getPipeType(level);
        double pipeGap = PipeSetLevel.getPipeGap(level);

        return switch (pipeSetType) {
            case PLASTIC -> new PlasticPipeSet(pipeGap);
            case STEEL -> new SteelPipeSet(pipeGap);
        };

    }

}

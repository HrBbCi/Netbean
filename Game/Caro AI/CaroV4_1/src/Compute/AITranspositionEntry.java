
package Compute;

import Compute.AIControl.Evaluation;

public class AITranspositionEntry {
    private final int remainingNode;
    private Evaluation node;

    public AITranspositionEntry(Evaluation node, int remainingNode) {
        this.node = node;
        this.remainingNode = remainingNode;
    }
    public Evaluation getNode() {
        return node;
    }
    public int getRemainingNode() {
        return remainingNode;
    }
}


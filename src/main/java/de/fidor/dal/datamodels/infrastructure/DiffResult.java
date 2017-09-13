package de.fidor.dal.datamodels.infrastructure;

import de.danielbechler.diff.node.DiffNode;
import lombok.Data;

@Data
public class DiffResult {
    public String diffs;
    public DiffNode.State diffState;
}

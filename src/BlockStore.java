import java.util.LinkedList;
import java.util.List;

public class BlockStore {
    List<Block> blocks;

    public BlockStore() {
        this.blocks = new LinkedList<Block>();
        blocks.add(HashUtil.getGenesisBlock());
    }

    public void append(Block block) {
        blocks.add(block);
    }

    public Block get(int index) {
        return blocks.get(index);
    }
}

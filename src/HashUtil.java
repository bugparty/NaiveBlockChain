import java.util.Date;

public class HashUtil {
    public static String calculateBlockHash(Block block) {
        StringBuilder  sb = new StringBuilder(1024);
        sb.append(block.index);
        sb.append(block.previousHash);
        sb.append(block.timestamp);
        sb.append(block.data);
        return CryptoUtil.SHA256(sb.toString());
    }

    public static Block generateBlock(String data, Block prevBlock) {
        Block block = new Block();
        block.index = prevBlock.index+1;
        block.timestamp = System.currentTimeMillis();
        block.previousHash = prevBlock.hash;
        block.hash = calculateBlockHash(prevBlock);
        return block;
    }

    public static Block getGenesisBlock() {
        Block block = new Block();
        block.index = 0;
        block.data = "All men could have freedom from inflation" +
                "All men could have freedom to transfer assets anywhere they wants.";
        block.previousHash = "";
        Date genesis = new Date(2017,9,13,0,0,0);
        block.timestamp = genesis.getTime();
        block.hash = calculateBlockHash(block);

        return block;
    }

    public static boolean isBlockValid(Block prevBlock, Block newBlock) {
        return newBlock.previousHash == prevBlock.hash
                && newBlock.index == (prevBlock.index+1)
                && newBlock.hash == calculateBlockHash(newBlock);
    }
}

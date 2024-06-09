public class AssociativeCache {
    int[][] cache;
    int[][] accessOrder;
    int totalSets, associativity, blockSize;

    public AssociativeCache(int sizeKB, int associativity, int blockSizeWords) {
        this.blockSize = blockSizeWords * 4; // each word is 4 bytes
        this.totalSets = (sizeKB * 1024) / (this.blockSize * associativity);
        this.associativity = associativity;
        this.cache = new int[totalSets][associativity];
        this.accessOrder = new int[totalSets][associativity];
        // Initialize the cache and access order arrays
        for (int i = 0; i < totalSets; i++) {
            for (int j = 0; j < associativity; j++) {
                this.cache[i][j] = -1;
                this.accessOrder[i][j] = 0;
            }
        }
    }

    public boolean foundInCache(int address, int lineNum) {
        int blockAddress = address / blockSize;
        int setIndex = blockAddress % totalSets;
        int tag = blockAddress / totalSets;
        
        boolean hit = false;
        for (int i = 0; i < associativity; i++) {
            if (cache[setIndex][i] == tag) {
                accessOrder[setIndex][i] = lineNum;
                hit = true;
                break;
            }
        }

        if (!hit) {
            int lruIndex = 0;
            int lruValue = accessOrder[setIndex][0];
            for (int i = 1; i < associativity; i++) {
                if (accessOrder[setIndex][i] < lruValue) {
                    lruValue = accessOrder[setIndex][i];
                    lruIndex = i;
                }
            }
            cache[setIndex][lruIndex] = tag;
            accessOrder[setIndex][lruIndex] = lineNum;
        }

        return hit;
    }
}

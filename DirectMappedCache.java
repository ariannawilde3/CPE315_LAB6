public class DirectMappedCache {
    int[] cache;
    int cacheSize;
    int blockSize;

    public DirectMappedCache(int sizeKB, int blockSizeWords) {
        this.blockSize = blockSizeWords * 4; // each word is 4 bytes
        this.cacheSize = (sizeKB * 1024) / this.blockSize;
        this.cache = new int[this.cacheSize];
        // Initialize the cache to -1 to indicate empty slots
        for (int i = 0; i < this.cacheSize; i++) {
            this.cache[i] = -1;
        }
    }

    public boolean foundInCache(int address) {
        int blockAddress = address / blockSize;
        int index = blockAddress % cacheSize;
        int tag = blockAddress / cacheSize;
        if (cache[index] == tag) {
            return true;
        }
        cache[index] = tag;
        return false;
    }
}

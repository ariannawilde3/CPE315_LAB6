import java.io.*;

public class lab6 {
    public static void main(String[] args) throws IOException {
        // Variable for statistics
        int numCacheAddresses;
        int cacheHits;

        // Cache 1: 2KB, direct mapped, 1-word blocks
        DirectMappedCache cache1 = new DirectMappedCache(2, 1);
        BufferedReader br1 = new BufferedReader(new FileReader(args[0]));
        numCacheAddresses = 0;
        cacheHits = 0;
        String line;
        while ((line = br1.readLine()) != null) {
            String[] parts = line.split("\t");
            int address = Integer.parseInt(parts[1], 16);
            numCacheAddresses++;
            if (cache1.foundInCache(address)) {
                cacheHits++;
            }
        }
        br1.close();
        double cache1Percentage = (double) (cacheHits * 100) / numCacheAddresses;
        System.out.printf("Cache #1\nCache size: %dB\tAssociativity: %d\tBlock size: %d\nHits: %d\tHit Rate: %.2f%%\n---------------------------\n",
                2048, 1, 1, cacheHits, cache1Percentage);

        // Reset counter for next cache
        numCacheAddresses = 0;
        cacheHits = 0;

        // Cache 2: 2KB, direct mapped, 2-word blocks
        DirectMappedCache cache2 = new DirectMappedCache(2, 2);
        BufferedReader br2 = new BufferedReader(new FileReader(args[0]));
        while ((line = br2.readLine()) != null) {
            String[] parts = line.split("\t");
            int address = Integer.parseInt(parts[1], 16);
            numCacheAddresses++;
            if (cache2.foundInCache(address)) {
                cacheHits++;
            }
        }
        br2.close();
        double cache2Percentage = (double) (cacheHits * 100) / numCacheAddresses;
        System.out.printf("Cache #2\nCache size: %dB\tAssociativity: %d\tBlock size: %d\nHits: %d\tHit Rate: %.2f%%\n---------------------------\n",
                2048, 1, 2, cacheHits, cache2Percentage);

        // Reset counter for next cache
        numCacheAddresses = 0;
        cacheHits = 0;

        // Cache 3: 2KB, direct mapped, 4-word blocks
        DirectMappedCache cache3 = new DirectMappedCache(2, 4);
        BufferedReader br3 = new BufferedReader(new FileReader(args[0]));
        while ((line = br3.readLine()) != null) {
            String[] parts = line.split("\t");
            int address = Integer.parseInt(parts[1], 16);
            numCacheAddresses++;
            if (cache3.foundInCache(address)) {
                cacheHits++;
            }
        }
        br3.close();
        double cache3Percentage = (double) (cacheHits * 100) / numCacheAddresses;
        System.out.printf("Cache #3\nCache size: %dB\tAssociativity: %d\tBlock size: %d\nHits: %d\tHit Rate: %.2f%%\n---------------------------\n",
                2048, 1, 4, cacheHits, cache3Percentage);

        // Reset counter for next cache
        numCacheAddresses = 0;
        cacheHits = 0;

        // Cache 4: 2KB, 2-way set associative, 1-word blocks
        AssociativeCache cache4 = new AssociativeCache(2, 2, 1);
        BufferedReader br4 = new BufferedReader(new FileReader(args[0]));
        int lineNum = 0;
        while ((line = br4.readLine()) != null) {
            String[] parts = line.split("\t");
            int address = Integer.parseInt(parts[1], 16);
            numCacheAddresses++;
            if (cache4.foundInCache(address, lineNum)) {
                cacheHits++;
            }
            lineNum++;
        }
        br4.close();
        double cache4Percentage = (double) (cacheHits * 100) / numCacheAddresses;
        System.out.printf("Cache #4\nCache size: %dB\tAssociativity: %d\tBlock size: %d\nHits: %d\tHit Rate: %.2f%%\n---------------------------\n",
                2048, 2, 1, cacheHits, cache4Percentage);

        // Reset counter for next cache
        numCacheAddresses = 0;
        cacheHits = 0;

        // Cache 5: 2KB, 4-way set associative, 1-word blocks
        AssociativeCache cache5 = new AssociativeCache(2, 4, 1);
        BufferedReader br5 = new BufferedReader(new FileReader(args[0]));
        lineNum = 0;
        while ((line = br5.readLine()) != null) {
            String[] parts = line.split("\t");
            int address = Integer.parseInt(parts[1], 16);
            numCacheAddresses++;
            if (cache5.foundInCache(address, lineNum)) {
                cacheHits++;
            }
            lineNum++;
        }
        br5.close();
        double cache5Percentage = (double) (cacheHits * 100) / numCacheAddresses;
        System.out.printf("Cache #5\nCache size: %dB\tAssociativity: %d\tBlock size: %d\nHits: %d\tHit Rate: %.2f%%\n---------------------------\n",
                2048, 4, 1, cacheHits, cache5Percentage);

        // Reset counter for next cache
        numCacheAddresses = 0;
        cacheHits = 0;

        // Cache 6: 2KB, 4-way set associative, 4-word blocks
        AssociativeCache cache6 = new AssociativeCache(2, 4, 4);
        BufferedReader br6 = new BufferedReader(new FileReader(args[0]));
        lineNum = 0;
        while ((line = br6.readLine()) != null) {
            String[] parts = line.split("\t");
            int address = Integer.parseInt(parts[1], 16);
            numCacheAddresses++;
            if (cache6.foundInCache(address, lineNum)) {
                cacheHits++;
            }
            lineNum++;
        }
        br6.close();
        double cache6Percentage = (double) (cacheHits * 100) / numCacheAddresses;
        System.out.printf("Cache #6\nCache size: %dB\tAssociativity: %d\tBlock size: %d\nHits: %d\tHit Rate: %.2f%%\n---------------------------\n",
                2048, 4, 4, cacheHits, cache6Percentage);

        // Reset counter for next cache
        numCacheAddresses = 0;
        cacheHits = 0;

        // Cache 7: 4KB, direct mapped, 1-word blocks
        DirectMappedCache cache7 = new DirectMappedCache(4, 1);
        BufferedReader br7 = new BufferedReader(new FileReader(args[0]));
        while ((line = br7.readLine()) != null) {
            String[] parts = line.split("\t");
            int address = Integer.parseInt(parts[1], 16);
            numCacheAddresses++;
            if (cache7.foundInCache(address)) {
                cacheHits++;
            }
        }
        br7.close();
        double cache7Percentage = (double) (cacheHits * 100) / numCacheAddresses;
        System.out.printf("Cache #7\nCache size: %dB\tAssociativity: %d\tBlock size: %d\nHits: %d\tHit Rate: %.2f%%\n---------------------------\n",
                4096, 1, 1, cacheHits, cache7Percentage);
    }
}

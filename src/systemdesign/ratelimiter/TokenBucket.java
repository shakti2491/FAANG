package systemdesign.ratelimiter;

public class TokenBucket
{
    private final long maxBucketSize;
    private final long refillRate;
    private double currBucketSize;
    private long lastRefillTime;

    public TokenBucket(long maxBucketSize, long refillRate, double currBucketSize, long lastRefillTime)
    {
        this.maxBucketSize = maxBucketSize;
        this.refillRate = refillRate;
        this.currBucketSize = maxBucketSize;
        this.lastRefillTime = System.nanoTime();
    }


    // number of tokens represent cost of operation
    public synchronized boolean allowRequest(int tokens){
        if(currBucketSize>=tokens)
        {
            currBucketSize -= tokens;
            return true;

        }

            return false;
    }


    private void refill(){
        long now = System.nanoTime();
        double tokensToAdd = (now-lastRefillTime)*refillRate/1e9;
        currBucketSize = Math.min(tokensToAdd+currBucketSize, maxBucketSize);
        lastRefillTime = now;
    }
}

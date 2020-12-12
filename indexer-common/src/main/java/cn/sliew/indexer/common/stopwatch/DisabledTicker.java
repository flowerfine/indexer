package cn.sliew.indexer.common.stopwatch;

public enum DisabledTicker implements Ticker {
    INSTANCE;

    @Override
    public long read() {
        return 0L;
    }
}
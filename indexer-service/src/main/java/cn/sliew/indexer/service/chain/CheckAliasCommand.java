package cn.sliew.indexer.service.chain;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.elasticsearch.client.RestHighLevelClient;

import java.util.Objects;

public class CheckAliasCommand implements Command {

    private static final String ALIAS_KEY = "alias";

    private RestHighLevelClient rhlClient;

    public CheckAliasCommand(RestHighLevelClient rhlClient) {
        Objects.requireNonNull(rhlClient, "rhlClient cant be null");
        this.rhlClient = rhlClient;
    }

    @Override
    public boolean execute(Context context) throws Exception {
        String alias = (String) context.get(ALIAS_KEY);
        return false;
    }
}

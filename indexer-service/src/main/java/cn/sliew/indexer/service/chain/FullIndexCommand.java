package cn.sliew.indexer.service.chain;

import cn.sliew.indexer.dao.mapper.CategoryMapper;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.elasticsearch.client.RestHighLevelClient;

public class FullIndexCommand implements Command {

    private static final String INDEX_COMMAND_KEY = "index_command_key";

    private RestHighLevelClient rhlClient;

    @Override
    public boolean execute(Context context) throws Exception {
        Object o = context.get(INDEX_COMMAND_KEY);
        return false;
    }
}
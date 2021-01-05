package cn.sliew.indexer.service.chain;

import cn.sliew.indexer.dao.entity.IndexCommand;
import com.google.common.base.Preconditions;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.elasticsearch.client.RestHighLevelClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FullIndexCommand implements Command {

    private static final Logger log = LoggerFactory.getLogger(FullIndexCommand.class);

    private static final String INDEX_COMMAND_KEY = "index_command_key";

    private RestHighLevelClient rhlClient;

    @Override
    public boolean execute(Context context) throws Exception {
        Object object = Preconditions.checkNotNull(context.get(INDEX_COMMAND_KEY));
        if (object instanceof IndexCommand) {

        }
        log.error("");
        return false;
    }
}
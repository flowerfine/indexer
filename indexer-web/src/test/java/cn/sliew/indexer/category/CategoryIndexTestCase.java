package cn.sliew.indexer.category;

import cn.sliew.indexer.ApplicationTestCase;
import cn.sliew.indexer.dao.mapper.CategoryMapper;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoryIndexTestCase extends ApplicationTestCase {

    @Autowired
    private RestHighLevelClient rhlClient;

    @Autowired
    private CategoryMapper categoryMapper;

    @Test
    public void indexCategory() {


    }
}

package cn.sliew.indexer.category;

import cn.sliew.indexer.ApplicationTestCase;
import cn.sliew.indexer.common.util.JacksonUtil;
import cn.sliew.indexer.dao.entity.Category;
import cn.sliew.indexer.dao.mapper.CategoryMapper;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.LoggingDeprecationHandler;
import org.elasticsearch.common.xcontent.NamedXContentRegistry;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentParser;
import org.elasticsearch.common.xcontent.json.JsonXContent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Slf4j
public class CategoryIndexTestCase extends ApplicationTestCase {

    @Autowired
    private RestHighLevelClient rhlClient;

    @Autowired
    private CategoryMapper categoryMapper;

    @Test
    public void indexCategory() {
        long startId = 0L;
        int size = 20;
        while (true) {
            List<Category> categories = categoryMapper.selectPaged(startId, size);
            if (CollectionUtils.isEmpty(categories)) {
                return;
            }
            categories.parallelStream().forEach(this::index);
            if (categories.size() < size) {
                return;
            }
            startId = categories.stream().mapToLong(Category::getId).max().getAsLong();
        }
    }

    private void index(Category category) {
        try {
            XContentBuilder xContentBuilder = JsonXContent.contentBuilder();
            xContentBuilder.startObject();
            xContentBuilder.field("categoryId", category.getCategoryId());
            xContentBuilder.field("categoryName", category.getCategoryName());
            xContentBuilder.field("parentCategoryId", category.getParentCategoryId());
            xContentBuilder.field("categoryIdPath", category.getCategoryIdPath());
            xContentBuilder.field("categoryNamePath", category.getCategoryNamePath());
            xContentBuilder.field("isBrand", category.getIsBrand());
            xContentBuilder.field("tips", category.getTips());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            xContentBuilder.field("@timestamp", formatter.format(LocalDateTime.now()));
            xContentBuilder.endObject();
            IndexRequest request = new IndexRequest();
            request.index("category");
            request.id(category.getCategoryId());
            request.source(xContentBuilder);
            IndexResponse response = rhlClient.index(request, RequestOptions.DEFAULT);
            log.info("{}", response.toString());

        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }
}

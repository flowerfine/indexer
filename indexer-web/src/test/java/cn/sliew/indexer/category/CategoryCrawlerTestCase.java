package cn.sliew.indexer.category;

import cn.sliew.indexer.ApplicationTestCase;
import cn.sliew.indexer.common.util.JacksonUtil;
import cn.sliew.indexer.dao.entity.LiveItemInfo;
import cn.sliew.indexer.dao.mapper.LiveItemInfoMapper;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Slf4j
public class CategoryCrawlerTestCase extends ApplicationTestCase {

    @Autowired
    private LiveItemInfoMapper liveItemInfoMapper;

    @Test
    public void testTbCategoryId() {
        long startId = 0L;
        int size = 20;
        while (true) {
            List<LiveItemInfo> liveItemInfos = liveItemInfoMapper.selectPaged(startId, size);
            if (CollectionUtils.isEmpty(liveItemInfos)) {
                return;
            }
            liveItemInfos.parallelStream().forEach(this::getTbCategoryId);
            if (liveItemInfos.size() < size) {
                return;
            }
            startId = liveItemInfos.stream().mapToLong(LiveItemInfo::getId).max().getAsLong();
        }
    }

    private void getTbCategoryId(LiveItemInfo liveItemInfo) {
        try {
            if (liveItemInfo.getItemUrl().contains("youzan")) {
                liveItemInfo.setIsDeleted(1);
                liveItemInfoMapper.update(liveItemInfo);
                return;
            }
            OkHttpClient client = new OkHttpClient();
            RequestBody body = new FormBody.Builder()
                    .add("ids[]", liveItemInfo.getItemId())
                    .build();
            Request request = new Request.Builder()
                    .url("https://taodaxiang.com/category/index/get")
                    .post(body)
                    .header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                    .header("Referer", "https://taodaxiang.com/category")
                    .header("Origin", "https://taodaxiang.com")
                    .header("Accept", "application/json")
                    .header("Accept-Language", "zh-CN,zh;q=0.9")
                    .build();
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                String json = response.body().string();
                List<TDXItemInfo> tdxItemInfos = JacksonUtil.parseJsonArray(json, TDXItemInfo.class);
                if (tdxItemInfos.size() == 0) {
                    liveItemInfo.setTbCategoryId(json);
                } else {
                    liveItemInfo.setTbCategoryId(tdxItemInfos.get(0).getCat_id());
                }
                liveItemInfoMapper.update(liveItemInfo);
            }
        } catch (Exception e) {
            log.error("{}", liveItemInfo.getItemId(), e);
            liveItemInfo.setIsDeleted(1);
            liveItemInfoMapper.update(liveItemInfo);
        }
    }

    @Getter
    @Setter
    public static class TDXItemInfo {
        private String id;
        private String title;
        private String url;
        private String img;
        private String cat_id;
        private String cat_name;
        private String scat_name;
    }
}

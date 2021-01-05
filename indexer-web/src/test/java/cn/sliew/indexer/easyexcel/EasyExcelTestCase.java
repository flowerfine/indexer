package cn.sliew.indexer.easyexcel;

import cn.sliew.indexer.ApplicationTestCase;
import cn.sliew.indexer.dao.mapper.CategoryMapper;
import com.alibaba.excel.EasyExcel;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.jdbc.Sql;

//@Sql("/sql/category.sql")
//@Transactional
public class EasyExcelTestCase extends ApplicationTestCase {

    @Autowired
    private CategoryMapper categoryMapper;

//    @Test
    public void parseExcel() throws Exception {
        EasyExcel.read(new ClassPathResource("/taobao_category_0731.xls").getInputStream(), Category.class, new CategoryReadListener(categoryMapper)).sheet().doRead();

        Thread.sleep(1000 * 60 * 60);
    }

    @Getter
    @Setter
    public static class Category {
        private String id;
        private String name;
        private String sed_id;
        private String sed_name;
        private String th_id;
        private String th_namefrom;
        private String fr_id;
        private String fr_namefrom;
        private String fv_id;
        private String fv_namefrom;
    }
}

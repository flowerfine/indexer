package cn.sliew.indexer.easyexcel;

import cn.sliew.indexer.dao.entity.Category;
import cn.sliew.indexer.dao.mapper.CategoryMapper;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

@Slf4j
public class CategoryReadListener extends AnalysisEventListener<EasyExcelTestCase.Category> {

    private CategoryMapper categoryMapper;

    public CategoryReadListener(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    @Override
    public void invoke(EasyExcelTestCase.Category category, AnalysisContext analysisContext) {
        saveData(category);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        log.info("所有数据解析完成！");
    }

    /**
     * 加上存储数据库
     */
    private void saveData(EasyExcelTestCase.Category category) {
        if (StringUtils.hasText(category.getId())) {
            saveIdName(category);
        }
        if (StringUtils.hasText(category.getSed_id())) {
            savesedIdName(category);
        }
        if (StringUtils.hasText(category.getTh_id())) {
            savethIdName(category);
        }
        if (StringUtils.hasText(category.getFr_id())) {
            savefrIdName(category);
        }
        if (StringUtils.hasText(category.getFv_id())) {
            savefvIdName(category);
        }
    }

    private void saveIdName(EasyExcelTestCase.Category category) {
        Category category1 = new Category();
        category1.setCategoryId(category.getId());
        category1.setCategoryName(category.getName());
        category1.setCategoryIdPath(category.getId());
        category1.setCategoryNamePath(category.getName());
        categoryMapper.insertOrUpdateSelective(category1);
    }

    private void savesedIdName(EasyExcelTestCase.Category category) {
        Category category1 = new Category();
        category1.setCategoryId(category.getSed_id());
        category1.setCategoryName(category.getSed_name());
        category1.setParentCategoryId(category.getId());
        category1.setCategoryIdPath(category.getId() + "|" + category.getSed_id());
        category1.setCategoryNamePath(category.getName() + "|" + category.getSed_name());
        categoryMapper.insertOrUpdateSelective(category1);
    }

    private void savethIdName(EasyExcelTestCase.Category category) {
        Category category1 = new Category();
        category1.setCategoryId(category.getTh_id());
        category1.setCategoryName(category.getTh_namefrom());
        category1.setParentCategoryId(category.getSed_id());
        category1.setCategoryIdPath(category.getId() + "|" + category.getSed_id() + "|" + category.getTh_id());
        category1.setCategoryNamePath(category.getName() + "|" + category.getSed_name() + "|" + category.getTh_namefrom());
        categoryMapper.insertOrUpdateSelective(category1);
    }

    private void savefrIdName(EasyExcelTestCase.Category category) {
        Category category1 = new Category();
        category1.setCategoryId(category.getFr_id());
        category1.setCategoryName(category.getFr_namefrom());
        category1.setParentCategoryId(category.getTh_id());
        category1.setCategoryIdPath(category.getId() + "|" + category.getFr_id());
        category1.setCategoryNamePath(category.getName() + "|" + category.getFr_namefrom());
        categoryMapper.insertOrUpdateSelective(category1);
    }

    private void savefvIdName(EasyExcelTestCase.Category category) {
        Category category1 = new Category();
        category1.setCategoryId(category.getFv_id());
        category1.setCategoryName(category.getFv_namefrom());
        category1.setParentCategoryId(category.getTh_id());
        category1.setCategoryIdPath(category.getId() + "|" + category.getFr_id() + "|" + category.getSed_id() + "|" + category.getTh_id() + "|" + category.getFv_id());
        category1.setCategoryNamePath(category.getName() + "|" + category.getFr_namefrom() + "|" + category.getSed_name() + "|" + category.getTh_namefrom() + "|" + category.getFv_namefrom());
        categoryMapper.insertOrUpdateSelective(category1);
    }
}

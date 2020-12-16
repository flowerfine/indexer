package cn.sliew.indexer.dao.mapper;

import cn.sliew.indexer.dao.entity.Category;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryMapper {

    int insertOrUpdate(Category record);

    int insertOrUpdateSelective(Category record);
}
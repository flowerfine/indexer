package cn.sliew.indexer.dao.mapper;

import cn.sliew.indexer.dao.entity.Category;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryMapper {

    int insertOrUpdate(Category record);

    int insertOrUpdateSelective(Category record);

    List<Category> selectPaged(@Param("startId") long startId, @Param("size") int size);
}
package cn.sliew.indexer.dao.mapper;

import cn.sliew.indexer.dao.entity.IndexCommand;

public interface IndexCommandMapper {
    int insert(IndexCommand record);

    IndexCommand selectByPrimaryKey(Long id);
}
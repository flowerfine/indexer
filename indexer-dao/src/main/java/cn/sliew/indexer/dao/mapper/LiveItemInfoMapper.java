package cn.sliew.indexer.dao.mapper;

import cn.sliew.indexer.dao.entity.LiveItemInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LiveItemInfoMapper {

    List<LiveItemInfo> selectPaged(@Param("startId") long startId, @Param("size") int size);

    int update(LiveItemInfo liveItemInfo);
}
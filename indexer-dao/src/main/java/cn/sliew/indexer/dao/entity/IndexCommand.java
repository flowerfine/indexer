package cn.sliew.indexer.dao.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * 索引命令表
 */
@Getter
@Setter
public class IndexCommand extends BaseEntity {
    /**
     * 索引表名
     */
    private String tableName;

    /**
     * 流式表类型
     */
    private Byte topicType;

    /**
     * 流式表id
     */
    private Long topicId;

    /**
     * 批量表类型
     */
    private Byte fileType;

    /**
     * 流式表id
     */
    private Long fileId;

    /**
     * 数据产出时间
     */
    private String version;
}
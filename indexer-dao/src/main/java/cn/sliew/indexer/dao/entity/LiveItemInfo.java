package cn.sliew.indexer.dao.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * live_item_info
 */
@Getter
@Setter
public class LiveItemInfo extends BaseEntity {

    /**
     * 商品链接
     */
    private String itemUrl;

    /**
     * 商品ID
     */
    private String itemId;

    /**
     * 商品渠道
     */
    private String channelId;

    /**
     * live_code
     */
    private String liveCode;

    /**
     * liveStreamId
     */
    private String liveStreamId;

    /**
     * anchor_code
     */
    private String anchorCode;

    /**
     * 上小黄车时间
     */
    private String itemOnTime;

    /**
     * 下小黄车时间
     */
    private String itemOffTime;

    /**
     * 最高在线人数
     */
    private String itemMaxOnline;

    /**
     * operate
     */
    private String operate;

    /**
     * 销量
     */
    private Long volume;

    /**
     * gmv
     */
    private Double gmv;

    /**
     * 售价
     */
    private Double price;

    /**
     * 0 不在小黄车 1 正在小黄车
     */
    private Byte status;

    /**
     * 商品名称
     */
    private String itemName;

    /**
     * 商品图片
     */
    private String itemImg;

    /**
     * 商品平台 1 淘宝 2 快手 3 有赞 4 魔筷
     */
    private Byte platform;

    private String categoryId;

    /**
     * 商品初始销量
     */
    private Long initialVolume;

    /**
     * 最佳购买件数
     */
    private Integer bestVolume;

    /**
     * 原始销量
     */
    private Integer originVolume;

    /**
     * 优惠
     */
    private String discountInfo;

    /**
     * 原始价格
     */
    private Double originPrice;

    /**
     * 抖音商品详情用 抖音必传
     */
    private String promotionId;

    /**
     * 淘宝类目id
     */
    private String tbCategoryId;
}
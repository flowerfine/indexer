package cn.sliew.indexer.dao.entity;

/**
 * 淘宝类目表
 */
public class Category extends BaseEntity {

    /**
     * 类目id
     */
    private String categoryId;

    /**
     * 类目名称
     */
    private String categoryName;

    /**
     * 上级类目id，一级类目无上级类目
     */
    private String parentCategoryId;

    /**
     * 类目id路径
     */
    private String categoryIdPath;

    /**
     * 类目名称路径
     */
    private String categoryNamePath;

    /**
     * 是否为品牌。0:不是品牌，1:是品牌
     */
    private Integer isBrand;

    /**
     * 提示信息
     */
    private String tips;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(String parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }

    public String getCategoryIdPath() {
        return categoryIdPath;
    }

    public void setCategoryIdPath(String categoryIdPath) {
        this.categoryIdPath = categoryIdPath;
    }

    public String getCategoryNamePath() {
        return categoryNamePath;
    }

    public void setCategoryNamePath(String categoryNamePath) {
        this.categoryNamePath = categoryNamePath;
    }

    public Integer getIsBrand() {
        return isBrand;
    }

    public void setIsBrand(Integer isBrand) {
        this.isBrand = isBrand;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }
}
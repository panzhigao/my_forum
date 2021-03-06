package vip.panzhigao.study.enums;

/**
 * 文章分类状态枚举
 * @author Administrator
 *
 */
public enum ArticleCategoryStatusEnum {
	/**
	 * 下线状态
	 */
	STATUS_BLOCKED(0, "下线状态"),
	/**
	 * 上线状态
	 */
	STATUS_NORMAL(1, "上线状态");

	private Integer code;

	private String name;

	ArticleCategoryStatusEnum(Integer code, String name) {
		this.code = code;
		this.name = name;
	}

    public Integer getCode() {
        return code;
    }

	public String getName() {
		return name;
	}

}

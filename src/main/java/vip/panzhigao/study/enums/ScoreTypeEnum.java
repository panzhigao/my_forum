package vip.panzhigao.study.enums;

/**
 * 积分类型枚举
 *
 * @author panzhigao
 */

public enum ScoreTypeEnum {
    /**
     * 登陆
     */
    LOGIN(1, "登陆", 5),
    /**
     * 发表文章成功
     */
    PUBLISH_ARTICLE(2, "发表文章成功", 5),
    /**
     * 回帖
     */
    COMMENT(3, "回帖", 2),
    /**
     * 签到
     */
    CHECK_IN(4, "签到", 5),
    /**
     * 注册
     */
    REGISTER(5, "注册", 20);
	
	Integer code;
    String name;
    Integer score;

    ScoreTypeEnum(Integer code, String name, Integer score) {
        this.code = code;
        this.name = name;
        this.score = score;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public Integer getScore() {
        return score;
    }
}

package vip.panzhigao.study.util;


import com.google.common.collect.Sets;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vip.panzhigao.study.exception.BusinessException;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Collection;
import java.util.Set;

/**
 * 校验工具类
 * @author panzhigao
 */
public class ValidationUtils {

    private static final Logger logger = LoggerFactory.getLogger(ValidationUtils.class);

    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    /**
     * 校验所有字段
     *
     * @param obj
     * @param <T>
     */
    public static <T> void validateEntity(T obj) {
        Set<ConstraintViolation<T>> set = validator.validate(obj);
        checkConstraintViolation(set);
    }

    /**
     * 校验字段，可以为字段添加分组
     *
     * @param object
     * @param groups
     * @param <T>
     */
    public static <T> void validateEntityWithGroups(T object, Class<?>... groups) {
        Set<ConstraintViolation<T>> set = validator.validate(object, groups);
        checkConstraintViolation(set);
    }

    /**
     * 校验字段
     *
     * @param object
     * @param propertyNames
     * @param <T>
     */
    public static <T> void validateProperty(T object, String ...propertyNames) {
        if(object==null){
            throw new BusinessException("参数不能为空");
        }
        Set<ConstraintViolation<T>> constraintViolations = Sets.newHashSet();
        for (String propertyName:propertyNames){
            Set<ConstraintViolation<T>> set = validator.validateProperty(object, propertyName);
            if(CollectionUtils.isNotEmpty(set)){
                constraintViolations.addAll(set);
            }
        }
        checkConstraintViolation(constraintViolations);
    }

    /**
     * 校验一个对象指定校验组中的一个指定的属性值
     *
     * @param object
     * @param propertyName
     * @param groups
     * @param <T>
     */
    public static <T> void validatePropertyWithGroups(T object, String propertyName, Class<?>... groups) {
        Set<ConstraintViolation<T>> constraintViolations = validator.validateProperty(object, propertyName, groups);
        checkConstraintViolation(constraintViolations);
    }

    private static <T> void checkConstraintViolation(Collection<ConstraintViolation<T>> c) {
        if (CollectionUtils.isNotEmpty(c)) {
            StringBuilder stringBuilder = new StringBuilder("参数有误：");
            for (ConstraintViolation<T> cv : c) {
                stringBuilder.append(cv.getMessage() + "; ");
            }
            logger.error(stringBuilder.toString());
            throw new BusinessException(stringBuilder.toString());
        }
    }
}

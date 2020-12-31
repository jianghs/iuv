package me.jianghs.iuv.common.converter;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.MapperConfig;

import java.util.List;
import java.util.stream.Stream;

/**
 * @className: BaseConverter
 * @description:
 * @author: jianghs430
 * @createDate: 2020/12/31 14:46
 * @version: 1.0
 */
@MapperConfig
public interface BaseMapping<SOURCE, TARGET> {
    /**
     * 映射同名属性
     * @param var1
     * @return
     */
    TARGET sourceToTarget(SOURCE var1);

    /**
     * 反向，映射同名属性
     * @param var1
     * @return
     */
    @InheritInverseConfiguration(name = "sourceToTarget")
    SOURCE targetToSource(TARGET var1);

    /**
     * 映射同名属性，集合形式
     * @param var1
     * @return
     */
    @InheritConfiguration(name = "sourceToTarget")
    List<TARGET> sourceToTarget(List<SOURCE> var1);

    /**
     * 反向，映射同名属性，集合形式
     * @param var1
     * @return
     */
    @InheritConfiguration(name = "targetToSource")
    List<SOURCE> targetToSource(List<TARGET> var1);

    /**
     * 映射同名属性，集合流形式
     * @param stream
     * @return
     */
    List<TARGET> sourceToTarget(Stream<SOURCE> stream);

    /**
     * 反向，映射同名属性，集合流形式
     * @param stream
     * @return
     */
    List<SOURCE> targetToSource(Stream<TARGET> stream);
}

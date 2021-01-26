package me.jianghs.iuv.controller.blog.converter;

import me.jianghs.iuv.common.converter.PageMapping;
import me.jianghs.iuv.controller.blog.result.ClassificationPage;
import me.jianghs.iuv.entity.Classification;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @className: TagConverter
 * @description:
 * @author: jianghs430
 * @createDate: 2020/12/31 9:26
 * @version: 1.0
 */
@Mapper
public interface ClassificationPageConverter extends PageMapping<Classification, ClassificationPage> {

    ClassificationPageConverter INSTANCE = Mappers.getMapper(ClassificationPageConverter.class);

}

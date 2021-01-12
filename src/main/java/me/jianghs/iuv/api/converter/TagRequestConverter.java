package me.jianghs.iuv.api.converter;

import me.jianghs.iuv.common.converter.BaseMapping;
import me.jianghs.iuv.api.request.TagRequest;
import me.jianghs.iuv.entity.Tag;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @className: TagRequestConverter
 * @description:
 * @author: jianghs430
 * @createDate: 2021/1/6 13:42
 * @version: 1.0
 */
@Mapper
public interface TagRequestConverter extends BaseMapping<TagRequest, Tag> {

    TagRequestConverter INSTANCE = Mappers.getMapper(TagRequestConverter.class);
}

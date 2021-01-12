package me.jianghs.iuv.api.converter;

import me.jianghs.iuv.common.converter.BaseMapping;
import me.jianghs.iuv.api.response.TagResponse;
import me.jianghs.iuv.entity.Tag;
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
public interface TagConverter extends BaseMapping<Tag, TagResponse> {

    TagConverter INSTANCE = Mappers.getMapper(TagConverter.class);

}

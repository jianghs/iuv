package me.jianghs.iuv.controller.converter;

import me.jianghs.iuv.common.converter.BaseMapping;
import me.jianghs.iuv.controller.response.TagPageResponse;
import me.jianghs.iuv.entity.Tag;
import org.mapstruct.MapperConfig;
import org.mapstruct.factory.Mappers;

/**
 * @className: TagConverter
 * @description:
 * @author: jianghs430
 * @createDate: 2020/12/31 9:26
 * @version: 1.0
 */
@MapperConfig
public interface TagConverter extends BaseMapping<Tag, TagPageResponse> {

    TagConverter INSTANCE = Mappers.getMapper(TagConverter.class);

}

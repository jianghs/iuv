package me.jianghs.iuv.api.converter;

import me.jianghs.iuv.common.converter.PageMapping;
import me.jianghs.iuv.api.response.TagPageResponse;
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
public interface TagPageConverter extends PageMapping<Tag, TagPageResponse> {

    TagPageConverter INSTANCE = Mappers.getMapper(TagPageConverter.class);

}

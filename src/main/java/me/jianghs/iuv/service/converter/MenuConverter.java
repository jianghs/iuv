package me.jianghs.iuv.service.converter;

import me.jianghs.iuv.api.response.TagResponse;
import me.jianghs.iuv.common.converter.BaseMapping;
import me.jianghs.iuv.entity.Menu;
import me.jianghs.iuv.entity.Tag;
import me.jianghs.iuv.service.dto.Node;
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
public interface MenuConverter extends BaseMapping<Menu, Node> {

    MenuConverter INSTANCE = Mappers.getMapper(MenuConverter.class);

}

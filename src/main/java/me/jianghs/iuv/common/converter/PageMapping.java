package me.jianghs.iuv.common.converter;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.mapstruct.MapperConfig;

/**
 * @className: PageConverter
 * @description:
 * @author: jianghs430
 * @createDate: 2020/12/31 16:02
 * @version: 1.0
 */
@MapperConfig
public interface PageMapping<SOURCE, TARGET> extends BaseMapping<SOURCE, TARGET> {

    /**
     * 分页复制
     * @param source
     * @return
     */
    default Page<TARGET> pageCopy(Page<SOURCE> source) {
        if (source == null) {
            return null;
        }
        Page<TARGET> target = new Page<>();
        target.setSize(source.getSize());
        target.setTotal(source.getTotal());
        target.setPages(source.getPages());
        target.setCurrent(source.getCurrent());
        target.setRecords(this.sourceToTarget(source.getRecords()));
        return target;
    }
}

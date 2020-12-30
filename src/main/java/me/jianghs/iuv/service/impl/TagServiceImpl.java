package me.jianghs.iuv.service.impl;

import me.jianghs.iuv.entity.Tag;
import me.jianghs.iuv.mapper.TagMapper;
import me.jianghs.iuv.service.ITagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 标签表 服务实现类
 * </p>
 *
 * @author jianghs
 * @since 2020-12-30
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements ITagService {

}

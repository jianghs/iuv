package me.jianghs.iuv.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import me.jianghs.iuv.common.annotation.RedisCache;
import me.jianghs.iuv.entity.Tag;
import me.jianghs.iuv.mapper.TagMapper;
import me.jianghs.iuv.service.ITagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import me.jianghs.iuv.service.dto.TagQueryDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 标签表 服务实现类
 * </p>
 *
 * @author jianghs
 * @since 2020-12-30
 */
@Service
@CacheConfig(cacheNames = "caffeineCacheManager")
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements ITagService {

    @Resource
    private TagMapper tagMapper;

    @Override
    @RedisCache(key = "IUV_TAG_", timeOut = 600L)
//    @Cacheable(cacheNames = "tag", key = "#id")
    public Tag detail(long id) {
        return tagMapper.selectById(id);
    }

    /**
     * 新增
     *
     * @param tag
     */
    @Override
    @CachePut(cacheNames = "tag", key = "#tag.id")
    public Tag addTag(Tag tag) {
        tag.setCreatorId(1L);
        tag.setCreateTime(LocalDateTime.now());
        tagMapper.insert(tag);

        LambdaQueryWrapper<Tag> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Tag::getTagName, tag.getTagName());
        return tagMapper.selectOne(queryWrapper);
    }

    /**
     * 更新
     *
     * @param tag
     */
    @Override
    @CachePut(cacheNames = "tag", key = "#tag.id")
    public Tag updateTag(Tag tag) {
        tag.setModifierId(1L);
        tag.setModifyTime(LocalDateTime.now());
        tagMapper.updateById(tag);

        LambdaQueryWrapper<Tag> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Tag::getId, tag.getId());
        return tagMapper.selectOne(queryWrapper);
    }

    /**
     * 删除
     *
     * @param id
     */
    @Override
    @CacheEvict(cacheNames = "tag", key = "#id")
    public void delete(Long id) {
        tagMapper.deleteById(id);
    }

    @Override
    public List<Tag> queryTagList(TagQueryDTO tagQuery) {
        LambdaQueryWrapper<Tag> tagLambdaQueryWrapper = new LambdaQueryWrapper<>();
        tagLambdaQueryWrapper.like(StringUtils.isNotBlank(tagQuery.getTagName()), Tag::getTagName, tagQuery.getTagName());
        tagLambdaQueryWrapper.eq(Objects.nonNull(tagQuery.getTagStatus()), Tag::getTagStatus, tagQuery.getTagStatus());
        tagLambdaQueryWrapper.ge(Objects.nonNull(tagQuery.getCreateTimeStart()), Tag::getCreateTime, tagQuery.getCreateTimeStart());
        tagLambdaQueryWrapper.le(Objects.nonNull(tagQuery.getCreateTimeEnd()), Tag::getCreateTime, tagQuery.getCreateTimeEnd());
        tagLambdaQueryWrapper.orderByAsc(Tag::getTagOrder);
        return tagMapper.selectList(tagLambdaQueryWrapper);
    }
}

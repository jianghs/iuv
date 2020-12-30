package me.jianghs.iuv.service.impl;

import me.jianghs.iuv.entity.Article;
import me.jianghs.iuv.mapper.ArticleMapper;
import me.jianghs.iuv.service.IArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文章表 服务实现类
 * </p>
 *
 * @author jianghs
 * @since 2020-12-30
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {

}

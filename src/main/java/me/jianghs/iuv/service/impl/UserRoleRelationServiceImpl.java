package me.jianghs.iuv.service.impl;

import me.jianghs.iuv.entity.UserRoleRelation;
import me.jianghs.iuv.mapper.UserRoleRelationMapper;
import me.jianghs.iuv.service.IUserRoleRelationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色关联表 服务实现类
 * </p>
 *
 * @author jianghs
 * @since 2020-12-30
 */
@Service
public class UserRoleRelationServiceImpl extends ServiceImpl<UserRoleRelationMapper, UserRoleRelation> implements IUserRoleRelationService {

}

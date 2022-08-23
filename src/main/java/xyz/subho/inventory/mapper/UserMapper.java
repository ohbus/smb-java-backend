package xyz.subho.inventory.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import xyz.subho.inventory.entity.Users;
import xyz.subho.inventory.models.UserModel;

@Component("UserMapper")
public class UserMapper implements Mapper<Users, UserModel>{

    @Override
    public UserModel transform(Users source) {

        var dto = new UserModel();
        BeanUtils.copyProperties(source, dto);
        return dto;
    }

    @Override
    public Users transformBack(UserModel source) {

        var entity = new Users();
        BeanUtils.copyProperties(source, entity);
        return entity;
    }
}

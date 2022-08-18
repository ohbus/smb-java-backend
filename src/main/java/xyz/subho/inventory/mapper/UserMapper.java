package xyz.subho.inventory.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import xyz.subho.inventory.entity.Users;
import xyz.subho.inventory.models.UserModel;

import java.util.Objects;

@Component("UserMapper")
public class UserMapper implements Mapper<Users, UserModel>{

    @Override
    public UserModel transform(Users source) {

        var dto = new UserModel();
        BeanUtils.copyProperties(source, dto);
        dto.setCreatedAtEpoch(
                Objects.isNull(source.getCreatedAt())
                        ? null
                        : source.getCreatedAt()
        );
        dto.setUpdatedAtEpoch(
                Objects.isNull(source.getUpdatedAt())
                        ? null
                        : source.getUpdatedAt()
        );
        return dto;
    }

    @Override
    public Users transformBack(UserModel source) {

        var entity = new Users();
        BeanUtils.copyProperties(source, entity);
        entity.setUpdatedAt(
                Objects.isNull(source.getUpdatedAtEpoch())
                    ? null
                    : source.getUpdatedAtEpoch()
        );
        entity.withCreatedAt(
                Objects.isNull(source.getCreatedAtEpoch())
                    ? null
                    : source.getCreatedAtEpoch()
        );
        return entity;
    }
}

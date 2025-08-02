package com.waveghost.user_details.infrastructure.mappers;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.waveghost.user_details.api.dtos.request.UserDetailRequest;
import com.waveghost.user_details.api.dtos.response.UserDetailResponse;
import com.waveghost.user_details.persistence.entities.UserDetailEntity;

@Mapper(componentModel = "spring")
public interface UserDetailMapper {

    @Mappings({
        @Mapping(target = "athlete", ignore = true),
        @Mapping(target = "coach", ignore = true),
        @Mapping(target = "judge", ignore = true)
    })
    UserDetailEntity ToEntity(UserDetailRequest request);

    UserDetailResponse ToResponse(UserDetailEntity entity);
    List<UserDetailResponse> ToResponse(List<UserDetailEntity> entity);

    @BeanMapping( nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE )
    void copy(UserDetailEntity source, @MappingTarget UserDetailEntity target);
}

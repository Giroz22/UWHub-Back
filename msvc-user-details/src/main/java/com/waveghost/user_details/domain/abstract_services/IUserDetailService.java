package com.waveghost.user_details.domain.abstract_services;

import com.waveghost.user_details.domain.abstract_services.crud.IDelete;
import com.waveghost.user_details.domain.abstract_services.crud.IGetAll;
import com.waveghost.user_details.domain.abstract_services.crud.IGetById;
import com.waveghost.user_details.domain.abstract_services.crud.IUpdate;
import com.waveghost.user_details.persistence.entities.UserDetailEntity;

public interface IUserDetailService extends
    // ICreate<UserDetailEntity>,
    IGetAll<UserDetailEntity>,
    IGetById<UserDetailEntity, String>,
    IUpdate<UserDetailEntity, String>,
    IDelete<String>
{
    UserDetailEntity create(UserDetailEntity entity);
    UserDetailEntity setAthlete(String id);
    UserDetailEntity setCoach(String id);
    UserDetailEntity setJudge(String id);
}

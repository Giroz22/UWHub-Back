package com.waveghost.user_details.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.waveghost.user_details.domain.abstract_services.IUserDetailService;
import com.waveghost.user_details.infrastructure.errors.UserDetailAlreadyExistException;
import com.waveghost.user_details.infrastructure.errors.UserDetailNotFoundException;
import com.waveghost.user_details.infrastructure.mappers.UserDetailMapper;
import com.waveghost.user_details.persistence.entities.UserDetailEntity;
import com.waveghost.user_details.persistence.repository.UserDetailRepository;

@Service
public class UserServiceImpl implements IUserDetailService{
    @Autowired
    private UserDetailRepository userDetailRepository;

    @Autowired
    private UserDetailMapper userDetailMapper;

    @Override
    public UserDetailEntity create(UserDetailEntity entity) {

        String id = entity.getId();

        if (this.userDetailRepository.existsById(id))
            throw new UserDetailAlreadyExistException(id);
        
        return this.userDetailRepository.save(entity);
    }

    @Override
    public List<UserDetailEntity> getAll() {
        return this.userDetailRepository.findAll();
    }

    @Override
    public UserDetailEntity getById(String id) {
        return this.find(id);
    }

    @Override
    public UserDetailEntity update(String id, UserDetailEntity entity) {
        UserDetailEntity userDetail = this.find(id);
        
        this.userDetailMapper.copy(entity, userDetail);

        return this.userDetailRepository.save(userDetail);
    }

    @Override
    public void delete(String id) {
        UserDetailEntity userDetail = this.find(id);
        
        this.userDetailRepository.delete(userDetail);
    }

    private UserDetailEntity find(String id){
        return this.userDetailRepository.findById(id)
            .orElseThrow(
                () -> new UserDetailNotFoundException(id)
            );
    }

    @Override
    public UserDetailEntity setAthlete(String id) {
        UserDetailEntity entity = this.find(id);
        entity.setAthlete("Is Athlete");
        return this.userDetailRepository.save(entity);
    }

    @Override
    public UserDetailEntity setCoach(String id) {
        UserDetailEntity entity = this.find(id);
        entity.setCoach("Is Coach");
        return this.userDetailRepository.save(entity);
    }

    @Override
    public UserDetailEntity setJudge(String id) {
        UserDetailEntity entity = this.find(id);
        entity.setJudge("Is Judge");
        return this.userDetailRepository.save(entity);
    }
}

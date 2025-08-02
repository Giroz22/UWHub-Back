package com.waveghost.user_details.domain.abstract_services.crud;

public interface IGetById<T, ID> {
    T getById(ID id);
}

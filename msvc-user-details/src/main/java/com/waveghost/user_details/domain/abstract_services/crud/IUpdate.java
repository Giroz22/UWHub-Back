package com.waveghost.user_details.domain.abstract_services.crud;

public interface IUpdate<T, ID> {
    T update(ID id, T entity);
}

package com.waveghost.user_details.domain.abstract_services.crud;

public interface ICreate<T> {
    T create(T entity);
}

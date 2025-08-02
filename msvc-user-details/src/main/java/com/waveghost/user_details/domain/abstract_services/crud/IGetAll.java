package com.waveghost.user_details.domain.abstract_services.crud;

import java.util.List;

public interface IGetAll<T> {
    List<T> getAll();
}

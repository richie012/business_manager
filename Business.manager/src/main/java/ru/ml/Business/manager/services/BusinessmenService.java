package ru.ml.Business.manager.services;

import java.util.List;
import ru.ml.Business.manager.entity.Businessmen;

public interface BusinessmenService {
    List<Businessmen> getBusinessmen();

    Businessmen getBusinessmenById(Long id);

    void saveBusinessmen(String name);
}

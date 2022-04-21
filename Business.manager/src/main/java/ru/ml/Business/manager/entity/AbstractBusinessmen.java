package ru.ml.Business.manager.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class AbstractBusinessmen implements Businessmen{
    protected String name;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public Long getId()
    {
        return id;
    }
}

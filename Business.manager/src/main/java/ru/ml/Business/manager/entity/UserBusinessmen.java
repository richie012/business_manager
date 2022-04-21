package ru.ml.Business.manager.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "businessmen")
public class UserBusinessmen extends AbstractBusinessmen
{
    public UserBusinessmen(String name)
    {
        this.name = name;
    }

    public UserBusinessmen()
    {

    }
}

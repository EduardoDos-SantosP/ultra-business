package com.ultra.view;

import com.ultra.controler.Model;
import com.ultra.model.DAOAbstrato;

public abstract class CrudController<T extends Model> extends ViewController {
    private T model;

    public abstract T newModelInstance();

    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }

    private DAOAbstrato<T> dao;

    public abstract DAOAbstrato<T> newDAOInstance();

    public DAOAbstrato<T> getDAO() {
        return dao != null ? dao : (dao = newDAOInstance());
    }
}

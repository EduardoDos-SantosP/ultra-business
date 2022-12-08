package com.ultra.controler;

public abstract class Model {
    private int pk;

    public Model() {
    }

    public Model(int pk) {
        this.pk = pk;
    }

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Model model = (Model) o;

        return pk == model.pk;
    }

    @Override
    public int hashCode() {
        return pk;
    }

    @Override
    public String toString() {
        return getClass() + ": " + getPk();
    }
}

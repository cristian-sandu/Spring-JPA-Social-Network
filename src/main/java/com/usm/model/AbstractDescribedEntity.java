package com.usm.model;

/*
 * Created by csandu on 3/24/2017.
 */

import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractDescribedEntity extends AbstractNamedEntity {

    @Column(length = 250, unique = true, nullable = false)
    private String email;

    @Column(length = 100, unique = true, nullable = false)
    private String office_phone;

    @Column(length = 200, unique = true, nullable = true)
    private String web_page;

    public AbstractDescribedEntity() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOffice_phone() {
        return office_phone;
    }

    public void setOffice_phone(String office_phone) {
        this.office_phone = office_phone;
    }

    public String getWeb_page() {
        return web_page;
    }

    public void setWeb_page(String web_page) {
        this.web_page = web_page;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        AbstractDescribedEntity that = (AbstractDescribedEntity) o;

        if (!email.equals(that.email)) return false;
        if (!office_phone.equals(that.office_phone)) return false;
        return web_page != null ? web_page.equals(that.web_page) : that.web_page == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + office_phone.hashCode();
        result = 31 * result + (web_page != null ? web_page.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AbstractDescribedEntity{" +
                ", email='" + email + '\'' +
                ", office_phone='" + office_phone + '\'' +
                ", web_page='" + web_page + '\'' +
                '}';
    }
}

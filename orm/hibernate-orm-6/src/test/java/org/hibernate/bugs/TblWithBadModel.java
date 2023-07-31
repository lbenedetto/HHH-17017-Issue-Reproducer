package org.hibernate.bugs;

import jakarta.persistence.*;

@Entity
public class TblWithBadModel {
    @Id
    Long id;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    MyEnum myEnum;

    public TblWithBadModel(Long id, MyEnum myEnum) {
        this.id = id;
        this.myEnum = myEnum;
    }

    public TblWithBadModel() {

    }
}

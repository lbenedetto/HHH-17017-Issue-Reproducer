package org.hibernate.bugs;

import javax.persistence.*;

@Entity
public class TblWithBadModel {
    @Id
    Long id;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(columnDefinition = "VARCHAR(255)")
    MyEnum myEnum;

    public TblWithBadModel(Long id, MyEnum myEnum) {
        this.id = id;
        this.myEnum = myEnum;
    }

    public TblWithBadModel() {

    }
}

package DAO;

import donnees.LieuEntity;

public class DAO_Lieu extends DAO_JPA<LieuEntity> {

    public DAO_Lieu() throws DAO_Exception {
        super();
        setClass(LieuEntity.class);
    }
}
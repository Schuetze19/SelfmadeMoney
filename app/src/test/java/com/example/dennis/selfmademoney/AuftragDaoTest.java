package com.example.dennis.selfmademoney;

import com.example.dennis.selfmademoney.dao.AuftragDao;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AuftragDaoTest {
    private final AuftragDao auftragDao = new AuftragDao();

    @Test
    public void findAuftrag(){
        assertEquals(auftragDao.findAll().get(1),auftragDao.findById(2));
        assertEquals(null, auftragDao.findById(10));
    }
}

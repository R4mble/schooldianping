package com.schooldianping.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author Ramble
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EncryptServiceTest {

    @Autowired
    private EncryptService encryptService;

    @Test
    public void encrypt() {
        System.out.println(encryptService.encrypt("shesheshe"));
    }

    @Test
    public void checkPassword() {
        assertTrue(encryptService.checkPassword("shesheshe","13466684fd1cb7acc7c163e295ddd9b5"));
    }
}
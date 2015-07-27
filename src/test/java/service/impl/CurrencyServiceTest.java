package service.impl;

import database.currency.Currency;
import database.currency.CurrencyDao;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
/**
 * Created by SpiritMoon
 */
public class CurrencyServiceTest {
    private CurrencyService service;
    private CurrencyDao dao;

    @Before
    public void setup() {
        dao = mock(CurrencyDao.class);
        service = new CurrencyService();
        service.setCurrencyDao(dao);
    }

    @Test
    public void testCreate() throws Exception {

    }

    @Test
    public void testRead() throws Exception {

    }

    @Test
    public void testUpdate() throws Exception {

    }

    @Test
    public void testDelete() throws Exception {

    }

    @Test
    public void testGetAll() throws Exception {
        List all = new ArrayList();
        all.add(new Currency(1, "USD"));
        all.add(new Currency(2 ,"EUR"));

        when(dao.getAll()).thenReturn(all);
        List result = service.getAll();
        verify(dao).getAll();
    }
}
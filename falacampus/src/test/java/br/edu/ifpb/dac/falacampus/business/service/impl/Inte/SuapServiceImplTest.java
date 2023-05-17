package br.edu.ifpb.dac.falacampus.business.service.impl.Inte;

import br.edu.ifpb.dac.falacampus.business.service.impl.ConverterService;
import br.edu.ifpb.dac.falacampus.business.service.impl.SuapServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNotNull;


public class SuapServiceImplTest {

    private SuapServiceImpl suapService;

    @BeforeEach
    public void setUp() {
        suapService = new SuapServiceImpl();
        suapService.setConverterService(new ConverterService());
    }

    @Test
    public void testLogin() {
        String response = suapService.login("username", "password");
        Assertions.assertNotNull(response);
        Assertions.assertTrue(response.contains("token"));
    }

    @Test
    public void testFindEmployee() {
        String response = suapService.findEmployee("token", "username");
        assertNotNull(response);
    }

    @Test
    public void testFindStudent() {
        String response = suapService.findStudent("token", "username");
        assertNotNull(response);

    }

    @Test
    public void testFindUser() {
        String response = suapService.findUser("token", "username");
        assertNotNull(response);

    }
}

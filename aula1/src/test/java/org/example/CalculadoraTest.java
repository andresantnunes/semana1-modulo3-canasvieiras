package org.example;

import org.junit.Assert;
import org.junit.Test;

public class CalculadoraTest {

    @Test
    public void asserts(){

        Assert.assertNotEquals(0,1);
        Assert.assertNull(null);
        Assert.assertEquals(1,1);
        Assert.assertTrue(true);
    }

    @Test
    public void somaTeste(){
        Calculadora calculadora = new Calculadora();
        Double valor1 = 10.1;
        Double valor2 = 23.1;

        Double resultado = calculadora.soma(valor1,valor2);

        Assert.assertNotNull(resultado);
        Assert.assertEquals(Double.valueOf(133.3), resultado);

    }

}

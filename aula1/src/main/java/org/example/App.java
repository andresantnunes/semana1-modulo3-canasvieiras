package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        Calculadora calculadora = new Calculadora();
        Double resultado = calculadora.soma(10.1,12.3);

        System.out.println("Resultado="+resultado);

    }
}

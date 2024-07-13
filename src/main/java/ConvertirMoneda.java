import java.util.Scanner;

public class ConvertirMoneda {
    public static void convertir(String monedaBase, String monedaTarget, ConsultarMoneda consulta, Scanner lectura) {
        double cantidad;
        double cantidadConvertida;

        Monedas monedas = consulta.buscarMoneda(monedaBase, monedaTarget);
        if (monedas == null) {
            System.out.println("No se pudo obtener la tasa de conversión.");
            return;
        }
        System.out.println("La Tasa de conversion para hoy\n" + monedaBase + " = " + monedas.conversion_rate() + " " + monedaTarget);
        System.out.println("Ingrese la cantidad de " + monedaBase);
        try {
            cantidad = Double.parseDouble(lectura.nextLine());
            cantidadConvertida = cantidad * monedas.conversion_rate();
            System.out.println(cantidad + " " + monedaBase + " = " + cantidadConvertida + " " + monedas.target_code());
        } catch (NumberFormatException e) {
            System.out.println("Cantidad inválida. Por favor ingrese un número.");
        }
    }

    public static void convertirOtraMoneda(ConsultarMoneda consulta, Scanner lectura) {
        System.out.println("Ingrese el codigo de la moneda base:");
        String monedaBase = lectura.nextLine().toUpperCase();
        System.out.println("Ingrese la moneda objetivo:");
        String monedaObjetivo = lectura.nextLine().toUpperCase();
        convertir(monedaBase, monedaObjetivo, consulta, lectura);
    }
}


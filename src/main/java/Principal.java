import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        try (Scanner lectura = new Scanner(System.in)) {
            ConsultarMoneda consulta = new ConsultarMoneda();
            int opcion = 0;
            while (opcion != 8) {
                System.out.println("""
                        ****************************
                        Bienvenidos Al conversor de monedas

                        Ingresa la conversion que deseas realizar

                        1. Dólar a Peso Argentino
                        2. Peso Argentino A Dollar
                        3. Dollar a Real Brasilero
                        4. Real Brasilero a Dólar
                        5. Dollar a Peso Colombiano
                        6. Peso Colombiano a Dolar
                        7. Convertir otra moneda
                        8. Salir""");
                try {
                    opcion = lectura.nextInt();
                    lectura.nextLine();

                    switch (opcion) {
                        case 1:
                            ConvertirMoneda.convertir("USD", "ARS", consulta, lectura);
                            break;
                        case 2:
                            ConvertirMoneda.convertir("ARS", "USD", consulta, lectura);
                            break;
                        case 3:
                            ConvertirMoneda.convertir("USD", "BRL", consulta, lectura);
                            break;
                        case 4:
                            ConvertirMoneda.convertir("BRL", "USD", consulta, lectura);
                            break;
                        case 5:
                            ConvertirMoneda.convertir("USD", "COP", consulta, lectura);
                            break;
                        case 6:
                            ConvertirMoneda.convertir("COP", "USD", consulta, lectura);
                            break;
                        case 7:
                            ConvertirMoneda.convertirOtraMoneda(consulta, lectura);
                            break;
                        case 8:
                            System.out.println("Saliendo...");
                            break;
                        default:
                            System.out.println("Opción inválida");
                            break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor ingrese un valor numérico.");
                    lectura.nextLine(); // Limpiar el buffer
                }
            }
        }
    }
}

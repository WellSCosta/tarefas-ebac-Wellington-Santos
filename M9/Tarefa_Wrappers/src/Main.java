public class Main {
    public static void main(String[] args) {
        wrapper();
    }
    public static void wrapper(){

        //Tipo primitivo
        int num1 = 2000000000;

        //Casting explicito
        short num2 = (short) num1;

        //Conversão para Wrapper
        Integer numWrapper = num1;

        //Imprimindo valores
        System.out.println("Tipo primitivo int : " + num1);
        System.out.println("Casting explicito para short: " + num2);
        System.out.println("Conversão para Wrapper: " + numWrapper);
    }
}
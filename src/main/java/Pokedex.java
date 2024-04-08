import java.sql.SQLException;
import java.util.Scanner;

public class Pokedex {
    private static final PokemonRepositoryImpl pokemonRepository = new PokemonRepositoryImpl();
    public static void main(String[] args) throws SQLException {
        int opcion;
        printBanner();
        boolean salir = false;
        while (!salir) {
            printMenu();
            opcion = selectedOption();
            switch (opcion) {
                case 0:
                    salir = true;
                    break;
                case 1:
                    PokemonController.viewAll(pokemonRepository);
                    break;
                case 2:
                    PokemonController.viewByNumber(pokemonRepository);
                    break;
                case 3:
                    PokemonController.addPokemon(pokemonRepository);
                    break;
            }
        }
    }


    public static void printMenu() {
        //System.out.println("0 Exit | " + "1 Print | " + "2 Add | " + "3 Update | " + "4 Delete | " + "5 Search");
        System.out.println(AnsiColor.BLUE.getCode());
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("0 Exit | 1 View all | 2 View by number | 3 Add pokemon");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println(AnsiColor.RESET.getCode());
    }

    private static void printBanner() {
        System.out.println(AnsiColor.RED.getCode());
        System.out.println("""
                ██████╗  ██████╗ ██╗  ██╗███████╗██████╗ ███████╗██╗  ██╗
                ██╔══██╗██╔═══██╗██║ ██╔╝██╔════╝██╔══██╗██╔════╝╚██╗██╔╝
                ██████╔╝██║   ██║█████╔╝ █████╗  ██║  ██║█████╗   ╚███╔╝\s
                ██╔═══╝ ██║   ██║██╔═██╗ ██╔══╝  ██║  ██║██╔══╝   ██╔██╗\s
                ██║     ╚██████╔╝██║  ██╗███████╗██████╔╝███████╗██╔╝ ██╗
                ╚═╝      ╚═════╝ ╚═╝  ╚═╝╚══════╝╚═════╝ ╚══════╝╚═╝  ╚═╝
                                                                        \s
                """);
        System.out.println(AnsiColor.RESET.getCode());
    }

    public static int selectedOption() {
        Scanner sc = new Scanner(System.in);
        int opcion;
        while (true) {
            try{
                opcion = Integer.parseInt(sc.next());
                if ( opcion <= 3 ) {
                    break;
                } else {
                    System.out.println(AnsiColor.RED.getCode());
                    System.out.println("Incorrect option");
                    System.out.println(AnsiColor.RESET.getCode());
                }
            }catch (IllegalArgumentException iae){
                System.out.println(AnsiColor.RED.getCode());
                System.out.println("Incorrect option");
                System.out.println(AnsiColor.RESET.getCode());
            }
        }
        return opcion;
    }
}

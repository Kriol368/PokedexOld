import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Pokedex {
    private static final PokemonRepositoryImpl pokemonRepository = new PokemonRepositoryImpl();
    public static void main(String[] args) throws SQLException {
        int opcion;
        printBanner();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        while (!salir) {
            printMenu();
            opcion = selectedOption();
            switch (opcion) {
                case 0:
                    salir = true;
                    break;
                case 1:
                    List<Pokemon> pokemons = pokemonRepository.findAll();
                    System.out.println(pokemons);
                    break;
                case 2:
                    System.out.println("Introduce el numero de la pokedex del pokemon a buscar: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    Pokemon p = pokemonRepository.findById(1);
                    System.out.println(p);
                    break;
                case 3:
                    System.out.println("Introduce the pokedex number: ");
                    int newid = Integer.parseInt(scanner.nextLine());
                    System.out.println("Introduce the name: ");
                    String newname = scanner.nextLine();
                    System.out.println("Introduce its first type: ");
                    String newtype1 = scanner.nextLine();
                    System.out.println("Introduce its second type: ");
                    String newtype2 = scanner.nextLine();
                    Pokemon newp = new Pokemon(newid,newname,newtype1,newtype2);
                    pokemonRepository.save(newp);
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
        int opcion = -1;
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

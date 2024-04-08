import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class PokemonController {


    public static void viewAll(PokemonRepositoryImpl pokemonRepository) throws SQLException{
        List<Pokemon> pokemons = pokemonRepository.findAll();
        System.out.println(pokemons);
    }

    public static void viewByNumber(PokemonRepositoryImpl pokemonRepository) throws SQLException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el numero de la pokedex del pokemon a buscar: ");
        int id = Integer.parseInt(scanner.nextLine());
        Pokemon p = pokemonRepository.findById(1);
        System.out.println(p);
    }

    public static void addPokemon(PokemonRepositoryImpl pokemonRepository) throws SQLException {
        Scanner scanner = new Scanner(System.in);
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
    }
}

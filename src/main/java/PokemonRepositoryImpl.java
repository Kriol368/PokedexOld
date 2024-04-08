import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PokemonRepositoryImpl implements IRepository<Pokemon> {
    private static Set<Pokemon> pokemonsCached = new HashSet<>();
    private java.sql.Connection con;

    public PokemonRepositoryImpl() {
        this.con = PokedexService.getConnection();
    }

    public Pokemon bdToEntity(ResultSet rs) throws SQLException {
        Pokemon p = getCached(rs.getInt("number"));
        if (p == null) {
            p = new Pokemon(rs.getInt("number"), rs.getString("name"), rs.getString("type1"), rs.getString("type2"));
            pokemonsCached.add(p);
        }
        return p;
    }

    private Pokemon getCached(int id) {
        for (Pokemon pokemon : pokemonsCached) {
            if (pokemon.getId() == id) return pokemon;
        }
        return null;
    }

    public List<Pokemon> findAll() throws SQLException {
        List<Pokemon> pokemons = new ArrayList<>();
        Statement st = this.con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM pokemon ORDER BY number");
        while (rs.next()) {
            Pokemon pokemon = bdToEntity(rs);
            pokemons.add(pokemon);
        }
        return pokemons;
    }

    public Pokemon findById(int id) throws SQLException {
        Pokemon pokemon = getCached(id);
        if (pokemon != null) {
            return pokemon;
        }
        PreparedStatement st = con.prepareStatement("SELECT * FROM pokemon WHERE number = ? ");
        st.setInt(1, id);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            pokemon = bdToEntity(rs);
        }
        return pokemon;
    }

    public void save(Pokemon pokemon) throws SQLException {
        ResultSet rs;
        PreparedStatement st;
        String query = "INSERT INTO pokemon VALUES (?, ?, ?, ?)";
        st = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        st.setInt(1, pokemon.getId());
        st.setString(2, pokemon.getName());
        st.setString(3, pokemon.getType1());
        st.setString(4, pokemon.getType2());
        st.executeUpdate();
        rs = st.getGeneratedKeys();
        if (rs.next()) {
            pokemon.setId(rs.getInt(1));
        }
    }

    public void delete(Pokemon pokemon) throws SQLException {
        PreparedStatement st = con.prepareStatement("DELETE FROM pokemon WHERE number = ?");
        st.setInt(1, pokemon.getId());
        st.executeUpdate();
        st.close();
    }
}

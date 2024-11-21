import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class PokedexApp extends JFrame {
    private JLabel imageLabel;
    private JTextArea descriptionArea;
    private HashMap<String, Pokemon> pokedex;

    public PokedexApp() {
        setTitle("Pokedex");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Crear base de datos de Pokémon
        pokedex = createPokedex();

        // Panel superior: Selección de Pokémon
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        JLabel selectLabel = new JLabel("Selecciona un Pokémon:");
        JComboBox<String> pokemonSelector = new JComboBox<>(pokedex.keySet().toArray(new String[0]));
        pokemonSelector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedPokemon = (String) pokemonSelector.getSelectedItem();
                updatePokemonInfo(selectedPokemon);
            }
        });
        topPanel.add(selectLabel);
        topPanel.add(pokemonSelector);

        // Panel central: Imagen y descripción
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        centerPanel.setBackground(Color.RED);

        // Imagen del Pokémon
        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        centerPanel.add(imageLabel, BorderLayout.CENTER);

        // Descripción
        descriptionArea = new JTextArea();
        descriptionArea.setFont(new Font("Arial", Font.PLAIN, 14));
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setLineWrap(true);
        descriptionArea.setEditable(false);
        descriptionArea.setBackground(Color.GREEN);
        centerPanel.add(descriptionArea, BorderLayout.SOUTH);

        // Añadir paneles al frame
        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);

        // Inicializar con el primer Pokémon
        updatePokemonInfo(pokemonSelector.getItemAt(0));
    }

    private HashMap<String, Pokemon> createPokedex() {
        HashMap<String, Pokemon> pokedex = new HashMap<>();

        // Lista de Pokémon con nombres, descripciones e imágenes
        pokedex.put("Vulpix", new Pokemon("Vulpix", "Pokémon tipo Fuego. Puede controlar llamas a voluntad.", "vulpix.png"));
        pokedex.put("Ninetales", new Pokemon("Ninetales", "Pokémon tipo Fuego. Sus nueve colas tienen poderes místicos.", "ninetales.png"));
        pokedex.put("Rhydon", new Pokemon("Rhydon", "Pokémon tipo Tierra/Roca. Es fuerte pero lento.", "rhydon.png"));
        pokedex.put("Oddish", new Pokemon("Oddish", "Pokémon tipo Planta/Veneno. Crece mejor bajo la luz lunar.", "oddish.png"));
        pokedex.put("Gloom", new Pokemon("Gloom", "Pokémon tipo Planta/Veneno. Libera un aroma peculiar.", "gloom.png"));
        pokedex.put("Drowzee", new Pokemon("Drowzee", "Pokémon tipo Psíquico. Puede inducir el sueño a sus enemigos.", "drowzee.png"));
        pokedex.put("Hypno", new Pokemon("Hypno", "Pokémon tipo Psíquico. Utiliza su péndulo para hipnotizar.", "hypno.png"));
        pokedex.put("Magnemite", new Pokemon("Magnemite", "Pokémon tipo Eléctrico. Genera campos magnéticos.", "magnemite.png"));
        pokedex.put("Magneton", new Pokemon("Magneton", "Pokémon tipo Eléctrico. Es la evolución de Magnemite.", "magneton.png"));
        pokedex.put("Mankey", new Pokemon("Mankey", "Pokémon tipo Lucha. Es agresivo y veloz.", "mankey.png"));
        pokedex.put("Primeape", new Pokemon("Primeape", "Pokémon tipo Lucha. Su furia aumenta su poder.", "primeape.png"));
        pokedex.put("Meowth", new Pokemon("Meowth", "Pokémon tipo Normal. Adora las monedas brillantes.", "meowth.png"));
        pokedex.put("Persian", new Pokemon("Persian", "Pokémon tipo Normal. Elegante y ágil.", "persian.png"));
        pokedex.put("Poliwag", new Pokemon("Poliwag", "Pokémon tipo Agua. Nada velozmente en ríos y lagos.", "poliwag.png"));
        pokedex.put("Poliwhirl", new Pokemon("Poliwhirl", "Pokémon tipo Agua. Su cuerpo está cubierto por una película viscosa.", "poliwhirl.png"));
        pokedex.put("Rhyhorn", new Pokemon("Rhyhorn", "Pokémon tipo Tierra/Roca. Posee una fuerza arrolladora.", "rhyhorn.png"));
        pokedex.put("Spearow", new Pokemon("Spearow", "Pokémon tipo Normal/Volador. Es pequeño pero feroz.", "spearow.png"));
        pokedex.put("Fearow", new Pokemon("Fearow", "Pokémon tipo Normal/Volador. Tiene un vuelo rápido y prolongado.", "fearow.png"));
        pokedex.put("Koffing", new Pokemon("Koffing", "Pokémon tipo Veneno. Libera gases tóxicos.", "koffing.png"));
        pokedex.put("Weezing", new Pokemon("Weezing", "Pokémon tipo Veneno. Es la evolución de Koffing.", "weezing.png"));

        return pokedex;
    }

    private void updatePokemonInfo(String pokemonName) {
        Pokemon selected = pokedex.get(pokemonName);
        if (selected != null) {
            imageLabel.setIcon(new ImageIcon(selected.getImagePath())); // Asegúrate de tener las imágenes en la misma carpeta
            descriptionArea.setText(selected.getDescription());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PokedexApp().setVisible(true));
    }
}

// Clase Pokémon
class Pokemon {
    private String name;
    private String description;
    private String imagePath;

    public Pokemon(String name, String description, String imagePath) {
        this.name = name;
        this.description = description;
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImagePath() {
        return imagePath;
    }
}
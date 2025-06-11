import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

/**
 * Clasa principala a aplicatiei "Biblioteca".
 * Initializeaza interfata grafica si deschide fereastra de autentificare.
 */
public class Biblioteca {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); // pentru stil nativ OS
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> {   // lansare interfata in firul grafic
            LoginFrame loginFrame = new LoginFrame();  //creeare login
            loginFrame.setVisible(true);  //ca sa fie vizibil
        });
    }
}

/**
 * Reprezinta o carte din biblioteca aplicatiei.
 */
class Carte {
    private String titlu;
    private String autor;
    private int an;
    private String editura;
    private double pret;
    private String rezumat;
    private boolean imprumutata;
    private ImageIcon coperta;


    /**
     * Constructor pentru initializarea unei carti.
     *
     * @param titlu     Titlul cartii.
     * @param autor     Autorul cartii.
     * @param an        Anul publicarii.
     * @param editura   Editura cartii.
     * @param pret      Pretul cartii in RON.
     * @param rezumat   Rezumatul cartii.
     * @param coperta   Imaginea de coperta a cartii.
     */
    public Carte(String titlu, String autor, int an, String editura, double pret, String rezumat, ImageIcon coperta) {
        this.titlu = titlu;
        this.autor = autor;
        this.an = an;
        this.editura = editura;
        this.pret = pret;
        this.rezumat = rezumat;
        this.imprumutata = false;
        this.coperta = coperta;
    }

    /** 
    *Getteri pentru accesarea atributelor clasei Carte 
    */
    public String getTitlu() { return titlu; }
    public String getAutor() { return autor; }
    public int getAn() { return an; }
    public String getEditura() { return editura; }
    public double getPret() { return pret; }
    public String getRezumat() { return rezumat; }
    public boolean esteImprumutata() { return imprumutata; }
    public ImageIcon getCoperta() { return coperta; }

    /**
     * Imprumuta cartea.
     */
    public void imprumutaCarte() {
        this.imprumutata = true;
    }
    /**
     * Returneaza cartea.
     */
    public void returneazaCarte() {
        this.imprumutata = false;
    }

  /**
     * @return O reprezentare textuala a cartii.
     */
    public String toString() {
        return titlu + ", de " + autor + (imprumutata ? " (Imprumutata)" : "");  //afisare carte in lista
    }
}

/**
 * Gestioneaza o colectie de carti.
 * Permite cautarea si manipularea acestora.
 */
class RepertoriuCarti {
    private List<Carte> carti;
    /**
     * Constructor care initializeaza colectia de carti.
     */
    public RepertoriuCarti() {
        carti = new ArrayList<>();

        carti.add(new Carte("Harry Potter si piatra filosofala", "J.K. Rowling", 1997,  "Grupul Art", 46.06, "'Întoarcând plicul, cu mâna tremurândă, Harry a văzut un sigiliu de ceară violet care" +"\r\n" + 
                                                                                                                                         "purta o stemă; un leu, un vultur, un bursuc și un șarpe înconjurând o litera mare 'H''." + "\r\n" +
                                                                                                                                "\r\n" + "Harry Potter nu a auzit nici măcar de Hogwarts când scrisorile încep să cadă pe covorașul" +"\r\n" + 
                                                                                                                                         "de la numărul patru, Privet Drive. Adresate cu cerneală verde pe pergament gălbui cu un sigiliu violet, "  + "\n\r" +  
                                                                                                                                         "ele sunt confiscate rapid de mătușa și unchiul său îngrozitor." +"\r\n" + 
                                                                                                                                         "Apoi, la cea de-a unsprezecea aniversare a lui Harry, un mare gigant cu ochi de gândac, numit Rubeus Hagrid," +"\r\n" + 
                                                                                                                                         "iese cu o veste uluitoare: Harry Potter este vrăjitor și are un loc la Școala de Vrăjitorie și Vrăjitorie Hogwarts." +"\r\n" + 
                                                                                                                                         "O aventură incredibilă este pe cale să înceapă!", new ImageIcon("img/harry-potter-si-piatra-filosofala--bg1.png")));

        carti.add(new Carte("Marele Gatsby", "F. Scott Fitzgerald", 1925, " Curtea Veche", 12.75, "Marele Gatsby, cea de-a treia carte a lui F. Scott Fitzgerald, este realizarea supremă a carierei sale." + "\n\r" + 
                                                                                                                              "Acest roman exemplar al epocii jazz-ului a fost apreciat de generații de cititori." +"\r\n" + 
                                                                                                                              "Povestea fabulosului bogat Jay Gatsby și dragostea lui pentru frumoasa Daisy Buchanan, a petrecerilor fastuoase" +"\r\n" + 
                                                                                                                              "de pe Long Island, este o lucrare excelentă. Povestea Americii în anii 1920.", new ImageIcon("img/marele-gatsby-curtea-veche-bg1.png")));

        carti.add(new Carte("1984", "George Orwell", 1949, "Litera", 34, "O capodoperă a rebeliunii și a închisorii, unde războiul este pace, libertatea este sclavie și Fratele Mare urmărește." + "\n\r" + 
                                                                                                     "Poliția Gândită, Fratele Mare, Orwellian - aceste cuvinte au intrat în vocabularul nostru datorită romanului distopic clasic" +"\r\n" + 
                                                                                                     "al lui George Orwell, 1984. Povestea Odiseei de coșmar a unui bărbat ce urmărește o poveste de dragoste interzisă" +"\r\n" + 
                                                                                                     "printr-o lume condusă de state aflate în conflict și o structură de putere care controlează nu numai informații," +"\r\n" + 
                                                                                                     "ci și gândirea și memoria individuală. Mai relevantă ca niciodată 1984 dezvăluie cele mai grave crime imaginabile," +"\r\n" + 
                                                                                                     "distrugerea adevărului, libertatea și individualitatea.", new ImageIcon("img/1984-vol-6-bg1.png")));

        carti.add(new Carte("...Sa ucizi o pasare cintatoare", "Harper Lee", 1960, "Polirom", 31.5,"Romanul de neuitat al unei copilării într-un oraș somnoros din sud și criza de conștiință care l-a zguduit." + "\n\r" + 
                                                                                                                               "'...Sa ucizi o pasare cintatoare' a devenit atât un bestseller instantaneu, cât și un succes critic atunci"  + "\n\r" +  
                                                                                                                               "când a fost publicat pentru prima dată în 1960. A câștigat premiul Pulitzer în 1961 și a fost ulterior" + "\n\r" +
                                                                                                                               "transformat într-un film câștigător al Oscarului, de asemenea un clasic. Compasiv, dramatic și profund emoționant,"  + "\n\r" +  
                                                                                                                               "'...Sa ucizi o pasare cintatoare' îi duce pe cititori la rădăcinile comportamentului uman - la inocență și experiență,"  + "\n\r" +  
                                                                                                                               "bunătate și cruzime, dragoste și ură, umor și patos. Acum, cu peste 18 milioane de exemplare tipărite și "  + "\n\r" +  
                                                                                                                               "traduse în patruzeci de limbi, această poveste regională a unei tinere din Alabama pretinde un apel universal."  + "\n\r" +  
                                                                                                                               "Harper Lee a considerat întotdeauna cartea ei o simplă poveste de dragoste. Astăzi este considerată o capodopera a literaturii americane.", new ImageIcon("img/sa-ucizi-o-pasare-cintatoare-editie-de-buzunar-bg1.png")));

        carti.add(new Carte("Hobbitul", "J.R.R. Tolkien", 1937, "RAO", 66.3, "Într-o gaură din pământ trăia un hobbit. Nu o gaură urâtă, murdară, umedă, plină cu capete de viermi și un miros moale, " +"\r\n" + 
                                                                                                         "nici o gaură uscată, goală, nisipoasă, fără nimic în care să te așezi sau să mănânci: era o gaură de hobbit și asta înseamnă confort." +"\r\n" + 
                                                                                                         "Scrisa pentru copiii lui Tolkien, Hobbitul a fost apreciata imediat de critici când a fost publicata pentru prima dată în 1937." +"\r\n" + 
                                                                                                         "Acum, recunoscuta ca un clasic atemporal, această introducere hobbitului Bilbo Baggins, vrăjitorul Gandalf, Gollum și" +"\r\n" + 
                                                                                                         "lumea spectaculoasă a Pământului de Mijloc povestește despre aventurile unui erou reticent, " +"\r\n" + 
                                                                                                         "a unui inel puternic și periculos și a crudului dragon Smaug Magnificul.", new ImageIcon("img/hobbitul-editie-ilustrata-bg1.png")));


    }
    /**
     * Returneaza lista de carti.
     * @return Lista completa a cartilor.
     */
    public List<Carte> getCarti() {
        return carti;
    }
    /**
     * Cauta carti in functie de un criteriu si un cuvant cheie.
     *
     * @param key      Cuvantul cheie pentru cautare.
     * @param criteriu Criteriul de cautare (titlu, autor, etc.).
     * @return O lista cu cartile care corespund criteriului.
     */
    public List<Carte> cautaCarti(String key, String criteriu) {
        List<Carte> rezultat = new ArrayList<>();
        for (Carte carte : carti) {
            switch (criteriu.toLowerCase()) {
                case "titlu":   //cautam dupa criteriul ales
                    if (carte.getTitlu().toLowerCase().contains(key.toLowerCase())) {
                        rezultat.add(carte);
                    }
                    break;
                case "autor":
                    if (carte.getAutor().toLowerCase().contains(key.toLowerCase())) {
                        rezultat.add(carte);
                    }
                    break;
                case "an":
                    try {
                        if (carte.getAn() == Integer.parseInt(key)) {
                            rezultat.add(carte);
                        }
                    } catch (NumberFormatException ignored) {}
                    break;
                case "editura":
                    if (carte.getEditura().toLowerCase().contains(key.toLowerCase())) {
                        rezultat.add(carte);
                    }
                    break;
                default:
                    if (carte.getTitlu().toLowerCase().contains(key.toLowerCase()) ||
                        carte.getAutor().toLowerCase().contains(key.toLowerCase())) {
                        rezultat.add(carte);
                    }
            }
        }
        return rezultat;   //returneaza cartea cautata
    }
}
/**
 * Fereastra de autentificare a utilizatorului.
 * Valideaza credentialele si deschide fereastra principala.
 */
class LoginFrame extends JFrame {
    /**
     * Constructor care initializeaza interfata de autentificare.
     */
    public LoginFrame() {
        setTitle("Autentificare");
        setSize(400, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2, 5, 5));
        setIconImage(new ImageIcon("img/lovepik-learning-english-books-material-png-image_400234770_wh1200.png").getImage());  //iconita bara titlu

        /**
         * Crearea campurilor de input pentru username si parola, butonul de login, modificari de aspect.
         */
        JLabel userLabel = new JLabel("Nume de utilizator:");
        JLabel passLabel = new JLabel("Parola:");
        JTextField userField = new JTextField();
        JPasswordField passField = new JPasswordField();
        JButton loginButton = new JButton("Login");

        userLabel.setFont(new Font("Jetbrains Mono", Font.PLAIN, 14));
        passLabel.setFont(new Font("Jetbrains Mono", Font.PLAIN, 14));
        userField.setFont(new Font("Jetbrains Mono", Font.PLAIN, 14));
        passField.setFont(new Font("Jetbrains Mono", Font.PLAIN, 14));
        loginButton.setFont(new Font("Jetbrains Mono", Font.PLAIN, 14));
        
        getContentPane().setBackground(new Color(30,30,46));  //culoarea de fundal a ferestrei principale
        userField.setBackground(new Color(49, 50, 68));
        passField.setBackground(new Color(49, 50, 68));
        loginButton.setContentAreaFilled(false);
        loginButton.setOpaque(true);
        loginButton.setBackground(new Color(49, 50, 68));
        userLabel.setForeground(new Color(205, 214, 244));
        passLabel.setForeground(new Color(205, 214, 244));
        userField.setForeground(new Color(205, 214, 244));
        passField.setForeground(new Color(205, 214, 244));
        loginButton.setForeground(new Color(205, 214, 244));
        userField.setBorder(BorderFactory.createEmptyBorder());
        passField.setBorder(BorderFactory.createEmptyBorder());
        userField.setCaretColor(new Color(205, 214, 244)); // seteaza culoarea cursorului pentru JTextField
        passField.setCaretColor(new Color(205, 214, 244)); // seteaza culoarea cursorului pentru JPasswordField

        //modificari de aspect a ferestrelor contextuale.
        UIManager.put("OptionPane.background", new Color(24, 24, 37)); 
        UIManager.put("Panel.background", new Color(24, 24, 37));
        UIManager.put("OptionPane.messageForeground", new Color(205, 214, 244));
        UIManager.put("OptionPane.messageFont" , new Font("Jetbrains Mono", Font.PLAIN, 14));
        UIManager.put("OptionPane.buttonBackground", new Color(49, 50, 68));
        UIManager.put("OptionPane.buttonText", new Color(205, 214, 244));
        UIManager.put("OptionPane.buttonFont", new Font("Jetbrains Mono", Font.PLAIN, 14));

        /**
         * Evenimente pentru logare
         */
        loginButton.addActionListener(e -> {
            String username = userField.getText();
            String password = new String(passField.getPassword());

            if (username.equals("maria") && password.equals("1234")) {
                JOptionPane.showMessageDialog(this, "Autentificat cu succes!");
                dispose();
                new MainFrame();
            } else {
                JOptionPane.showMessageDialog(this, "Numele sau parola este gresita!", "Eroare!", JOptionPane.ERROR_MESSAGE);
            }
        });

        /**
         * Adaugare de elemente in frame
         */
        add(userLabel);  
        add(userField);
        add(passLabel);
        add(passField);
        add(new JLabel());
        add(loginButton);
    }
}

/**
 * Fereastra principala a aplicatiei "Biblioteca".
 * Permite vizualizarea, cautarea si gestionarea cartilor.
 */
class MainFrame extends JFrame {
    private RepertoriuCarti repertoriu;
    private JList<Carte> listaCarti;
    private JTextArea detaliiCarte;
    private JLabel copertaCarte;

    /**
     * Constructor care initializeaza interfata principala.
     */
    public MainFrame() {
        repertoriu = new RepertoriuCarti();

        setTitle("Biblioteca");
        setSize(1200, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setIconImage(new ImageIcon("img/lovepik-learning-english-books-material-png-image_400234770_wh1200.png").getImage());

        /**
         * Crearea barii de meniu
         */
        JMenuBar menuBar = new JMenuBar();
        JMenu ajutorMenu = new JMenu("Ajutor");
        JMenu scurtaturiMenu = new JMenu("Scurtaturi");
        JMenuItem scurtaturiItem = new JMenuItem("Scurtaturi");
        JMenuItem despreItem = new JMenuItem("Despre");
        JMenuItem tutorialItem = new JMenuItem("Tutorial");

        /**
         * Afisarea informatiilor la clic
         */
        despreItem.addActionListener(e -> showDespreDialog());  
        scurtaturiItem.addActionListener(e -> showScurtaturiDialog());
        tutorialItem.addActionListener(e -> showTutorialDialog());

        /**
         * Adaugarea elementelor la bara de meniu
         */
        ajutorMenu.add(despreItem); 
        ajutorMenu.add(tutorialItem);
        scurtaturiMenu.add(scurtaturiItem);
        menuBar.add(ajutorMenu);
        menuBar.add(scurtaturiMenu);
        setJMenuBar(menuBar);

        /**
         * Crearea imaginii cartilor
         */
        copertaCarte = new JLabel();
        copertaCarte.setHorizontalAlignment(SwingConstants.CENTER);
        copertaCarte.setVerticalAlignment(SwingConstants.TOP);
        copertaCarte.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(copertaCarte, BorderLayout.EAST); // plaseaza coperta in partea dreapta

        /**
         * Crearea listei de carti
         */
        listaCarti = new JList<>(new DefaultListModel<>());
        actualizareListaCarti(repertoriu.getCarti());
        listaCarti.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                afisareDetaliiCarte(listaCarti.getSelectedValue());
            }
        });
        
        /**
         * Crearea zonei cu detaliile cartii
         */
        detaliiCarte = new JTextArea();
        detaliiCarte.setEditable(false);

        listaCarti.setBackground(new Color(30,30,46));
        listaCarti.setForeground(new Color(205, 214, 244));
        listaCarti.setSelectionBackground(new Color(49, 50, 68));
        listaCarti.setSelectionForeground(new Color(205, 214, 244));
        listaCarti.setFont(new Font("Jetbrains Mono", Font.PLAIN, 14));

        detaliiCarte.setBackground(new Color(49,50,68));
        detaliiCarte.setForeground(new Color(205, 214, 244));
        detaliiCarte.setFont(new Font("Jetbrains Mono", Font.PLAIN, 14));

        listaCarti.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));  //padding
        detaliiCarte.setBorder(BorderFactory.createEmptyBorder(5,10,5,10)); 

        /**
         * Crearea partii de cautare
         */
        JPanel cautarePanel = new JPanel();  
        JTextField cautareField = new JTextField(15);
        JComboBox<String> criteriuBox = new JComboBox<>(new String[]{"Titlu", "Autor", "An", "Editura"});
        JButton cautareButton = new JButton("Cauta...");
        cautareButton.addActionListener(e -> {
            String keyword = cautareField.getText().trim();
            String criteriu = (String) criteriuBox.getSelectedItem();
            actualizareListaCarti(repertoriu.cautaCarti(keyword, criteriu));
        });
        JLabel cautare= new JLabel("Cautare:");
        cautarePanel.add(cautare).setForeground(new Color(205, 214, 244));
        cautare.setFont(new Font("Jetbrains Mono", Font.PLAIN, 14));
        cautarePanel.add(cautareField).setBackground(new Color(49, 50, 68));
        cautareField.setForeground(new Color(205, 214, 244));
        cautareField.setFont(new Font("Jetbrains Mono", Font.PLAIN, 14));
        cautareField.setBorder(BorderFactory.createEmptyBorder());

        JLabel dupa= new JLabel("Dupa:");
        cautarePanel.add(dupa).setForeground(new Color(205, 214, 244));
        dupa.setFont(new Font("Jetbrains Mono", Font.PLAIN, 14));
        cautarePanel.add(criteriuBox).setFont(new Font("Jetbrains Mono", Font.PLAIN, 14));
        cautarePanel.add(cautareButton).setFont(new Font("Jetbrains Mono", Font.PLAIN, 14));
        criteriuBox.setBackground(new Color(49, 50, 68));
        cautareButton.setContentAreaFilled(false);
        cautareButton.setOpaque(true);
        cautareButton.setBackground(new Color(49, 50, 68));
        cautareButton.setForeground(new Color(205, 214, 244));
        cautareField.setCaretColor(new Color(205, 214, 244));

        /**
         * Crearea partii de imprumut/retur
         */ 
        JPanel actionPanel = new JPanel();
        JButton imprumutButton = new JButton("Imprumuta");
        JButton returButton = new JButton("Returneaza");
        imprumutButton.setContentAreaFilled(false);
        imprumutButton.setOpaque(true);
        imprumutButton.setBackground(new Color(49, 50, 68));
        imprumutButton.setForeground(new Color(205, 214, 244));
        returButton.setContentAreaFilled(false);
        returButton.setOpaque(true);
        returButton.setBackground(new Color(49, 50, 68));
        returButton.setForeground(new Color(205, 214, 244));
        imprumutButton.setFont(new Font("Jetbrains Mono", Font.PLAIN, 14));
        returButton.setFont(new Font("Jetbrains Mono", Font.PLAIN, 14));

        /**
         * Gestionarea imprumuturilor
         */
        imprumutButton.addActionListener(e -> {  
            Carte carteSelectata = listaCarti.getSelectedValue();
            if (carteSelectata != null && !carteSelectata.esteImprumutata()) {
                carteSelectata.imprumutaCarte();
                actualizareListaCarti(repertoriu.getCarti());
                afisareDetaliiCarte(carteSelectata);
            } else {
                JOptionPane.showMessageDialog(this, "Cartea este deja imprumutata sau nu a fost selectata!", "Eroare!", JOptionPane.ERROR_MESSAGE);
            }
        });

        /**
         * Gestionarea retururilor
         */
        returButton.addActionListener(e -> {   
            Carte carteSelectata = listaCarti.getSelectedValue();
            if (carteSelectata != null && carteSelectata.esteImprumutata()) {
                carteSelectata.returneazaCarte();
                actualizareListaCarti(repertoriu.getCarti());
                afisareDetaliiCarte(carteSelectata);
            } else {
                JOptionPane.showMessageDialog(this, "Cartea nu este imprumutata sau nu a fost selectata!", "Eroare!", JOptionPane.ERROR_MESSAGE);
            }
        });

        /**
         * Crearea acceleratorilor pentru scurtaturi la butoanele de imprumut si retur
         */
        imprumutButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_I, KeyEvent.CTRL_DOWN_MASK), "imprumuta"); 
        imprumutButton.getActionMap().put("imprumuta", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                imprumutButton.doClick();
            }
        });

        returButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.CTRL_DOWN_MASK), "returneaza");
        returButton.getActionMap().put("returneaza", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                returButton.doClick();
            }
        });

        /**
         * Adaugam butoanele in panel, panourile de cautare si actiuni in layout si creeam scrollbars
         */
        actionPanel.add(imprumutButton);  
        actionPanel.add(returButton);

        add(cautarePanel, BorderLayout.NORTH); 

        JScrollPane scrollListaCarti = new JScrollPane(listaCarti);
        scrollListaCarti.setBorder(null); // eliminam bordura alba
        JScrollPane scrollDetaliiCarte = new JScrollPane(detaliiCarte);
        scrollDetaliiCarte.setBorder(null);

        add(scrollListaCarti, BorderLayout.WEST);  //pentru a putea da scroll in lista
        add(scrollDetaliiCarte, BorderLayout.CENTER); //pentru a putea da scroll la detalii
        add(actionPanel, BorderLayout.SOUTH);  //adaugam panoul de actiuni in layout

        setVisible(true);  //pentru ca elementele sa fie vizibile
    }


    /** 
     * Redimensioneaza imaginea copertii cartii pentru aspect
    */
    private ImageIcon redimensImagine(ImageIcon icon, int width, int height) {
        if (icon == null) return null;
        Image img = icon.getImage();
        Image resizedImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImg);
    }

    /**
     * Actualizeaza lista de carti afisata.
     * @param carti Lista de carti care urmeaza sa fie afisata.
     */
    private void actualizareListaCarti(List<Carte> carti) {
        DefaultListModel<Carte> model = new DefaultListModel<>();
        for (Carte carte : carti) {
            model.addElement(carte);
        }
        listaCarti.setModel(model);
    }

    /**
     * Afiseaza detalii despre cartea selectata.
     * @param carte Cartea selectata.
     */
    private void afisareDetaliiCarte(Carte carte) {  //crearea descrierii cartii in zona de detalii
        if (carte != null) {
            detaliiCarte.setText("Titlu: " + carte.getTitlu() + "\n" +
                                "Autor: " + carte.getAutor() + "\n" +
                                "An: " + carte.getAn() + "\n" +
                                "Editura: " + carte.getEditura() + "\n" +
                                "Pret: " + carte.getPret() + " RON" + "\n" +
                                "Stare: " + (carte.esteImprumutata() ? "Imprumutata" : "Disponibila") + "\n\n" +
                                "Rezumat:\n" + carte.getRezumat());
            copertaCarte.setIcon(redimensImagine(carte.getCoperta(), 120, 180));
        } else {
            detaliiCarte.setText("");
            copertaCarte.setIcon(null);
        }
    }

    /**
     * Afiseaza mesajele accesate din meniu
     */
    private void showDespreDialog() {
        JOptionPane.showMessageDialog(this,
                "Aplicatie Biblioteca\n\nVersiune: 1.0\n\nDespre: Aceasta este o aplicatie de gestionare a cartilor intr-o biblioteca.",
                "Despre Aplicatie", JOptionPane.INFORMATION_MESSAGE);
    }

    private void showScurtaturiDialog() {
        JOptionPane.showMessageDialog(this,
        "Combinarile de taste sunt:\n\nCTRL + I: Imprumutarea unei carti\n\nCTRL + R: Returnarea unei carti\n\nPentru a folosi aceste scurtaturi, selectati cartea dorita si dupa apasati simultan pe cele doua taste.",
        "Scurtaturi", JOptionPane.INFORMATION_MESSAGE);   
    }

    private void showTutorialDialog() {
        JOptionPane.showMessageDialog(this,
        "Bun venit in aplicatia Biblioteca! Acesta este micul ghid pentru utilizarea aplicatiei." +"\r\n" +"\r\n" + 
        "In partea stanga a ferestrei aplicatie se afla lista cartilor." +"\r\n" + 
        "In partea dreapta se afla detalii despre cartea selectata." +"\r\n" + 
        "In partea de jos a ferestrei se afla bara de acțiuni." +"\r\n" + 
        "Pentru a imprumuta o carte, selectati-o din lista si apasati pe butonul 'Imprumuta' din bara de acțiuni." +"\r\n" + 
        "Pentru a returna o carte, selectati-o din lista si apasati pe butonul 'Returneaza' din bara de acțiuni." +"\r\n" + 
        "In partea de sus, puteti cauta o carte dupa titlu, autor, editura si pret introducand aceste date in casuta de cautare si apasand butonul 'Cautare...'\n\nSpor la citit!",
        "Tutorial", JOptionPane.INFORMATION_MESSAGE);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views_panels;
//Importaciones de generales para el facil acceso a metodos y atributos:

import java.awt.Color;
//NOTA: Al igual que con la anterior clase: "AdicionesUsuario.java", no se puede generalizar puesto que 
//      se interpreta como "Paneles" y se requiere una reorganizacion de metodos de accionamientos. 
import DataBase_Models.Libros;

/**
 *
 * @author Fabrizio
 */
public class AdicionesLibro extends javax.swing.JPanel {

    //Variables de uso global:
    boolean isEditionLibros = false;
    Libros librosEdition;

    /**
     * Creates new form prinicipal
     */
    public AdicionesLibro() {
        initComponents();
        //Metodo insertor de imagen:
        //ImageIcon();
        //Estilos del panel:
        InitStylesPanel();
    }

    public AdicionesLibro(Libros libro) {
        initComponents();
        librosEdition = libro;
        isEditionLibros = true;
        InitStylesPanel();
    }

    //Estilos para el panel DEVOLUCIONES:
    private void InitStylesPanel() {
        //Estilizacion del titulo:
        lblTitle_AdicionLibrosPanel.putClientProperty("FlatLaf.styleClass", "h1");

        //Mas metodos ha incluir(Opcional).
        //Generador de leyendas de los campos de captura de texto:
        txtFldLibroID_AdicionLibrosPanel.putClientProperty("JTextField.placeholderText", "Ingrese el ID del libro");
        txtFldTituloLibro_AdicionLibrosPanel.putClientProperty("JTextField.placeholderText", "Ingrese el titulo del libro");
        txtFldFechaPublicacion_AdicionLibrosPanel.putClientProperty("JTextField.placeholderText", "Ingrese la fecha de publicacion");
        txtFldAutor_AdicionLibrosPanel.putClientProperty("JTextField.placeholderText", "Ingrese el nombre/seudonimo del autor");
        txtFldCategoria_AdicionLibrosPanel.putClientProperty("JTextField.placeholderText", "Ingrese la categoria del libro");
        txtFldEdicion_AdicionLibrosPanel.putClientProperty("JTextField.placeholderText", "Ingrese el numero de edicion del libro");
        txtFldidioma_AdicionLibrosPanel.putClientProperty("JTextField.placeholderText", "Ingrese el idioma nativo del libro");
        txtFldDescripcion_AdicionLibrosPanel.putClientProperty("JTextField.placeholderText", "NOTA: Descripcion breve");
        txtFldStock_AdicionLibrosPanel.putClientProperty("JTextField.placeholderText", "Numero de Stock");
        txtFldDisponibilidad_AdicionLibrosPanel.putClientProperty("JTextField.placeholderText", "Ingrese SI o NO segun la disponibilidad");
        txtFldEjemplares_AdicionLibrosPanel.putClientProperty("JTextField.placeholderText", "Numero de Ejemplares");

        if (isEditionLibros) {
            lblTitle_AdicionLibrosPanel.setText("EDICION DEL LIBRO");
            btnAgregar_AdicionLibrosPanel.setText("GUARDAR");
            if (librosEdition != null) {
                //CHECKPOINT: Lunes, 27/01/2025 - 17:08
                //NOTA: Corregir la transformacion de los tipos de datos. Usar la guia de AdicionesUsuario.java
                txtFldTituloLibro_AdicionLibrosPanel.setText(librosEdition.getTitle());
                txtFldFechaPublicacion_AdicionLibrosPanel.setText(librosEdition.getfecha());
                txtFldAutor_AdicionLibrosPanel.setText(librosEdition.getAuthor());
                txtFldCategoria_AdicionLibrosPanel.setText(librosEdition.getCategory());
                txtFldEdicion_AdicionLibrosPanel.setText(librosEdition.getEdit());
                txtFldidioma_AdicionLibrosPanel.setText(librosEdition.getLang());
                txtFldPaginas_AdicionLibrosPanel.setText(librosEdition.getPages());
                txtFldDescripcion_AdicionLibrosPanel.setText(librosEdition.getDescripcion());
                txtFldEjemplares_AdicionLibrosPanel.setText(librosEdition.getEjemplares());
                txtFldStock_AdicionLibrosPanel.setText(String.valueOf(librosEdition.getStock()));
                txtFldDisponibilidad_AdicionLibrosPanel.setText(String.valueOf(librosEdition.getAvailable()));
                //CHECKPOINT: Miercoles, 29/01/2025 - 
                //NOTA: Corregir la transformacion de los tipos de datos. Usar la guia de AdicionesUsuario.java        
            }
        }
    }

    //Metodo de imagen:
    //Al ser un panel refactor del otro, copia todo su codigo
    //NOTA: No afecta en mucho si es que esta bien codificado.
    //metodo fallido de insercion de imagen:
    //private void ImageIcon() {
    //Metodo fallido:
    /*        
        URL imageURL = getClass().getResource("/Images/EBSCO-LISTA-344x258-c-default.jpg");
        if (imageURL != null) {
            Icon mIcon = new ImageIcon(new ImageIcon("/Images/EBSCO-LISTA-344x258-c-default.jpg").getImage().getScaledInstance(lblimageIcon.getWidth(), lblimageIcon.getHeight(), Image.SCALE_SMOOTH));
            lblimageIcon.setIcon(mIcon);  // Asegura que el ícono se establezca en el JLabel
        } else {
            System.out.println("Image not found!");
        }
     */
    //Solucion:
    //Insercion deesde icons por URL externa.
    //}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBackground_AdicionLibrosPanel = new javax.swing.JPanel();
        lblTitle_AdicionLibrosPanel = new javax.swing.JLabel();
        lblLibroID_AdicionLibrosPanel = new javax.swing.JLabel();
        txtFldLibroID_AdicionLibrosPanel = new javax.swing.JTextField();
        jSeparator2_AdicionLibrosPanel = new javax.swing.JSeparator();
        lblTituloLibro_AdicionLibrosPanel = new javax.swing.JLabel();
        txtFldTituloLibro_AdicionLibrosPanel = new javax.swing.JTextField();
        jSeparator3_AdicionLibrosPanel = new javax.swing.JSeparator();
        lblFechaPublicacion_AdicionLibrosPanel = new javax.swing.JLabel();
        txtFldFechaPublicacion_AdicionLibrosPanel = new javax.swing.JTextField();
        jSeparator4_AdicionLibrosPanel = new javax.swing.JSeparator();
        lblAutor_AdicionLibrosPanel = new javax.swing.JLabel();
        txtFldAutor_AdicionLibrosPanel = new javax.swing.JTextField();
        jSeparator1_AdicionLibrosPanel = new javax.swing.JSeparator();
        lblCategoria_AdicionLibrosPanel = new javax.swing.JLabel();
        txtFldCategoria_AdicionLibrosPanel = new javax.swing.JTextField();
        jSeparator5_AdicionLibrosPanel = new javax.swing.JSeparator();
        lblEdicion_AdicionLibrosPanel = new javax.swing.JLabel();
        txtFldEdicion_AdicionLibrosPanel = new javax.swing.JTextField();
        jSeparator6_AdicionLibrosPanel = new javax.swing.JSeparator();
        lblidioma_AdicionLibrosPanel = new javax.swing.JLabel();
        txtFldidioma_AdicionLibrosPanel = new javax.swing.JTextField();
        jSeparator7_AdicionLibrosPanel = new javax.swing.JSeparator();
        lblDescripcion_AdicionLibrosPanel = new javax.swing.JLabel();
        txtFldDescripcion_AdicionLibrosPanel = new javax.swing.JTextField();
        jSeparator8_AdicionLibrosPanel = new javax.swing.JSeparator();
        lblStock_AdicionLibrosPanel = new javax.swing.JLabel();
        txtFldStock_AdicionLibrosPanel = new javax.swing.JTextField();
        lblPaginas_AdicionLibrosPanel = new javax.swing.JLabel();
        txtFldPaginas_AdicionLibrosPanel = new javax.swing.JTextField();
        jSeparator9_AdicionLibrosPanel = new javax.swing.JSeparator();
        lblDisponibilidad_AdicionLibrosPanel = new javax.swing.JLabel();
        txtFldDisponibilidad_AdicionLibrosPanel = new javax.swing.JTextField();
        jSeparator10_AdicionLibrosPanel = new javax.swing.JSeparator();
        lblEjemplares_AdicionLibrosPanel = new javax.swing.JLabel();
        txtFldEjemplares_AdicionLibrosPanel = new javax.swing.JTextField();
        jSeparator11_AdicionLibrosPanel = new javax.swing.JSeparator();
        btnAgregar_AdicionLibrosPanel = new javax.swing.JButton();

        pnlBackground_AdicionLibrosPanel.setBackground(new java.awt.Color(255, 255, 255));
        pnlBackground_AdicionLibrosPanel.setMinimumSize(new java.awt.Dimension(0, 0));
        pnlBackground_AdicionLibrosPanel.setPreferredSize(new java.awt.Dimension(0, 0));

        lblTitle_AdicionLibrosPanel.setForeground(new java.awt.Color(0, 0, 0));
        lblTitle_AdicionLibrosPanel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle_AdicionLibrosPanel.setText("ADICION DE LIBROS");

        lblLibroID_AdicionLibrosPanel.setForeground(new java.awt.Color(0, 0, 0));
        lblLibroID_AdicionLibrosPanel.setText("LIBRO ID");

        jSeparator2_AdicionLibrosPanel.setForeground(new java.awt.Color(204, 204, 204));

        lblTituloLibro_AdicionLibrosPanel.setForeground(new java.awt.Color(0, 0, 0));
        lblTituloLibro_AdicionLibrosPanel.setText("TITULO DE LIBRO");

        jSeparator3_AdicionLibrosPanel.setForeground(new java.awt.Color(204, 204, 204));

        lblFechaPublicacion_AdicionLibrosPanel.setBackground(new java.awt.Color(0, 0, 0));
        lblFechaPublicacion_AdicionLibrosPanel.setForeground(new java.awt.Color(0, 0, 0));
        lblFechaPublicacion_AdicionLibrosPanel.setText("FECHA DE PUBLICACION");

        jSeparator4_AdicionLibrosPanel.setForeground(new java.awt.Color(204, 204, 204));

        lblAutor_AdicionLibrosPanel.setBackground(new java.awt.Color(0, 0, 0));
        lblAutor_AdicionLibrosPanel.setForeground(new java.awt.Color(0, 0, 0));
        lblAutor_AdicionLibrosPanel.setText("AUTOR");

        jSeparator1_AdicionLibrosPanel.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator1_AdicionLibrosPanel.setOrientation(javax.swing.SwingConstants.VERTICAL);

        lblCategoria_AdicionLibrosPanel.setBackground(new java.awt.Color(0, 0, 0));
        lblCategoria_AdicionLibrosPanel.setForeground(new java.awt.Color(0, 0, 0));
        lblCategoria_AdicionLibrosPanel.setText("CATEGORIA");

        jSeparator5_AdicionLibrosPanel.setForeground(new java.awt.Color(204, 204, 204));

        lblEdicion_AdicionLibrosPanel.setBackground(new java.awt.Color(0, 0, 0));
        lblEdicion_AdicionLibrosPanel.setForeground(new java.awt.Color(0, 0, 0));
        lblEdicion_AdicionLibrosPanel.setText("EDICION");

        jSeparator6_AdicionLibrosPanel.setForeground(new java.awt.Color(204, 204, 204));

        lblidioma_AdicionLibrosPanel.setBackground(new java.awt.Color(0, 0, 0));
        lblidioma_AdicionLibrosPanel.setForeground(new java.awt.Color(0, 0, 0));
        lblidioma_AdicionLibrosPanel.setText("IDIOMA");

        jSeparator7_AdicionLibrosPanel.setForeground(new java.awt.Color(204, 204, 204));

        lblDescripcion_AdicionLibrosPanel.setBackground(new java.awt.Color(0, 0, 0));
        lblDescripcion_AdicionLibrosPanel.setForeground(new java.awt.Color(0, 0, 0));
        lblDescripcion_AdicionLibrosPanel.setText("DESCRIPCION");

        jSeparator8_AdicionLibrosPanel.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator8_AdicionLibrosPanel.setOrientation(javax.swing.SwingConstants.VERTICAL);

        lblStock_AdicionLibrosPanel.setBackground(new java.awt.Color(0, 0, 0));
        lblStock_AdicionLibrosPanel.setForeground(new java.awt.Color(0, 0, 0));
        lblStock_AdicionLibrosPanel.setText("STOCK");

        lblPaginas_AdicionLibrosPanel.setForeground(new java.awt.Color(0, 0, 0));
        lblPaginas_AdicionLibrosPanel.setText("PAGINAS");

        jSeparator9_AdicionLibrosPanel.setForeground(new java.awt.Color(204, 204, 204));

        lblDisponibilidad_AdicionLibrosPanel.setBackground(new java.awt.Color(0, 0, 0));
        lblDisponibilidad_AdicionLibrosPanel.setForeground(new java.awt.Color(0, 0, 0));
        lblDisponibilidad_AdicionLibrosPanel.setText("DISPONIBILIDAD");

        jSeparator10_AdicionLibrosPanel.setForeground(new java.awt.Color(204, 204, 204));

        lblEjemplares_AdicionLibrosPanel.setBackground(new java.awt.Color(0, 0, 0));
        lblEjemplares_AdicionLibrosPanel.setForeground(new java.awt.Color(0, 0, 0));
        lblEjemplares_AdicionLibrosPanel.setText("NUMERO DE EJEMPLARES");

        jSeparator11_AdicionLibrosPanel.setForeground(new java.awt.Color(204, 204, 204));

        btnAgregar_AdicionLibrosPanel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAgregar_AdicionLibrosPanel.setText("AGREGAR");
        btnAgregar_AdicionLibrosPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout pnlBackground_AdicionLibrosPanelLayout = new javax.swing.GroupLayout(pnlBackground_AdicionLibrosPanel);
        pnlBackground_AdicionLibrosPanel.setLayout(pnlBackground_AdicionLibrosPanelLayout);
        pnlBackground_AdicionLibrosPanelLayout.setHorizontalGroup(
            pnlBackground_AdicionLibrosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBackground_AdicionLibrosPanelLayout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(pnlBackground_AdicionLibrosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblLibroID_AdicionLibrosPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2_AdicionLibrosPanel, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTituloLibro_AdicionLibrosPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator3_AdicionLibrosPanel, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFechaPublicacion_AdicionLibrosPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                    .addComponent(jSeparator4_AdicionLibrosPanel, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAutor_AdicionLibrosPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTitle_AdicionLibrosPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtFldLibroID_AdicionLibrosPanel)
                    .addComponent(txtFldTituloLibro_AdicionLibrosPanel)
                    .addComponent(txtFldFechaPublicacion_AdicionLibrosPanel)
                    .addComponent(txtFldAutor_AdicionLibrosPanel))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1_AdicionLibrosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBackground_AdicionLibrosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblCategoria_AdicionLibrosPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblEdicion_AdicionLibrosPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblidioma_AdicionLibrosPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator5_AdicionLibrosPanel)
                    .addComponent(jSeparator6_AdicionLibrosPanel)
                    .addComponent(jSeparator7_AdicionLibrosPanel)
                    .addComponent(lblDescripcion_AdicionLibrosPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                    .addComponent(txtFldCategoria_AdicionLibrosPanel)
                    .addComponent(txtFldEdicion_AdicionLibrosPanel)
                    .addComponent(txtFldidioma_AdicionLibrosPanel)
                    .addComponent(txtFldDescripcion_AdicionLibrosPanel))
                .addGap(18, 18, 18)
                .addComponent(jSeparator8_AdicionLibrosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlBackground_AdicionLibrosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBackground_AdicionLibrosPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblEjemplares_AdicionLibrosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlBackground_AdicionLibrosPanelLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(btnAgregar_AdicionLibrosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlBackground_AdicionLibrosPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlBackground_AdicionLibrosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblDisponibilidad_AdicionLibrosPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator9_AdicionLibrosPanel)
                            .addComponent(jSeparator10_AdicionLibrosPanel)
                            .addComponent(jSeparator11_AdicionLibrosPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(txtFldDisponibilidad_AdicionLibrosPanel)
                            .addComponent(txtFldEjemplares_AdicionLibrosPanel)
                            .addGroup(pnlBackground_AdicionLibrosPanelLayout.createSequentialGroup()
                                .addGroup(pnlBackground_AdicionLibrosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlBackground_AdicionLibrosPanelLayout.createSequentialGroup()
                                        .addComponent(txtFldStock_AdicionLibrosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, Short.MAX_VALUE))
                                    .addGroup(pnlBackground_AdicionLibrosPanelLayout.createSequentialGroup()
                                        .addComponent(lblStock_AdicionLibrosPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(17, 17, 17)))
                                .addGroup(pnlBackground_AdicionLibrosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPaginas_AdicionLibrosPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtFldPaginas_AdicionLibrosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(22, 22, 22))
        );
        pnlBackground_AdicionLibrosPanelLayout.setVerticalGroup(
            pnlBackground_AdicionLibrosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackground_AdicionLibrosPanelLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(pnlBackground_AdicionLibrosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator8_AdicionLibrosPanel)
                    .addGroup(pnlBackground_AdicionLibrosPanelLayout.createSequentialGroup()
                        .addGroup(pnlBackground_AdicionLibrosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlBackground_AdicionLibrosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(pnlBackground_AdicionLibrosPanelLayout.createSequentialGroup()
                                    .addComponent(lblCategoria_AdicionLibrosPanel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtFldCategoria_AdicionLibrosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jSeparator5_AdicionLibrosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblEdicion_AdicionLibrosPanel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtFldEdicion_AdicionLibrosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jSeparator6_AdicionLibrosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblidioma_AdicionLibrosPanel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtFldidioma_AdicionLibrosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jSeparator7_AdicionLibrosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblDescripcion_AdicionLibrosPanel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtFldDescripcion_AdicionLibrosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jSeparator1_AdicionLibrosPanel, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnlBackground_AdicionLibrosPanelLayout.createSequentialGroup()
                                    .addComponent(lblTitle_AdicionLibrosPanel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblLibroID_AdicionLibrosPanel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtFldLibroID_AdicionLibrosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jSeparator2_AdicionLibrosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblTituloLibro_AdicionLibrosPanel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtFldTituloLibro_AdicionLibrosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jSeparator3_AdicionLibrosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblFechaPublicacion_AdicionLibrosPanel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtFldFechaPublicacion_AdicionLibrosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jSeparator4_AdicionLibrosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblAutor_AdicionLibrosPanel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtFldAutor_AdicionLibrosPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)))
                            .addGroup(pnlBackground_AdicionLibrosPanelLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(pnlBackground_AdicionLibrosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblStock_AdicionLibrosPanel)
                                    .addComponent(lblPaginas_AdicionLibrosPanel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlBackground_AdicionLibrosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtFldStock_AdicionLibrosPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                                    .addComponent(txtFldPaginas_AdicionLibrosPanel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator9_AdicionLibrosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblDisponibilidad_AdicionLibrosPanel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFldDisponibilidad_AdicionLibrosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator10_AdicionLibrosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblEjemplares_AdicionLibrosPanel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFldEjemplares_AdicionLibrosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator11_AdicionLibrosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAgregar_AdicionLibrosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 7, Short.MAX_VALUE)))
                .addGap(46, 46, 46))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground_AdicionLibrosPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 801, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground_AdicionLibrosPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar_AdicionLibrosPanel;
    private javax.swing.JSeparator jSeparator10_AdicionLibrosPanel;
    private javax.swing.JSeparator jSeparator11_AdicionLibrosPanel;
    private javax.swing.JSeparator jSeparator1_AdicionLibrosPanel;
    private javax.swing.JSeparator jSeparator2_AdicionLibrosPanel;
    private javax.swing.JSeparator jSeparator3_AdicionLibrosPanel;
    private javax.swing.JSeparator jSeparator4_AdicionLibrosPanel;
    private javax.swing.JSeparator jSeparator5_AdicionLibrosPanel;
    private javax.swing.JSeparator jSeparator6_AdicionLibrosPanel;
    private javax.swing.JSeparator jSeparator7_AdicionLibrosPanel;
    private javax.swing.JSeparator jSeparator8_AdicionLibrosPanel;
    private javax.swing.JSeparator jSeparator9_AdicionLibrosPanel;
    private javax.swing.JLabel lblAutor_AdicionLibrosPanel;
    private javax.swing.JLabel lblCategoria_AdicionLibrosPanel;
    private javax.swing.JLabel lblDescripcion_AdicionLibrosPanel;
    private javax.swing.JLabel lblDisponibilidad_AdicionLibrosPanel;
    private javax.swing.JLabel lblEdicion_AdicionLibrosPanel;
    private javax.swing.JLabel lblEjemplares_AdicionLibrosPanel;
    private javax.swing.JLabel lblFechaPublicacion_AdicionLibrosPanel;
    private javax.swing.JLabel lblLibroID_AdicionLibrosPanel;
    private javax.swing.JLabel lblPaginas_AdicionLibrosPanel;
    private javax.swing.JLabel lblStock_AdicionLibrosPanel;
    private javax.swing.JLabel lblTitle_AdicionLibrosPanel;
    private javax.swing.JLabel lblTituloLibro_AdicionLibrosPanel;
    private javax.swing.JLabel lblidioma_AdicionLibrosPanel;
    private javax.swing.JPanel pnlBackground_AdicionLibrosPanel;
    private javax.swing.JTextField txtFldAutor_AdicionLibrosPanel;
    private javax.swing.JTextField txtFldCategoria_AdicionLibrosPanel;
    private javax.swing.JTextField txtFldDescripcion_AdicionLibrosPanel;
    private javax.swing.JTextField txtFldDisponibilidad_AdicionLibrosPanel;
    private javax.swing.JTextField txtFldEdicion_AdicionLibrosPanel;
    private javax.swing.JTextField txtFldEjemplares_AdicionLibrosPanel;
    private javax.swing.JTextField txtFldFechaPublicacion_AdicionLibrosPanel;
    private javax.swing.JTextField txtFldLibroID_AdicionLibrosPanel;
    private javax.swing.JTextField txtFldPaginas_AdicionLibrosPanel;
    private javax.swing.JTextField txtFldStock_AdicionLibrosPanel;
    private javax.swing.JTextField txtFldTituloLibro_AdicionLibrosPanel;
    private javax.swing.JTextField txtFldidioma_AdicionLibrosPanel;
    // End of variables declaration//GEN-END:variables
}

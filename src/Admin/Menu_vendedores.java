package Admin;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.*;
import org.json.simple.parser.ParseException;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import constructores.vendedor;
import funciones.funcionVe;
//vista admin
public class Menu_vendedores implements Serializable {
	JButton crear = new JButton();
	JButton cargar = new JButton();
	JButton actualizar = new JButton();
	JButton eliminar = new JButton();
	JButton pdf = new JButton();
	
	//matriz
	Object [][] vendedores;
	
	//tabla y complemento
	JTable tabla;
	JScrollPane sp;
	
	private void botones () {
		crear.setText("crear");
		crear.setBounds(550,100,130,70);
		
		// Funcion crear
				ActionListener funcion_crear = new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						crear();

					}
				};
				// Acción del evento
				crear.addActionListener(funcion_crear);
				
				// carga masiva
				cargar.setText("Carga Masiva");
				cargar.setBounds(730, 100, 130, 70);

				ActionListener funcion_carga = new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						try {
							carga_masiva();
						} catch (IOException | ParseException e1) {
							
							e1.printStackTrace();
						}

					}
				};

				// Acción del evento
				cargar.addActionListener(funcion_carga);

				actualizar.setText("Actualizar");
				actualizar.setBounds(550, 260, 130, 70);

				// Funcion actualizar
				ActionListener funcion_actualizar = new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						modificar();
					}
				};

				// Acción del evento
				actualizar.addActionListener(funcion_actualizar);

				eliminar.setText("Eliminar");
				eliminar.setBounds(730, 260, 130, 70);

				// Funcion eliminar
				ActionListener funcion_eliminar = new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						eliminar();

					}
				};

				// Acción del evento
				eliminar.addActionListener(funcion_eliminar);

				pdf.setText("Exportar pdf");
				pdf.setBounds(550, 420, 310, 70);
				
				// Funcion eliminar
				ActionListener funcion_pdf = new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						try {
							generar_pdf();
						} catch (FileNotFoundException | DocumentException e1) {
							
							e1.printStackTrace();
						}

					}
				};

				// Acción del evento
				pdf.addActionListener(funcion_pdf);

		
	}
	
			private void tabla() throws ClassNotFoundException {
		//matrices para almacenar datos, lo bueno es que estas se pueden cargar despues
				String[] datos = { "Codigo", "Nombre", "Caja", "Ventas", "Genero", "Contrasena" };
		
				funcionVe fV = new funcionVe();	
				vendedores = fV.listar();
				tabla = new JTable(vendedores,datos);		
				sp = new JScrollPane(tabla);
				sp.setBounds(10, 10, 500, 600);
		
			}

			private void crear() {

				JFrame crear = new JFrame();
				JPanel p1 = new JPanel();
				p1.setLayout(null);

				// etiquetas
				JLabel l1 = new JLabel();
				JLabel l2 = new JLabel();
				JLabel l3 = new JLabel();
				JLabel l4 = new JLabel();
				JLabel l5 = new JLabel();
				JLabel l6 = new JLabel();

				// cajas de texto
				JTextField t1 = new JTextField();
				JTextField t2 = new JTextField();
				JTextField t3 = new JTextField();
				JTextField t4 = new JTextField();
				JTextField t5 = new JTextField();
				JTextField t6 = new JTextField();

				// Boton
				JButton b1 = new JButton();

				l1.setText("Codigo:");
				l1.setFont(new Font("Serig", Font.PLAIN, 25));
				l1.setBounds(50, 40, 180, 80);
				l1.setVisible(true);
				p1.add(l1);

				l2.setText("Nombre:");
				l2.setFont(new Font("Serig", Font.PLAIN, 25));
				l2.setBounds(50, 120, 180, 80);
				l2.setVisible(true);
				p1.add(l2);

				l3.setText("Caja:");
				l3.setFont(new Font("Serig", Font.PLAIN, 25));
				l3.setBounds(50, 200, 180, 80);
				l3.setVisible(true);
				p1.add(l3);
				
				l4.setText("Ventas:");
				l4.setFont(new Font("Serig", Font.PLAIN, 25));
				l4.setBounds(50, 280, 180, 80);
				l4.setVisible(true);
				p1.add(l4);

				l5.setText("Genero:");
				l5.setFont(new Font("Serig", Font.PLAIN, 25));
				l5.setBounds(50, 360, 180, 80);
				l5.setVisible(true);
				p1.add(l5);
				
				l6.setText("Contraseña:");
				l6.setFont(new Font("Serig", Font.PLAIN, 25));
				l6.setBounds(50, 440, 180, 80);
				l6.setVisible(true);
				p1.add(l6);

				crear.setTitle("Crear");
				crear.setLocationRelativeTo(null);
				crear.setBounds(500, 150, 600, 700);
				crear.setVisible(true);
				p1.setBackground(Color.gray);
				crear.add(p1);

				// jtextfield
				t1.setBounds(240, 70, 200, 40);
				t2.setBounds(240, 150, 200, 40);
				t3.setBounds(240, 230, 200, 40);
				t4.setBounds(240, 310, 200, 40);
				t5.setBounds(240, 390, 200, 40);
				t6.setBounds(240, 470, 200, 40);

				p1.add(t1);
				p1.add(t2);
				p1.add(t3);
				p1.add(t4);
				p1.add(t5);
				p1.add(t6);

				// boton
				b1.setText("Guardar");
				b1.setBounds(200, 570, 150, 60);
				p1.add(b1);

				// Funcionalidad
				ActionListener ingresar = new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						funcionVe fV = new funcionVe(); 

						fV.crear(t2.getText(), Integer.parseInt(t3.getText()), Integer.parseInt(t4.getText()), t5.getText(), t6.getText());
						

					}
				};

				// Acción del evento
				b1.addActionListener(ingresar);

			}

			private String leerarchivo() {

				JPanel c1 = new JPanel();
				JFileChooser fc = new JFileChooser();
				int op = fc.showOpenDialog(c1);
				String content = "";
				if (op == JFileChooser.APPROVE_OPTION) {

					File pRuta = fc.getSelectedFile();
					String ruta = pRuta.getAbsolutePath();
					File archivo = null;
					FileReader fr = null;
					BufferedReader br = null;

					try {
						archivo = new File(ruta);
						fr = new FileReader(archivo);
						br = new BufferedReader(fr);
						String linea = "";

						while ((linea = br.readLine()) != null) {

							content += linea + "\n";
						}
						return content;

					} catch (FileNotFoundException ex) {
						String resp = (String) JOptionPane.showInputDialog(null, "No se encontro el archivo");
					} catch (IOException ex) {
						String resp = (String) JOptionPane.showInputDialog(null, "No se pudo abrir el archivo");
					} finally {
						try {
							if (null != fr) {
								fr.close();
							}
						} catch (Exception e2) {
							String resp = (String) JOptionPane.showInputDialog(null, "No se encontro el archivo");
							return "";
						}
					}
					return content;
				}
				return null;
			}

			private void carga_masiva() throws FileNotFoundException, IOException, ParseException {
				
				String archivo_retorno = leerarchivo();

				JsonParser parse = new JsonParser();
				JsonArray matriz = parse.parse(archivo_retorno).getAsJsonArray();

				for (int i = 0; i < matriz.size(); i++) {

						JsonObject objeto = matriz.get(i).getAsJsonObject();
						funcionVe fV = new funcionVe();
						fV.crear(objeto.get("nombre").getAsString(), objeto.get("caja").getAsInt(), 
								objeto.get("ventas").getAsInt(), objeto.get("genero").getAsString(), 
								objeto.get("password").getAsString());
				}
			}
			

			private void eliminar() {
				int posicion = tabla.getSelectedRow();

				if (posicion != -1) {

					funcionVe fV = new funcionVe();
					fV.eliminar(Integer.parseInt(vendedores[posicion][0].toString()));
					

				} else {
					JOptionPane.showMessageDialog(null, "Debe selecionar una Fila");
				}
				tabla.repaint();
				sp.repaint();

			}

			private void modificar() {
				int seleccionar = tabla.getSelectedRow();
				if (seleccionar != -1) {

					JFrame crear = new JFrame("Modificar");
					JPanel p1 = new JPanel();
					p1.setLayout(null);

					// etiquetas
					JLabel l1 = new JLabel();
					JLabel l2 = new JLabel();
					JLabel l3 = new JLabel();
					JLabel l4 = new JLabel();
					JLabel l5 = new JLabel();
					JLabel l6 = new JLabel();

					// cajas de texto
					JTextField t1 = new JTextField();
					JTextField t2 = new JTextField();
					JTextField t3 = new JTextField();
					JTextField t4 = new JTextField();
					JTextField t5 = new JTextField();
					JTextField t6 = new JTextField();

					// Boton
					JButton b1 = new JButton();

					l1.setText("Codigo:");
					l1.setFont(new Font("Serig", Font.PLAIN, 25));
					l1.setBounds(50, 40, 180, 80);
					l1.setVisible(true);
					p1.add(l1);

					l2.setText("Nombre:");
					l2.setFont(new Font("Serig", Font.PLAIN, 25));
					l2.setBounds(50, 120, 180, 80);
					l2.setVisible(true);
					p1.add(l2);

					l3.setText("Caja:");
					l3.setFont(new Font("Serig", Font.PLAIN, 25));
					l3.setBounds(50, 200, 180, 80);
					l3.setVisible(true);
					p1.add(l3);

					l4.setText("Ventas:");
					l4.setFont(new Font("Serig", Font.PLAIN, 25));
					l4.setBounds(50, 280, 180, 80);
					l4.setVisible(true);
					p1.add(l4);

					l5.setText("Genero:");
					l5.setFont(new Font("Serig", Font.PLAIN, 25));
					l5.setBounds(50, 360, 180, 80);
					l5.setVisible(true);
					p1.add(l5);
					
					l6.setText("Contraseña:");
					l6.setFont(new Font("Serig", Font.PLAIN, 25));
					l6.setBounds(50, 440, 180, 80);
					l6.setVisible(true);
					p1.add(l6);

					crear.setTitle("Crear");
					crear.setLocationRelativeTo(null);
					crear.setBounds(500, 150, 600, 700);
					crear.setVisible(true);
					p1.setBackground(Color.cyan);
					crear.add(p1);

					// jtextfield
					t1.setBounds(240, 70, 200, 40);
					t2.setBounds(240, 150, 200, 40);
					t3.setBounds(240, 230, 200, 40);
					t4.setBounds(240, 310, 200, 40);
					t5.setBounds(240, 390, 200, 40);
					t6.setBounds(240, 470, 200, 40);

					t1.setText(vendedores[seleccionar][0] + "");
					t2.setText(vendedores[seleccionar][1].toString());
					t3.setText(vendedores[seleccionar][2] + "");
					t4.setText(vendedores[seleccionar][3] + "");
					t5.setText(vendedores[seleccionar][4].toString());
					t6.setText(vendedores[seleccionar][5].toString());

					p1.add(t1);
					p1.add(t2);
					p1.add(t3);
					p1.add(t4);
					p1.add(t5);
					p1.add(t6);

					// boton
					b1.setText("Guardar");
					b1.setBounds(200, 570, 150, 60);
					p1.add(b1);

					// Funcionalidad
					ActionListener ingresar = new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							//otra forma de realizar la conexion hecho el 05/07/2022
							vendedor objeto = new vendedor();
									objeto.setCodigo(Integer.parseInt(t1.getText()));
									objeto.setNombre(t2.getText());
									objeto.setCaja(Integer.parseInt(t3.getText()));
									objeto.setVentas(Integer.parseInt(t4.getText()));
									objeto.setGenero(t5.getText());
									objeto.setContrasena(t6.getText());
									
									funcionVe fV = new funcionVe();
									fV.modificar(objeto);
						}
					};

					// Acción del evento
					b1.addActionListener(ingresar);
				} else {
					JOptionPane.showMessageDialog(null, "Debe selecionar una Fila");
				}

			}

			private void generar_pdf() throws FileNotFoundException, DocumentException {

				FileOutputStream gen = new FileOutputStream("Vendedores.pdf");
				Document documento = new Document();

				PdfWriter.getInstance(documento, gen);
				documento.open();

				Paragraph parrafo = new Paragraph("Vendedores");
				parrafo.setAlignment(1);
				documento.add(parrafo);
				documento.add(new Paragraph("\n"));

				for (int i = 0; i < vendedores.length; i++) {

					if (vendedores[i][0] == null) {
						break;
					} else {
						documento.add(new Paragraph("Código: " + vendedores[i][0] + "  " + "Nombre: " + vendedores[i][1] + "  "
								+ "Caja: " + vendedores[i][2] + "  " + "Ventas: " + vendedores[i][3] + "  " + "Genero: "
								+ vendedores[i][4] + "  " + "Contraseña: " + vendedores[i][5]));
						documento.add(new Paragraph("\n\n"));
					}

				}
				documento.close();
				JOptionPane.showMessageDialog(null, "El archivo se creo correctamente");
				try {
					File sucursales_doc = new File("Vendedores.pdf");
					Desktop.getDesktop().open(sucursales_doc);
				} catch (Exception e) {
				}
			}
	
	public void ejecutar() throws ClassNotFoundException {
		botones();
		tabla();
	}
	
}

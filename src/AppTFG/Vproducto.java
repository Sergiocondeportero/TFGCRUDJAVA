package AppTFG;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Vproducto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblid;
	private JButton btnNewButton;
	private JButton btnEliminar;
	private JButton btnActualizar;
	private JTextField txtNombre;
	private JTextField txtPrecio;
	private JTextField txtVentas;
	private JTextField txtStock;
	private JTextField txtDescripcion;
	private JButton btnLimpiar;
	private JTable tblProductos;
	Daoproducto dao = new Daoproducto();
	DefaultTableModel modelo= new DefaultTableModel();
	ArrayList<Producto> lista;
	private JScrollPane scrollPane;
	int fila=-1;
	Producto producto= new Producto();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vproducto frame = new Vproducto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

public void actualizarTabla() {
	while(modelo.getRowCount()>0) {
		modelo.removeRow(0);
	}
	lista= dao.consultaProducto();
	for (Producto producto : lista) {
		 Object prod[]= new Object[6];
		 prod[0] = producto.getId();
	      prod[1] = producto.getNombre();
	      prod[2] = producto.getStock();
	       prod[3] = producto.getVentas();
	       prod[4] = producto.getPrecio();
	       prod[5] = producto.getDescripcion();
	        
	        modelo.addRow(prod);
	}
	tblProductos.setModel(modelo);
}
public void limpiar() {
	lblid.setText("");
    txtNombre.setText("");
    txtPrecio.setText("");
    txtVentas.setText("");
    txtStock.setText("");
    txtDescripcion.setText("");
}
	public Vproducto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1018, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNombre.setFont(new Font("Arial", Font.BOLD, 14));
		lblNombre.setBounds(45, 66, 130, 46);
		contentPane.add(lblNombre);
		
		lblid = new JLabel("0");
		lblid.setFont(new Font("Arial", Font.BOLD, 14));
		lblid.setBounds(164, 24, 130, 46);
		contentPane.add(lblid);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setVerticalAlignment(SwingConstants.BOTTOM);
		lblPrecio.setFont(new Font("Arial", Font.BOLD, 14));
		lblPrecio.setBounds(45, 103, 130, 46);
		contentPane.add(lblPrecio);
		
		JLabel lblNewLabel_2 = new JLabel("ID:");
		lblNewLabel_2.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2.setBounds(56, 10, 130, 46);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblVentas = new JLabel("Ventas:");
		lblVentas.setVerticalAlignment(SwingConstants.BOTTOM);
		lblVentas.setFont(new Font("Arial", Font.BOLD, 14));
		lblVentas.setBounds(45, 148, 130, 46);
		contentPane.add(lblVentas);
		
		JLabel lblStock = new JLabel("Stock:");
		lblStock.setVerticalAlignment(SwingConstants.BOTTOM);
		lblStock.setFont(new Font("Arial", Font.BOLD, 14));
		lblStock.setBounds(45, 202, 130, 46);
		contentPane.add(lblStock);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setVerticalAlignment(SwingConstants.BOTTOM);
		lblDescripcion.setFont(new Font("Arial", Font.BOLD, 14));
		lblDescripcion.setBounds(45, 246, 130, 46);
		contentPane.add(lblDescripcion);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(147, 95, 130, 19);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(147, 132, 130, 19);
		contentPane.add(txtPrecio);
		
		txtVentas = new JTextField();
		txtVentas.setColumns(10);
		txtVentas.setBounds(147, 177, 130, 19);
		contentPane.add(txtVentas);
		
		txtStock = new JTextField();
		txtStock.setColumns(10);
		txtStock.setBounds(147, 231, 130, 19);
		contentPane.add(txtStock);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(147, 275, 130, 19);
		contentPane.add(txtDescripcion);
		
		btnNewButton = new JButton("Agregar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					 if (txtNombre.getText().equals("") || txtPrecio.getText().equals("") || txtVentas.getText().equals("") ||  txtStock.getText().equals("") ||   txtDescripcion.getText().equals("")) {
				                    
				             JOptionPane.showMessageDialog(null, "Campos vacíos");
				                return;
				            }
					
				Producto prod= new Producto();
				prod.setNombre(txtNombre.getText());
				prod.setPrecio(Double.parseDouble(txtPrecio.getText())); 
	            prod.setVentas(Integer.parseInt(txtVentas.getText())); 
	            prod.setStock(Integer.parseInt(txtStock.getText()));
	            prod.setDescripcion(txtDescripcion.getText()); 
				if(dao.insertarProducto(prod)) {
					actualizarTabla();
					limpiar();
					JOptionPane.showMessageDialog(null,"se agregó correctamente!!");
				}else {
					JOptionPane.showMessageDialog(null, "error");
				}
				} catch (Exception e2) {	
					JOptionPane.showMessageDialog(null, "error");
				}
			}
		});
		btnNewButton.setBounds(164, 302, 85, 21);
		contentPane.add(btnNewButton);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int opcion=JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar este producto?","Eliminar Producto:",JOptionPane.YES_NO_OPTION);
					if(opcion==0) {
					if(dao.eliminarProducto(producto.getId())&&producto.getId()>0) {
						actualizarTabla();
						limpiar();
						JOptionPane.showMessageDialog(null, "el producto fue eliminado correctamente");
					}else {
						JOptionPane.showMessageDialog(null, "error, seleccione un producto");
					}
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "error");
				}
			}
		});
		btnEliminar.setBounds(164, 333, 85, 21);
		contentPane.add(btnEliminar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					 if (txtNombre.getText().equals("") || txtPrecio.getText().equals("") || txtVentas.getText().equals("") ||  txtStock.getText().equals("") ||   txtDescripcion.getText().equals("")) {
		                    
			             JOptionPane.showMessageDialog(null, "Campos vacíos");
			                return;
			            }
				
			
			producto.setNombre(txtNombre.getText());
			producto.setPrecio(Double.parseDouble(txtPrecio.getText())); 
            producto.setVentas(Integer.parseInt(txtVentas.getText())); 
            producto.setStock(Integer.parseInt(txtStock.getText()));
            producto.setDescripcion(txtDescripcion.getText()); 
			if(dao.editarProducto(producto)) {
				actualizarTabla();
				limpiar();
				JOptionPane.showMessageDialog(null,"se actualizó correctamente!!");
			}else {
				JOptionPane.showMessageDialog(null, "error");
			}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "error");
				}
			}
		});
		btnActualizar.setBounds(164, 364, 85, 21);
		contentPane.add(btnActualizar);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			limpiar();
		}
		});
		btnLimpiar.setBounds(164, 395, 85, 21);
		contentPane.add(btnLimpiar);
		scrollPane = new JScrollPane();
		scrollPane.setBounds(417, 32, 543, 384);
		contentPane.add(scrollPane);
		
		tblProductos = new JTable();
		tblProductos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int fila = tblProductos.getSelectedRow();
				if (fila >= 0) {  
					producto = lista.get(fila);
					lblid.setText(String.valueOf(producto.getId()));
					txtNombre.setText(producto.getNombre());
					txtStock.setText(String.valueOf(producto.getStock()));
					txtVentas.setText(String.valueOf(producto.getVentas()));
					txtPrecio.setText(String.valueOf(producto.getPrecio()));
					txtDescripcion.setText(producto.getDescripcion());
				}
			}
		});
		tblProductos.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(tblProductos);
		modelo.addColumn("ID");
		modelo.addColumn("Nombre");
		modelo.addColumn("Stock");
		modelo.addColumn("Ventas");
		modelo.addColumn("Precio");
		modelo.addColumn("Descripción");
		actualizarTabla();
		
	}

}

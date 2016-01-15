package cnuphys.ced.event.data;

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

public class CutTableScrollPane extends JScrollPane {

	protected int width = 150;
	protected int height = 200;

	/**
	 * The table that will be on this scroll pane.
	 */
	private CutTable cutTable;

	/**
	 * Constructor will also create the table itself.
	 * 
	 * @param cutList
	 *            the list of cuts
	 * @param label
	 *            a label for the list
	 */

	public CutTableScrollPane(Vector<ICut> cutList, String label) {
		super();
		cutTable = new CutTable(cutList);
		getViewport().add(cutTable);

		setBorder(BorderFactory.createTitledBorder(null, label,
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.blue));
//		addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent me) {
//				System.err.println("DUDE");
//
//				if (me.getClickCount() == 1) {
//					CutTableModel model = getCutTableModel();
//					int row = cutTable.getSelectedRow();
//					int column = cutTable.getSelectedColumn();
//
//					if ((row >= 0) && (column == CutTableModel.ACTIVE)) {
//						model.fireTableDataChanged();
//					}
//
//				}
//			}
//		});

	}

	/**
	 * Accessor for the underlying table.
	 * 
	 * @return the underlying cut table.
	 */
	public CutTable getCutTable() {
		return cutTable;
	}

	/**
	 * Refresh the table.
	 */

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(width, height);
	}

	/**
	 * Simple accessor for underlying model.
	 * 
	 * @return The underlying table model.
	 */
	public CutTableModel getCutTableModel() {
		if (cutTable == null) {
			return null;
		}

		return (CutTableModel) (cutTable.getModel());
	}
	
	/**
	 * Get the underlyiong table
	 * @return the table
	 */
	private CutTable getTable() {
		return cutTable;
	}

	/**
	 * @param height
	 *            The height to set.
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @param width
	 *            The width to set.
	 */
	public void setWidth(int width) {
		this.width = width;
	}

}

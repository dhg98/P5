package es.ucm.fdi.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.table.AbstractTableModel;

import es.ucm.fdi.model.Junction;

public class ListOfJunctionTableModel extends AbstractTableModel {

	private ArrayList <Junction> elements; //Mismo motivo que en SimWindow
	private String[] fieldNames = {"ID", "Green", "Red"};
	
	@Override
	public int getRowCount() {
		return elements.size();
	}

	@Override
	public int getColumnCount() {
		return fieldNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Map<String, String> description = new HashMap<>();
		elements.get(rowIndex).describe(description);
		return description.get(fieldNames[columnIndex]);
	}
}
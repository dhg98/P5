package es.ucm.fdi.view;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import es.ucm.fdi.model.*;

import javax.swing.table.AbstractTableModel;

public class ListOfRoadTableModel extends AbstractTableModel {
	
	private ArrayList <Road> elements; //Mismo motivo que en SimWindow
	private String[] fieldNames = {"ID", "Source", "Target", "Length", "Max Speed", "Vehicles"};
	
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

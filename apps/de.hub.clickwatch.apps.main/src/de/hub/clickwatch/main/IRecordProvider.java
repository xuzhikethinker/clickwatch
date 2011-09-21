package de.hub.clickwatch.main;

import com.google.inject.ImplementedBy;

import de.hub.clickwatch.main.impl.RecordProvider;
import de.hub.clickwatch.model.Node;
import de.hub.clickwatch.recoder.cwdatabase.DataBase;
import de.hub.clickwatch.recoder.cwdatabase.Record;

@ImplementedBy(RecordProvider.class)
public interface IRecordProvider {

	public DataBase getDataBase();
	
	public Record getRecord();
	
	public Node[] getSelectedNodes();
	
}
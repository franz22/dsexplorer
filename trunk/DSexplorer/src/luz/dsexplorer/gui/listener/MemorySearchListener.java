package luz.dsexplorer.gui.listener;

import java.util.EventListener;

import luz.dsexplorer.objects.Result;

public interface MemorySearchListener extends EventListener  {
    
	public void FirstSearchPerformed(int from, int to);
	
	public void NextSearchPerformed();
	
	public void AddPerformed(Result result);


}
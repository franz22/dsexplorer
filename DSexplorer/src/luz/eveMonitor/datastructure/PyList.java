package luz.eveMonitor.datastructure;

import java.util.Iterator;

import luz.dsexplorer.winapi.api.Process;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;

public class PyList extends PyObject{

	public PyList(PyObject_VAR_HEAD head, Process process) {
		super(head, 24, process);
	}
	
	public int		getElements(){return super.getInt   (0);}	//24
	public int		getListPtr (){return super.getInt   (4);}
	public int		getListSize(){return super.getInt   (8);}
	public int		getU3      (){return super.getInt   (12);}
	public int		getU4      (){return super.getInt   (16);}
	public int		getU5      (){return super.getInt   (20);}
	
	public PyObject getElement(int i){
		IntByReference val = new IntByReference();
		try {
			process.ReadProcessMemory(Pointer.createConstant(getListPtr()+(4*i)), val.getPointer(), 4, null);
			return	PyObjectFactory.getObject(val.getValue(), process, false);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Iterator<PyObject> getDictEntries(){
		return new Iterator<PyObject>() {
			int index=0;
			int limit=getElements();

			@Override
			public boolean hasNext() {
				return index<limit;
			}

			@Override
			public PyObject next() {
				return getElement(index++);
			}

			@Override
			public void remove() {}
		};
	}

}
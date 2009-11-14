package luz.dsexplorer.objects;

import javax.swing.tree.DefaultMutableTreeNode;

public class Result extends DefaultMutableTreeNode{
	private static final long serialVersionUID = 4163723615095260358L;
	private Long pointer;
	private boolean areChildrenDefined=false;
	public enum Type{Byte1, Byte2, Byte4, Byte8, Float, Double, Ascii, Unicode, ByteArray, Custom}
	private Type type=Type.Byte4;
	private Object value=null;
	
	public Result(Long pointer, Object value){
		this.pointer=pointer;
		this.value=value;
	}
	
	public long getPointer(){
		return pointer;
	}
	
	public String getPointerString(){
		return pointer==null?null:String.format("%1$08X", pointer);
	}
	
	public void setPointer(Long pointer){
		this.pointer=pointer;
	}
	
	public void setType(Type type) {
		this.type = type;
	}

	public Type getType() {
		return type;
	}
	
	public Object getValue() {
		return value;
	}
	
	public void setValue(Object value) {
		this.value=value;
	}
	
	////////////////////////////////////////

	@Override
	public boolean isLeaf() {
		return true;
	}
	
	@Override
	public int getChildCount() {
		if (!areChildrenDefined)
			defineChildNodes();
		return super.getChildCount();
	}
	
	
	private void defineChildNodes() {
		areChildrenDefined = true;
		add(new Result(null, null));
	}
	
	@Override
	public String toString() {
		return getPointerString()+" - "+getValue();
	}


}

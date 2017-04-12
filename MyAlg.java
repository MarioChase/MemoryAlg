import java.util.LinkedList;

public abstract class MyAlg implements ISwapper{
    	LinkedList<Block> memory = new LinkedList<Block>();
    @Override
	public void init(int memSize) {
		memory.add(new Block(memSize));
	}
	public abstract boolean load(IProcess p, IMemory mem);
	
	@Override
	public void unload(IProcess p, IMemory mem) {
		for (int i = 0; i < memory.size(); i++) {
			if (memory.get(i).p_stored == p) {
				mem.unload(p);
				memory.get(i).clearBlock();
				memory = memory.get(i).mergeBlock(memory);
			}
		}
	}
    
}
import java.util.LinkedList;

public class MyBestFitAlg implements ISwapper {
	LinkedList<Block> memory = new LinkedList<Block>();

	@Override
	public void init(int memSize) {
		memory.add(new Block(memSize));
	}

	@Override
	public boolean load(IProcess p, IMemory mem) {
		int bestFit = -1;
		int difference = (int) Double.POSITIVE_INFINITY;
		for (int i = 0; i < memory.size(); i++) {
			if (memory.get(i).p_stored == null) {
				System.out.println(memory.get(i).size + ":" + i);
			}
		}
		return false;
	}

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

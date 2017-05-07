import java.util.LinkedList;

public class MyFirstFitAlg extends MyAlg{

	@Override
	public boolean load(IProcess p, IMemory mem) {
		System.out.println(memory.size());
		for (int i = 0; i < memory.size(); i++) {
			if (p.getSize() < memory.get(i).size && memory.get(i).p_stored == null) {
				memory = memory.get(i).splitBlock(memory, p, i);
				mem.load(memory.get(i).p_stored, memory.get(i).start_marker, memory.get(i).end_marker);
				return true;
			}
		}
		return false;
	}
}

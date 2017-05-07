import java.util.LinkedList;
	public class Block {
		IProcess p_stored;
		int size;
		int start_marker;
		int end_marker;

		Block(LinkedList<Block> memory, IProcess p, int index) {
			p_stored = p;
			size = p_stored.getSize();
			if (index > 0) {
				start_marker = memory.get(index - 1).end_marker + 1;
				end_marker = start_marker + p.getSize() - 1;
			} else if (index == 0) {
				start_marker = 0;
				end_marker = p.getSize();
			}
		}

		Block(LinkedList<Block> memory, int space, int index) {
			p_stored = null;
			size = space;
			if (memory.size() >= 2) {
				start_marker = memory.get(index - 1).end_marker + 1;
				end_marker = start_marker + space - 1;
			} else if (index == 0) {
				start_marker = 0;
				end_marker = space;
			}
		}

		Block(int space) {
			p_stored = null;
			size = space;
		}

		public void clearBlock() {
			p_stored = null;
		}

		public void setSize(int change) {
			size = change;
		}

		public LinkedList<Block> splitBlock(LinkedList<Block> memory, IProcess a, int index) {
			this.size -= a.getSize();
			memory.add(index, new Block(memory, a, index));
			return memory;
		}

		public LinkedList<Block> mergeBlock(LinkedList<Block> memory) {
			if (memory.size() < 2) {
				return memory;
			}
			for (int i = 1; i < memory.size(); i++) {
				if (memory.get(i).p_stored == memory.get(i - 1).p_stored) {
					memory.get(i).setSize(memory.get(i).size + memory.get(i - 1).size);
					memory.remove(i - 1);
				}
			}
			return memory;
		}
	}
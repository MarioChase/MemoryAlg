import java.util.LinkedList;

public class MyBestFitAlg extends MyAlg {


	

	@Override
	public boolean load(IProcess p, IMemory mem) {
		int bestFit = -1;
		int difference = (int) Double.POSITIVE_INFINITY;
		for(int i = 0; i < memory.size(); i++){
			if(memory.get(i).p_stored == null){
				System.out.println(memory.get(i).size + ":" + i);
				if(memory.get(i).size > p.getSize()){
					System.out.println(p.getSize() + "\\" + p.getId());
					if(memory.get(i).size - p.getSize() < difference){
						difference = (memory.get(i).size - p.getSize());
						bestFit = i;
					}
				}	
			}
		}
		if(bestFit != -1){
		//	System.out.println(bestFit + "|" + memory.get(bestFit).size);
		//	System.out.println( memory.get(bestFit).start_marker + "," + memory.get(bestFit).end_marker);
		//	mem.dump();
			memory = memory.get(bestFit).splitBlock(memory,p,bestFit);
			mem.load(memory.get(bestFit).p_stored, memory.get(bestFit).start_marker, memory.get(bestFit).end_marker);
			return true;
		}
		else{
		return false;}
	}

	

}

package de.hub.clickwatch.apps.god.visuals;

public class NodeRefresher extends Thread {
	private GodNetwork parent;
	
	public NodeRefresher(GodNetwork parent) {
		this.parent = parent;
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException intExc) {
				//nothing
			}
			
			for (String node : parent.getServer().getRoutingtable().getNodes()) {
				boolean found = false;
				for (String known : parent.getNodeNames()) {
					if (known.equals(node)) {
						found = true;
						break;
					}
				}
				
				if (!found) {
					parent.addNode(node);
				}
			}
		}
	}
}

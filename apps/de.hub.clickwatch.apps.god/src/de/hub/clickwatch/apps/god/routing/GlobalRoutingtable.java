package de.hub.clickwatch.apps.god.routing;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GlobalRoutingtable implements Serializable {
	private static final long serialVersionUID = -6046518405036658052L;
	private static Set<String> nodes = new HashSet<String>();
	private static Map<String, DijkstraContainer> routingtable = new HashMap<String, DijkstraContainer>();
	
	public static Map<String, DijkstraContainer> getRoutingtable() {
		return routingtable;
	}
	
	public static Set<String> getNodes() {
		return new HashSet<String>(nodes);
	}
	
	public static void removeUsedLink(String from, String to) {
		for (String s : routingtable.keySet()) {
			routingtable.get(s).removeLink(from, to);
		}
	}
	
	public static void upgradeUsedLink(String from, String to, int metricDiff) {
		for (String s : routingtable.keySet()) {
			routingtable.get(s).upgradeLink(from, to, metricDiff);
		}
	}
	
	public static void degradeUsedLink(String from, String to) {
		for (String s : routingtable.keySet()) {
			routingtable.get(s).degradeLink(from, to);
		}
	}
	
	public static void addLink(String from, String to) {
		nodes.add(from);
		nodes.add(to);
		
		if (!routingtable.containsKey(from)) {
			routingtable.put(from, new DijkstraContainer(from));
		}
		if (!routingtable.containsKey(to)) {
			routingtable.put(to, new DijkstraContainer(to));
		}
		
		for (String s : routingtable.keySet()) {
			routingtable.get(s).runDijkstra();
		}
	}
}

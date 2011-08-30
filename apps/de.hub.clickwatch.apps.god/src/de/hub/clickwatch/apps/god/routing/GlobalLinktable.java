package de.hub.clickwatch.apps.god.routing;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import de.hub.clickwatch.apps.god.SzenarioHWL;
import de.hub.clickwatch.apps.god.information.LinktableLinkInformation;

public class GlobalLinktable implements Serializable {
	private static final long serialVersionUID = 6406600578300311068L;
	private static Map<String, LinktableLinkInformation> linktable = new HashMap<String, LinktableLinkInformation>();
	
	public static Map<String, LinktableLinkInformation> getLinktable() {
		return linktable;
	}
	
	public static Set<String> getNeighbors(String node) {
		Set<String> neighbors = new HashSet<String>();
		for (String link : linktable.keySet()) {
			if (link.startsWith(node)) {
				StringTokenizer strTok = new StringTokenizer(link, "" + SzenarioHWL.LINKTABLE_SEPARATOR);
				strTok.nextToken();
				neighbors.add(strTok.nextToken());
			}
		}
		return neighbors;
	}
	
	public static void removeFromGlobalLinktableIfExistent(String fromTo) {
		if ((fromTo != null) && (linktable.containsKey(fromTo))) {
			StringTokenizer strTok = new StringTokenizer(fromTo, "" + SzenarioHWL.LINKTABLE_SEPARATOR);
			if (strTok.countTokens() == 2) {
				String from = strTok.nextToken();
				String to = strTok.nextToken();
				GlobalRoutingtable.removeUsedLink(from, to);
				linktable.remove(fromTo);
			} else {
				System.err.println("WARNING: someone tries to remove a link, but does not provide exactly 2 node mac-addresses, but: " + strTok.countTokens());
			}
		}
	}
	
	public static void updateOrAddToGlobalLinktable(String fromTo, LinktableLinkInformation infos) {
		if ((fromTo != null) && (infos != null)) {
			if (linktable.containsKey(fromTo)) {
				updateLinktable(fromTo, infos);
			} else {
				addToLinktable(fromTo, infos);
			}
		}
	}
	
	private static void updateLinktable(String fromTo, LinktableLinkInformation infos) {
		StringTokenizer strTok = new StringTokenizer(fromTo, "" + SzenarioHWL.LINKTABLE_SEPARATOR);
		if (strTok.countTokens() == 2) {
			String from = strTok.nextToken();
			String to = strTok.nextToken();
			
			int metricDiff = linktable.get(fromTo).getMetric() - infos.getMetric();
			if (metricDiff >= 0) {
				GlobalRoutingtable.upgradeUsedLink(from, to, metricDiff);
			} else {
				GlobalRoutingtable.degradeUsedLink(from, to);
			}
			
			linktable.put(fromTo, infos);
			
		} else {
			System.err.println("WARNING: someone tries to update a link, but does not provide exactly 2 node mac-addresses, but: " + strTok.countTokens());
		}
	}
	
	private static void addToLinktable(String fromTo, LinktableLinkInformation infos) {
		StringTokenizer strTok = new StringTokenizer(fromTo, "" + SzenarioHWL.LINKTABLE_SEPARATOR);
		if (strTok.countTokens() == 2) {
			String from = strTok.nextToken();
			String to = strTok.nextToken();
			if (infos.getMetric() < SzenarioHWL.LINK_ADD_MIN_THRESHOLD) {
				GlobalRoutingtable.addLink(from, to);
			}
			
			linktable.put(fromTo, infos);
		} else {
			System.err.println("WARNING: someone tries to add a link, but does not provide exactly 2 node mac-addresses, but: " + strTok.countTokens());
		}
	}
}

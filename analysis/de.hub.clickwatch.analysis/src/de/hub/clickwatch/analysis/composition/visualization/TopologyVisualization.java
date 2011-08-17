package de.hub.clickwatch.analysis.composition.visualization;

import java.awt.Component;
import java.awt.Dimension;

import org.eclipse.emf.ecore.resource.Resource;

import de.hub.clickwatch.analysis.composition.model.DataNode;
import de.hub.clickwatch.analysis.composition.model.ModelNode;
import de.hub.clickwatch.analysis.composition.model.ModelUtil;
import de.hub.clickwatch.analysis.composition.model.Visualization;
import de.hub.clickwatch.analysis.models.topology.Link;
import de.hub.clickwatch.analysis.models.topology.Node;
import de.hub.clickwatch.analysis.models.topology.Topology;
import de.hub.clickwatch.analysis.visualization.IVisualization;
import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;

public class TopologyVisualization implements IVisualization {

	public static final String VisualizationName = "Topology";
	
	@Override
	public boolean isEnabledForInput(Object input) {
		if (input instanceof ModelNode) {
			DataNode node = (DataNode)input;
			Visualization visualization = node.getVisualization();
			if (visualization != null && visualization.getKind() != null && !visualization.getKind().equals("")) {
				return visualization.getKind().equals(VisualizationName);
			}
		}
		return false;
	}

	@Override
	public Component createVisualization(Object input) {
		input = ModelUtil.getModelFromModelNode((ModelNode)input);
		
		if (input instanceof Resource) {
			input = ((Resource)input).getContents().get(0);
		} 
		
		if (!(input instanceof Topology)) {
			return null;
		} 
		
		Topology topology = (Topology)input;
		Graph<Node, Link> graph = new SparseMultigraph<Node, Link>();
		for (Node node: topology.getNodes()) {
			graph.addVertex(node);
		}
		for (Link link: topology.getLinks()) {
			graph.addEdge(link, link.getSource(), link.getTarget());
		}
		
		Layout<Node, Link> layout = new CircleLayout<Node, Link>(graph);
		layout.setSize(new Dimension(300, 300)); 
		final BasicVisualizationServer<Node, Link> vv =
				new BasicVisualizationServer<Node, Link>(layout);
		vv.setPreferredSize(new Dimension(350, 350));
		return vv;
	}

}

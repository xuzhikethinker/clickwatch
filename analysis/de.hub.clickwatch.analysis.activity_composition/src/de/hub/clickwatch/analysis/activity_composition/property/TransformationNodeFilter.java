package de.hub.clickwatch.analysis.activity_composition.property;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.AbstractPropertySectionFilter;

import de.hub.clickwatch.analysis.activity_composition.model.Transformation;

public class TransformationNodeFilter extends AbstractPropertySectionFilter {

	@Override
	protected boolean accept(PictogramElement pe) {
		EObject bo = Graphiti.getLinkService()
				.getBusinessObjectForLinkedPictogramElement(pe);
		if (bo instanceof Transformation) {
			return true;
		}
		return false;
	}

}

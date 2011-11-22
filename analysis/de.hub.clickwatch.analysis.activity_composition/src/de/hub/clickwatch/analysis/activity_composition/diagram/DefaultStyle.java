package de.hub.clickwatch.analysis.activity_composition.diagram;

import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;

import de.hub.xveg.xvegfeaturemodel.Color;
import de.hub.xveg.xvegfeaturemodel.StyleInfo;
import de.hub.xveg.xvegfeaturemodel.builder.ColorBuilder;
import de.hub.xveg.xvegfeaturemodel.builder.StyleInfoBuilder;

public class DefaultStyle {
	public static StyleInfo INSTANCE = StyleInfoBuilder.newStyleInfoBuilder().
			withBackgroundColor(ColorBuilder.newColorBuilder().
					withR(255).withG(255).withB(255).build()).
			withLineColor(ColorBuilder.newColorBuilder().
					withR(0).withG(55).withB(108).build()).
			withTextColor(ColorBuilder.newColorBuilder().
					withR(0).withG(55).withB(108).build()).
			withFontSize(12).withBoldFont(true).build();
	
	public static IColorConstant createColorConstant(Color color, IColorConstant defaultColor) {
		return color == null ? defaultColor : new ColorConstant(color.getR(), color.getG(), color.getB());
	}
}

package edu.hu.clickwatch.examples.links;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xpand2.XpandExecutionContextImpl;
import org.eclipse.xpand2.XpandFacade;
import org.eclipse.xpand2.output.Outlet;
import org.eclipse.xpand2.output.OutputImpl;
import org.eclipse.xtend.XtendFacade;
import org.eclipse.xtend.typesystem.emf.EmfMetaModel;

public class Main {
	
	private EPackage metaModel;
	private EObject model;
	
	private void loadModels() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("scwm", new XMIResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new XMIResourceFactoryImpl());
		
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getLoadOptions().put(XMLResource.OPTION_EXTENDED_META_DATA, Boolean.TRUE);
		Resource metaModelResource = resourceSet.getResource(URI.createFileURI("src/edu/hu/clickwatch/examples/links/SpecificMetaModel.ecore"), true);		
		metaModel = (EPackage)metaModelResource.getContents().get(0);
		EPackage.Registry.INSTANCE.put(metaModel.getNsURI(), metaModel);
		
		Resource modelResource = resourceSet.getResource(URI.createFileURI("src/edu/hu/clickwatch/examples/links/SpecificModel.scwm"), true);
		model = modelResource.getContents().get(0);
	}
	
	public void evalXtend() {	
		XtendFacade f = XtendFacade.create("edu::hu::clickwatch::examples::links::seismo_stats");
		f.registerMetaModel(new EmfMetaModel(metaModel));
		
		System.out.println(f.call("performAnalysis", new Object[]{model}));
	}
	
	public void executeXpand() {
		OutputImpl output = new OutputImpl();
		output.addOutlet(new Outlet(false, "iso-8859-1", null, true,
				"src/edu/hu/clickwatch/examples/links/"));

		XpandExecutionContextImpl execCtx = new XpandExecutionContextImpl(output, null);
		execCtx.getResourceManager().setFileEncoding("iso-8859-1"); //$NON-NLS-1$
		execCtx.registerMetaModel(new EmfMetaModel(metaModel));

		XpandFacade facade = XpandFacade.create(execCtx);
		facade.evaluate("edu::hu::clickwatch::examples::links::seismo_stats::Main", model);
	}
	
	public static void main(String[] args) {
		Main instance = new Main();
		instance.loadModels();
		instance.evalXtend();
		instance.executeXpand();
	}
}

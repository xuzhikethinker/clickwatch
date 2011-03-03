package edu.hu.clickwatch.tests;

import org.eclipse.emf.ecore.EObject;

import edu.hu.clickwatch.XmlModelRepository;
import edu.hu.clickwatch.merge.IMergeConfiguration;
import edu.hu.clickwatch.merge.Merger;
import edu.hu.clickwatch.model.ClickWatchModelFactory;
import edu.hu.clickwatch.model.ClickWatchNodeMergeConfiguration;
import edu.hu.clickwatch.model.Element;
import edu.hu.clickwatch.model.Node;

public class MergeWithTimeTest extends AbstractTest {
	
	private XmlModelRepository xmlModelRepository;
	private Merger merger;
	
	@Override
	protected void additionalSetUp() {
		merger = injector.getInstance(Merger.class);
		xmlModelRepository = injector.getInstance(XmlModelRepository.class);
	}
	
	@Override
	protected Class<? extends IMergeConfiguration> getMergeConfigurationClass() {
		return ClickWatchNodeMergeConfiguration.class;
	}

	private EObject performMergeCW(String mergedValueStr, String newValueStr, String cmpStr, boolean changedModel) {
		mergedValueStr = "<edu.hu.clickwatch.model:Element xmlns:edu.hu.clickwatch.model='edu.hu.clickwatch.model' name='1'>\n\t" + mergedValueStr + "\n</edu.hu.clickwatch.model:Element>";
		newValueStr = "<edu.hu.clickwatch.model:Element xmlns:edu.hu.clickwatch.model='edu.hu.clickwatch.model' name='1'>\n\t" + newValueStr + "\n</edu.hu.clickwatch.model:Element>";
		cmpStr = "<edu.hu.clickwatch.model:Element xmlns:edu.hu.clickwatch.model='edu.hu.clickwatch.model' name='1'>\n\t" + cmpStr + "\n</edu.hu.clickwatch.model:Element>";
		
		Node mergedNode = ClickWatchModelFactory.eINSTANCE.createNode();
		mergedNode.setRecording(true);		
		EObject mergedValue = xmlModelRepository.deserializeXml(mergedValueStr);
		mergedNode.getElements().add((Element)mergedValue);
		EObject orig = mergedValue;
		
		Node newNode = ClickWatchModelFactory.eINSTANCE.createNode();
		EObject newValue = xmlModelRepository.deserializeXml(newValueStr);
		newNode.getElements().add((Element)newValue);
		
		EObject cmpValue = xmlModelRepository.deserializeXml(cmpStr);
		
		((ClickWatchNodeMergeConfiguration)merger.getConfiguration()).setNode(mergedNode);
		boolean result = merger.merge(mergedNode, newNode);
	
		assertEquals(true, result);
		assertEquals(changedModel, !((ClickWatchNodeMergeConfiguration)merger.getConfiguration()).getChanges().isEmpty());
		assertEquals(orig, mergedValue);
		boolean eEquals = merger.eEquals(mergedValue, cmpValue);
		if (!eEquals) {
			assertEquals(cmpStr, xmlModelRepository.serializeXml(mergedValue));
		} 
		assertTrue(eEquals);
		return mergedValue;
	}
	
	public void testSimple() {
		performMergeCW(
				"<handler name='a'><A time='1'/></handler>", 
				"<handler name='a'><A time='2'/></handler>",
				"<handler name='a'><A time='1'/><A time='2'/></handler>", true);
		performMergeCW(
				"<handler name='a'/>", 
				"<handler name='a'><A time='1'/><A time='2'/></handler>",
				"<handler name='a'><A time='1'/><A time='2'/></handler>", true);
	}
}

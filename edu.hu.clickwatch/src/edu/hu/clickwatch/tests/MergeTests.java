package edu.hu.clickwatch.tests;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import edu.hu.clickwatch.XmlModelRepository;
import edu.hu.clickwatch.merge.IMergeConfiguration;
import edu.hu.clickwatch.merge.Merger;
import edu.hu.clickwatch.model.ClickWatchNodeMergeConfiguration;

public class MergeTests extends AbstractTest {

	private XmlModelRepository xmlModelRepository;
	private Merger merger;
	
	private static class RegisterChangesConfiguration extends ClickWatchNodeMergeConfiguration {
		boolean changed = false;

		@Override
		public void handleDiffernce(IContext context, Object oldValue,
				Object newValue, int index) {
			changed = true;
		}

		@Override
		public boolean isToAdd(IContext context, Object oldValue,
				Object newValue) {
			return false;
		}		
	}

	@Override
	protected Class<? extends IMergeConfiguration> getMergeConfigurationClass() {
		return RegisterChangesConfiguration.class;
	}

	@Override
	protected void additionalSetUp() {
		merger = injector.getInstance(Merger.class);
		xmlModelRepository = injector.getInstance(XmlModelRepository.class);
	}
	
	private EObject performMergeXML(String mergedValueStr, String newValueStr, boolean changedModel) {
		EObject mergedValue = xmlModelRepository.deserializeXml(mergedValueStr);
		EObject orig = mergedValue;
		EObject newValue = xmlModelRepository.deserializeXml(newValueStr);
		
		((RegisterChangesConfiguration)merger.getConfiguration()).changed = false;
		boolean result = merger.merge(mergedValue, newValue);
	
		assertEquals(true, result);
		assertEquals(changedModel, ((RegisterChangesConfiguration)merger.getConfiguration()).changed);
		assertEquals(orig, mergedValue);
		boolean eEquals = merger.eEquals(mergedValue, newValue);
		if (!eEquals) {
			assertEquals(xmlModelRepository.serializeXml(newValue), xmlModelRepository.serializeXml(mergedValue));
		}
		assertTrue(eEquals);
		return mergedValue;
	}
	
	private EObject performMergeXSD(String mergedValueStr, String newValueStr, boolean changedModel) {
		EPackage metaModel = null;
		try {
			metaModel = xmlModelRepository.loadMetaModelFromXSD(URI.createFileURI(XmlModelRepositoryTest.LINK_STAT_XSD), 
					TestUtil.readFileAsString(XmlModelRepositoryTest.LINK_STAT_XSD));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		EObject mergedValue = xmlModelRepository.deserializeModel(metaModel, mergedValueStr);
		EObject orig = mergedValue;
		EObject newValue = xmlModelRepository.deserializeModel(metaModel, newValueStr);
		
		((RegisterChangesConfiguration)merger.getConfiguration()).changed = false;
		boolean result = merger.merge(mergedValue, newValue);
	
		assertEquals(true, result);
		assertEquals(changedModel, ((RegisterChangesConfiguration)merger.getConfiguration()).changed);
		assertEquals(orig, mergedValue);
		boolean eEquals = merger.eEquals(mergedValue, newValue);
		if (!eEquals) {
			assertEquals(xmlModelRepository.serializeXml(newValue), xmlModelRepository.serializeXml(mergedValue));
		}
		assertTrue(eEquals);
		return mergedValue;
	}
	
	private EObject performMergeCW(String mergedValueStr, String newValueStr, boolean changedModel) {
		mergedValueStr = "<edu.hu.clickwatch.model:Element xmlns:edu.hu.clickwatch.model='edu.hu.clickwatch.model'>" + mergedValueStr + "</edu.hu.clickwatch.model:Element>";
		newValueStr = "<edu.hu.clickwatch.model:Element xmlns:edu.hu.clickwatch.model='edu.hu.clickwatch.model'>" + newValueStr + "</edu.hu.clickwatch.model:Element>";
		
		EObject mergedValue = xmlModelRepository.deserializeXml(mergedValueStr);
		EObject orig = mergedValue;
		EObject newValue = xmlModelRepository.deserializeXml(newValueStr);
		
		((RegisterChangesConfiguration)merger.getConfiguration()).changed = false;
		boolean result = merger.merge(mergedValue, newValue);
	
		assertEquals(true, result);
		assertEquals(changedModel, ((RegisterChangesConfiguration)merger.getConfiguration()).changed);
		assertEquals(orig, mergedValue);
		boolean eEquals = merger.eEquals(mergedValue, newValue);
		if (!eEquals) {
			assertEquals(xmlModelRepository.serializeXml(newValue), xmlModelRepository.serializeXml(mergedValue));
		}
		assertTrue(eEquals);
		return mergedValue;
	}
	
	public void testGeneral() {
		performMergeXML("<foo/>", "<foo/>", false);
	}
	
	public void testTexts() {
		performMergeXML("<foo><bar>TEXT</bar></foo>", "<foo><bar>SIP</bar></foo>", true);
		performMergeXML("<foo><bar>TEXT</bar></foo>", "<foo><bar>TEXT</bar></foo>", false);
		performMergeXML("<foo><bar>TEXT</bar></foo>", "<foo><bar>TEXT</bar>TEXT</foo>", true);
	}
	
	public void testAttributes() {
		performMergeXML("<foo attr='ATTR'>TEXT</foo>", "<foo>TEXT</foo>", true);
		performMergeXML("<foo>TEXT</foo>", "<foo attr='ATTR'>TEXT</foo>", true);
		performMergeXML("<foo attr='ATTR'>TEXT</foo>", "<foo attr='ATTR2'>TEXT</foo>", true);
		performMergeXML("<foo attr='ATTR'>TEXT</foo>", "<foo attr='ATTR'>TEXT</foo>", false);
		performMergeXML("<foo attr='ATTR'>TEXT</foo>", "<foo attr='ATTR' attr2='ATTR'>TEXT</foo>", true);
		performMergeXML("<foo attr='ATTR'>TEXT</foo>", "<foo attr='ATTR' attr2='ATTR2'>TEXT</foo>", true);
		performMergeXML("<foo attr='ATTR' attr2='ATTR'>TEXT</foo>", "<foo attr='ATTR' attr2='ATTR'>TEXT</foo>", false);
		performMergeXML("<foo attr='ATTR' attr2='ATTR'>TEXT</foo>", "<foo attr2='ATTR' attr='ATTR'>TEXT</foo>", true);
		performMergeXML("<foo attr='ATTR' attr2='ATTR2'>TEXT</foo>", "<foo attr2='ATTR2' attr='ATTR'>TEXT</foo>", true);
	}
	
	public void testElements() {
		performMergeXML("<foo><bar/></foo>", "<foo></foo>", true);
		performMergeXML("<foo><bar/></foo>", "<foo><bar/></foo>", false);
		performMergeXML("<foo></foo>", "<foo><bar/></foo>", true);
		performMergeXML("<foo><bar/></foo>", "<foo><bar/><bar/></foo>", true);
		performMergeXML("<foo><bar/></foo>", "<foo><bar/><bar2/></foo>", true);
	}
	
	public void testXSD() {
		performMergeXSD("<entry/>", "<entry/>", false);
	}
	
	public void testXSDObjects() {
		performMergeXSD("<entry/>", "<entry><link/></entry>", true);
		performMergeXSD("<entry/>", "<entry><link/><link/></entry>", true);
		performMergeXSD("<entry><link/></entry>", "<entry><link/><link/></entry>", true);
		performMergeXSD("<entry><link/></entry>", "<entry><link/></entry>", false);
		performMergeXSD("<entry><link/></entry>", "<entry/>", true);
	}
	
	public void testXSDFeatures() {
		performMergeXSD("<entry/>", "<entry seq='16'/>", true);
		performMergeXSD("<entry seq='16'/>", "<entry seq='16'/>", false);
		performMergeXSD("<entry seq='16'/>", "<entry seq='32'/>", true);
		// performMergeXSD("<entry seq='16'/>", "<entry/>", true); fails for technical reasons, i.e. seq is int and empty int is 0 not empty
	}

	public void testCWModel() {
		performMergeCW(
				"<handler name='ls'><A/></handler>", 
				"<handler name='ls'><A/></handler><handler name='r'><B/></handler>", true); 
		performMergeCW(
				"<handler name='r'><A/><B/></handler>", 
				"<handler name='r'><A/><B/></handler><handler name='ls'><B/></handler>", true); 
		performMergeCW( 
				"<handler name='ls'><A/></handler><handler name='r'><B/></handler>", 
				"<handler name='ls'><A/></handler>", true); 
	}
}
package edu.institution.midterm;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class PartManagerImplTest {

	// 90%+ coverage on all classes 
    @Test
    public void partCostTest() { 
    	PartManagerImpl partManager = new PartManagerImpl();
        partManager.importPartStore("src\\\\edu\\\\institution\\\\midterm\\\\bom.json");
        
        Part part = partManager.costPart("290B7266J1");
        Assert.assertEquals(415.16f, part.getPrice(), 0.00);
        part = partManager.costPart("290B7266J2");
        Assert.assertEquals(532.20f, part.getPrice(), 0.00); 
        part = partManager.costPart("290B7266J6");
        Assert.assertEquals(334.10f, part.getPrice(), 0.00);
        part = partManager.costPart("20-0001");
        Assert.assertEquals(96.39f, part.getPrice(), 0.00);
        part = partManager.costPart("20-0015");
        Assert.assertEquals(70.46f, part.getPrice(), 0.00);
    }
     
    @Test
    public void testFinalAssemblies() {
        PartManagerImpl partManager = new PartManagerImpl();
        partManager.importPartStore("src\\\\edu\\\\institution\\\\midterm\\\\bom.json");
        List<Part> part = partManager.getFinalAssemblies();
        Assert.assertEquals(part.size(), 4);
        Assert.assertEquals(part.get(0).getPartNumber(), "20-0001");
    }
    
    @Test
    public void testPurchasedPartsByPrice() {
        PartManagerImpl partManager = new PartManagerImpl();
        partManager.importPartStore("src\\\\edu\\\\institution\\\\midterm\\\\bom.json");
        List<Part> part = partManager.getPurchasedPartsByPrice();
        Assert.assertEquals(part.get(0).getPrice(), 19.75f, 0.00);
    }
    
    @Test
    public void partTest() {
    	Part part = new Part();
    	part.setName("Name");
    	part.setPartNumber("123");
    	part.setPartType("ASSEMBLY");
    	Assert.assertTrue(part.getName().equals("Name"));
    	Part partDupl = part;
    	Part part2 = new Part();
    	Assert.assertTrue(part.equals(partDupl));
    	Assert.assertFalse(part.equals(part2));
    	Assert.assertFalse(part.hashCode() == part2.hashCode());
    	Assert.assertTrue(part.hashCode() == partDupl.hashCode());
    	part2.setPartNumber(null);
    	partDupl = null;
    	Assert.assertFalse(part.equals(partDupl));
    	Assert.assertFalse(part.getPartNumber().equals(part2.getPartNumber()));
    	BomEntry bom = new BomEntry();
    	Assert.assertFalse(part.equals(bom));

    }
    
    @Test
    public void bomTest() {
    	BomEntry bom = new BomEntry();
    	BomEntry bomDupl = bom;
    	BomEntry bom2 = new BomEntry();
    	bom.setPartNumber("123");
    	bom.setQuantity(123);
    	Assert.assertTrue(bom.equals(bomDupl));
    	Assert.assertFalse(bom.equals(bom2));
    	Assert.assertFalse(bom.hashCode() == bom2.hashCode());
    	Assert.assertTrue(bom.hashCode() == bomDupl.hashCode());
    	Assert.assertTrue(bom.toString().equals("BomEntry [partNumber=123, quantitiy=123]"));
    	bom2.setPartNumber(null);
    	bomDupl = null;
    	Assert.assertFalse(bom.equals(bomDupl));
    	Assert.assertFalse(bom.getPartNumber().equals(bom2.getPartNumber()));
    	List<BomEntry> boms = new ArrayList<BomEntry>();
    	boms.add(bom);
    	boms.add(bom2);
    	Part part = new Part();
    	Assert.assertFalse(bom.equals(part));
    	part.setBillOfMaterial(boms);
    	
    }
    
}

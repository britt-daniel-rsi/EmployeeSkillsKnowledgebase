package com.rsi.esk.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import com.rsi.esk.util.NumberUtils;

public class Test_Phone {


	@Test
	public void testPlus() {
		
		assertEquals(1+1,2);
		assertEquals(2+2,4);
	}
	
	@Test
	public void testNumber() {
		List<Phone> phones = new ArrayList<Phone>();
		phones.add(new Phone("(111)-222-3333"));
		phones.add(new Phone("(222)-222-3333"));
		phones.add(new Phone("(333)-222-3333"));
		phones.add(new Phone("(444)-222-3333"));
		
		assertEquals(phones.get(0).getNumber(),"(111)-222-3333");
		assertEquals(phones.get(1).getNumber(),"(222)-222-3333");
		assertEquals(phones.get(2).getNumber(),"(333)-222-3333");
		assertEquals(phones.get(3).getNumber(),"(444)-222-3333");
	}

	@Test
	public void testIsEmpty() {
		List<Phone> phones = new ArrayList<Phone>();
		assertTrue(phones.isEmpty());
		phones.add(new Phone("(111)-222-3333"));
		assertFalse("should have one element", phones.isEmpty());
		phones.add(new Phone("(222)-222-3333"));
		assertFalse("should have two elements", phones.isEmpty());
	}
//	@Test
//	public void testSyntax() {
//		List<Phone> phones = new ArrayList<Phone>();
//		phones.add(new Phone("111-222-3333"));
//		phones.add(new Phone("2222223333"));
//		phones.add(new Phone("(222)2223333"));
//		phones.add(new Phone("(Hey)-Hey-Heyy"));
//		phones.add(new Phone("string"));
//		
//		assertFalse("No Parens around area code", StringUtils.isNotEmpty(phones.get(0).getNumber()));
//		assertFalse("No Parens or dashes found", StringUtils.isNotEmpty(phones.get(1).getNumber()));
//		assertFalse("No dashes found", StringUtils.isNotEmpty(phones.get(2).getNumber()));
//		assertFalse("Strings with with parens and dashes should fail", StringUtils.isNotEmpty(phones.get(3).getNumber()));
//		assertFalse("Strings should fail", StringUtils.isNotEmpty(phones.get(4).getNumber()));		
//	}
}

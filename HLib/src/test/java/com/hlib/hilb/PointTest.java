package com.hlib.hilb;

import static org.junit.Assert.*;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.hlib.service.ReturnService;

@RunWith(value=Parameterized.class)
public class PointTest {

	private int expectedPoint;
	private int borrowableTerm;
	private Date start;
	private Date end;
	
	@Parameters 
	public static Collection<Object[]> getTestParameters() throws ParseException {
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		return Arrays.asList(new Object[][] {
			{5, new Date(System.currentTimeMillis())},
			{5, new Date(formatter.parse("2016-05-29").getTime())},
			{-150, new Date(formatter.parse("2016-04-29").getTime())},
			{-65, new Date(formatter.parse("2016-05-15").getTime())}
		});
	}

	
	public PointTest(int expectedPoint, Date start) {
		
		this.expectedPoint = expectedPoint;
		this.start = start;
		this.end = new Date(System.currentTimeMillis());
		this.borrowableTerm = 14;
	}
	
	@Test
	public void test() {
		ReturnService service = new ReturnService();
		int realPoint = service.calcPoint(borrowableTerm, start, end);
		
		assertEquals(expectedPoint, realPoint);
	}

}

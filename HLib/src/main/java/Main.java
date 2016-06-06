import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hlib.dao.BookInfoDAO;
import com.hlib.dao.BorrowInfoDAO;
import com.hlib.dao.MemberInfoDAO;
import com.hlib.domain.BookInfo;
import com.hlib.domain.BorrowInfo;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/hlib/beans/beans.xml");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		
		MemberInfoDAO memberInfoDAO= (MemberInfoDAO) context.getBean("MemberInfoDAO");
		BookInfoDAO bookInfoDAO = (BookInfoDAO) context.getBean("BookInfoDAO");
		BookInfo bookInfo = new BookInfo("9791156642008", "정보보안 이론과 실제");
		bookInfoDAO.insert(bookInfo);
		
		BorrowInfo borrowInfo = new BorrowInfo();
		borrowInfo.setBookInfo_ISBN("9791156642008");
		try {
			borrowInfo.setBorrowDate((java.sql.Date)format.parse("2016-06-02"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BorrowInfoDAO borrowInfoDAO = (BorrowInfoDAO) context.getBean("BorrowInfoDAO");
		borrowInfoDAO.insert(borrowInfo);
		
		context.close();
	} 
}

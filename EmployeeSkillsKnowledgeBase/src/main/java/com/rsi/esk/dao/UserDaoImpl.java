package com.rsi.esk.dao;

import com.rsi.esk.domain.User;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;


public class UserDaoImpl implements UserDao{
    private SessionFactory sessionFactory;

	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	@Override
	@SuppressWarnings("rawtypes")
    public Integer getMaxId() {
        Session session = this.sessionFactory.openSession();
        SQLQuery query = session.createSQLQuery(
                "select max(user_id) from esk.user");
        List maxIds = query.list();
        System.out.println(maxIds.get(0));
        session.close();

        return (Integer) maxIds.get(0);
    }

	@Override
	public void save(User user) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(user);
        tx.commit();
        session.close();
    }

	@Override
	@SuppressWarnings("unchecked")
    public List<User> list() {
        Session session = this.sessionFactory.openSession();
        List<User> userList = session.createQuery("from User").list();
        session.close();

        return userList;
    }

	@Override
	@SuppressWarnings("unchecked")
    public List<User> userNameSearch(String userName) {
        Session session = this.sessionFactory.openSession();
        List<User> userList = session.createQuery(
                "from User where userName='" + userName + "'").list();
        session.close();

        return userList;
    }

	@Override
	@SuppressWarnings("unchecked")
    public List<User> IdSearch(Integer id) {
        Session session = this.sessionFactory.openSession();
        List<User> userList = session.createQuery(
                "from User where id='" + id + "'").list();
        session.close();

        return userList;
    }

    @Override
	public Boolean checkPassword(String userName, String password) {
    	Session session = sessionFactory.openSession();
		try {
			byte[] hashedPass = SHA1(password);
			System.out.println(bytesToHex(hashedPass));
	        SQLQuery query = session.createSQLQuery("select user_password from esk.user where user_name =" + userName);        
	        if(bytesToHex((byte[]) query.list().get(0)).equals(bytesToHex(hashedPass))){
	        	session.close();
	        	return true;
	        }
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return false;
    }
    
	private static byte[] SHA1(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException  { 
	    MessageDigest md = MessageDigest.getInstance("SHA-1");
	    byte[] sha1hash = new byte[40];
	    md.update(text.getBytes());
	    sha1hash = md.digest();
	    return sha1hash;
	} 
	private static String bytesToHex(byte[] b) {
	      char hexDigit[] = {'0', '1', '2', '3', '4', '5', '6', '7',
	                         '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
	      StringBuffer buf = new StringBuffer();
	      for (int j=0; j<b.length; j++) {
	         buf.append(hexDigit[(b[j] >> 4) & 0x0f]);
	         buf.append(hexDigit[b[j] & 0x0f]);
	      }
	      return buf.toString();
	   }
}

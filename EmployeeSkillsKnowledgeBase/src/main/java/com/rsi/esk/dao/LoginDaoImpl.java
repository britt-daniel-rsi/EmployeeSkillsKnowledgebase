package com.rsi.esk.dao;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.hibernate.Session;

import com.rsi.esk.domain.User;
import com.rsi.esk.util.EncryptionUtils;

public class LoginDaoImpl extends HibernateDao implements LoginDao{

	@Override
	public boolean matchUserToPass(String username, String password) {
		Session session = getSessionFactory().openSession();
		boolean correct = false;
		try {
			byte[] hashedPass = EncryptionUtils.SHA1(password);
			@SuppressWarnings("unchecked")
			List<User> userList = session.createQuery("from User where user_name = :username and user_password = :password")
				.setParameter("username", username)
				.setParameter("password", hashedPass).list();
			session.close();
			if(userList.size() != 0){
				userList.get(0).getUserPassword();
				correct = true;
			}
	        return correct;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return false;
	}
}

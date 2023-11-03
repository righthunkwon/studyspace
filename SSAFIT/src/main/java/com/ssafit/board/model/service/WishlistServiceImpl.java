package com.ssafit.board.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafit.board.model.dao.WishlistDao;
import com.ssafit.board.model.dto.Wishlist;

@Service
public class WishlistServiceImpl implements WishlistService {

	private WishlistDao wishlistDao;
	
	@Autowired
	public WishlistServiceImpl(WishlistDao wishlistDao) {
		this.wishlistDao = wishlistDao;
	}
	
	@Override
	public int regist(String userId, int movieId) {
		Wishlist tmp = wishlistDao.selectOne(userId, movieId);
		if(tmp == null) {
			wishlistDao.insert(userId, movieId);
			return 0;
		}
		return 1;
	}
	
	@Override
	public int delete(String userId,int movieId) {
		Wishlist tmp = wishlistDao.selectOne(userId, movieId);
		if(tmp != null) {
			wishlistDao.delete(userId, movieId);
			return 0;
		}
		return 1;
	}
	
	@Override
	public List<Wishlist> showWishlist(String userId){
		List<Wishlist> list = new ArrayList<Wishlist>();
		List<Wishlist> origin = wishlistDao.selectAll();
		for(int i =0;i<origin.size();i++) {
			if(origin.get(i).getUserId().equals(userId)) {
				list.add(origin.get(i));
			}
		}
		return list;				
	}
	
}

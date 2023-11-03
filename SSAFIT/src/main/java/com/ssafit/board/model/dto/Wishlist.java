package com.ssafit.board.model.dto;

public class Wishlist {
	private int wishlistId;
	private String userId;
	private int videoId;
	public Wishlist() {
		// TODO Auto-generated constructor stub
	}
	public Wishlist(int wishlistId, String userId, int videoId) {
		super();
		this.wishlistId = wishlistId;
		this.userId = userId;
		this.videoId = videoId;
	}
	public Wishlist(int wishlistId) {
		super();
		this.wishlistId = wishlistId;
	}
	public int getWishlistId() {
		return wishlistId;
	}
	public void setWishlistId(int wishlistId) {
		this.wishlistId = wishlistId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getVideoId() {
		return videoId;
	}
	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}
	@Override
	public String toString() {
		return "Wishlist [wishlistId=" + wishlistId + ", userId=" + userId + ", videoId=" + videoId + "]";
	}
	
	
}

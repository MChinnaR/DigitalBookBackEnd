package com.digitalbook.response;

public class AuthorDetails {

	private Long  authId;
    private String authorName;
    
    
	public AuthorDetails() {
		
	}


	public AuthorDetails(Long authId, String authorName) {
		super();
		this.authId = authId;
		this.authorName = authorName;
	}


	public Long getAuthId() {
		return authId;
	}


	public void setAuthId(Long authId) {
		this.authId = authId;
	}


	public String getAuthorName() {
		return authorName;
	}


	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}


	@Override
	public String toString() {
		return "AuthorDetails [authId=" + authId + ", authorName=" + authorName + "]";
	}
    
    
}

package com.digitalbook.Model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "authoer_details")
public class AuthorDetails implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long  authId;
    private String authorName;

    public AuthorDetails(Long authId, String authorName) {
        this.authId = authId;
        this.authorName = authorName;
    }
    public AuthorDetails() {

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

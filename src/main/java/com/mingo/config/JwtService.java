package com.mingo.config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class JwtService {

	private static final String SECRET_KEY = "65794a68624763694f694a49557a49314e694a392e65794a536232786c496a6f6957796456553056534a7977674a30464554556c4f4a3130694c434a4a63334e315a5849694f694a4262576c3049454630614746335957786c4969776956584e6c636d3568625755694f694a4262576c305147647459576c734c6d4e7662534973496d5634634349364d5463794d44517a4e6a4d7a4e43776961574630496a6f784e7a49774d446b774e7a4d30"+
	                                         "66512e52796358477539644a424e785361392d414455624477335478747866387333656a7375796e492d51485634";
	public String extractUsername(String token) {
		// TODO Auto-generated method stub
		return extractClaim(token, Claims::getSubject);
	}
	
	public boolean isTokenValid(String token, UserDetails userDetails) {
	    final String username = extractUsername(token);
	    return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
	}
	
	private boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}

	private Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}

	public String generateToken(UserDetails userDetails) {
		return generateToken(new HashMap<>(),userDetails);
	}
	
	private String generateToken(Map<String, Object> extractClaims, UserDetails userDetails) {
	    List<String> roles = userDetails.getAuthorities().stream()
	        .map(grantedAuthority -> grantedAuthority.getAuthority())
	        .collect(Collectors.toList());

	    extractClaims.put("roles", roles);

	    return Jwts.builder()
	        .setClaims(extractClaims)
	        .setSubject(userDetails.getUsername())
	        .setIssuedAt(new Date(System.currentTimeMillis()))
	        .setExpiration(new Date(System.currentTimeMillis() + 7 * 24 * 60 * 60 * 1000)) // 1 week expiration
	        .signWith(getSignINKey(), SignatureAlgorithm.HS256)
	        .compact();
	}
	
    public Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }
	
	private <T>T extractClaim(String token,Function<Claims, T> claimResolver){
		final Claims claims=extractAllClaims(token);
		return claimResolver.apply(claims);
		
	}
	private Claims extractAllClaims(String token) {
		return Jwts
				.parserBuilder()
				.setSigningKey(getSignINKey())
				.build()
				.parseClaimsJws(token)
				.getBody();
	}
	
	
	private Key getSignINKey() {
		byte[] key=Decoders.BASE64.decode(SECRET_KEY);
		return Keys.hmacShaKeyFor(key);
	}
	
	public static String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

}

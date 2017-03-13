package com.xcesys.extras.config.springsecurity;

import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.xcesys.extras.entity.RememberMeToken;
import com.xcesys.extras.repository.RememberMeTookenRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SpringDataTokenRepositoryImpl implements PersistentTokenRepository {

	@Autowired
	RememberMeTookenRepository rememberMeTookenRepository;

	@Override
	public void createNewToken(PersistentRememberMeToken token) {
		RememberMeToken rememberMeToken = new RememberMeToken(token.getUsername(), token.getSeries(),
				token.getTokenValue(), token.getDate());
		rememberMeTookenRepository.save(rememberMeToken);
	}

	@Override
	public void updateToken(String series, String tokenValue, Date lastUsed) {
		RememberMeToken rememberMeToken = rememberMeTookenRepository.findBySeries(series);
		rememberMeToken.setToken(tokenValue);
		rememberMeToken.setLastUsed(lastUsed);
		rememberMeTookenRepository.save(rememberMeToken);
	}

	@Override
	public PersistentRememberMeToken getTokenForSeries(String series) {
		RememberMeToken rememberMeToken = rememberMeTookenRepository.findBySeries(series);
		if (rememberMeToken == null) {
			log.debug("No remember me token for series '{}' was found.", series);
			return null;
		}
		return new PersistentRememberMeToken(rememberMeToken.getUsername(), rememberMeToken.getSeries(),
				rememberMeToken.getToken(), rememberMeToken.getLastUsed());
	}

	@Override
	public void removeUserTokens(String username) {
		List<RememberMeToken> rememberMeTookens = rememberMeTookenRepository.findByUsername(username);
		for (RememberMeToken rememberMeToken : rememberMeTookens) {
			rememberMeTookenRepository.delete(rememberMeToken);
		}
	}

}

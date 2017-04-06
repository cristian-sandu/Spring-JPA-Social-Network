package com.usm.dao.tokenRepository;

import com.usm.model.persistentLogin.PersistentLogin;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;

@Repository("tokenRepositoryDAO")
@Transactional
public class TokenRepository implements PersistentTokenRepository {

    @PersistenceContext
    private EntityManager entityManager;

    private static final Logger logger = LogManager.getRootLogger();

    public void createNewToken(PersistentRememberMeToken token) {
        logger.info("Creating Token for user : {}", token.getUsername());
        PersistentLogin persistentLogin = new PersistentLogin();
        persistentLogin.setUsername(token.getUsername());
        persistentLogin.setSeries(token.getSeries());
        persistentLogin.setToken(token.getTokenValue());
        persistentLogin.setLast_used(token.getDate());
        entityManager.persist(persistentLogin);
        entityManager.flush();
    }

    public PersistentRememberMeToken getTokenForSeries(String seriesId) {
        logger.info("Fetch Token if any for seriesId : {}", seriesId);
        try {
            Query query = entityManager.createNamedQuery("PersistentUser.getUserBySeries");
            query.setParameter("series", seriesId);
            PersistentLogin persistentLogin = (PersistentLogin) query.getSingleResult();

            return new PersistentRememberMeToken(persistentLogin.getUsername(), persistentLogin.getSeries(),
                    persistentLogin.getToken(), persistentLogin.getLast_used());
        } catch (Exception e) {
            logger.info("Token not found...");
            return null;
        }
    }

    public void removeUserTokens(String username) {
        logger.info("Removing Token if any for user : {}", username);
        Query query = entityManager.createNamedQuery("PersistentUser.getUserByUsername");
        query.setParameter("username", username);
        PersistentLogin persistentLogin = (PersistentLogin) query.getSingleResult();

        if (persistentLogin != null) {
            logger.info("rememberMe was selected");
            entityManager.remove(persistentLogin);
        }
    }

    public void updateToken(String seriesId, String tokenValue, Date lastUsed) {
        logger.info("Updating Token for seriesId : {}", seriesId);
        PersistentLogin persistentLogin = entityManager.find(PersistentLogin.class, seriesId);
        persistentLogin.setToken(tokenValue);
        persistentLogin.setLast_used(lastUsed);
        entityManager.merge(persistentLogin);
        entityManager.flush();
    }

}
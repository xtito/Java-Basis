package com.xtito.shiro.dao;

import com.whalin.MemCached.MemCachedClient;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by [Zy]
 * 2017/10/9 12:47
 */
public class MCSessionDao extends AbstractSessionDAO {

    private static final transient Logger log = LoggerFactory.getLogger(MCSessionDao.class);

    private MemCachedClient client;

    public MCSessionDao(MemCachedClient client) {
        if (client == null) {
            throw new RuntimeException("必须存在memCached客户端实例");
        }
        this.client = client;
    }


    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = generateSessionId(session);
        assignSessionId(session, sessionId);
        try {
            client.set(sessionId.toString(), session, (int) session.getTimeout() / 1000);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return sessionId;

    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        Session session = null;
        try {
            session = (Session) client.get(sessionId.toString());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return session;
    }

    @Override
    public void update(Session session) throws UnknownSessionException {
        try {
            client.replace(session.getId().toString(), session, (int) session.getTimeout() / 1000);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public void delete(Session session) {
        try {
            client.delete(session.getId().toString());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public Collection<Session> getActiveSessions() {
        return Collections.emptySet();
    }
}

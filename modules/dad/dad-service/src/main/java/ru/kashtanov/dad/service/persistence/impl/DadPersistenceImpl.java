/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package ru.kashtanov.dad.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import ru.kashtanov.dad.exception.NoSuchDadException;
import ru.kashtanov.dad.model.Dad;
import ru.kashtanov.dad.model.impl.DadImpl;
import ru.kashtanov.dad.model.impl.DadModelImpl;
import ru.kashtanov.dad.service.persistence.DadPersistence;
import ru.kashtanov.dad.service.persistence.DadUtil;
import ru.kashtanov.dad.service.persistence.impl.constants.DadPersistenceConstants;

/**
 * The persistence implementation for the dad service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DadPersistence.class)
public class DadPersistenceImpl
	extends BasePersistenceImpl<Dad> implements DadPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DadUtil</code> to access the dad persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DadImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByByName;
	private FinderPath _finderPathWithoutPaginationFindByByName;
	private FinderPath _finderPathCountByByName;

	/**
	 * Returns all the dads where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching dads
	 */
	@Override
	public List<Dad> findByByName(String name) {
		return findByByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dads where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DadModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of dads
	 * @param end the upper bound of the range of dads (not inclusive)
	 * @return the range of matching dads
	 */
	@Override
	public List<Dad> findByByName(String name, int start, int end) {
		return findByByName(name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dads where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DadModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of dads
	 * @param end the upper bound of the range of dads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dads
	 */
	@Override
	public List<Dad> findByByName(
		String name, int start, int end,
		OrderByComparator<Dad> orderByComparator) {

		return findByByName(name, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dads where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DadModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of dads
	 * @param end the upper bound of the range of dads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dads
	 */
	@Override
	public List<Dad> findByByName(
		String name, int start, int end,
		OrderByComparator<Dad> orderByComparator, boolean useFinderCache) {

		name = Objects.toString(name, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByByName;
				finderArgs = new Object[] {name};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByByName;
			finderArgs = new Object[] {name, start, end, orderByComparator};
		}

		List<Dad> list = null;

		if (useFinderCache) {
			list = (List<Dad>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Dad dad : list) {
					if (!name.equals(dad.getName())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_DAD_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_BYNAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_BYNAME_NAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DadModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
				}

				list = (List<Dad>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first dad in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dad
	 * @throws NoSuchDadException if a matching dad could not be found
	 */
	@Override
	public Dad findByByName_First(
			String name, OrderByComparator<Dad> orderByComparator)
		throws NoSuchDadException {

		Dad dad = fetchByByName_First(name, orderByComparator);

		if (dad != null) {
			return dad;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchDadException(sb.toString());
	}

	/**
	 * Returns the first dad in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dad, or <code>null</code> if a matching dad could not be found
	 */
	@Override
	public Dad fetchByByName_First(
		String name, OrderByComparator<Dad> orderByComparator) {

		List<Dad> list = findByByName(name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dad in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dad
	 * @throws NoSuchDadException if a matching dad could not be found
	 */
	@Override
	public Dad findByByName_Last(
			String name, OrderByComparator<Dad> orderByComparator)
		throws NoSuchDadException {

		Dad dad = fetchByByName_Last(name, orderByComparator);

		if (dad != null) {
			return dad;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchDadException(sb.toString());
	}

	/**
	 * Returns the last dad in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dad, or <code>null</code> if a matching dad could not be found
	 */
	@Override
	public Dad fetchByByName_Last(
		String name, OrderByComparator<Dad> orderByComparator) {

		int count = countByByName(name);

		if (count == 0) {
			return null;
		}

		List<Dad> list = findByByName(
			name, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dads before and after the current dad in the ordered set where name = &#63;.
	 *
	 * @param dadId the primary key of the current dad
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dad
	 * @throws NoSuchDadException if a dad with the primary key could not be found
	 */
	@Override
	public Dad[] findByByName_PrevAndNext(
			long dadId, String name, OrderByComparator<Dad> orderByComparator)
		throws NoSuchDadException {

		name = Objects.toString(name, "");

		Dad dad = findByPrimaryKey(dadId);

		Session session = null;

		try {
			session = openSession();

			Dad[] array = new DadImpl[3];

			array[0] = getByByName_PrevAndNext(
				session, dad, name, orderByComparator, true);

			array[1] = dad;

			array[2] = getByByName_PrevAndNext(
				session, dad, name, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Dad getByByName_PrevAndNext(
		Session session, Dad dad, String name,
		OrderByComparator<Dad> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DAD_WHERE);

		boolean bindName = false;

		if (name.isEmpty()) {
			sb.append(_FINDER_COLUMN_BYNAME_NAME_3);
		}
		else {
			bindName = true;

			sb.append(_FINDER_COLUMN_BYNAME_NAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(DadModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindName) {
			queryPos.add(name);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(dad)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Dad> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dads where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	@Override
	public void removeByByName(String name) {
		for (Dad dad :
				findByByName(
					name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(dad);
		}
	}

	/**
	 * Returns the number of dads where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching dads
	 */
	@Override
	public int countByByName(String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByByName;

		Object[] finderArgs = new Object[] {name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DAD_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_BYNAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_BYNAME_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_BYNAME_NAME_2 = "dad.name = ?";

	private static final String _FINDER_COLUMN_BYNAME_NAME_3 =
		"(dad.name IS NULL OR dad.name = '')";

	public DadPersistenceImpl() {
		setModelClass(Dad.class);

		setModelImplClass(DadImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the dad in the entity cache if it is enabled.
	 *
	 * @param dad the dad
	 */
	@Override
	public void cacheResult(Dad dad) {
		entityCache.putResult(DadImpl.class, dad.getPrimaryKey(), dad);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the dads in the entity cache if it is enabled.
	 *
	 * @param dads the dads
	 */
	@Override
	public void cacheResult(List<Dad> dads) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (dads.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Dad dad : dads) {
			if (entityCache.getResult(DadImpl.class, dad.getPrimaryKey()) ==
					null) {

				cacheResult(dad);
			}
		}
	}

	/**
	 * Clears the cache for all dads.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DadImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the dad.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Dad dad) {
		entityCache.removeResult(DadImpl.class, dad);
	}

	@Override
	public void clearCache(List<Dad> dads) {
		for (Dad dad : dads) {
			entityCache.removeResult(DadImpl.class, dad);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DadImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new dad with the primary key. Does not add the dad to the database.
	 *
	 * @param dadId the primary key for the new dad
	 * @return the new dad
	 */
	@Override
	public Dad create(long dadId) {
		Dad dad = new DadImpl();

		dad.setNew(true);
		dad.setPrimaryKey(dadId);

		dad.setCompanyId(CompanyThreadLocal.getCompanyId());

		return dad;
	}

	/**
	 * Removes the dad with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dadId the primary key of the dad
	 * @return the dad that was removed
	 * @throws NoSuchDadException if a dad with the primary key could not be found
	 */
	@Override
	public Dad remove(long dadId) throws NoSuchDadException {
		return remove((Serializable)dadId);
	}

	/**
	 * Removes the dad with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dad
	 * @return the dad that was removed
	 * @throws NoSuchDadException if a dad with the primary key could not be found
	 */
	@Override
	public Dad remove(Serializable primaryKey) throws NoSuchDadException {
		Session session = null;

		try {
			session = openSession();

			Dad dad = (Dad)session.get(DadImpl.class, primaryKey);

			if (dad == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDadException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(dad);
		}
		catch (NoSuchDadException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Dad removeImpl(Dad dad) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dad)) {
				dad = (Dad)session.get(DadImpl.class, dad.getPrimaryKeyObj());
			}

			if (dad != null) {
				session.delete(dad);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (dad != null) {
			clearCache(dad);
		}

		return dad;
	}

	@Override
	public Dad updateImpl(Dad dad) {
		boolean isNew = dad.isNew();

		if (!(dad instanceof DadModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(dad.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(dad);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in dad proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Dad implementation " +
					dad.getClass());
		}

		DadModelImpl dadModelImpl = (DadModelImpl)dad;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (dad.getCreateDate() == null)) {
			if (serviceContext == null) {
				dad.setCreateDate(date);
			}
			else {
				dad.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!dadModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				dad.setModifiedDate(date);
			}
			else {
				dad.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(dad);
			}
			else {
				dad = (Dad)session.merge(dad);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(DadImpl.class, dadModelImpl, false, true);

		if (isNew) {
			dad.setNew(false);
		}

		dad.resetOriginalValues();

		return dad;
	}

	/**
	 * Returns the dad with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dad
	 * @return the dad
	 * @throws NoSuchDadException if a dad with the primary key could not be found
	 */
	@Override
	public Dad findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDadException {

		Dad dad = fetchByPrimaryKey(primaryKey);

		if (dad == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDadException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return dad;
	}

	/**
	 * Returns the dad with the primary key or throws a <code>NoSuchDadException</code> if it could not be found.
	 *
	 * @param dadId the primary key of the dad
	 * @return the dad
	 * @throws NoSuchDadException if a dad with the primary key could not be found
	 */
	@Override
	public Dad findByPrimaryKey(long dadId) throws NoSuchDadException {
		return findByPrimaryKey((Serializable)dadId);
	}

	/**
	 * Returns the dad with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dadId the primary key of the dad
	 * @return the dad, or <code>null</code> if a dad with the primary key could not be found
	 */
	@Override
	public Dad fetchByPrimaryKey(long dadId) {
		return fetchByPrimaryKey((Serializable)dadId);
	}

	/**
	 * Returns all the dads.
	 *
	 * @return the dads
	 */
	@Override
	public List<Dad> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dads.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DadModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dads
	 * @param end the upper bound of the range of dads (not inclusive)
	 * @return the range of dads
	 */
	@Override
	public List<Dad> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dads.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DadModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dads
	 * @param end the upper bound of the range of dads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dads
	 */
	@Override
	public List<Dad> findAll(
		int start, int end, OrderByComparator<Dad> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dads.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DadModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dads
	 * @param end the upper bound of the range of dads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dads
	 */
	@Override
	public List<Dad> findAll(
		int start, int end, OrderByComparator<Dad> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Dad> list = null;

		if (useFinderCache) {
			list = (List<Dad>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DAD);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DAD;

				sql = sql.concat(DadModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Dad>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the dads from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Dad dad : findAll()) {
			remove(dad);
		}
	}

	/**
	 * Returns the number of dads.
	 *
	 * @return the number of dads
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DAD);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "dadId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DAD;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DadModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the dad persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new DadModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", Dad.class.getName()));

		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByByName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByByName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"name"}, true);

		_finderPathWithoutPaginationFindByByName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByByName",
			new String[] {String.class.getName()}, new String[] {"name"}, true);

		_finderPathCountByByName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByByName",
			new String[] {String.class.getName()}, new String[] {"name"},
			false);

		DadUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		DadUtil.setPersistence(null);

		entityCache.removeCache(DadImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	@Override
	@Reference(
		target = DadPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = DadPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = DadPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private BundleContext _bundleContext;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_DAD = "SELECT dad FROM Dad dad";

	private static final String _SQL_SELECT_DAD_WHERE =
		"SELECT dad FROM Dad dad WHERE ";

	private static final String _SQL_COUNT_DAD =
		"SELECT COUNT(dad) FROM Dad dad";

	private static final String _SQL_COUNT_DAD_WHERE =
		"SELECT COUNT(dad) FROM Dad dad WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "dad.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Dad exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Dad exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DadPersistenceImpl.class);

	private FinderPath _createFinderPath(
		String cacheName, String methodName, String[] params,
		String[] columnNames, boolean baseModelResult) {

		FinderPath finderPath = new FinderPath(
			cacheName, methodName, params, columnNames, baseModelResult);

		if (!cacheName.equals(FINDER_CLASS_NAME_LIST_WITH_PAGINATION)) {
			_serviceRegistrations.add(
				_bundleContext.registerService(
					FinderPath.class, finderPath,
					MapUtil.singletonDictionary("cache.name", cacheName)));
		}

		return finderPath;
	}

	private Set<ServiceRegistration<FinderPath>> _serviceRegistrations =
		new HashSet<>();
	private ServiceRegistration<ArgumentsResolver>
		_argumentsResolverServiceRegistration;

	private static class DadModelArgumentsResolver
		implements ArgumentsResolver {

		@Override
		public Object[] getArguments(
			FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
			boolean original) {

			String[] columnNames = finderPath.getColumnNames();

			if ((columnNames == null) || (columnNames.length == 0)) {
				if (baseModel.isNew()) {
					return new Object[0];
				}

				return null;
			}

			DadModelImpl dadModelImpl = (DadModelImpl)baseModel;

			long columnBitmask = dadModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(dadModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |= dadModelImpl.getColumnBitmask(
						columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(dadModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			DadModelImpl dadModelImpl, String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = dadModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = dadModelImpl.getColumnValue(columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}
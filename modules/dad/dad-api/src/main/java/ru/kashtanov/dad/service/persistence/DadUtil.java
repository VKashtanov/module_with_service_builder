/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package ru.kashtanov.dad.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import ru.kashtanov.dad.model.Dad;

/**
 * The persistence utility for the dad service. This utility wraps <code>ru.kashtanov.dad.service.persistence.impl.DadPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DadPersistence
 * @generated
 */
public class DadUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Dad dad) {
		getPersistence().clearCache(dad);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Dad> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Dad> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Dad> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Dad> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Dad> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Dad update(Dad dad) {
		return getPersistence().update(dad);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Dad update(Dad dad, ServiceContext serviceContext) {
		return getPersistence().update(dad, serviceContext);
	}

	/**
	 * Returns all the dads where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching dads
	 */
	public static List<Dad> findByByName(String name) {
		return getPersistence().findByByName(name);
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
	public static List<Dad> findByByName(String name, int start, int end) {
		return getPersistence().findByByName(name, start, end);
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
	public static List<Dad> findByByName(
		String name, int start, int end,
		OrderByComparator<Dad> orderByComparator) {

		return getPersistence().findByByName(
			name, start, end, orderByComparator);
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
	public static List<Dad> findByByName(
		String name, int start, int end,
		OrderByComparator<Dad> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByByName(
			name, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dad in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dad
	 * @throws NoSuchDadException if a matching dad could not be found
	 */
	public static Dad findByByName_First(
			String name, OrderByComparator<Dad> orderByComparator)
		throws ru.kashtanov.dad.exception.NoSuchDadException {

		return getPersistence().findByByName_First(name, orderByComparator);
	}

	/**
	 * Returns the first dad in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dad, or <code>null</code> if a matching dad could not be found
	 */
	public static Dad fetchByByName_First(
		String name, OrderByComparator<Dad> orderByComparator) {

		return getPersistence().fetchByByName_First(name, orderByComparator);
	}

	/**
	 * Returns the last dad in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dad
	 * @throws NoSuchDadException if a matching dad could not be found
	 */
	public static Dad findByByName_Last(
			String name, OrderByComparator<Dad> orderByComparator)
		throws ru.kashtanov.dad.exception.NoSuchDadException {

		return getPersistence().findByByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the last dad in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dad, or <code>null</code> if a matching dad could not be found
	 */
	public static Dad fetchByByName_Last(
		String name, OrderByComparator<Dad> orderByComparator) {

		return getPersistence().fetchByByName_Last(name, orderByComparator);
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
	public static Dad[] findByByName_PrevAndNext(
			long dadId, String name, OrderByComparator<Dad> orderByComparator)
		throws ru.kashtanov.dad.exception.NoSuchDadException {

		return getPersistence().findByByName_PrevAndNext(
			dadId, name, orderByComparator);
	}

	/**
	 * Removes all the dads where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public static void removeByByName(String name) {
		getPersistence().removeByByName(name);
	}

	/**
	 * Returns the number of dads where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching dads
	 */
	public static int countByByName(String name) {
		return getPersistence().countByByName(name);
	}

	/**
	 * Caches the dad in the entity cache if it is enabled.
	 *
	 * @param dad the dad
	 */
	public static void cacheResult(Dad dad) {
		getPersistence().cacheResult(dad);
	}

	/**
	 * Caches the dads in the entity cache if it is enabled.
	 *
	 * @param dads the dads
	 */
	public static void cacheResult(List<Dad> dads) {
		getPersistence().cacheResult(dads);
	}

	/**
	 * Creates a new dad with the primary key. Does not add the dad to the database.
	 *
	 * @param dadId the primary key for the new dad
	 * @return the new dad
	 */
	public static Dad create(long dadId) {
		return getPersistence().create(dadId);
	}

	/**
	 * Removes the dad with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dadId the primary key of the dad
	 * @return the dad that was removed
	 * @throws NoSuchDadException if a dad with the primary key could not be found
	 */
	public static Dad remove(long dadId)
		throws ru.kashtanov.dad.exception.NoSuchDadException {

		return getPersistence().remove(dadId);
	}

	public static Dad updateImpl(Dad dad) {
		return getPersistence().updateImpl(dad);
	}

	/**
	 * Returns the dad with the primary key or throws a <code>NoSuchDadException</code> if it could not be found.
	 *
	 * @param dadId the primary key of the dad
	 * @return the dad
	 * @throws NoSuchDadException if a dad with the primary key could not be found
	 */
	public static Dad findByPrimaryKey(long dadId)
		throws ru.kashtanov.dad.exception.NoSuchDadException {

		return getPersistence().findByPrimaryKey(dadId);
	}

	/**
	 * Returns the dad with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dadId the primary key of the dad
	 * @return the dad, or <code>null</code> if a dad with the primary key could not be found
	 */
	public static Dad fetchByPrimaryKey(long dadId) {
		return getPersistence().fetchByPrimaryKey(dadId);
	}

	/**
	 * Returns all the dads.
	 *
	 * @return the dads
	 */
	public static List<Dad> findAll() {
		return getPersistence().findAll();
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
	public static List<Dad> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<Dad> findAll(
		int start, int end, OrderByComparator<Dad> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<Dad> findAll(
		int start, int end, OrderByComparator<Dad> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the dads from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of dads.
	 *
	 * @return the number of dads
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DadPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(DadPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile DadPersistence _persistence;

}
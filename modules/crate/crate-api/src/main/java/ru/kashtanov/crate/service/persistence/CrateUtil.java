/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package ru.kashtanov.crate.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import ru.kashtanov.crate.model.Crate;

/**
 * The persistence utility for the crate service. This utility wraps <code>ru.kashtanov.crate.service.persistence.impl.CratePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CratePersistence
 * @generated
 */
public class CrateUtil {

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
	public static void clearCache(Crate crate) {
		getPersistence().clearCache(crate);
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
	public static Map<Serializable, Crate> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Crate> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Crate> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Crate> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Crate> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Crate update(Crate crate) {
		return getPersistence().update(crate);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Crate update(Crate crate, ServiceContext serviceContext) {
		return getPersistence().update(crate, serviceContext);
	}

	/**
	 * Returns all the crates where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching crates
	 */
	public static List<Crate> findByByName(String name) {
		return getPersistence().findByByName(name);
	}

	/**
	 * Returns a range of all the crates where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CrateModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of crates
	 * @param end the upper bound of the range of crates (not inclusive)
	 * @return the range of matching crates
	 */
	public static List<Crate> findByByName(String name, int start, int end) {
		return getPersistence().findByByName(name, start, end);
	}

	/**
	 * Returns an ordered range of all the crates where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CrateModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of crates
	 * @param end the upper bound of the range of crates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching crates
	 */
	public static List<Crate> findByByName(
		String name, int start, int end,
		OrderByComparator<Crate> orderByComparator) {

		return getPersistence().findByByName(
			name, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the crates where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CrateModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of crates
	 * @param end the upper bound of the range of crates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching crates
	 */
	public static List<Crate> findByByName(
		String name, int start, int end,
		OrderByComparator<Crate> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByByName(
			name, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first crate in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crate
	 * @throws NoSuchCrateException if a matching crate could not be found
	 */
	public static Crate findByByName_First(
			String name, OrderByComparator<Crate> orderByComparator)
		throws ru.kashtanov.crate.exception.NoSuchCrateException {

		return getPersistence().findByByName_First(name, orderByComparator);
	}

	/**
	 * Returns the first crate in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crate, or <code>null</code> if a matching crate could not be found
	 */
	public static Crate fetchByByName_First(
		String name, OrderByComparator<Crate> orderByComparator) {

		return getPersistence().fetchByByName_First(name, orderByComparator);
	}

	/**
	 * Returns the last crate in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crate
	 * @throws NoSuchCrateException if a matching crate could not be found
	 */
	public static Crate findByByName_Last(
			String name, OrderByComparator<Crate> orderByComparator)
		throws ru.kashtanov.crate.exception.NoSuchCrateException {

		return getPersistence().findByByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the last crate in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crate, or <code>null</code> if a matching crate could not be found
	 */
	public static Crate fetchByByName_Last(
		String name, OrderByComparator<Crate> orderByComparator) {

		return getPersistence().fetchByByName_Last(name, orderByComparator);
	}

	/**
	 * Returns the crates before and after the current crate in the ordered set where name = &#63;.
	 *
	 * @param crateId the primary key of the current crate
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crate
	 * @throws NoSuchCrateException if a crate with the primary key could not be found
	 */
	public static Crate[] findByByName_PrevAndNext(
			long crateId, String name,
			OrderByComparator<Crate> orderByComparator)
		throws ru.kashtanov.crate.exception.NoSuchCrateException {

		return getPersistence().findByByName_PrevAndNext(
			crateId, name, orderByComparator);
	}

	/**
	 * Removes all the crates where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public static void removeByByName(String name) {
		getPersistence().removeByByName(name);
	}

	/**
	 * Returns the number of crates where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching crates
	 */
	public static int countByByName(String name) {
		return getPersistence().countByByName(name);
	}

	/**
	 * Caches the crate in the entity cache if it is enabled.
	 *
	 * @param crate the crate
	 */
	public static void cacheResult(Crate crate) {
		getPersistence().cacheResult(crate);
	}

	/**
	 * Caches the crates in the entity cache if it is enabled.
	 *
	 * @param crates the crates
	 */
	public static void cacheResult(List<Crate> crates) {
		getPersistence().cacheResult(crates);
	}

	/**
	 * Creates a new crate with the primary key. Does not add the crate to the database.
	 *
	 * @param crateId the primary key for the new crate
	 * @return the new crate
	 */
	public static Crate create(long crateId) {
		return getPersistence().create(crateId);
	}

	/**
	 * Removes the crate with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param crateId the primary key of the crate
	 * @return the crate that was removed
	 * @throws NoSuchCrateException if a crate with the primary key could not be found
	 */
	public static Crate remove(long crateId)
		throws ru.kashtanov.crate.exception.NoSuchCrateException {

		return getPersistence().remove(crateId);
	}

	public static Crate updateImpl(Crate crate) {
		return getPersistence().updateImpl(crate);
	}

	/**
	 * Returns the crate with the primary key or throws a <code>NoSuchCrateException</code> if it could not be found.
	 *
	 * @param crateId the primary key of the crate
	 * @return the crate
	 * @throws NoSuchCrateException if a crate with the primary key could not be found
	 */
	public static Crate findByPrimaryKey(long crateId)
		throws ru.kashtanov.crate.exception.NoSuchCrateException {

		return getPersistence().findByPrimaryKey(crateId);
	}

	/**
	 * Returns the crate with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param crateId the primary key of the crate
	 * @return the crate, or <code>null</code> if a crate with the primary key could not be found
	 */
	public static Crate fetchByPrimaryKey(long crateId) {
		return getPersistence().fetchByPrimaryKey(crateId);
	}

	/**
	 * Returns all the crates.
	 *
	 * @return the crates
	 */
	public static List<Crate> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the crates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CrateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of crates
	 * @param end the upper bound of the range of crates (not inclusive)
	 * @return the range of crates
	 */
	public static List<Crate> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the crates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CrateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of crates
	 * @param end the upper bound of the range of crates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of crates
	 */
	public static List<Crate> findAll(
		int start, int end, OrderByComparator<Crate> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the crates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CrateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of crates
	 * @param end the upper bound of the range of crates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of crates
	 */
	public static List<Crate> findAll(
		int start, int end, OrderByComparator<Crate> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the crates from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of crates.
	 *
	 * @return the number of crates
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CratePersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(CratePersistence persistence) {
		_persistence = persistence;
	}

	private static volatile CratePersistence _persistence;

}
/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package ru.kashtanov.crate.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

import ru.kashtanov.crate.exception.NoSuchCrateException;
import ru.kashtanov.crate.model.Crate;

/**
 * The persistence interface for the crate service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CrateUtil
 * @generated
 */
@ProviderType
public interface CratePersistence extends BasePersistence<Crate> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CrateUtil} to access the crate persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the crates where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching crates
	 */
	public java.util.List<Crate> findByByName(String name);

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
	public java.util.List<Crate> findByByName(String name, int start, int end);

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
	public java.util.List<Crate> findByByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Crate>
			orderByComparator);

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
	public java.util.List<Crate> findByByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Crate>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first crate in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crate
	 * @throws NoSuchCrateException if a matching crate could not be found
	 */
	public Crate findByByName_First(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<Crate>
				orderByComparator)
		throws NoSuchCrateException;

	/**
	 * Returns the first crate in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crate, or <code>null</code> if a matching crate could not be found
	 */
	public Crate fetchByByName_First(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<Crate>
			orderByComparator);

	/**
	 * Returns the last crate in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crate
	 * @throws NoSuchCrateException if a matching crate could not be found
	 */
	public Crate findByByName_Last(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<Crate>
				orderByComparator)
		throws NoSuchCrateException;

	/**
	 * Returns the last crate in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crate, or <code>null</code> if a matching crate could not be found
	 */
	public Crate fetchByByName_Last(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<Crate>
			orderByComparator);

	/**
	 * Returns the crates before and after the current crate in the ordered set where name = &#63;.
	 *
	 * @param crateId the primary key of the current crate
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crate
	 * @throws NoSuchCrateException if a crate with the primary key could not be found
	 */
	public Crate[] findByByName_PrevAndNext(
			long crateId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<Crate>
				orderByComparator)
		throws NoSuchCrateException;

	/**
	 * Removes all the crates where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public void removeByByName(String name);

	/**
	 * Returns the number of crates where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching crates
	 */
	public int countByByName(String name);

	/**
	 * Caches the crate in the entity cache if it is enabled.
	 *
	 * @param crate the crate
	 */
	public void cacheResult(Crate crate);

	/**
	 * Caches the crates in the entity cache if it is enabled.
	 *
	 * @param crates the crates
	 */
	public void cacheResult(java.util.List<Crate> crates);

	/**
	 * Creates a new crate with the primary key. Does not add the crate to the database.
	 *
	 * @param crateId the primary key for the new crate
	 * @return the new crate
	 */
	public Crate create(long crateId);

	/**
	 * Removes the crate with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param crateId the primary key of the crate
	 * @return the crate that was removed
	 * @throws NoSuchCrateException if a crate with the primary key could not be found
	 */
	public Crate remove(long crateId) throws NoSuchCrateException;

	public Crate updateImpl(Crate crate);

	/**
	 * Returns the crate with the primary key or throws a <code>NoSuchCrateException</code> if it could not be found.
	 *
	 * @param crateId the primary key of the crate
	 * @return the crate
	 * @throws NoSuchCrateException if a crate with the primary key could not be found
	 */
	public Crate findByPrimaryKey(long crateId) throws NoSuchCrateException;

	/**
	 * Returns the crate with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param crateId the primary key of the crate
	 * @return the crate, or <code>null</code> if a crate with the primary key could not be found
	 */
	public Crate fetchByPrimaryKey(long crateId);

	/**
	 * Returns all the crates.
	 *
	 * @return the crates
	 */
	public java.util.List<Crate> findAll();

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
	public java.util.List<Crate> findAll(int start, int end);

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
	public java.util.List<Crate> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Crate>
			orderByComparator);

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
	public java.util.List<Crate> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Crate>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the crates from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of crates.
	 *
	 * @return the number of crates
	 */
	public int countAll();

}
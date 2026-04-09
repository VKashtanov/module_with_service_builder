/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package ru.kashtanov.dad.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

import ru.kashtanov.dad.exception.NoSuchDadException;
import ru.kashtanov.dad.model.Dad;

/**
 * The persistence interface for the dad service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DadUtil
 * @generated
 */
@ProviderType
public interface DadPersistence extends BasePersistence<Dad> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DadUtil} to access the dad persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the dads where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching dads
	 */
	public java.util.List<Dad> findByByName(String name);

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
	public java.util.List<Dad> findByByName(String name, int start, int end);

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
	public java.util.List<Dad> findByByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Dad>
			orderByComparator);

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
	public java.util.List<Dad> findByByName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Dad> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first dad in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dad
	 * @throws NoSuchDadException if a matching dad could not be found
	 */
	public Dad findByByName_First(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<Dad>
				orderByComparator)
		throws NoSuchDadException;

	/**
	 * Returns the first dad in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dad, or <code>null</code> if a matching dad could not be found
	 */
	public Dad fetchByByName_First(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<Dad>
			orderByComparator);

	/**
	 * Returns the last dad in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dad
	 * @throws NoSuchDadException if a matching dad could not be found
	 */
	public Dad findByByName_Last(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<Dad>
				orderByComparator)
		throws NoSuchDadException;

	/**
	 * Returns the last dad in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dad, or <code>null</code> if a matching dad could not be found
	 */
	public Dad fetchByByName_Last(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<Dad>
			orderByComparator);

	/**
	 * Returns the dads before and after the current dad in the ordered set where name = &#63;.
	 *
	 * @param dadId the primary key of the current dad
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dad
	 * @throws NoSuchDadException if a dad with the primary key could not be found
	 */
	public Dad[] findByByName_PrevAndNext(
			long dadId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<Dad>
				orderByComparator)
		throws NoSuchDadException;

	/**
	 * Removes all the dads where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public void removeByByName(String name);

	/**
	 * Returns the number of dads where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching dads
	 */
	public int countByByName(String name);

	/**
	 * Caches the dad in the entity cache if it is enabled.
	 *
	 * @param dad the dad
	 */
	public void cacheResult(Dad dad);

	/**
	 * Caches the dads in the entity cache if it is enabled.
	 *
	 * @param dads the dads
	 */
	public void cacheResult(java.util.List<Dad> dads);

	/**
	 * Creates a new dad with the primary key. Does not add the dad to the database.
	 *
	 * @param dadId the primary key for the new dad
	 * @return the new dad
	 */
	public Dad create(long dadId);

	/**
	 * Removes the dad with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dadId the primary key of the dad
	 * @return the dad that was removed
	 * @throws NoSuchDadException if a dad with the primary key could not be found
	 */
	public Dad remove(long dadId) throws NoSuchDadException;

	public Dad updateImpl(Dad dad);

	/**
	 * Returns the dad with the primary key or throws a <code>NoSuchDadException</code> if it could not be found.
	 *
	 * @param dadId the primary key of the dad
	 * @return the dad
	 * @throws NoSuchDadException if a dad with the primary key could not be found
	 */
	public Dad findByPrimaryKey(long dadId) throws NoSuchDadException;

	/**
	 * Returns the dad with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dadId the primary key of the dad
	 * @return the dad, or <code>null</code> if a dad with the primary key could not be found
	 */
	public Dad fetchByPrimaryKey(long dadId);

	/**
	 * Returns all the dads.
	 *
	 * @return the dads
	 */
	public java.util.List<Dad> findAll();

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
	public java.util.List<Dad> findAll(int start, int end);

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
	public java.util.List<Dad> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Dad>
			orderByComparator);

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
	public java.util.List<Dad> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Dad> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the dads from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of dads.
	 *
	 * @return the number of dads
	 */
	public int countAll();

}
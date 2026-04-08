/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package ru.kashtanov.crate.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link CrateLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CrateLocalService
 * @generated
 */
public class CrateLocalServiceWrapper
	implements CrateLocalService, ServiceWrapper<CrateLocalService> {

	public CrateLocalServiceWrapper(CrateLocalService crateLocalService) {
		_crateLocalService = crateLocalService;
	}

	/**
	 * Adds the crate to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CrateLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param crate the crate
	 * @return the crate that was added
	 */
	@Override
	public ru.kashtanov.crate.model.Crate addCrate(
		ru.kashtanov.crate.model.Crate crate) {

		return _crateLocalService.addCrate(crate);
	}

	/**
	 * Creates a new crate with the primary key. Does not add the crate to the database.
	 *
	 * @param crateId the primary key for the new crate
	 * @return the new crate
	 */
	@Override
	public ru.kashtanov.crate.model.Crate createCrate(long crateId) {
		return _crateLocalService.createCrate(crateId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _crateLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the crate from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CrateLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param crate the crate
	 * @return the crate that was removed
	 */
	@Override
	public ru.kashtanov.crate.model.Crate deleteCrate(
		ru.kashtanov.crate.model.Crate crate) {

		return _crateLocalService.deleteCrate(crate);
	}

	/**
	 * Deletes the crate with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CrateLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param crateId the primary key of the crate
	 * @return the crate that was removed
	 * @throws PortalException if a crate with the primary key could not be found
	 */
	@Override
	public ru.kashtanov.crate.model.Crate deleteCrate(long crateId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _crateLocalService.deleteCrate(crateId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _crateLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _crateLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _crateLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ru.kashtanov.crate.model.impl.CrateModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _crateLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ru.kashtanov.crate.model.impl.CrateModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _crateLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _crateLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _crateLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public ru.kashtanov.crate.model.Crate fetchCrate(long crateId) {
		return _crateLocalService.fetchCrate(crateId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _crateLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the crate with the primary key.
	 *
	 * @param crateId the primary key of the crate
	 * @return the crate
	 * @throws PortalException if a crate with the primary key could not be found
	 */
	@Override
	public ru.kashtanov.crate.model.Crate getCrate(long crateId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _crateLocalService.getCrate(crateId);
	}

	/**
	 * Returns a range of all the crates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ru.kashtanov.crate.model.impl.CrateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of crates
	 * @param end the upper bound of the range of crates (not inclusive)
	 * @return the range of crates
	 */
	@Override
	public java.util.List<ru.kashtanov.crate.model.Crate> getCrates(
		int start, int end) {

		return _crateLocalService.getCrates(start, end);
	}

	/**
	 * Returns the number of crates.
	 *
	 * @return the number of crates
	 */
	@Override
	public int getCratesCount() {
		return _crateLocalService.getCratesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _crateLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _crateLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _crateLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the crate in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CrateLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param crate the crate
	 * @return the crate that was updated
	 */
	@Override
	public ru.kashtanov.crate.model.Crate updateCrate(
		ru.kashtanov.crate.model.Crate crate) {

		return _crateLocalService.updateCrate(crate);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _crateLocalService.getBasePersistence();
	}

	@Override
	public CrateLocalService getWrappedService() {
		return _crateLocalService;
	}

	@Override
	public void setWrappedService(CrateLocalService crateLocalService) {
		_crateLocalService = crateLocalService;
	}

	private CrateLocalService _crateLocalService;

}
/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package ru.kashtanov.dad.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link DadLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DadLocalService
 * @generated
 */
public class DadLocalServiceWrapper
	implements DadLocalService, ServiceWrapper<DadLocalService> {

	public DadLocalServiceWrapper(DadLocalService dadLocalService) {
		_dadLocalService = dadLocalService;
	}

	/**
	 * Adds the dad to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DadLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dad the dad
	 * @return the dad that was added
	 */
	@Override
	public ru.kashtanov.dad.model.Dad addDad(ru.kashtanov.dad.model.Dad dad) {
		return _dadLocalService.addDad(dad);
	}

	/**
	 * Creates a new dad with the primary key. Does not add the dad to the database.
	 *
	 * @param dadId the primary key for the new dad
	 * @return the new dad
	 */
	@Override
	public ru.kashtanov.dad.model.Dad createDad(long dadId) {
		return _dadLocalService.createDad(dadId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dadLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the dad from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DadLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dad the dad
	 * @return the dad that was removed
	 */
	@Override
	public ru.kashtanov.dad.model.Dad deleteDad(
		ru.kashtanov.dad.model.Dad dad) {

		return _dadLocalService.deleteDad(dad);
	}

	/**
	 * Deletes the dad with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DadLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dadId the primary key of the dad
	 * @return the dad that was removed
	 * @throws PortalException if a dad with the primary key could not be found
	 */
	@Override
	public ru.kashtanov.dad.model.Dad deleteDad(long dadId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dadLocalService.deleteDad(dadId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dadLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dadLocalService.dynamicQuery();
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

		return _dadLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ru.kashtanov.dad.model.impl.DadModelImpl</code>.
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

		return _dadLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ru.kashtanov.dad.model.impl.DadModelImpl</code>.
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

		return _dadLocalService.dynamicQuery(
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

		return _dadLocalService.dynamicQueryCount(dynamicQuery);
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

		return _dadLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public ru.kashtanov.dad.model.Dad fetchDad(long dadId) {
		return _dadLocalService.fetchDad(dadId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dadLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the dad with the primary key.
	 *
	 * @param dadId the primary key of the dad
	 * @return the dad
	 * @throws PortalException if a dad with the primary key could not be found
	 */
	@Override
	public ru.kashtanov.dad.model.Dad getDad(long dadId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dadLocalService.getDad(dadId);
	}

	/**
	 * Returns a range of all the dads.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ru.kashtanov.dad.model.impl.DadModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dads
	 * @param end the upper bound of the range of dads (not inclusive)
	 * @return the range of dads
	 */
	@Override
	public java.util.List<ru.kashtanov.dad.model.Dad> getDads(
		int start, int end) {

		return _dadLocalService.getDads(start, end);
	}

	/**
	 * Returns the number of dads.
	 *
	 * @return the number of dads
	 */
	@Override
	public int getDadsCount() {
		return _dadLocalService.getDadsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dadLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dadLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dadLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the dad in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DadLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dad the dad
	 * @return the dad that was updated
	 */
	@Override
	public ru.kashtanov.dad.model.Dad updateDad(
		ru.kashtanov.dad.model.Dad dad) {

		return _dadLocalService.updateDad(dad);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _dadLocalService.getBasePersistence();
	}

	@Override
	public DadLocalService getWrappedService() {
		return _dadLocalService;
	}

	@Override
	public void setWrappedService(DadLocalService dadLocalService) {
		_dadLocalService = dadLocalService;
	}

	private DadLocalService _dadLocalService;

}
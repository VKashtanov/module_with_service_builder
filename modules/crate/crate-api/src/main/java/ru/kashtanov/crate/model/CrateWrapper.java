/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package ru.kashtanov.crate.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Crate}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Crate
 * @generated
 */
public class CrateWrapper
	extends BaseModelWrapper<Crate> implements Crate, ModelWrapper<Crate> {

	public CrateWrapper(Crate crate) {
		super(crate);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("crateId", getCrateId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("weight", getWeight());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long crateId = (Long)attributes.get("crateId");

		if (crateId != null) {
			setCrateId(crateId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Double weight = (Double)attributes.get("weight");

		if (weight != null) {
			setWeight(weight);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	/**
	 * Returns the company ID of this crate.
	 *
	 * @return the company ID of this crate
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the crate ID of this crate.
	 *
	 * @return the crate ID of this crate
	 */
	@Override
	public long getCrateId() {
		return model.getCrateId();
	}

	/**
	 * Returns the create date of this crate.
	 *
	 * @return the create date of this crate
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this crate.
	 *
	 * @return the description of this crate
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the group ID of this crate.
	 *
	 * @return the group ID of this crate
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this crate.
	 *
	 * @return the modified date of this crate
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this crate.
	 *
	 * @return the name of this crate
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this crate.
	 *
	 * @return the primary key of this crate
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this crate.
	 *
	 * @return the user ID of this crate
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this crate.
	 *
	 * @return the user name of this crate
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this crate.
	 *
	 * @return the user uuid of this crate
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the weight of this crate.
	 *
	 * @return the weight of this crate
	 */
	@Override
	public double getWeight() {
		return model.getWeight();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this crate.
	 *
	 * @param companyId the company ID of this crate
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the crate ID of this crate.
	 *
	 * @param crateId the crate ID of this crate
	 */
	@Override
	public void setCrateId(long crateId) {
		model.setCrateId(crateId);
	}

	/**
	 * Sets the create date of this crate.
	 *
	 * @param createDate the create date of this crate
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this crate.
	 *
	 * @param description the description of this crate
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the group ID of this crate.
	 *
	 * @param groupId the group ID of this crate
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this crate.
	 *
	 * @param modifiedDate the modified date of this crate
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this crate.
	 *
	 * @param name the name of this crate
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this crate.
	 *
	 * @param primaryKey the primary key of this crate
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this crate.
	 *
	 * @param userId the user ID of this crate
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this crate.
	 *
	 * @param userName the user name of this crate
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this crate.
	 *
	 * @param userUuid the user uuid of this crate
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the weight of this crate.
	 *
	 * @param weight the weight of this crate
	 */
	@Override
	public void setWeight(double weight) {
		model.setWeight(weight);
	}

	@Override
	protected CrateWrapper wrap(Crate crate) {
		return new CrateWrapper(crate);
	}

}
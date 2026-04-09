/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package ru.kashtanov.dad.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import ru.kashtanov.dad.model.Dad;

/**
 * The cache model class for representing Dad in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DadCacheModel implements CacheModel<Dad>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DadCacheModel)) {
			return false;
		}

		DadCacheModel dadCacheModel = (DadCacheModel)object;

		if (dadId == dadCacheModel.dadId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, dadId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{dadId=");
		sb.append(dadId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", name=");
		sb.append(name);
		sb.append(", weight=");
		sb.append(weight);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Dad toEntityModel() {
		DadImpl dadImpl = new DadImpl();

		dadImpl.setDadId(dadId);
		dadImpl.setGroupId(groupId);
		dadImpl.setCompanyId(companyId);
		dadImpl.setUserId(userId);

		if (userName == null) {
			dadImpl.setUserName("");
		}
		else {
			dadImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			dadImpl.setCreateDate(null);
		}
		else {
			dadImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			dadImpl.setModifiedDate(null);
		}
		else {
			dadImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			dadImpl.setName("");
		}
		else {
			dadImpl.setName(name);
		}

		dadImpl.setWeight(weight);

		if (description == null) {
			dadImpl.setDescription("");
		}
		else {
			dadImpl.setDescription(description);
		}

		dadImpl.resetOriginalValues();

		return dadImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		dadId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();

		weight = objectInput.readDouble();
		description = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(dadId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeDouble(weight);

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public long dadId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public double weight;
	public String description;

}
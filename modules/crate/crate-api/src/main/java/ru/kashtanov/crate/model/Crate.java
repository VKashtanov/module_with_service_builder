/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package ru.kashtanov.crate.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Crate service. Represents a row in the &quot;Crate_Crate&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see CrateModel
 * @generated
 */
@ImplementationClassName("ru.kashtanov.crate.model.impl.CrateImpl")
@ProviderType
public interface Crate extends CrateModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>ru.kashtanov.crate.model.impl.CrateImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Crate, Long> CRATE_ID_ACCESSOR =
		new Accessor<Crate, Long>() {

			@Override
			public Long get(Crate crate) {
				return crate.getCrateId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Crate> getTypeClass() {
				return Crate.class;
			}

		};

}
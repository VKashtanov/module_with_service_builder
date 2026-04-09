/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package ru.kashtanov.dad.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Dad service. Represents a row in the &quot;Dad_Dad&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see DadModel
 * @generated
 */
@ImplementationClassName("ru.kashtanov.dad.model.impl.DadImpl")
@ProviderType
public interface Dad extends DadModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>ru.kashtanov.dad.model.impl.DadImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Dad, Long> DAD_ID_ACCESSOR =
		new Accessor<Dad, Long>() {

			@Override
			public Long get(Dad dad) {
				return dad.getDadId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Dad> getTypeClass() {
				return Dad.class;
			}

		};

}
/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package ru.kashtanov.crate.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchCrateException extends NoSuchModelException {

	public NoSuchCrateException() {
	}

	public NoSuchCrateException(String msg) {
		super(msg);
	}

	public NoSuchCrateException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchCrateException(Throwable throwable) {
		super(throwable);
	}

}
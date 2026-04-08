/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package ru.kashtanov.crate.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.AssertUtils;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.kashtanov.crate.exception.NoSuchCrateException;
import ru.kashtanov.crate.model.Crate;
import ru.kashtanov.crate.service.CrateLocalServiceUtil;
import ru.kashtanov.crate.service.persistence.CratePersistence;
import ru.kashtanov.crate.service.persistence.CrateUtil;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class CratePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "ru.kashtanov.crate.service"));

	@Before
	public void setUp() {
		_persistence = CrateUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Crate> iterator = _crates.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Crate crate = _persistence.create(pk);

		Assert.assertNotNull(crate);

		Assert.assertEquals(crate.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Crate newCrate = addCrate();

		_persistence.remove(newCrate);

		Crate existingCrate = _persistence.fetchByPrimaryKey(
			newCrate.getPrimaryKey());

		Assert.assertNull(existingCrate);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addCrate();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Crate newCrate = _persistence.create(pk);

		newCrate.setGroupId(RandomTestUtil.nextLong());

		newCrate.setCompanyId(RandomTestUtil.nextLong());

		newCrate.setUserId(RandomTestUtil.nextLong());

		newCrate.setUserName(RandomTestUtil.randomString());

		newCrate.setCreateDate(RandomTestUtil.nextDate());

		newCrate.setModifiedDate(RandomTestUtil.nextDate());

		newCrate.setName(RandomTestUtil.randomString());

		newCrate.setWeight(RandomTestUtil.nextDouble());

		newCrate.setDescription(RandomTestUtil.randomString());

		_crates.add(_persistence.update(newCrate));

		Crate existingCrate = _persistence.findByPrimaryKey(
			newCrate.getPrimaryKey());

		Assert.assertEquals(existingCrate.getCrateId(), newCrate.getCrateId());
		Assert.assertEquals(existingCrate.getGroupId(), newCrate.getGroupId());
		Assert.assertEquals(
			existingCrate.getCompanyId(), newCrate.getCompanyId());
		Assert.assertEquals(existingCrate.getUserId(), newCrate.getUserId());
		Assert.assertEquals(
			existingCrate.getUserName(), newCrate.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingCrate.getCreateDate()),
			Time.getShortTimestamp(newCrate.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingCrate.getModifiedDate()),
			Time.getShortTimestamp(newCrate.getModifiedDate()));
		Assert.assertEquals(existingCrate.getName(), newCrate.getName());
		AssertUtils.assertEquals(
			existingCrate.getWeight(), newCrate.getWeight());
		Assert.assertEquals(
			existingCrate.getDescription(), newCrate.getDescription());
	}

	@Test
	public void testCountByByName() throws Exception {
		_persistence.countByByName("");

		_persistence.countByByName("null");

		_persistence.countByByName((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Crate newCrate = addCrate();

		Crate existingCrate = _persistence.findByPrimaryKey(
			newCrate.getPrimaryKey());

		Assert.assertEquals(existingCrate, newCrate);
	}

	@Test(expected = NoSuchCrateException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Crate> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"Crate_Crate", "crateId", true, "groupId", true, "companyId", true,
			"userId", true, "userName", true, "createDate", true,
			"modifiedDate", true, "name", true, "weight", true, "description",
			true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Crate newCrate = addCrate();

		Crate existingCrate = _persistence.fetchByPrimaryKey(
			newCrate.getPrimaryKey());

		Assert.assertEquals(existingCrate, newCrate);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Crate missingCrate = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingCrate);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Crate newCrate1 = addCrate();
		Crate newCrate2 = addCrate();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCrate1.getPrimaryKey());
		primaryKeys.add(newCrate2.getPrimaryKey());

		Map<Serializable, Crate> crates = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, crates.size());
		Assert.assertEquals(newCrate1, crates.get(newCrate1.getPrimaryKey()));
		Assert.assertEquals(newCrate2, crates.get(newCrate2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Crate> crates = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(crates.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Crate newCrate = addCrate();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCrate.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Crate> crates = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, crates.size());
		Assert.assertEquals(newCrate, crates.get(newCrate.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Crate> crates = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(crates.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Crate newCrate = addCrate();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCrate.getPrimaryKey());

		Map<Serializable, Crate> crates = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, crates.size());
		Assert.assertEquals(newCrate, crates.get(newCrate.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			CrateLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Crate>() {

				@Override
				public void performAction(Crate crate) {
					Assert.assertNotNull(crate);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Crate newCrate = addCrate();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Crate.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("crateId", newCrate.getCrateId()));

		List<Crate> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Crate existingCrate = result.get(0);

		Assert.assertEquals(existingCrate, newCrate);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Crate.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("crateId", RandomTestUtil.nextLong()));

		List<Crate> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Crate newCrate = addCrate();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Crate.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("crateId"));

		Object newCrateId = newCrate.getCrateId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("crateId", new Object[] {newCrateId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingCrateId = result.get(0);

		Assert.assertEquals(existingCrateId, newCrateId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Crate.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("crateId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"crateId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Crate addCrate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Crate crate = _persistence.create(pk);

		crate.setGroupId(RandomTestUtil.nextLong());

		crate.setCompanyId(RandomTestUtil.nextLong());

		crate.setUserId(RandomTestUtil.nextLong());

		crate.setUserName(RandomTestUtil.randomString());

		crate.setCreateDate(RandomTestUtil.nextDate());

		crate.setModifiedDate(RandomTestUtil.nextDate());

		crate.setName(RandomTestUtil.randomString());

		crate.setWeight(RandomTestUtil.nextDouble());

		crate.setDescription(RandomTestUtil.randomString());

		_crates.add(_persistence.update(crate));

		return crate;
	}

	private List<Crate> _crates = new ArrayList<Crate>();
	private CratePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}
/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package ru.kashtanov.dad.service.persistence.test;

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

import ru.kashtanov.dad.exception.NoSuchDadException;
import ru.kashtanov.dad.model.Dad;
import ru.kashtanov.dad.service.DadLocalServiceUtil;
import ru.kashtanov.dad.service.persistence.DadPersistence;
import ru.kashtanov.dad.service.persistence.DadUtil;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class DadPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "ru.kashtanov.dad.service"));

	@Before
	public void setUp() {
		_persistence = DadUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Dad> iterator = _dads.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Dad dad = _persistence.create(pk);

		Assert.assertNotNull(dad);

		Assert.assertEquals(dad.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Dad newDad = addDad();

		_persistence.remove(newDad);

		Dad existingDad = _persistence.fetchByPrimaryKey(
			newDad.getPrimaryKey());

		Assert.assertNull(existingDad);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addDad();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Dad newDad = _persistence.create(pk);

		newDad.setGroupId(RandomTestUtil.nextLong());

		newDad.setCompanyId(RandomTestUtil.nextLong());

		newDad.setUserId(RandomTestUtil.nextLong());

		newDad.setUserName(RandomTestUtil.randomString());

		newDad.setCreateDate(RandomTestUtil.nextDate());

		newDad.setModifiedDate(RandomTestUtil.nextDate());

		newDad.setName(RandomTestUtil.randomString());

		newDad.setWeight(RandomTestUtil.nextDouble());

		newDad.setDescription(RandomTestUtil.randomString());

		_dads.add(_persistence.update(newDad));

		Dad existingDad = _persistence.findByPrimaryKey(newDad.getPrimaryKey());

		Assert.assertEquals(existingDad.getDadId(), newDad.getDadId());
		Assert.assertEquals(existingDad.getGroupId(), newDad.getGroupId());
		Assert.assertEquals(existingDad.getCompanyId(), newDad.getCompanyId());
		Assert.assertEquals(existingDad.getUserId(), newDad.getUserId());
		Assert.assertEquals(existingDad.getUserName(), newDad.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingDad.getCreateDate()),
			Time.getShortTimestamp(newDad.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingDad.getModifiedDate()),
			Time.getShortTimestamp(newDad.getModifiedDate()));
		Assert.assertEquals(existingDad.getName(), newDad.getName());
		AssertUtils.assertEquals(existingDad.getWeight(), newDad.getWeight());
		Assert.assertEquals(
			existingDad.getDescription(), newDad.getDescription());
	}

	@Test
	public void testCountByByName() throws Exception {
		_persistence.countByByName("");

		_persistence.countByByName("null");

		_persistence.countByByName((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Dad newDad = addDad();

		Dad existingDad = _persistence.findByPrimaryKey(newDad.getPrimaryKey());

		Assert.assertEquals(existingDad, newDad);
	}

	@Test(expected = NoSuchDadException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Dad> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"Dad_Dad", "dadId", true, "groupId", true, "companyId", true,
			"userId", true, "userName", true, "createDate", true,
			"modifiedDate", true, "name", true, "weight", true, "description",
			true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Dad newDad = addDad();

		Dad existingDad = _persistence.fetchByPrimaryKey(
			newDad.getPrimaryKey());

		Assert.assertEquals(existingDad, newDad);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Dad missingDad = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingDad);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Dad newDad1 = addDad();
		Dad newDad2 = addDad();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDad1.getPrimaryKey());
		primaryKeys.add(newDad2.getPrimaryKey());

		Map<Serializable, Dad> dads = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, dads.size());
		Assert.assertEquals(newDad1, dads.get(newDad1.getPrimaryKey()));
		Assert.assertEquals(newDad2, dads.get(newDad2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Dad> dads = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(dads.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Dad newDad = addDad();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDad.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Dad> dads = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, dads.size());
		Assert.assertEquals(newDad, dads.get(newDad.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Dad> dads = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(dads.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Dad newDad = addDad();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDad.getPrimaryKey());

		Map<Serializable, Dad> dads = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, dads.size());
		Assert.assertEquals(newDad, dads.get(newDad.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			DadLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Dad>() {

				@Override
				public void performAction(Dad dad) {
					Assert.assertNotNull(dad);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Dad newDad = addDad();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Dad.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("dadId", newDad.getDadId()));

		List<Dad> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Dad existingDad = result.get(0);

		Assert.assertEquals(existingDad, newDad);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Dad.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("dadId", RandomTestUtil.nextLong()));

		List<Dad> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Dad newDad = addDad();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Dad.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("dadId"));

		Object newDadId = newDad.getDadId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("dadId", new Object[] {newDadId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingDadId = result.get(0);

		Assert.assertEquals(existingDadId, newDadId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Dad.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("dadId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"dadId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Dad addDad() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Dad dad = _persistence.create(pk);

		dad.setGroupId(RandomTestUtil.nextLong());

		dad.setCompanyId(RandomTestUtil.nextLong());

		dad.setUserId(RandomTestUtil.nextLong());

		dad.setUserName(RandomTestUtil.randomString());

		dad.setCreateDate(RandomTestUtil.nextDate());

		dad.setModifiedDate(RandomTestUtil.nextDate());

		dad.setName(RandomTestUtil.randomString());

		dad.setWeight(RandomTestUtil.nextDouble());

		dad.setDescription(RandomTestUtil.randomString());

		_dads.add(_persistence.update(dad));

		return dad;
	}

	private List<Dad> _dads = new ArrayList<Dad>();
	private DadPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}
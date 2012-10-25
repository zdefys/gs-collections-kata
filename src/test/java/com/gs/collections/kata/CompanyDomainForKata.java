/*
 * Copyright 2012 Goldman Sachs.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.gs.collections.kata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.functions.Mapper;

import org.junit.Before;

public abstract class CompanyDomainForKata
{
    protected final Company company = new Company("Bloggs Shed Supplies");

    @Before
    public void setUp()
    {
        Order.resetNextOrderNumber();
        this.setUpCustomersAndOrders();
        this.setUpSuppliers();
    }

    private void setUpSuppliers()
    {
        this.company.addSupplier(new Supplier("Shedtastic", new String[]{"shed", "big shed", "huge shed"}));
        this.company.addSupplier(new Supplier("Splendid Crocks", new String[]{"cup", "saucer", "bowl"}));
        this.company.addSupplier(new Supplier("Annoying Pets", new String[]{"dog", "cat", "goldfish"}));
        this.company.addSupplier(new Supplier("Gnomes 'R' Us", new String[]{"gnome"}));
        this.company.addSupplier(new Supplier("Furniture Hamlet", new String[]{"table", "sofa", "chair"}));
        this.company.addSupplier(new Supplier("SFD", new String[]{"sofa", "chair"}));
        this.company.addSupplier(new Supplier("Doxins", new String[]{"kettle", "plasma screen", "sandwich toaster"}));
    }

    private void setUpCustomersAndOrders()
    {
        Order fredOrder = new Order();
        fredOrder.addLineItem(new LineItem("Shed", 50.0));

        /**
         * TODO 8: Refactor Order and its API so this repetition is not necessary.
         */
        // TODO 8: Add 3 cups at 1.5 each to the order
        fredOrder.addLineItems(new LineItem("cup", 1.5), 3);

        // TODO 8: Add 3 saucers at 1.0 each to the order
        fredOrder.addLineItems(new LineItem("saucer", 1.0), 3);

        fredOrder.addLineItem(new LineItem("chair", 12.50));
        fredOrder.addLineItem(new LineItem("table", 1.0));

        Customer fred = new Customer("Fred", "London");
        fred.addOrder(fredOrder);
        this.company.addCustomer(fred);

        Order maryOrder = new Order();
        maryOrder.addLineItem(new LineItem("cat", 150.0));
        maryOrder.addLineItem(new LineItem("big shed", 500.0));

        // TODO 8: Add 4 cups at 1.50 each to the order
        maryOrder.addLineItems(new LineItem("cup", 1.5), 4);

        // TODO 8: Add 4 saucers at 1.50 each to the order
        maryOrder.addLineItems(new LineItem("saucer", 1.5), 4);

        maryOrder.addLineItem(new LineItem("sofa", 120.0));
        maryOrder.addLineItem(new LineItem("dog", 75.0));

        Customer mary = new Customer("Mary", "Liphook");
        mary.addOrder(maryOrder);
        this.company.addCustomer(mary);

        Order billOrder1 = new Order();
        billOrder1.addLineItem(new LineItem("shed", 50.0));
        billOrder1.addLineItems(new LineItem("gnome", 7.50), 43);

        Order billOrder2 = new Order();
        billOrder2.addLineItem(new LineItem("bowl", 1.25));
        billOrder2.addLineItem(new LineItem("goldfish", 0.50));

        Order billOrder3 = new Order();
        billOrder3.addLineItem(new LineItem("table", 1.0));

        Customer bill = new Customer("Bill", "London");
        bill.addOrder(billOrder1);
        bill.addOrder(billOrder2);
        bill.addOrder(billOrder3);

        this.company.addCustomer(bill);
    }
}

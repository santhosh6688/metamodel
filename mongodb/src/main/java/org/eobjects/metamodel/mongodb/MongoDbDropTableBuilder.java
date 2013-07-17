/**
 * eobjects.org MetaModel
 * Copyright (C) 2010 eobjects.org
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 * Boston, MA  02110-1301  USA
 */
package org.eobjects.metamodel.mongodb;

import org.eobjects.metamodel.MetaModelException;
import org.eobjects.metamodel.drop.AbstractTableDropBuilder;
import org.eobjects.metamodel.schema.MutableSchema;
import org.eobjects.metamodel.schema.Table;

final class MongoDbDropTableBuilder extends AbstractTableDropBuilder {

    private final MongoDbUpdateCallback _updateCallback;

    public MongoDbDropTableBuilder(MongoDbUpdateCallback updateCallback, Table table) {
        super(table);
        _updateCallback = updateCallback;
    }

    @Override
    public void execute() throws MetaModelException {
        Table table = getTable();
        _updateCallback.removeCollection(table.getName());
        MutableSchema schema = (MutableSchema) table.getSchema();
        schema.removeTable(table);
    }

}
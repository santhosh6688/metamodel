/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.metamodel.couchdb;

import org.apache.metamodel.data.Document;
import org.apache.metamodel.schema.builder.ColumnNameAsKeysRowConverter;
import org.ektorp.ViewResult.Row;

final class CouchDbDocumentConverter extends ColumnNameAsKeysRowConverter {

    @Override
    protected Object get(Document document, String columnName) {
        if (CouchDbDataContext.FIELD_ID.equals(columnName)) {
            Row row = (Row) document.getSourceObject();
            return row.getId();
        }
        // TODO Auto-generated method stub
        return super.get(document, columnName);
    }
}
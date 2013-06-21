package de.lmu.ifi.dbs.elki.visualization.parallel3d.layout;

/*
 This file is part of ELKI:
 Environment for Developing KDD-Applications Supported by Index-Structures

 Copyright (C) 2013
 Ludwig-Maximilians-Universität München
 Lehr- und Forschungseinheit für Datenbanksysteme
 ELKI Development Team

 This program is free software: you can redistribute it and/or modify
 it under the terms of the GNU Affero General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU Affero General Public License for more details.

 You should have received a copy of the GNU Affero General Public License
 along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */


import de.lmu.ifi.dbs.elki.database.Database;
import de.lmu.ifi.dbs.elki.database.relation.Relation;
import de.lmu.ifi.dbs.elki.utilities.optionhandling.Parameterizable;

/**
 * Arrange parallel coordinates on a 2D plane, for 3D parallel coordinates.
 * 
 * @author Erich Schubert
 * 
 * @param <V> Object type
 */
public interface Layouter3DPC<V> extends Parameterizable {
  /**
   * Run the layouting algorithm.
   * 
   * @param database Database to use
   * @param rel Relation to use
   * 
   * @return Layout, nodes indexed by dimension.
   */
  Layout layout(Database database, Relation<? extends V> rel);
}
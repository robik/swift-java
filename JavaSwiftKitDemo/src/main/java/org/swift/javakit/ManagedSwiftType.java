//===----------------------------------------------------------------------===//
//
// This source file is part of the Swift.org open source project
//
// Copyright (c) 2024 Apple Inc. and the Swift.org project authors
// Licensed under Apache License v2.0
//
// See LICENSE.txt for license information
//
// SPDX-License-Identifier: Apache-2.0
//
//===----------------------------------------------------------------------===//

package org.swift.javakit;

import java.lang.foreign.MemorySegment;

public interface ManagedSwiftType {
    /**
     * The memory segment of `self` of the managed Swift object/value.
     * @return
     */
    public MemorySegment $memorySegment();

}

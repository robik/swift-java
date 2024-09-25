// Generated by jextract-swift
// Swift module: JavaKitExample

package com.example.swift.generated;

import org.swift.javakit.SwiftKit;
import java.lang.foreign.*;
import java.lang.invoke.*;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.nio.charset.StandardCharsets;

  public final class JavaKitExample {
      private JavaKitExample() {
    // Should not be called directly
  }

      static final String DYLIB_NAME = "JavaKitExample";
  static final Arena LIBRARY_ARENA = Arena.ofAuto();

      // TODO: rather than the C ones offer the Swift mappings
  public static final ValueLayout.OfBoolean C_BOOL = ValueLayout.JAVA_BOOLEAN;
  public static final ValueLayout.OfByte C_CHAR = ValueLayout.JAVA_BYTE;
  public static final ValueLayout.OfShort C_SHORT = ValueLayout.JAVA_SHORT;
  public static final ValueLayout.OfInt C_INT = ValueLayout.JAVA_INT;
  public static final ValueLayout.OfLong C_LONG_LONG = ValueLayout.JAVA_LONG;
  public static final ValueLayout.OfFloat C_FLOAT = ValueLayout.JAVA_FLOAT;
  public static final ValueLayout.OfDouble C_DOUBLE = ValueLayout.JAVA_DOUBLE;
  public static final AddressLayout C_POINTER = ValueLayout.ADDRESS
          .withTargetLayout(MemoryLayout.sequenceLayout(java.lang.Long.MAX_VALUE, ValueLayout.JAVA_BYTE));
  public static final ValueLayout.OfLong C_LONG = ValueLayout.JAVA_LONG;

    
      public static final ValueLayout.OfBoolean SWIFT_BOOL = ValueLayout.JAVA_BOOLEAN;
  public static final ValueLayout.OfByte SWIFT_INT8 = ValueLayout.JAVA_BYTE;
  public static final ValueLayout.OfChar SWIFT_UINT16 = ValueLayout.JAVA_CHAR;
  public static final ValueLayout.OfShort SWIFT_INT16 = ValueLayout.JAVA_SHORT;
  public static final ValueLayout.OfInt SWIFT_INT32 = ValueLayout.JAVA_INT;
  public static final ValueLayout.OfLong SWIFT_INT64 = ValueLayout.JAVA_LONG;
  public static final ValueLayout.OfFloat SWIFT_FLOAT = ValueLayout.JAVA_FLOAT;
  public static final ValueLayout.OfDouble SWIFT_DOUBLE = ValueLayout.JAVA_DOUBLE;
  public static final AddressLayout SWIFT_POINTER = ValueLayout.ADDRESS;
  // On the platform this was generated on, Int was Int64
  public static final SequenceLayout SWIFT_BYTE_ARRAY = MemoryLayout.sequenceLayout(8, ValueLayout.JAVA_BYTE);
  public static final ValueLayout.OfLong SWIFT_INT = SWIFT_INT64;
  public static final ValueLayout.OfLong SWIFT_UINT = SWIFT_INT64;
  public static final AddressLayout SWIFT_SELF = SWIFT_POINTER;
  public static final AddressLayout SWIFT_TYPE_METADATA_PTR = SWIFT_POINTER;

      static final boolean TRACE_DOWNCALLS = Boolean.getBoolean("jextract.trace.downcalls");
  static void traceDowncall(Object... args) {
      var ex = new RuntimeException();
      String traceArgs = Arrays.stream(args)
              .map(Object::toString)
              .collect(Collectors.joining(", "));
      System.out.printf("[java][%s:%d] Downcall: %s(%s)\n",
              ex.getStackTrace()[1].getFileName(),
              ex.getStackTrace()[1].getLineNumber(),
              ex.getStackTrace()[1].getMethodName(),
              traceArgs);
  }
  static void trace(Object... args) {
      var ex = new RuntimeException();
      String traceArgs = Arrays.stream(args)
              .map(Object::toString)
              .collect(Collectors.joining(", "));
      System.out.printf("[java][%s:%d] %s: %s\n",
              ex.getStackTrace()[1].getFileName(),
              ex.getStackTrace()[1].getLineNumber(),
              ex.getStackTrace()[1].getMethodName(),
              traceArgs);
  }

      static MemorySegment findOrThrow(String symbol) {
      return SYMBOL_LOOKUP.find(symbol)
              .orElseThrow(() -> new UnsatisfiedLinkError("unresolved symbol: %s".formatted(symbol)));
  }

      static MethodHandle upcallHandle(Class<?> fi, String name, FunctionDescriptor fdesc) {
      try {
          return MethodHandles.lookup().findVirtual(fi, name, fdesc.toMethodType());
      } catch (ReflectiveOperationException ex) {
          throw new AssertionError(ex);
      }
  }

      static MemoryLayout align(MemoryLayout layout, long align) {
      return switch (layout) {
          case PaddingLayout p -> p;
          case ValueLayout v -> v.withByteAlignment(align);
          case GroupLayout g -> {
              MemoryLayout[] alignedMembers = g.memberLayouts().stream()
                      .map(m -> align(m, align)).toArray(MemoryLayout[]::new);
              yield g instanceof StructLayout ?
                      MemoryLayout.structLayout(alignedMembers) : MemoryLayout.unionLayout(alignedMembers);
          }
          case SequenceLayout s -> MemoryLayout.sequenceLayout(s.elementCount(), align(s.elementLayout(), align));
      };
  }

      static final SymbolLookup SYMBOL_LOOKUP =
          SymbolLookup.libraryLookup(System.mapLibraryName(DYLIB_NAME), LIBRARY_ARENA)
                  .or(SymbolLookup.loaderLookup())
                  .or(Linker.nativeLinker().defaultLookup());

      // ==== --------------------------------------------------
  // helloWorld

      private static class helloWorld {
        public static final FunctionDescriptor DESC =     FunctionDescriptor.ofVoid(
        );
            /**
     * Demangled representation:
     * {@snippet lang = Swift:
     * JavaKitExample.helloWorld() -> ()
     * }
     */
    public static final MemorySegment ADDR = JavaKitExample.findOrThrow("$s14JavaKitExample10helloWorldyyF");

        public static final MethodHandle HANDLE = Linker.nativeLinker().downcallHandle(ADDR, DESC);
      } // printDowncallMethods(_:_:) @ JExtractSwift/Swift2JavaTranslator+Printing.swift:444
      /**
   * Function descriptor for:
   * {@snippet lang=swift :
   * public func helloWorld()
   * }
   */
  public static FunctionDescriptor helloWorld$descriptor() {
      return helloWorld.DESC;
  }

      /**
   * Downcall method handle for:
   * {@snippet lang=swift :
   * public func helloWorld()
   * }
   */
  public static MethodHandle helloWorld$handle() {
      return helloWorld.HANDLE;
  }

      /**
   * Address for:
   * {@snippet lang=swift :
   * public func helloWorld()
   * }
   */
  public static MemorySegment helloWorld$address() {
      return helloWorld.ADDR;
  }

      /**
   * {@snippet lang=swift :
   * public func helloWorld()
   * }
   */
  public static void helloWorld() {
    var mh$ = helloWorld.HANDLE;
    try {
      if (TRACE_DOWNCALLS) {
         traceDowncall();
      }
       mh$.invokeExact();
    } catch (Throwable ex$) {
      throw new AssertionError("should not reach here", ex$);
    }
  }

      // ==== --------------------------------------------------
  // globalTakeInt

      private static class globalTakeInt {
        public static final FunctionDescriptor DESC =     FunctionDescriptor.ofVoid(
          SWIFT_INT
          );
            /**
     * Demangled representation:
     * {@snippet lang = Swift:
     * JavaKitExample.globalTakeInt(i: Swift.Int) -> ()
     * }
     */
    public static final MemorySegment ADDR = JavaKitExample.findOrThrow("$s14JavaKitExample13globalTakeInt1iySi_tF");

        public static final MethodHandle HANDLE = Linker.nativeLinker().downcallHandle(ADDR, DESC);
      } // printDowncallMethods(_:_:) @ JExtractSwift/Swift2JavaTranslator+Printing.swift:444
      /**
   * Function descriptor for:
   * {@snippet lang=swift :
   * public func globalTakeInt(i: Swift.Int)
   * }
   */
  public static FunctionDescriptor globalTakeInt$descriptor() {
      return globalTakeInt.DESC;
  }

      /**
   * Downcall method handle for:
   * {@snippet lang=swift :
   * public func globalTakeInt(i: Swift.Int)
   * }
   */
  public static MethodHandle globalTakeInt$handle() {
      return globalTakeInt.HANDLE;
  }

      /**
   * Address for:
   * {@snippet lang=swift :
   * public func globalTakeInt(i: Swift.Int)
   * }
   */
  public static MemorySegment globalTakeInt$address() {
      return globalTakeInt.ADDR;
  }

      /**
   * {@snippet lang=swift :
   * public func globalTakeInt(i: Swift.Int)
   * }
   */
  public static void globalTakeInt(long i) {
    var mh$ = globalTakeInt.HANDLE;
    try {
      if (TRACE_DOWNCALLS) {
         traceDowncall(i);
      }
       mh$.invokeExact(i);
    } catch (Throwable ex$) {
      throw new AssertionError("should not reach here", ex$);
    }
  }

  } // printModuleClass(_:body:) @ JExtractSwift/Swift2JavaTranslator+Printing.swift:192

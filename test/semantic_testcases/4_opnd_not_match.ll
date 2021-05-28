target datalayout = "e-m:e-p270:32:32-p271:32:32-p272:64:64-i64:64-f80:128-n8:16:32:64-S128"
target triple = "x86_64-pc-linux-gnu"

define i32 @main() #0 {
  %1 = alloca i32
  store i32 2, i32* %1
  %2 = alloca double
  store double, double* %2
  %3 = alloca i32
  %4 = load i32, i32* %1
  %5 = load double, double* %2
  %6 = shl i32 %4, %5
  store i32 %6, i32* %3
  ret i32 0
}

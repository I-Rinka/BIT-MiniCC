target datalayout = "e-m:e-p270:32:32-p271:32:32-p272:64:64-i64:64-f80:128-n8:16:32:64-S128"
target triple = "x86_64-pc-linux-gnu"

define i32 @main() #0 {
  %1 = alloca i32
  %2 = alloca i32
  %3 = alloca i32
  store i32 0, i32* %1
  store i32 1, i32* %2
  store i32 2, i32* %3
  %4 = load i32, i32* %1
  %5 = load i32, i32* %2
  %6 = add i32 %4, %5
  %7 = load i32, i32* %3
  %8 = add i32 %7, 3
  %9 = add i32 %6, %8
  store i32 %9, i32* %3
  ret i32 0
}

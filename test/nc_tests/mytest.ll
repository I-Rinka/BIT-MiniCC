target datalayout = "e-m:e-p270:32:32-p271:32:32-p272:64:64-i64:64-f80:128-n8:16:32:64-S128"
target triple = "x86_64-pc-linux-gnu"

define i32 @main() #0 {
  %1 = alloca i32
  %2 = alloca i32
  %3 = alloca [10 x [30 x [20 x i32]]]
  %4 = alloca [7 x [5 x [3 x i32]]]
  %5 = getelementptr [10 x [30 x [20 x i32]]], [10 x [30 x [20 x i32]]]* %3, i32 0, i32 20
  %6 = getelementptr [30 x [20 x i32]], [30 x [20 x i32]]* %5, i32 0, i32 30
  %7 = getelementptr [20 x i32], [20 x i32]* %6, i32 0, i32 10
  %8 = getelementptr [7 x [5 x [3 x i32]]], [7 x [5 x [3 x i32]]]* %4, i32 0, i32 10
  %9 = load i32, i32* %1
  %10 = add i32 %9, 1
  %11 = getelementptr [5 x [3 x i32]], [5 x [3 x i32]]* %8, i32 0, i32 %10
  %12 = getelementptr [3 x i32], [3 x i32]* %11, i32 0, i32 1
  store i32 %12, i32* %7
  ret i32 0
}

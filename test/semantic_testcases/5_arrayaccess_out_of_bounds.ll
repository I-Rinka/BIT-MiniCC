target datalayout = "e-m:e-p270:32:32-p271:32:32-p272:64:64-i64:64-f80:128-n8:16:32:64-S128"
target triple = "x86_64-pc-linux-gnu"

define i32 @main() #0 {
  %1 = alloca [5 x [3 x i32]]
  %2 = alloca i32
  %3 = i32* getelementptr inbounds ([5 x [3 x i32]], [5 x [3 x i32]]* %1, i64 0, i64 [5, 0], i64 [5, 0]) null
  store i32 %3, i32* %2
  %4 = i32* getelementptr inbounds ([5 x [3 x i32]], [5 x [3 x i32]]* %1, i64 0, i64 [0]) null
  store null %4, null* %2
  ret i32 0
}

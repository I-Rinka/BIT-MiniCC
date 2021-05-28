target datalayout = "e-m:e-p270:32:32-p271:32:32-p272:64:64-i64:64-f80:128-n8:16:32:64-S128"
target triple = "x86_64-pc-linux-gnu"

define i32 @main() #0 {
  %1 = alloca [5 x [3 x i32]]
  %2 = alloca i32
  store i32 none, i32* %2
  store null none, null* %2
  ret i32 0
}

target datalayout = "e-m:e-p270:32:32-p271:32:32-p272:64:64-i64:64-f80:128-n8:16:32:64-S128"
target triple = "x86_64-pc-linux-gnu"

define i32 @main() #0 {
  %1 = alloca i32
  %2 = alloca i32
  %3 = load i32, i32* 2
  store i32 %3, i32* %1
  %4 = alloca i32
  %5 = add i32 0, 0
  %6 = add i32 %5, 1
  store i32 %6, i32* %4
  ret i32 0
}
define i32 @f() #0 {
  ret i32 1
}

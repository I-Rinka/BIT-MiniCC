target datalayout = "e-m:e-p270:32:32-p271:32:32-p272:64:64-i64:64-f80:128-n8:16:32:64-S128"
target triple = "x86_64-pc-linux-gnu"

define i32 @f(i32 %0, i32 %1) #0 {
  %3 = alloca i32
  store i32 %0, i32* %3
  %4 = alloca i32
  store i32 %1, i32* %4
  %5 = load i32, i32* %3
  %6 = load i32, i32* %4
  %7 = add i32 %5, %6
  ret i32 %7
}
define i32 @main() #0 {
  %1 = alloca i32
  %2 = call i32 (unknownType, unknownType)@f(nulli32 1)
  store i32 %2, i32* %1
  %3 = call i32 (unknownType, unknownType)@f(nulli32 1, null)
  store i32 %3, i32* %1
  ret i32 0
}

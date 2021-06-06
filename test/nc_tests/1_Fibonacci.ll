target datalayout = "e-m:e-p270:32:32-p271:32:32-p272:64:64-i64:64-f80:128-n8:16:32:64-S128"
target triple = "x86_64-pc-linux-gnu"

define i32 @fibonacci(i32 %0) #0 {
  %1 = alloca i32
  store i32 %0, i32* %1
  %3 = alloca i32
  %4 = load i32, i32* %1
  %5 = icmp slt i32 %4, 1
  br il %5, label %6, label %7
  6:
  store i32 0, i32* %3
  br label %14
  7:
  %8 = load i32, i32* %1
  %9 = icmp sle i32 %8, 2
  br il %9, label %10, label %11
  10:
  store i32 1, i32* %3
  br label %13
  11:
  %12 = add null none, none
  store null %12, null* %3
  br label %13
  13:
  br label %14
  14:
  %15 = load i32, i32* %3
  ret i32 %15
}
define i32 @main() #0 {
  %1 = alloca i32
  store i32 none, i32* %1
  %2 = alloca i32
  store i32 none, i32* %2
  ret i32 0
}

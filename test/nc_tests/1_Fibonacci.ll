target datalayout = "e-m:e-p270:32:32-p271:32:32-p272:64:64-i64:64-f80:128-n8:16:32:64-S128"
target triple = "x86_64-pc-linux-gnu"

define i32 @fibonacci(i32 %1) #0 {
  %0 = alloca i32
  store i32 %0, i32* %0
  %3 = alloca i32
  %4 = load i32, i32* %0
  %5 = icmp slt i32 %4, 1
  br il %5, label %6, label %7
  6:
  store i32 0, i32* %3
  br label %20
  7:
  %8 = load i32, i32* %0
  %9 = icmp sle i32 %8, 2
  br il %9, label %10, label %11
  10:
  store i32 1, i32* %3
  br label %19
  11:
  %12 = load i32, i32* %0
  %13 = sub i32 %12, 1
  %14 = call i32 @fibonacci(i32 %13)
  %15 = load i32, i32* %0
  %16 = sub i32 %15, 2
  %17 = call i32 @fibonacci(i32 %16)
  %18 = add i32 %14, %17
  store i32 %18, i32* %3
  br label %19
  19:
  br label %20
  20:
  %21 = load i32, i32* %3
  ret i32 %21
}
define i32 @main() #0 {
  call void @Mars_PrintStr(i8* i8* getelementptr([26 x i8], [26 x i8]*@.str.0, i32 0, i32 0))
  %1 = alloca i32
  %2 = call i32 @Mars_GetInt()
  store i32 %2, i32* %1
  %3 = alloca i32
  %4 = load i32, i32* %1
  %5 = call i32 @fibonacci(i32 %4)
  store i32 %5, i32* %3
  call void @Mars_PrintStr(i8* i8* getelementptr([38 x i8], [38 x i8]*@.str.1, i32 0, i32 0))
  %6 = load i32, i32* %3
  call void @Mars_PrintInt(i32 %6)
  ret i32 0
}

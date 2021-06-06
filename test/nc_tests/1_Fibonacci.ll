target datalayout = "e-m:e-p270:32:32-p271:32:32-p272:64:64-i64:64-f80:128-n8:16:32:64-S128"
target triple = "x86_64-pc-linux-gnu"

define i32 @fibonacci(i32 %0) #0 {
  %2 = alloca i32
  store i32 %0, i32* %2
  %3 = alloca i32
  %4 = load i32, i32* %2
  %5 = icmp slt i32 %4, 1
  br i1 %5, label %6, label %7
  6:
  store i32 0, i32* %3
  br label %20
  7:
  %8 = load i32, i32* %2
  %9 = icmp sle i32 %8, 2
  br i1 %9, label %10, label %11
  10:
  store i32 1, i32* %3
  br label %19
  11:
  %12 = load i32, i32* %2
  %13 = sub i32 %12, 1
  %14 = call i32 @fibonacci(i32 %13)
  %15 = load i32, i32* %2
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
  %1 = getelementptr [26 x i8], [26 x i8]* @.str.0, i32 0, i32 0
  call void @Mars_PrintStr(i8* %1)
  %2 = alloca i32
  %3 = call i32 @Mars_GetInt()
  store i32 %3, i32* %2
  %4 = alloca i32
  %5 = load i32, i32* %2
  %6 = call i32 @fibonacci(i32 %5)
  store i32 %6, i32* %4
  %7 = getelementptr [38 x i8], [38 x i8]* @.str.1, i32 0, i32 0
  call void @Mars_PrintStr(i8* %7)
  %8 = load i32, i32* %4
  call void @Mars_PrintInt(i32 %8)
  ret i32 0
}

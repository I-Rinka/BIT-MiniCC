target datalayout = "e-m:e-p270:32:32-p271:32:32-p272:64:64-i64:64-f80:128-n8:16:32:64-S128"
target triple = "x86_64-pc-linux-gnu"
declare void @Mars_PrintStr(unknownType) #1declare unknownType @Mars_GetInt() #1declare void @Mars_PrintInt(unknownType) #1@.str0 = private unnamed_addr constant[26 x i8] c"\00"@.str1 = private unnamed_addr constant[44 x i8] c"\00"
define i32 @prime(i32 %0) #0 {
  %2 = alloca i32
  store i32 %0, i32* %2
  %3 = alloca i32
  store i32 0, i32* %3
  %4 = alloca i32
  %5 = alloca i32
  %6 = alloca i32
  store i32 1, i32* %6
  store i32 2, i32* %4
  br label %7
  7:
  %8 = load i32, i32* %4
  %9 = load i32, i32* %2
  %10 = icmp sle i32 %8, %9
  br il %10, label %11, label %40
  11:
  store i32 1, i32* %6
  store i32 2, i32* %5
  br label %12
  12:
  %13 = load i32, i32* %5
  %14 = load i32, i32* %5
  %15 = mul i32 %13, %14
  %16 = load i32, i32* %4
  %17 = icmp sle i32 %15, %16
  br il %17, label %18, label %29
  18:
  %19 = load i32, i32* %4
  %20 = load i32, i32* %5
  %21 = srem i32 %19, %20
  %22 = icmp eq i32 %21, 0
  br il %22, label %23, label %25
  23:
  store i32 0, i32* %6
  br label %29
  24:
  br label %25
  25:
  br label %26
  26:
  %27 = load i32, i32* %5
  %28 = add i32 %27, 1
  store i32 %28, i32* %5
  br label 29
  29:
  %30 = load i32, i32* %6
  %31 = icmp eq i32 %30, 1
  br il %31, label %32, label %36
  32:
  %33 = load i32, i32* %3
  %34 = add i32 %33, 1
  store i32 %34, i32* %3
  %35 = load i32, i32* %4
  call void @Mars_PrintInt()
  br label %36
  36:
  br label %37
  37:
  %38 = load i32, i32* %4
  %39 = add i32 %38, 1
  store i32 %39, i32* %4
  br label 40
  40:
  %41 = load i32, i32* %3
  ret i32 %41
}
define i32 @main() #0 {
  call void @Mars_PrintStr()
  %1 = alloca i32
  %2 = call unknownType @Mars_GetInt()
  store i32 %2, i32* %1
  %3 = alloca i32
  %4 = load i32, i32* %1
  %5 = call i32 @prime(i32 %4)
  store i32 %5, i32* %3
  call void @Mars_PrintStr()
  %6 = load i32, i32* %3
  call void @Mars_PrintInt()
  ret i32 0
}

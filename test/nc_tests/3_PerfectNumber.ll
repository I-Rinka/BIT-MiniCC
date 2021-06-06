target datalayout = "e-m:e-p270:32:32-p271:32:32-p272:64:64-i64:64-f80:128-n8:16:32:64-S128"
target triple = "x86_64-pc-linux-gnu"

define void @perfectNumber(i32 %0) #0 {
  %2 = alloca i32
  store i32 %0, i32* %2
  %3 = alloca [80 x i32]
  %4 = alloca i32
  %5 = alloca i32
  %6 = alloca i32
  %7 = alloca i32
  %8 = alloca i32
  store i32 0, i32* %8
  store i32 2, i32* %5
  br label %9
  9:
  %10 = load i32, i32* %5
  %11 = load i32, i32* %2
  %12 = icmp slt i32 %10, %11
  br i1 %12, label %13, label %45
  13:
  store i32 0, i32* %6
  %14 = load i32, i32* %5
  store i32 %14, i32* %7
  store i32 1, i32* %4
  br label %15
  15:
  %16 = load i32, i32* %4
  %17 = load i32, i32* %5
  %18 = sdiv i32 %17, 2
  %19 = add i32 %18, 1
  %20 = icmp slt i32 %16, %19
  br i1 %20, label %21, label %34
  21:
  %22 = load i32, i32* %5
  %23 = load i32, i32* %4
  %24 = srem i32 %22, %23
  %25 = icmp eq i32 %24, 0
  br i1 %25, label %26, label %30
  26:
  %27 = getelementptr [80 x i32], [80 x i32]* %3, i32 0, i32 0
  %28 = load i32, i32* %4
  store i32 %28, i32* %27
  %29 = load i32, i32* %4
  store i32 %29, i32* %7
  br label %30
  30:
  br label %31
  31:
  %32 = load i32, i32* %4
  %33 = add i32 %32, 1
  store i32 %33, i32* %4
  br label %34
  34:
  %35 = load i32, i32* %7
  %36 = icmp eq i32 0, %35
  br i1 %36, label %37, label %41
  37:
  %38 = load i32, i32* %5
  call void @Mars_PrintInt(i32 %38)
  %39 = load i32, i32* %8
  %40 = add i32 %39, 1
  store i32 %40, i32* %8
  br label %41
  41:
  br label %42
  42:
  %43 = load i32, i32* %5
  %44 = add i32 %43, 1
  store i32 %44, i32* %5
  br label %45
  45:
  %46 = load i32, i32* %8
  call void @Mars_PrintInt(i32 %46)
  ret void
}
define i32 @main() #0 {
  call void @perfectNumber(i32 100)
  ret i32 0
}

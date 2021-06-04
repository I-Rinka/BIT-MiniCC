target datalayout = "e-m:e-p270:32:32-p271:32:32-p272:64:64-i64:64-f80:128-n8:16:32:64-S128"
target triple = "x86_64-pc-linux-gnu"
@a = common global [10 x [20 x i32]] zeroinitializer
@b = global i32 1
define i32 @f1(i32 %0, i32 %1) #0 {
  %3 = alloca i32
  store i32 %0, i32* %3
  %4 = alloca i32
  store i32 %1, i32* %4
  %5 = alloca i32
  %6 = load i32, i32* %3
  %7 = load i32, i32* %4
  %8 = add i32 %6, %7
  store i32 %8, i32* %5
  %9 = load i32, i32* %5
  ret i32 %9
}
define void @f2() #0 {
  ret void
}
define i32 @main() #0 {
  %1 = alloca i32
  store i32 1, i32* %1
  %2 = alloca i32
  store i32 2, i32* %2
  %3 = alloca i32
  %4 = load i32, i32* %1
  %5 = icmp ne i32 %4, 0
  %6 = xor i1 %5, true
  %7 = zext i1 %6 to i32
  store i32 %7, i32* %3
  %8 = load i32, i32* %1
  %9 = xor i32 %8, -1
  store i32 %9, i32* %3
  %10 = load i32, i32* %1
  %11 = load i32, i32* %2
  %12 = add i32 %10, %11
  store i32 %12, i32* %3
  %13 = load i32, i32* %1
  %14 = load i32, i32* %2
  %15 = srem i32 %13, %14
  store i32 %15, i32* %3
  %16 = load i32, i32* %1
  %17 = load i32, i32* %2
  %18 = shl i32 %16, %17
  store i32 %18, i32* %3
  %19 = load i32, i32* %1
  %20 = add i32 %19, 1
  store i32 %20, i32* %1
  store i32 %20, i32* %3
  %21 = load i32, i32* %1
  %22 = add i32 %21, 1
  store i32 %22, i32* %1
  store i32 %22, i32* %3
  %23 = load i32, i32* %1
  %24 = icmp ne i32 %23, 0
  br il %24, label %25, label %29
  25:
  %26 = load i32, i32* %1
  %27 = load i32, i32* %2
  %28 = call i32 @f1(i32 %26, i32 %27)
  store i32 %28, i32* %3
  br label %38
  29:
  %30 = load i32, i32* %1
  %31 = icmp ne i32 %30, 0
  br il %31, label %32, label %36
  32:
  %33 = load i32, i32* @b
  %34 = load i32, i32* %2
  %35 = call i32 @f1(i32 %33, i32 %34)
  store i32 %35, i32* %3
  br label %37
  36:
  call void @f2()
  br label %37
  37:
  br label %38
  38:
  %39 = alloca i32
  store i32 0, i32* %39
  br label %40
  40:
  %41 = load i32, i32* %39
  %42 = load i32, i32* %1
  %43 = icmp slt i32 %41, %42
  br il %43, label 44, label %52
  44:
  br label %52
  45:
  br label %40
  46:
  %47 = load i32, i32* %3
  %48 = add i32 %47, 1
  store i32 %48, i32* %3
  br label %49
  49:
  %50 = load i32, i32* %39
  %51 = add i32 %50, 1
  store i32 %51, i32* %39
  br label %52
  52:
  br label %53
  53:
  br label %53
  54:
  ret i32 0
}

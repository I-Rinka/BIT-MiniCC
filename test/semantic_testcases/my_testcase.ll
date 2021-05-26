target datalayout = "e-m:e-p270:32:32-p271:32:32-p272:64:64-i64:64-f80:128-n8:16:32:64-S128"
target triple = "x86_64-pc-linux-gnu"

define i32 @main(i32 %0, i32 %1) #0 {
    %3 = alloca i32
    store i32 %0, i32* %3
    %4 = alloca i32
    store i32 %1, i32* %4
    %5 = mul i32 2, 3
    %6 = add i32 5, 6
    %7 = mul i32 %5, %6
    %8 = add i32 1, %7
    store i32 %8, i32* %4
    %9 = alloca i32
    %10 = alloca i32
    store i32 3, i32* %10
    %11 = load i32, i32* %9
    ret i32 %11
}

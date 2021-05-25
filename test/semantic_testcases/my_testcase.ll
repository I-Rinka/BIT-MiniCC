source_filename = "test/semantic_testcases/my_testcase.c"
target datalayout = "e-m:e-p270:32:32-p271:32:32-p272:64:64-i64:64-f80:128-n8:16:32:64-S128"
target triple = "x86_64-pc-linux-gnu"
define i32 @f1(i32 %0, i32 %1) #0 {
f1_start:
  %2 = alloca i32
  ret i32 0
}

define void @f2() #0 {
f2_start:
  ret void}

define i32 @main() #0 {
main_start:
  %0 = alloca i32
  %1 = alloca i32
  %2 = alloca i32
  %3 = alloca i32
  ret i32 0
}


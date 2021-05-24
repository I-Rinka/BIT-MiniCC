source_filename = "test/semantic_testcases/my_testcase.c"
target datalayout = "e-m:e-p270:32:32-p271:32:32-p272:64:64-i64:64-f80:128-n8:16:32:64-S128"
target triple = "x86_64-pc-linux-gnu"
%0 = shl i32 %1, %2
store i32 %1, i32* %3

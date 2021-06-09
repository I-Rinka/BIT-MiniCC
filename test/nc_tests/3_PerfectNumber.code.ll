@.str.0 = i8* "The sum is :\n"
@.str.1 = i8* "All perfect numbers within 100:\n"
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
  br i1 %12, label %13, label %49
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
  br i1 %20, label %21, label %38
  21:
  %22 = load i32, i32* %5
  %23 = load i32, i32* %4
  %24 = srem i32 %22, %23
  %25 = icmp eq i32 %24, 0
  br i1 %25, label %26, label %34
  26:
  %27 = load i32, i32* %6
  %28 = add i32 %27, 1
  store i32 %28, i32* %6
  %29 = getelementptr [80 x i32], [80 x i32]* %3, i32 0, i32 %28
  %30 = load i32, i32* %4
  store i32 %30, i32* %29
  %31 = load i32, i32* %4
  %32 = load i32, i32* %7
  %33 = sub i32 %32, %31
  store i32 %33, i32* %7
  br label %34
  34:
  br label %35
  35:
  %36 = load i32, i32* %4
  %37 = add i32 %36, 1
  store i32 %37, i32* %4
  br label %15
  38:
  %39 = load i32, i32* %7
  %40 = icmp eq i32 0, %39
  br i1 %40, label %41, label %45
  41:
  %42 = load i32, i32* %5
  call void @Mars_PrintInt(i32 %42)
  %43 = load i32, i32* %8
  %44 = add i32 %43, 1
  store i32 %44, i32* %8
  br label %45
  45:
  br label %46
  46:
  %47 = load i32, i32* %5
  %48 = add i32 %47, 1
  store i32 %48, i32* %5
  br label %9
  49:
  %50 = getelementptr [16 x i8], [16 x i8]* @.str.0, i32 0, i32 0
  call void @Mars_PrintStr(i8* %50)
  %51 = load i32, i32* %8
  call void @Mars_PrintInt(i32 %51)
  ret void
}
define i32 @main() #0 {
  %1 = getelementptr [35 x i8], [35 x i8]* @.str.1, i32 0, i32 0
  call void @Mars_PrintStr(i8* %1)
  call void @perfectNumber(i32 100)
  ret i32 0
}

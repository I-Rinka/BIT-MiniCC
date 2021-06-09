@.str.0 = i8* "Please Input 16 numbers:\n"
@.str.1 = i8* "Array A:\n"
@.str.2 = i8* "\n"
@.str.3 = i8* "Array B:\n"
define void @array4_4() #0 {
  %1 = alloca [4 x [4 x i32]]
  %2 = alloca [4 x [4 x i32]]
  %3 = alloca i32
  %4 = alloca i32
  %5 = getelementptr [28 x i8], [28 x i8]* @.str.0, i32 0, i32 0
  call void @Mars_PrintStr(i8* %5)
  store i32 0, i32* %3
  br label %6
  6:
  %7 = load i32, i32* %3
  %8 = icmp slt i32 %7, 4
  br i1 %8, label %9, label %35
  9:
  store i32 0, i32* %4
  br label %10
  10:
  %11 = load i32, i32* %4
  %12 = icmp slt i32 %11, 4
  br i1 %12, label %13, label %31
  13:
  %14 = load i32, i32* %3
  %15 = getelementptr [4 x [4 x i32]], [4 x [4 x i32]]* %1, i32 0, i32 %14
  %16 = load i32, i32* %4
  %17 = getelementptr [4 x i32], [4 x i32]* %15, i32 0, i32 %16
  %18 = call i32 @Mars_GetInt()
  store i32 %18, i32* %17
  %19 = load i32, i32* %4
  %20 = sub i32 3, %19
  %21 = getelementptr [4 x [4 x i32]], [4 x [4 x i32]]* %2, i32 0, i32 %20
  %22 = load i32, i32* %3
  %23 = getelementptr [4 x i32], [4 x i32]* %21, i32 0, i32 %22
  %24 = load i32, i32* %3
  %25 = getelementptr [4 x [4 x i32]], [4 x [4 x i32]]* %1, i32 0, i32 %24
  %26 = load i32, i32* %4
  %27 = getelementptr [4 x i32], [4 x i32]* %25, i32 0, i32 %26
  store i32 %27, i32* %23
  br label %28
  28:
  %29 = load i32, i32* %4
  %30 = add i32 %29, 1
  store i32 %30, i32* %4
  br label %10
  31:
  br label %32
  32:
  %33 = load i32, i32* %3
  %34 = add i32 %33, 1
  store i32 %34, i32* %3
  br label %6
  35:
  %36 = getelementptr [12 x i8], [12 x i8]* @.str.1, i32 0, i32 0
  call void @Mars_PrintStr(i8* %36)
  store i32 0, i32* %3
  br label %37
  37:
  %38 = load i32, i32* %3
  %39 = icmp slt i32 %38, 4
  br i1 %39, label %40, label %57
  40:
  store i32 0, i32* %4
  br label %41
  41:
  %42 = load i32, i32* %4
  %43 = icmp slt i32 %42, 4
  br i1 %43, label %44, label %52
  44:
  %45 = load i32, i32* %3
  %46 = getelementptr [4 x [4 x i32]], [4 x [4 x i32]]* %1, i32 0, i32 %45
  %47 = load i32, i32* %4
  %48 = getelementptr [4 x i32], [4 x i32]* %46, i32 0, i32 %47
  call void @Mars_PrintInt(i32 %48)
  br label %49
  49:
  %50 = load i32, i32* %4
  %51 = add i32 %50, 1
  store i32 %51, i32* %4
  br label %41
  52:
  %53 = getelementptr [4 x i8], [4 x i8]* @.str.2, i32 0, i32 0
  call void @Mars_PrintStr(i8* %53)
  br label %54
  54:
  %55 = load i32, i32* %3
  %56 = add i32 %55, 1
  store i32 %56, i32* %3
  br label %37
  57:
  %58 = getelementptr [12 x i8], [12 x i8]* @.str.3, i32 0, i32 0
  call void @Mars_PrintStr(i8* %58)
  store i32 0, i32* %3
  br label %59
  59:
  %60 = load i32, i32* %3
  %61 = icmp slt i32 %60, 4
  br i1 %61, label %62, label %79
  62:
  store i32 0, i32* %4
  br label %63
  63:
  %64 = load i32, i32* %4
  %65 = icmp slt i32 %64, 4
  br i1 %65, label %66, label %74
  66:
  %67 = load i32, i32* %3
  %68 = getelementptr [4 x [4 x i32]], [4 x [4 x i32]]* %2, i32 0, i32 %67
  %69 = load i32, i32* %4
  %70 = getelementptr [4 x i32], [4 x i32]* %68, i32 0, i32 %69
  call void @Mars_PrintInt(i32 %70)
  br label %71
  71:
  %72 = load i32, i32* %4
  %73 = add i32 %72, 1
  store i32 %73, i32* %4
  br label %63
  74:
  %75 = getelementptr [4 x i8], [4 x i8]* @.str.2, i32 0, i32 0
  call void @Mars_PrintStr(i8* %75)
  br label %76
  76:
  %77 = load i32, i32* %3
  %78 = add i32 %77, 1
  store i32 %78, i32* %3
  br label %59
  79:
  ret void
}
define i32 @main() #0 {
  call void @array4_4()
  ret i32 0
}

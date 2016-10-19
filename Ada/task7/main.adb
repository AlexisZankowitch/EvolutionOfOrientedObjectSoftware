with Stack, Text_IO;
use Text_IO;

procedure main is
    type Elem is delta 0.01 digits 5;
    package MyStackPack is new Stack(Elem);
    use MyStackPack;
    package MyDecimal_IO is new Decimal_IO(Elem);
    use MyDecimal_IO;
    MyStack : StackType(2);
    X : Elem := 0.00;
begin
    Push(MyStack,2.0);
    Print(MyStack);
    Push(MyStack,3.0);
    Print(MyStack);
    New_Line;
    Put("pop: ");
    Pop(MyStack, X);
    Put(X);
    New_Line;
    Print(MyStack);
    Push(MyStack,4.0);
    Print(MyStack);
    New_Line;
    Put("Push full: ");
    Push(MyStack,5.0);
    Pop(MyStack, X);
    Put(X);
    Pop(MyStack, X);
    Put(X);
    Pop(MyStack, X);
    Put(X);
end main;

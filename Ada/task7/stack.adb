with Text_IO, Ada.Integer_Text_IO;
use Text_IO, Ada.Integer_Text_IO;

package body stack is 

    package MyDecimal_IO is new Decimal_IO(ElemType);
    use MyDecimal_IO;
        
    procedure Push(Stack : in out StackType; Elem : in ElemType) is 
    begin
        Stack.Counter := Stack.Counter + 1 ; 
        Stack.St(Stack.Counter) := Elem;
    exception 
        when Constraint_Error =>
            Put("The stack is full");
            Stack.Counter := Stack.Counter - 1 ; 
    end Push;
    
    procedure Pop(Stack : in out StackType; Elem  : in out ElemType) is 
    begin
        Elem := Stack.St(Stack.Counter);
        Stack.Counter := Stack.Counter -1;
    exception 
        when Constraint_Error =>
            Put("The stack is empty");
            Stack.Counter := Stack.Counter + 1 ; 
    end Pop;
    
    procedure Print(Stack : in out StackType) is 
        c : Integer :=1;
    begin
        New_Line;
        Put_Line("Stack : [");
        while (c <= Stack.Counter) loop
			Put(Stack.St(c));New_Line;
			c := c+1;
  		end loop;
  		Put("]");
    end Print;
    
end stack;

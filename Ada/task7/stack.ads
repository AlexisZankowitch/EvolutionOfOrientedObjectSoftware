generic 
    type ElemType is delta <> digits <>;
package Stack is 

    type Arr is array (Integer range <>) of ElemType;
    
    type StackType(MaxSize : Integer) is 
        record
            Counter : Integer := 0;
            St : Arr(0..MaxSize);
        end record;
    
    procedure Push(Stack : in out StackType; Elem  : in ElemType);
    procedure Pop(Stack : in out StackType; Elem  : in out ElemType);
    procedure Print(Stack : in out StackType);
    
end Stack;
        
